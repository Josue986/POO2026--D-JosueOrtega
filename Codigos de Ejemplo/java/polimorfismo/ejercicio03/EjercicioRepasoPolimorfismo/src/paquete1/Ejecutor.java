/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete1;

import java.util.ArrayList;
import paquete2.*;

public class Ejecutor {

    public static void main(String[] args) {

        ArrayList<PasajeInterCantonal> pasajes = new ArrayList<>();
        
        Persona persona1 = new Persona("Luis Valencia", "110011");
        Persona persona2 = new Persona("Ana Bustamante", "110012");
        Persona persona3 = new Persona("Oscar Lima", "110013");
        Persona persona4 = new Persona("Mónica Sarango", "110014");
        
        PasajeNormal pa = new PasajeNormal();
        pa.establecerPersona(persona1);
        
        PasajeMenorEdad pm = new PasajeMenorEdad();
        pm.establecerPersona(persona2);
        
        PasajeTerceraEdad pt = new PasajeTerceraEdad();
        pt.establecerPersona(persona3);
        
        PasajeUniversitario pu = new PasajeUniversitario();
        pu.establecerPersona(persona4);
        
        pasajes.add(pa);
        pasajes.add(pm);
        pasajes.add(pt);
        pasajes.add(pu);

        for (int i = 0; i < pasajes.size(); i++) {
            
            pasajes.get(i).establecerValorPasaje();
            
        }
        
        for (int i = 0; i < pasajes.size(); i++) {
            
            System.out.printf("Pasajero: %s\n"
                    + "Cédula: %s\n"
                    + "Valor Pasaje: %.2f\n"
                    + "---------------------\n",
                    pasajes.get(i).obtenerPersona().obtenerNombre(),
                    pasajes.get(i).obtenerPersona().obtenerCedula(),
                    pasajes.get(i).obtenerValorPasaje());
            
        }

    }
}
