/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodemodos;

/**
 *
 * @author reroes
 */

public class Pais {

    String nombrePais;
    String capitalPais;
    
    public Pais(String nom, String cap){
        nombrePais = nom;
        capitalPais = cap;
    }
    
    public void establecerNombrePais(String nom){
        nombrePais = nom;
    }
    
    public void establecerCapitalPais(String a){
        capitalPais = a;
    }
    
    public String obtenerNombrePais(){
        return nombrePais;
    }
    
    public String obtenerCapitalPais(){
        return capitalPais;
    }
    
}