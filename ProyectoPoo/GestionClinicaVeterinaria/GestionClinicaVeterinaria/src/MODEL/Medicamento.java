/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Pablo
 */
import java.io.Serializable;

public class Medicamento implements Serializable {

    private String idMed;//id del medicamento
    private String nombreMed;//nombre del medicamento
    private double precioMed;//precio del medicamento
    private int stock;//stock del medicamento

    public Medicamento(String idMed, String nombreMed, double precioMed, int stock) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.precioMed = precioMed;
        this.stock = stock;
    }

    public String getIdMed() {
        return idMed;
    }

    public void setIdMed(String idMed) {
        this.idMed = idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public double getPrecioMed() {
        return precioMed;
    }

    public void setPrecioMed(double precioMed) {
        this.precioMed = precioMed;
    }

    public int getStock() {
        return stock;
    }

    public void reducirStock(int cantidad) {
        stock -= cantidad;

    }

    public boolean verificarDisponibilidad() {
        if (0 < stock) {
            return true;
        } else {
            return false;
        }

    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
