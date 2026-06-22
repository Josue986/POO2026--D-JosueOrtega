/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejtelevisor;

/**
 *
 * @author jotue
 */
public class Televisor {
    private String numSerie;
    private int tamanio;
    private double precio;
    private String modelo;

    public Televisor(String numSerie, int tamanio, double precio, String modelo) {
        this.numSerie = numSerie;
        this.tamanio = tamanio;
        this.precio = precio;
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public int getTamanio() {
        return tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getModelo() {
        return modelo;
    }
      
}
