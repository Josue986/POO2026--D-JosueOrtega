/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

import java.util.Date;

/**
 *
 * @author SebastianCodena
 */
public class Venta {
     private String id;
    private Date fecha;
    private double total;
    private int cantidad;
    private Artesania artesania;

    public Venta(String id, Artesania artesania, int cantidad) {
        this.id = id;
        this.artesania = artesania;
        this.cantidad = cantidad;
        this.fecha = new Date();
        this.total = calcularTotal();
    }

    public double calcularTotal() {
        double total = artesania.calcularPrecioVenta() * cantidad;
        System.out.println("Total de la venta: " + total);
        return total;
    }

    public double getTotal() {
        return total;
    }
}