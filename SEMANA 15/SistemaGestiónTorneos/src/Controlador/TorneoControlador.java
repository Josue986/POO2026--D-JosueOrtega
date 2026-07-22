/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.TorneoVista;
import java.util.List;
/**
 *
 * @author jotue
 */
public class TorneoControlador {
    private EquipoDAO equipoDAO;
    private JugadorDAO jugadorDAO;
    private PartidoDAO partidoDAO;
    private TorneoVista vista;

    public TorneoControlador(EquipoDAO equipoDAO, JugadorDAO jugadorDAO, PartidoDAO partidoDAO, TorneoVista vista) {
        this.equipoDAO = equipoDAO;
        this.jugadorDAO = jugadorDAO;
        this.partidoDAO = partidoDAO;
        this.vista = vista;
    }

    public void registrarEquipo(String nombre) {
        if (nombre.isEmpty()) {
            vista.mostrarMensaje("[ERROR] El nombre del equipo no puede estar vacío.");
            return;
        }
        
        Equipo nuevo = new Equipo(nombre);
        if (equipoDAO.insertar(nuevo)) {
            vista.mostrarMensaje("[ÉXITO] Equipo '" + nombre + "' registrado de forma persistente.");
        } else {
            vista.mostrarMensaje("[ERROR] No se pudo guardar. ¿Quizás el equipo ya existe?");
        }
    }

    public void registrarJugador(String cedula, String nombre, String apellido, int idEquipo, int numCamiseta) {
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            vista.mostrarMensaje("[ERROR] Cédula, nombre y apellido son obligatorios.");
            return;
        }
        if (idEquipo <= 0 || numCamiseta < 0) {
            vista.mostrarMensaje("[ERROR] El ID de equipo o el número de camiseta no son válidos.");
            return;
        }

        Equipo equipo = equipoDAO.buscarPorId(idEquipo);
        if (equipo == null) {
            vista.mostrarMensaje("[ERROR] El ID de equipo ingresado no existe.");
            return;
        }

        Jugador nuevoJugador = new Jugador(0, cedula, nombre, apellido, idEquipo, numCamiseta);
        
