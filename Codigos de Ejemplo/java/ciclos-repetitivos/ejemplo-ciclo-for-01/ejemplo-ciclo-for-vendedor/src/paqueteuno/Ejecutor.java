/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;

public class Ejecutor {
    public static void main(String[] args) {
        // variables para ingreso de datos
             
        String nombre;
        int edad;
        double sMinino;
        int autos;
        int numeroVendedores; // variable que usará para almacenar el número de
                             // vendedores a procesar
                             
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingreso el número de vendedores a procesar");
        numeroVendedores = entrada.nextInt();
        entrada.nextLine(); // Scanner.nextLine() no actua correctamente 
                            // despues de Scanner.nextInt()
                            // Puede revisar: https://bit.ly/2LMJTUU 
        // Inicio de proceso iterativo 
        for (int i = 0; i < numeroVendedores; i++) {
                
            System.out.println("Ingrese el nombre del vendedor");
            nombre = entrada.nextLine();
            System.out.println("Ingrese edad del vendedor");
            edad = entrada.nextInt();
            System.out.println("Ingrese el salario mínimo");
            sMinino = entrada.nextDouble();
            System.out.println("Ingrese el número de autos vendidos");
            autos = entrada.nextInt();
            
            // con los datos ingresados se crea el objeto de tipo Vendedor
            Vendedor v = new Vendedor(nombre, edad, sMinino, autos);
            v.calcularPagoMensual();
            
            
            // Para la presentación en pantalla se usa printf
            // Creating Format Strings
            // https://docs.oracle.com/javase/tutorial/java/data/strings.html
            System.out.printf("\n\nDatos de Vendedor\n" +
                    "Nombre: %s\n" +
                    "Edad: %d\n" +
                    "Salario mínimo: %.2f\n" +
                    "Número de autos: %d\n" +
                    "Pago mensual: %.2f\n\n", 
                    v.obtenerNombres(), 
                    v.obtenerEdad(),
                    v.obtenerSalarioMinimo(), 
                    v.obtenerNumeroAutos(),
                    v.obtenerPagoMensual());
            
            entrada.nextLine(); // Scanner.nextLine() no actua correctamente 
                            // despues de Scanner.nextInt()
                            // Puede revisar: https://bit.ly/2LMJTUU 
        }
    }
}
