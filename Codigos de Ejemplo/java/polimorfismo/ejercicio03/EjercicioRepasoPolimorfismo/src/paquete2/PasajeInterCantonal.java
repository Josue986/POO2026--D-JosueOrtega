/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete2;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public abstract class PasajeInterCantonal implements Serializable{
    protected double valorPasaje;
    protected Persona usuario;
    
    public void establecerPersona(Persona u){
        usuario = u;
    }
    
    public Persona obtenerPersona(){
        return usuario;
    }
    
    public abstract void establecerValorPasaje();
    
    public double obtenerValorPasaje(){
        return valorPasaje;
    }
    
    
    public String toString(){
        return String.format("Hola\n%s\n", "Mundo");
    }
    
    
}
