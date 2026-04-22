
package com.mycompany.ejecutordatosestudiante;
import java.util.Scanner;

public class EjecutorDatosEstudiante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float nota1 = 0;
        float nota2 = 0;
        float nota3 = 0;
        String nombre = null;
        String id = null;
        String añoEscolar = null;
        
        System.out.println("|   Sistema para datos de estudiantes   |");
        
        //1er Estudiante
        System.out.print("\n Nombre de Estudiante 1: ");
        nombre = sc.nextLine();
        System.out.print("ID del Estudiante: ");
        id = sc.nextLine();
        System.out.print("Curso / Anno del estudiante: ");
        añoEscolar = sc.nextLine();
        
        Estudiante estudiante1 = new Estudiante (nombre, id, añoEscolar);
        
        System.out.println("Acontinuacion ingrese tres notas del estudiante");
        System.out.print("Nota 1: ");
        nota1 = sc.nextFloat();
        System.out.print("Nota 2: ");
        nota2 = sc.nextFloat();
        System.out.print("Nota 3: ");
        nota3 = sc.nextFloat();
        sc.nextLine();
        
        estudiante1.calcularPromedio(nota1, nota2, nota3);
        System.out.println(estudiante1.getPromedio());  
        
        //2do Estudiante
        System.out.print("\n Nombre de estudiante 2: ");
        nombre = sc.nextLine();
        System.out.print("ID del Estudiante: ");
        id = sc.nextLine();
        System.out.print("Curso / Anno del Estudiante: ");
        añoEscolar = sc.nextLine();
        
        Estudiante estudiante2 = new Estudiante (nombre, id, añoEscolar);
        System.out.println("Acontinuacion ingrese tres notas del estudiante");
        System.out.print("Nota 1: ");
        nota1 = sc.nextFloat();
        System.out.print("Nota 2: ");
        nota2 = sc.nextFloat();
        System.out.print("Nota 3: ");
        nota3 = sc.nextFloat();
        sc.nextLine();
        
        estudiante2.calcularPromedio(nota1, nota2, nota3);
        System.out.println(estudiante2.getPromedio());  
        
        //3er Estudiante
        System.out.print("\n Nombre de Estudiante 3: ");
        nombre = sc.nextLine();
        System.out.print("ID del Estudiante: ");
        id = sc.nextLine();
        System.out.print("Curso / Anno del Estudiante: ");
        añoEscolar = sc.nextLine();      
        Estudiante estudiante3 = new Estudiante (nombre, id, añoEscolar);
        
        System.out.println("Acontinuacion ingrese tres notas del estudiante");
        System.out.print("Nota 1: ");
        nota1 = sc.nextFloat();
        System.out.print("Nota 2: ");
        nota2 = sc.nextFloat();
        System.out.print("Nota 3: ");
        nota3 = sc.nextFloat();
        
        estudiante3.calcularPromedio(nota1, nota2, nota3);
        System.out.println(estudiante3.getPromedio());  
        
    }   
}
