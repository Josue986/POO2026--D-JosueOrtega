/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    public static void main(String[] args) {
        // variables
        int edad;
        String nombre;
        double pensionBasica;
        int numeropensiones;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese número pensiones");
        numeropensiones = entrada.nextInt();
        
        entrada.nextLine();
        for (int i = 0; i < numeropensiones; i++) {
            System.out.println("Ingrese nombre del alumno");
            nombre = entrada.nextLine();
            System.out.println("Ingrese edad del alumno");
            edad = entrada.nextInt();
            System.out.println("Ingrese pension básica");
            pensionBasica = entrada.nextDouble();
            entrada.nextLine();
            // se crea el objeto
            PensionMatricula pension = new PensionMatricula(nombre, edad, 
                    pensionBasica);
            
            System.out.println("Datos de pensión");
            System.out.printf("Nombre: %s\n", pension.obtenerNombreAlumno());
            System.out.printf("Edad: %d\n", pension.obtenerEdad());
            System.out.printf("Pensión Básica: %.2f\n", 
                    pension.obtenerPensionBasica());
            System.out.printf("Pensión Final: %.2f\n", 
                    pension.obtenerPensionFinal());
            System.out.printf("----------------------------");
        }
    }
}
