/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

/**
 *
 * @author SebastianCodena
 */
public class Material {
    private String id;
    private String tipo;
    private double costo;

    public Material(String id, String tipo, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getTipo() {
        return tipo;
    }
}

