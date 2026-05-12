package ejecutarhospítal;
import java.util.Scanner;

public class EjecutarHospítal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean salir = true;
        
        // Variables a usae
        String nomH = "";
        String ciudad = "";
        int nDoc = 0;
        int nCam = 0;
        double pres;
        
                
        do {
            // Imprimo un Menu de opciones
            System.out.println("------------------------------------------------------");
            System.out.println("Menu de opciones");
            System.out.println("1) Crear un Hospital en Quito");
            System.out.println("2) Crear un Hospital en Quito con un presupusto de 2500.10");
            System.out.println("3) Crear un Hospital en Ecuador");
            System.out.println("4) Salir.\n");
            System.out.print("Opcion: ");
            opc = sc.nextInt();
            sc.nextLine();        
            System.out.println("------------------------------------------------------");
        
            switch (opc) {
                case 1:
                    System.out.println("\n------------------------------------------------------");
                    System.out.print("Ingrese nombre del Hospital: ");
                    nomH = sc.nextLine();
                    System.out.print("Ingrese numero de Doctores: ");
                    nDoc = sc.nextInt();
                    System.out.print("Ingrese numero de camas: ");
                    nCam = sc.nextInt();
                    System.out.print("Ingrese presupuesto del Hospital: ");
                    pres = sc.nextDouble();
                
                    Hospital h = new Hospital (nomH, nDoc, nCam, pres); // Uso el primer constructor de mi objeto
                
                    System.out.println("El Hospital " + h.getNombreHospital() + " creado en la ciudad de " 
                        + h.getCiudad() + " tiene un presupuesto de " + h.getPresupuesto());
                    System.out.println("\n------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("\n------------------------------------------------------");
                    System.out.print("Ingrese nombre del Hospital: ");
                    nomH = sc.nextLine();
                    System.out.print("Ingrese numero de Doctores: ");
                    nDoc = sc.nextInt();
                    System.out.print("Ingrese numero de camas: ");
                    nCam = sc.nextInt();
                
                    Hospital h1 = new Hospital (nomH, nDoc, nCam); // Uso el primer constructor de mi objeto
                
                    System.out.println("El Hospital " + h1.getNombreHospital() + " creado en la ciudad de " 
                        + h1.getCiudad() + " tiene un presupuesto de " + h1.getPresupuesto());
                    System.out.println("\n------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("\n------------------------------------------------------");
                    System.out.print("Ingrese nombre del Hospital: ");
                    nomH = sc.nextLine();
                    System.out.print("Ingrese la ciudad: ");
                    ciudad = sc.nextLine();
                    System.out.print("Ingrese numero de Doctores: ");
                    nDoc = sc.nextInt();
                    System.out.print("Ingrese numero de camas: ");
                    nCam = sc.nextInt();
                    System.out.print("Ingrese presupuesto del Hospital: ");
                    pres = sc.nextDouble();
                
                    Hospital h2 = new Hospital (nomH, ciudad, nDoc, nCam, pres); // Uso el primer constructor de mi objeto
                
                    System.out.println("El Hospital " + h2.getNombreHospital() + " creado en la ciudad de " 
                        + h2.getCiudad() + " tiene un presupuesto de " + h2.getPresupuesto());
                    System.out.println("------------------------------------------------------");
                    break;
                    
                case 4:
                    salir = false;
                    System.out.println("Saliendo del Sistema");
                    System.out.println("------------------------------------------------------\n");
                    break;
                default:
                    System.out.println("Ingrese un valor entre 1 y 3");
                    break;
            }
        } while (salir);
        
    }    
}
