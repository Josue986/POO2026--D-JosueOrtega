package ejdb.controlador;

import ejdb.modelo.Estudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorEstudiante {

    private static final String URL = "jdbc:sqlite:db/ejemplo.db";

    private Connection obtenerConexion() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        crearTabla(conn);
        return conn;
    }

    private void crearTabla(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS estudiante ("
                + "cedula TEXT NOT NULL PRIMARY KEY, "
                + "nombres TEXT, "
                + "matricula INTEGER, "
                + "pago REAL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public boolean insertar(Estudiante estudiante) {
        String sql = "INSERT INTO estudiante (cedula, nombres, matricula, pago) VALUES (?, ?, ?, ?)";
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, estudiante.getCedula());
            pstmt.setString(2, estudiante.getNombres());
            pstmt.setInt(3, estudiante.getMatricula());
            pstmt.setDouble(4, estudiante.getPago());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Estudiante> listar() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombres, matricula, pago FROM estudiante";

        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearEstudiante(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    public Estudiante buscarPorCedula(String cedula) {
        String sql = "SELECT cedula, nombres, matricula, pago FROM estudiante WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapearEstudiante(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizar(Estudiante estudiante) {
        String sql = "UPDATE estudiante SET nombres = ?, matricula = ?, pago = ? WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, estudiante.getNombres());
            pstmt.setInt(2, estudiante.getMatricula());
            pstmt.setDouble(3, estudiante.getPago());
            pstmt.setString(4, estudiante.getCedula());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String cedula) {
        String sql = "DELETE FROM estudiante WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    private Estudiante mapearEstudiante(ResultSet rs) throws SQLException {
        return new Estudiante(
                rs.getString("cedula"),
                rs.getString("nombres"),
                rs.getInt("matricula"),
                rs.getDouble("pago")
        );
    }
}
