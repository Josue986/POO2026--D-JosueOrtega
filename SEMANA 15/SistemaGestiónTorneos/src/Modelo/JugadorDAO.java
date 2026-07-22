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
public class JugadorDAO {
    public boolean insertar(Jugador jugador) {
        String sql = "INSERT INTO jugadores(cedula, nombre, apellido, id_equipo, num_camiseta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, jugador.getCedula()); 
            pstmt.setString(2, jugador.getNombre());
            pstmt.setString(3, jugador.getApellido());
            pstmt.setInt(4, jugador.getIdEquipo());
            pstmt.setInt(5, jugador.getNumCamiseta());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar jugador: " + e.getMessage());
            return false;
        }
    }

    public List<Jugador> listarPorEquipo(int idEquipo) {
        List<Jugador> lista = new ArrayList<>();
        String sql = "SELECT * FROM jugadores WHERE id_equipo = ?";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idEquipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Jugador(
                        rs.getInt("id"),
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("id_equipo"),
                        rs.getInt("num_camiseta")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al filtrar jugadores: " + e.getMessage());
        }
        return lista;
    }
}
