package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.personasbecas;

public class controladorBecas {

    private static final String URL = "jdbc:sqlite:db/becas.db";

    public Connection obtenerConexion() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        crearTabla(conn);
        return conn;
    }
    
    private void crearTabla(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS becas ("
                + "cedula TEXT NOT NULL, "
                + "nombre TEXT, "
                + "edad	INTEGER, "
                + "id_becas	TEXT,"
                + "nombre_beca	TEXT,"
                + "monto REAL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
    
    public boolean insertar(personasbecas pb) {
        String sql = "INSERT INTO becas (cedula, nombre, edad, id_becas, nombre_beca, monto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pb.getCedula());
            pstmt.setString(2, pb.getNombres());
            pstmt.setInt(3, pb.getEdad());
            pstmt.setString(4, pb.getIdBecas());
            pstmt.setString(5, pb.getNombreBeca());
            pstmt.setDouble(6, pb.getMonto());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<personasbecas> listar() {
        ArrayList<personasbecas> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre, edad, id_becas, nombre_beca, monto FROM becas";

        try (Connection conn = obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearBecas(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }
    
    private personasbecas mapearBecas(ResultSet rs) throws SQLException {
        return new personasbecas(
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getInt("edad"),
                rs.getString("idBecas"),
                rs.getString("nombreBeca"),
                rs.getDouble("monto")
        );
    }
    
    public personasbecas buscarPorCedula(String cedula) {
        String sql = "SELECT * FROM becas WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapearBecas(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }

        return null;
    }
    
    public boolean actualizar(personasbecas pb) {
        String sql = "UPDATE becas SET nombre = ?, nombre_beca = ?, monto = ? WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pb.getNombres());
            pstmt.setString(2, pb.getNombreBeca());
            pstmt.setDouble(3, pb.getMonto());
            pstmt.setString(4, pb.getCedula());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(String cedula) {
        String sql = "DELETE FROM becas WHERE cedula = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedula);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    
}
