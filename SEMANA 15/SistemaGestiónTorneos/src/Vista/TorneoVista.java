/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Controlador.TorneoControlador;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jotue
 */
public class TorneoVista {
    private Scanner scanner = new Scanner(System.in);

    public void iniciarMenu(TorneoControlador controlador) {
        int opcion = 0;
        do {
            System.out.println("\n=======================================");
            System.out.println("     SPORTTRACK PRO - MENU PRINCIPAL    ");
            System.out.println("=======================================");
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Registrar Jugador (Vincular a Equipo)");
            System.out.println("3. Programar Partido (Crear Evento)");
            System.out.println("4. Registrar Marcador/Resultado");
            System.out.println("5. Consultar Plantilla de un Equipo");
            System.out.println("6. Consultar Historial de un Equipo");
            System.out.println("7. Ver Tabla de Posiciones");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRAR NUEVO EQUIPO ---");
                        System.out.print("Ingrese el nombre del equipo: ");
                        String nombreEq = scanner.nextLine().trim();
                        controlador.registrarEquipo(nombreEq);
                        break;

                    case 2:
                        System.out.println("\n--- REGISTRAR NUEVO JUGADOR ---");
                        // Recibe texto puro desde el controlador, NO objetos
                        List<String> equiposTexto = controlador.obtenerEquiposFormateados();
                        if (equiposTexto.isEmpty()) {
                            System.out.println("[ALERTA] No hay equipos registrados. Cree uno primero.");
                            break;
                        }

                        System.out.println("Equipos disponibles:");
                        for (String eqStr : equiposTexto) {
                            System.out.println("  " + eqStr);
                        }

                        System.out.print("Ingrese el ID del equipo de destino: ");
                        int idEqJug = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese la cédula del jugador: ");
                        String cedJug = scanner.nextLine().trim();
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nomJug = scanner.nextLine().trim();
                        System.out.print("Ingrese el apellido del jugador: ");
                        String apeJug = scanner.nextLine().trim();
                        System.out.print("Ingrese el número de camiseta: ");
                        int numCam = Integer.parseInt(scanner.nextLine());

                        controlador.registrarJugador(cedJug, nomJug, apeJug, idEqJug, numCam);
                        break;

                    case 3:
                        System.out.println("\n--- PROGRAMAR NUEVO ENCUENTRO ---");
                        List<String> eqsPartidosTexto = controlador.obtenerEquiposFormateados();
                        if (eqsPartidosTexto.size() < 2) {
                            System.out.println("[ERROR] Se requieren mínimo 2 equipos en el sistema.");
                            break;
                        }

                        for (String eqStr : eqsPartidosTexto) {
                            System.out.println("  " + eqStr);
                        }
                        System.out.print("ID del Equipo Local: ");
                        int loc = Integer.parseInt(scanner.nextLine());
                        System.out.print("ID del Equipo Visitante: ");
                        int vis = Integer.parseInt(scanner.nextLine());
                        System.out.print("Fecha del encuentro (Ej: 2026-07-20): ");
                        String fec = scanner.nextLine().trim();
                        System.out.print("Sede / Estadio: ");
                        String sed = scanner.nextLine().trim();

                        System.out.println("\n-- Datos del Árbitro asignado --");
                        System.out.print("Cédula del árbitro: ");
                        String arbCed = scanner.nextLine().trim();
                        System.out.print("Nombre del árbitro: ");
                        String arbNom = scanner.nextLine().trim();
                        System.out.print("Apellido del árbitro: ");
                        String arbApe = scanner.nextLine().trim();
                        System.out.print("Licencia (Ej: FIFA, Nacional): ");
                        String arbLic = scanner.nextLine().trim();

                        controlador.programarPartido(loc, vis, fec, sed, arbCed, arbNom, arbApe, arbLic);
                        break;

                    case 4:
                        System.out.println("\n--- REGISTRAR RESULTADO DE PARTIDO ---");
                        // Recibe texto puro procesado, no el modelo Partido
                        List<String> partidosTexto = controlador.obtenerPartidosFormateados();
                        if (partidosTexto.isEmpty()) {
                            System.out.println("No hay partidos programados en el sistema.");
                            break;
                        }

                        for (String partStr : partidosTexto) {
                            System.out.println("  " + partStr);
                        }

                        System.out.print("Ingrese el ID del partido a actualizar: ");
                        int idPart = Integer.parseInt(scanner.nextLine());
                        System.out.print("Goles del equipo local: ");
                        int gLoc = Integer.parseInt(scanner.nextLine());
                        System.out.print("Goles del equipo visitante: ");
                        int gVis = Integer.parseInt(scanner.nextLine());

                        controlador.registrarResultado(idPart, gLoc, gVis);
                        break;

                    case 5:
                        System.out.println("\n--- CONSULTAR JUGADORES POR EQUIPO ---");
                        System.out.print("Ingrese el ID del equipo: ");
                        int idFiltroJug = Integer.parseInt(scanner.nextLine());
                        controlador.listarJugadoresDeEquipo(idFiltroJug);
                        break;

                    case 6:
                        System.out.println("\n--- CONSULTAR HISTORIAL DE UN EQUIPO ---");
                        System.out.print("Ingrese el ID del equipo: ");
                        int idFiltroHist = Integer.parseInt(scanner.nextLine());
                        controlador.listarHistorialDeEquipo(idFiltroHist);
                        break;

                    case 7:
                        controlador.mostrarTablaPosiciones();
                        break;

                    case 8:
                        System.out.println("Finalizando la ejecución de SportTrack Pro. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("[ALERTA] Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Tipo de dato inválido. Ingrese números donde se requiera.");
            }
        } while (opcion != 8);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
