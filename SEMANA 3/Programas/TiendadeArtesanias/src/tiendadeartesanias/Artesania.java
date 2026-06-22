/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

/**
 *
 * @author SebastianCodena
 */
public class Artesania {
    private String id;
    private String nombre;
    private double precioBase;
    private int stock;
    private String creador;
    private Material material;

    public Artesania(String id, String nombre, double precioBase, int stock, String creador, Material material) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
        this.creador = creador;
        this.material = material;
    }

    public double calcularPrecioVenta() {
        double precio = precioBase + material.getCosto() * 0.5;
        System.out.println("Calculando precio de venta: " + precio);
        return precio;
    }

    public boolean reducirStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            System.out.println("Stock actualizado: " + stock);
            return true;
        }
        System.out.println("No hay suficiente stock");
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}

