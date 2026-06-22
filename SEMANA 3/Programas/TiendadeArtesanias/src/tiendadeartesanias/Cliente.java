/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

/**
 *
 * @author SebastianCodena
 */
public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String cedula;
    private double presupuesto;

    public Cliente(String id, String nombre, String apellido, String cedula, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.presupuesto = presupuesto;
    }

    public boolean puedeComprar(double total) {
        System.out.println("Verificando presupuesto...");
        return presupuesto >= total;
    }

    public void pagar(double total) {
        presupuesto -= total;
        System.out.println("Pago realizado. Presupuesto restante: " + presupuesto);
    }
}