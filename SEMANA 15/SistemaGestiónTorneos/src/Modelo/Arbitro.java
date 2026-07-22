/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jotue
 */
public class Arbitro extends Persona {
    private String licensia;
    
    public Arbitro(int id, String cedula, String nombre, String apellido, String licensia) {
        super(id, cedula, nombre, apellido);
        this.licensia = licensia;
    }

    public String getLicensia() { return licensia; }

    public void setLicensia(String licensia) { this.licensia = licensia; }
}
