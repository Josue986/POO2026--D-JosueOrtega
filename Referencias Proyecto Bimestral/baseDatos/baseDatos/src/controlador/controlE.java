package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.estudiante;

public class controlE {

    
    private static final String URL = "jdbc:sqlite:db/becas.db";

    private Connection obtenerConexion() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        crearTabla(conn);
        return conn;
    }
    
    private void crearTabla(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS personasbecas ("
                + "cedula TEXT NOT NULL, "
                + "nombre TEXT, "
                + "edad INTEGER, "
                + "id_becas, TEXT "
                + "nombre_beca, TEXT"
                + "monto REAL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }
    
    public boolean insertar(estudiante est) {
        String sql = "INSERT INTO personasbecas (cedula, nombre, edad, id_becas, nombre_beca, monto) VALUES (?, ?, ?, ?,?,?)";
        try (Connection conn = obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, est.getCedula());
            pstmt.setString(2, est.getNombre());
            pstmt.setInt(3, est.getEdad());
            pstmt.setString(4, est.getIdBecas());
            pstmt.setString(5, est.getNombreBeca());
            pstmt.setDouble(6, est.getMonto());
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Estudiante> listar() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre, edad, id_becas, nombre_beca, monto FROM personasbecas";

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

    
}
