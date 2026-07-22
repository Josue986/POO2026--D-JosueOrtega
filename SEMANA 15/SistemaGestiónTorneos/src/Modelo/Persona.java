/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jotue
 */
public abstract class Persona {
    protected int id;
    protected String cedula;
    protected String nombre;
    protected String apellido;

    public Persona() {
    }
    
    public Persona(int id, String cedula, String nombre, String apellido){
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public int getId(){ return id; }
    
    public String getCedula() { return cedula; }

    public void setCedula(String cedula) { this.cedula = cedula; }
    
    public String getNombre(){ return nombre; }
    
    public void setNombre(String nombre){ this.nombre = nombre; }

    public String getApellido() {  return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }
}
