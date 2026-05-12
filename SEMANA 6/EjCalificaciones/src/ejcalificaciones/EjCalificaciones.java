package ejcalificaciones;
import java.util.Scanner;

public class EjCalificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nombre, materia;
        int n;
        double notas;
        
        System.out.println("----   Datos del Estudiante.   ---- ");
        System.out.print("Nombre: ");
        nombre = sc.nextLine();       
        System.out.print("Cuantas notas va a registrar?: ");
        n = sc.nextInt();
        
        double[] matNotas = new double[n];
        
        
        for(int i=0; i<matNotas.length;i++){
            System.out.print("Nota (" + (i+1) + "): ");
            notas = sc.nextDouble();
            System.out.println("Materia: ");
            materia = sc.nextLine();
            
        }
        
        Libreta libreta = new Libreta(nombre, notas);
        
        libreta.calcularPromedio(notas);
        libreta.calcularPromedioCualitativo();
        
        System.out.println("El alumno " + libreta.getNombreAlumno() + " tiene un promedio de " + libreta.getPromedio() 
                + " (" + libreta.getPromedioCualitativo() + ").");
    }
    
}
