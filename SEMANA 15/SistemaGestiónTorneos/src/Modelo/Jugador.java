/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jotue
 */
public class Jugador extends Persona {
    private int idEquipo;
    protected int numCamiseta;
    protected String posicion;  

    public Jugador(int id, String cedula, String nombre, String apellido, int idEquipo, int numCamiseta) {
        super(id, cedula, nombre, apellido);
        this.idEquipo = idEquipo;
        this.numCamiseta = numCamiseta;
    }

    public int getIdEquipo() { return idEquipo; }
    
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    public int getNumCamiseta() { return numCamiseta; }

    public void setNumCamiseta(int numCamiseta) { this.numCamiseta = numCamiseta; }

    public String getPosicion() { return posicion; }

    public void setPosicion(String posicion) { this.posicion = posicion; }
}
