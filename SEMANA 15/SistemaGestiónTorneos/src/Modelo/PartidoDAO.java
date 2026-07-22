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
public class PartidoDAO {

    private EquipoDAO equipoDAO = new EquipoDAO();

    public boolean insertar(Partido partido) {
        String sql = "INSERT INTO partidos (id_equipo_local, id_equipo_visita, fecha, sede, "
                + "arbitro_cedula, arbitro_nombre, arbitro_apellido, arbitro_licensia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, partido.getEquipoLocal().getIdEquipo());
            pstmt.setInt(2, partido.getEquipoVisitante().getIdEquipo());
            pstmt.setString(3, partido.getFecha());
            pstmt.setString(4, partido.getSede());

            pstmt.setString(5, partido.getArbitro().getCedula());
            pstmt.setString(6, partido.getArbitro().getNombre());
            pstmt.setString(7, partido.getArbitro().getApellido());
            pstmt.setString(8, partido.getArbitro().getLicensia());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar partido: " + e.getMessage());
            return false;
        }
    }

    public boolean registrarResultado(int idPartido, int golesLocal, int golesVisita) {
        String sql = "UPDATE partidos SET goles_local = ?, goles_visita = ? WHERE id = ?";
        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, golesLocal);
            pstmt.setInt(2, golesVisita);
            pstmt.setInt(3, idPartido);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar marcador: " + e.getMessage());
            return false;
        }
    }

    public List<Partido> listarHistorialPorEquipo(int idEquipo) {
        List<Partido> historial = new ArrayList<>();
        String sql = "SELECT * FROM partidos WHERE id_equipo_local = ? OR id_equipo_visita = ?";

        try (Connection conn = ConexionSQLite.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEquipo);
            pstmt.setInt(2, idEquipo);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    historial.add(mapearPartido(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener historial: " + e.getMessage());
        }
        return historial;
    }

    public List<Partido> listarTodos() {
        List<Partido> lista = new ArrayList<>();
        String sql = "SELECT * FROM partidos";
        try (Connection conn = ConexionSQLite.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearPartido(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar todos los partidos: " + e.getMessage());
        }
        return lista;
    }

    private Partido mapearPartido(ResultSet rs) throws SQLException {
        Equipo local = equipoDAO.buscarPorId(rs.getInt("id_equipo_local"));
        Equipo visita = equipoDAO.buscarPorId(rs.getInt("id_equipo_visita"));
        Arbitro arbitro = new Arbitro(
                0,
                rs.getString("arbitro_cedula"),
                rs.getString("arbitro_nombre"),
                rs.getString("arbitro_apellido"),
                rs.getString("arbitro_licensia")
        );

        Partido partido = new Partido(
                rs.getInt("id"),
                local,
                visita,
                arbitro,
                rs.getString("fecha"),
                rs.getString("sede")
        );

        // SQLite devuelve 0 si el campo es NULL usando rs.getInt()
        if (rs.getObject("goles_local") != null) {
            partido.setGolesLocal(rs.getInt("goles_local"));
            partido.setGolesVisitante(rs.getInt("goles_visita"));
        }

        return partido;
    }
}
