/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

import java.util.Scanner;
import paqueteuno.LibretaCalificacion;
/**
 *
 * @author reroes
 */
public class Ejecutor {
    public static void main(String[] args) {
        // listado de variables para ingreso de datos por teclado
        Scanner entrada = new Scanner(System.in);
        String nombreEstudiante;
        double [] calificacionesEstudiante;
        int numerocalificaciones;
        
        // Ingreso de valores por teclado
        System.out.println("Ingrese el nombre del estudiante");
        nombreEstudiante = entrada.nextLine();
        System.out.println("Ingrese el número de calificaciones");
        numerocalificaciones = entrada.nextInt();
        // con el numerocalificaciones se crea el objeto arreglo de
        // calificaciones tipo double
        calificacionesEstudiante = new double[numerocalificaciones];
        for (int i = 0; i < numerocalificaciones; i++) {
            System.out.printf("Ingrese calificación %d\n", i+1);
            calificacionesEstudiante[i] = entrada.nextDouble();
        }
        
        // con el ingreso del nombre del estudiante y el ingreso del conjunto
        // de calificaciones; se procede a crear el objeto de tipo
        // LibretaCalificacion
        LibretaCalificacion libreta = new LibretaCalificacion(nombreEstudiante,
                calificacionesEstudiante);
        // Se llama a los métodos que realizan el calculo del
        // promedio y promedio cualitativo
        libreta.establecerPromedio();
        libreta.establecerPromedioCualitativo();
        // proceso para presentar la información
        String cadena = "Libreta de Calificaciones\n";
        cadena = String.format("%sNombre: %s\nCalificaciones:\n", cadena, 
                libreta.obtenerEstudiante());
        for (int i = 0; i < libreta.obtenerCalificaciones().length; i++) {
            cadena = String.format("%s\t\t%.2f\n", cadena, 
                    libreta.obtenerCalificaciones()[i]);
        }
        cadena = String.format("%sPromedio calificaciones: %.2f\n"
                + "Promedio cuantitativo: %s\n",  
                cadena, libreta.obtenerPromedio(), libreta.obtenerPromedioCualitativo());
        System.out.printf("\n%s\n", cadena);
    }
}