        if (jugadorDAO.insertar(nuevoJugador)) {
            vista.mostrarMensaje("[ÉXITO] Jugador " + nombre + " " + apellido + " (Camiseta #" + numCamiseta + ") vinculado a " + equipo.getNombreEq());
        } else {
            vista.mostrarMensaje("[ERROR] No se pudo registrar. Verifique que la cédula no esté duplicada.");
        }
    }

    public void programarPartido(int idLocal, int idVisita, String fecha, String sede, 
                                 String arbCedula, String arbNombre, String arbApellido, String arbLicencia) {
        
        if (idLocal == idVisita) {
            vista.mostrarMensaje("[ERROR] Un equipo no puede jugar contra sí mismo.");
            return;
        }
        if (fecha.isEmpty() || sede.isEmpty() || arbNombre.isEmpty()) {
            vista.mostrarMensaje("[ERROR] Fecha, sede y nombre del árbitro son obligatorios.");
            return;
        }

        Equipo local = equipoDAO.buscarPorId(idLocal);
        Equipo visita = equipoDAO.buscarPorId(idVisita);

        if (local == null || visita == null) {
            vista.mostrarMensaje("[ERROR] Uno o ambos equipos no existen.");
            return;
        }

        Arbitro arbitro = new Arbitro(0, arbCedula, arbNombre, arbApellido, arbLicencia);
        
        Partido nuevoPartido = new Partido(0, local, visita, arbitro, fecha, sede);

        if (partidoDAO.insertar(nuevoPartido)) {
            vista.mostrarMensaje("[ÉXITO] Partido programado: " + local.getNombreEq() + " vs " + visita.getNombreEq() + " en " + sede);
        } else {
            vista.mostrarMensaje("[ERROR] No se pudo programar el partido.");
        }
    }

    public void registrarResultado(int idPartido, int golesLocal, int golesVisita) {
        if (golesLocal < 0 || golesVisita < 0) {
            vista.mostrarMensaje("[ERROR] Los goles no pueden ser números negativos.");
            return;
        }

        if (partidoDAO.registrarResultado(idPartido, golesLocal, golesVisita)) {
            vista.mostrarMensaje("[ÉXITO] Marcador actualizado correctamente.");
        } else {
            vista.mostrarMensaje("[ERROR] No se encontró ningún partido con el ID: " + idPartido);
        }
    }

    public void listarJugadoresDeEquipo(int idEquipo) {
        Equipo eq = equipoDAO.buscarPorId(idEquipo);
        if (eq == null) {
            vista.mostrarMensaje("[ERROR] El equipo no existe.");
            return;
        }

        List<Jugador> lista = jugadorDAO.listarPorEquipo(idEquipo);
        vista.mostrarMensaje("\n=======================================");
        vista.mostrarMensaje("  PLANTILLA: " + eq.getNombreEq().toUpperCase());
        vista.mostrarMensaje("=======================================");
        
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay jugadores registrados en este equipo.");
            return;
        }

        for (Jugador j : lista) {
            vista.mostrarMensaje("Cédula: " + j.getCedula() + " | #" + j.getNumCamiseta() + " - " + j.getNombre() + " " + j.getApellido());
        }
    }

    public void listarHistorialDeEquipo(int idEquipo) {
        Equipo eq = equipoDAO.buscarPorId(idEquipo);
        if (eq == null) {
            vista.mostrarMensaje("[ERROR] El equipo no existe.");
            return;
        }

        List<Partido> historial = partidoDAO.listarHistorialPorEquipo(idEquipo);
        vista.mostrarMensaje("\n=======================================");
        vista.mostrarMensaje("  HISTORIAL DE PARTIDOS: " + eq.getNombreEq().toUpperCase());
        vista.mostrarMensaje("=======================================");

        if (historial.isEmpty()) {
            vista.mostrarMensaje("Este equipo no ha programado ni jugado partidos aún.");
            return;
        }

        for (Partido p : historial) {
            String marcador = (p.getGolesLocal() == null) 
                ? "PENDIENTE POR JUGAR" 
                : p.getGolesLocal() + " - " + p.getGolesVisitante();
            
            vista.mostrarMensaje("[" + p.getFecha() + " en " + p.getSede() + "] " +
                    p.getEquipoLocal().getNombreEq() + " vs " + p.getEquipoVisitante().getNombreEq() + 
                    " | Marcador: " + marcador + " -> " + p.obtenerResultado());
        }
    }

    public void mostrarTablaPosiciones() {
        List<Equipo> equipos = equipoDAO.listarTodos();
        List<Partido> partidos = partidoDAO.listarTodos();

        vista.mostrarMensaje("\n=======================================");
        vista.mostrarMensaje("          TABLA DE POSICIONES          ");
        vista.mostrarMensaje("=======================================");
        System.out.printf("%-25s %-6s\n", "Equipo", "Puntos");
        vista.mostrarMensaje("---------------------------------------");

        for (Equipo eq : equipos) {
            int puntos = 0;
            for (Partido p : partidos) {
                // Solo calcular si el partido ya se jugó (goles != null)
                if (p.getGolesLocal() != null) {
                    if (p.getEquipoLocal().getIdEquipo() == eq.getIdEquipo()) {
                        if (p.getGolesLocal() > p.getGolesVisitante()) puntos += 3; // Ganó Local
                        else if (p.getGolesLocal().equals(p.getGolesVisitante())) puntos += 1; // Empate
                    } else if (p.getEquipoVisitante().getIdEquipo() == eq.getIdEquipo()) {
                        if (p.getGolesVisitante() > p.getGolesLocal()) puntos += 3; // Ganó Visitante
                        else if (p.getGolesLocal().equals(p.getGolesVisitante())) puntos += 1; // Empate
                    }
                }
            }
            System.out.printf("%-25s %-6d\n", eq.getNombreEq(), puntos);
        }
    }
    
    public java.util.List<String> obtenerEquiposFormateados() {
        java.util.List<Equipo> lista = equipoDAO.listarTodos();
        java.util.List<String> lineas = new java.util.ArrayList<>();

        for (Equipo e : lista) {
            // El controlador extrae los datos y arma el texto para la Vista
            lineas.add("ID: " + e.getIdEquipo() + " - " + e.getNombreEq());
        }
        return lineas;
    }

    public java.util.List<String> obtenerPartidosFormateados() {
        java.util.List<Partido> lista = partidoDAO.listarTodos();
        java.util.List<String> lineas = new java.util.ArrayList<>();

        for (Partido p : lista) {
            String estado = (p.getGolesLocal() == null)
                    ? "PENDIENTE"
                    : p.getGolesLocal() + "-" + p.getGolesVisitante();

            // El controlador procesa el formato visual del partido
            lineas.add("ID: " + p.getId() + " | " + p.getEquipoLocal().getNombreEq()
                    + " vs " + p.getEquipoVisitante().getNombreEq() + " [" + estado + "]");
        }
        return lineas;
    }
}
