package Controlador;

import Modelo.*;
import Util.ConexionSQLite;
import java.sql.*;
import java.util.ArrayList;

public class LavadoDAO {

    public void registrarLavado(Lavado lavado) {
        String sql = "INSERT INTO lavar (placa, tipoLavado, precio, cliente) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, lavado.getPlaca());
            pstmt.setString(2, lavado.tipoLavado());
            pstmt.setDouble(3, lavado.precio());
            pstmt.setString(4, lavado.getCliente());
            pstmt.executeUpdate();
            System.out.println("Lavado registrado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar lavado: " + e.getMessage());
        }
    }
    
    public ArrayList<String> obtenerLavados() {
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT * FROM lavar";

        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String info = "ID: " + rs.getInt("id") +
                        ", Placa: " + rs.getString("placa") +
                        ", Tipo: " + rs.getString("tipoLavado") +
                        ", Precio: $" + rs.getDouble("precio") +
                        ", Cliente: " + rs.getString("cliente");
                lista.add(info);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lavados: " + e.getMessage());
        }

        return lista;
    }
    


    
}
