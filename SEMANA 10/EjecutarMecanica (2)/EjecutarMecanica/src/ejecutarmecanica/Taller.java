/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

import java.util.ArrayList;

/**
 *
 * @author SebastianCodena
 */
public class Taller {

    private ArrayList<ReparacionMecanica> listaMecanica;
    private ArrayList<ReparacionChapasPintura> listaChapaPintura;
    private ArrayList<Revision> listaRevision;

    public Taller() {
        this.listaMecanica = new ArrayList<>();
        this.listaChapaPintura = new ArrayList<>();
        this.listaRevision = new ArrayList<>();
    }

    // =========================
    // AGREGAR TRABAJOS
    // =========================

    public void agregarMecanica(ReparacionMecanica m) {
        listaMecanica.add(m);
    }

    public void agregarChapaPintura(ReparacionChapasPintura cp) {
        listaChapaPintura.add(cp);
    }

    public void agregarRevision(Revision r) {
        listaRevision.add(r);
    }

    // =========================
    // UNIR TODO EN UNA LISTA
    // =========================

    public ArrayList<Trabajo> obtenerTodosLosTrabajos() {

        ArrayList<Trabajo> todos = new ArrayList<>();

        todos.addAll(listaMecanica);
        todos.addAll(listaChapaPintura);
        todos.addAll(listaRevision);

        return todos;
    }

    // =========================
    // MÉTODO PRINCIPAL: MOSTRAR TODO
    // =========================

    public void mostrarOriginalYOrdenado() {

        // ===== LISTA ORIGINAL =====
        System.out.println("==================================");
        System.out.println("         LISTA ORIGINAL");
        System.out.println("==================================");

        ArrayList<Trabajo> original = obtenerTodosLosTrabajos();
        for (Trabajo t : original) {
            mostrarTrabajoCompleto(t);
        }

        // ===== ORDENAR (BURBUJA) =====
        ArrayList<Trabajo> todos = obtenerTodosLosTrabajos();
        for (int i = 0; i < todos.size() - 1; i++) {
            for (int j = 0; j < todos.size() - i - 1; j++) {
                if (todos.get(j).getHoras() < todos.get(j + 1).getHoras()) {
                    Trabajo temp = todos.get(j);
                    todos.set(j, todos.get(j + 1));
                    todos.set(j + 1, temp);
                }
            }
        }

        System.out.println("\n==================================");
        System.out.println("     LISTA ORDENADA POR HORAS");
        System.out.println("==================================");

        for (int i = 0; i < todos.size(); i++) {
            // 1. Primero dibujamos la línea divisoria superior
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            
            // 2. Ahora imprimimos el número de orden DEBAJO de la línea
            System.out.println("ID Nuevo: " + (i + 1));
            
            // 3. Finalmente, imprimimos los datos correspondientes
            mostrarTrabajoCompleto(todos.get(i));
        }
    }
    
    // =========================
    // MOSTRAR TODO EL TRABAJO
    // =========================
    private void mostrarTrabajoCompleto(Trabajo t) {
        // !!! ELIMINAMOS la línea de guiones de aquí para que no rompa el diseño !!!

        // Imprime la base de la tabla en la misma línea
        System.out.printf(
            "| ID: %-3d | Descripción: %-35s | Horas: %-3d | Finalizado: %-5s",
            t.getIdtrabajo(),
            t.getDescripcion(),
            t.getHoras(),
            t.isFinalizado()
        );

        if (t instanceof Reparacion) {
            Reparacion r = (Reparacion) t;
            System.out.printf(" | Costo material: %-8.2f", r.getCostoMaterial());
        }

        if (t instanceof ReparacionMecanica) {
            ReparacionMecanica m = (ReparacionMecanica) t;
            System.out.printf(" | Tipo: Mecánica | Plazo: %-2d | Precio: %-8.2f",
                    m.getPlazo(),
                    m.CalcularPrecioReparacionMecanica());
        }

        if (t instanceof ReparacionChapasPintura) {
            ReparacionChapasPintura cp = (ReparacionChapasPintura) t;
            System.out.printf(" | Tipo: Chapas/Pintura | Plazo: %-2d | Precio: %-8.2f",
                    cp.getPlazo(),
                    cp.CalcularPrecioChapas());
        }

        if (t instanceof Revision) {
            Revision r = (Revision) t;
            System.out.printf(" | Tipo: Revisión | Plazo: %-2d | Precio: %-8.2f",
                    r.getPlazo(),
                    r.calcularPrecioRevision());
        }

        // Cerramos la celda y hacemos el salto de línea definitivo para la SIGUIENTE orden
        System.out.println(" |"); 
    }
}