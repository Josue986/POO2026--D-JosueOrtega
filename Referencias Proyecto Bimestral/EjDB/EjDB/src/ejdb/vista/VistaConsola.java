package ejdb.vista;

import ejdb.controlador.ControladorEstudiante;
import ejdb.modelo.Estudiante;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {

    private final ControladorEstudiante controlador;
    private final Scanner scanner;

    public VistaConsola() {
        controlador = new ControladorEstudiante();
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> buscarEstudiante();
                case 4 -> actualizarEstudiante();
                case 5 -> eliminarEstudiante();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion no valida.");
            }

            System.out.println();
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("===== GESTION DE ESTUDIANTES =====");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar por cedula");
        System.out.println("4. Actualizar estudiante");
        System.out.println("5. Eliminar estudiante");
        System.out.println("0. Salir");
    }

    private void registrarEstudiante() {
        System.out.println("\n--- Registrar estudiante ---");
        String cedula = leerTexto("Cedula: ");

        if (controlador.buscarPorCedula(cedula) != null) {
            System.out.println("Ya existe un estudiante con esa cedula.");
            return;
        }

        String nombres = leerTexto("Nombres: ");
        int matricula = leerEntero("Matricula: ");
        double pago = leerDouble("Pago: ");
        

        Estudiante estudiante = new Estudiante(cedula, nombres, matricula, pago);

        if (controlador.insertar(estudiante)) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el estudiante.");
        }
    }

    private void listarEstudiantes() {
        System.out.println("\n--- Lista de estudiantes ---");
        ArrayList<Estudiante> estudiantes = controlador.listar();

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    private void buscarEstudiante() {
        System.out.println("\n--- Buscar estudiante ---");
        String cedula = leerTexto("Cedula: ");
        Estudiante estudiante = controlador.buscarPorCedula(cedula);

        if (estudiante != null) {
            System.out.println(estudiante);
        } else {
            System.out.println("No se encontro un estudiante con esa cedula.");
        }
    }

    private void actualizarEstudiante() {
        System.out.println("\n--- Actualizar estudiante ---");
        String cedula = leerTexto("Cedula a actualizar: ");
        Estudiante estudiante = controlador.buscarPorCedula(cedula);

        if (estudiante == null) {
            System.out.println("No se encontro un estudiante con esa cedula.");
            return;
        }

        System.out.println("Registro actual: " + estudiante);
        String nombres = leerTexto("Nuevos nombres: ");
        int matricula = leerEntero("Nueva matricula: ");
        double pago = leerDouble("Nuevo pago: ");

        estudiante.setNombres(nombres);
        estudiante.setMatricula(matricula);
        estudiante.setPago(pago);

        if (controlador.actualizar(estudiante)) {
            System.out.println("Estudiante actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar el estudiante.");
        }
    }

    private void eliminarEstudiante() {
        System.out.println("\n--- Eliminar estudiante ---");
        String cedula = leerTexto("Cedula a eliminar: ");

        if (controlador.eliminar(cedula)) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontro un estudiante con esa cedula.");
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }
}
