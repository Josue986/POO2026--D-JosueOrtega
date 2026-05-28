/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodemodos;

import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class Principal {
    
    public static void main(String[] args) {
        // Crear objetos tipos Pais, hasta que el 
        // usuario lo decida
        Scanner entrada = new Scanner(System.in); // objeto - datos por teclado
        boolean bandera = true;
        String pregunta; // la usaremos para determinar el proceso de fin de ciclo
        String nPais;
        String cPais;
        
        while(bandera==true){ // while(bandera)
            // 1. Solicitamos por teclado los datos para crear el objeto
            System.out.println("Ingresar el nombre del país");
            nPais = entrada.nextLine();
            System.out.println("Ingresar la capital del país");
            cPais = entrada.nextLine();
            
            // 2. Se crea el objeto Pais, usando el constructor
            Pais p1 = new Pais(nPais, cPais);
            
            // 3. Usamos los métodos obtener de cada atributo para presentar
            // datos del objetos País creado (p1)
            
            System.out.printf("Los datos del país son: Nombre: %s "
                    + "Capital: %s\n", p1.obtenerNombrePais(), 
                    p1.obtenerCapitalPais());
            
            // 4. Pregutamos al usuario si desea ingresar más objetos tipo País
            
            System.out.println("Desea ingresar más datos. Ingrese (s) para "
                    + "salir del proceso");
            pregunta = entrada.nextLine();
            
            if(pregunta.equals("s")){
                bandera = false;
            }
            
        }
        
    }
    
}
