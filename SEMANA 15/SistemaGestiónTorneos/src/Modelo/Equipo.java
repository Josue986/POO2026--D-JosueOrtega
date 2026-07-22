/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jotue
 */
public class Equipo {
     protected int idEquipo;
    protected String nombreEq;
    
    public Equipo(String nombreEq) {
        this.nombreEq = nombreEq;
    }
    
    public Equipo(int idEquipo, String nombreEq) {
        this.idEquipo = idEquipo;
        this.nombreEq = nombreEq;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEq() {
        return nombreEq;
    }

    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }
    
    @Override
    public String toString() {
        return "ID: " + idEquipo + " | Nombre: " + nombreEq;
    }
}
