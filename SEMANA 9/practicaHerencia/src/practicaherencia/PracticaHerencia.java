
package practicaherencia;
import java.util.ArrayList;
import java.util.Scanner;

public class PracticaHerencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        String id =  "";
        String nombre = "";
        int cargaHoraria = 0;
        
        String lenguajeProgramacion = "";
        String rolEnEquipo = "";
        
        Desarrollador dev = new Desarrollador("", "", 0, "", "");
        ArrayList<Desarrollador> devs;
        
        do {
            System.out.println("====================================");
            System.out.println("|         Lista de Tickets         |");
            System.out.println("====================================");
            System.out.println("1) Registrar Desarrollador.");
            System.out.println("2) Ver informacion del Desarrollador.");         
            System.out.println("0) Salir del Programa.");
            System.out.print("> ");
            opc = sc.nextInt();
            sc.nextLine();
            System.out.println("--------------------------\n");
            switch(opc){
                case 1:
                    System.out.print("\nID: ");
                    id = sc.nextLine();
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Carga Horaria: ");
                    cargaHoraria = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Lenguaje de Programacion: " + lenguajeProgramacion);
                    lenguajeProgramacion = sc.nextLine();
                    System.out.print("Rol en Equipo: ");
                    rolEnEquipo = sc.nextLine();
                    
                    dev.setIdEmpleado(id);
                    dev.setNombre(nombre);
                    dev.setCargaHoraria(cargaHoraria);
                    dev.setLenguajeProgrmacion(lenguajeProgramacion);
                    dev.setRolEnEquipo(rolEnEquipo);
                    
                    // devs.add(dev);
                    System.out.println("--------------------------");
                break;
                case 2:
                    System.out.println("");
                    dev.infoSuper();        
                    System.out.println("");
                    dev.info();
                    System.out.println("--------------------------");
                break;
                case 0:
                    System.out.println("\nSaliendo del Sistema.");
                    System.out.println("--------------------------");
                break;    
                default:
                    System.out.println("\nError: solo se permiten numeros enteros");
                    System.out.println("---------------------------------------");
                break;
            }
        } while(opc!=0);
    }
    
}
