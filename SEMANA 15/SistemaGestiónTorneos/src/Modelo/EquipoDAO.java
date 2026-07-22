/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Conexion.ConexionSQLite;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jotue
 */
public class EquipoDAO {
    public boolean insertar(Equipo equipo) {
        String sql = "INSERT INTO equipos(nombre) VALUES(?)";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, equipo.getNombreEq());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar equipo: " + e.getMessage());
            return false;
        }
    }

    public List<Equipo> listarTodos() {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipos";
        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                lista.add(new Equipo(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar equipos: " + e.getMessage());
        }
        return lista;
    }

    public Equipo buscarPorId(int id) {
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Equipo(rs.getInt("id"), rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar equipo: " + e.getMessage());
        }
        return null;
    }
}
