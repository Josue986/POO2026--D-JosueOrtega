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
public class PasajeMenorEdad extends PasajeInterCantonal 
        implements Serializable{
    
    
    public void establecerValorPasaje(){
        valorPasaje = 100;
    }
    
    public String toString(){
        return String.format("%s\n%.2f\n", super.toString(), obtenerValorPasaje());
    }
}
