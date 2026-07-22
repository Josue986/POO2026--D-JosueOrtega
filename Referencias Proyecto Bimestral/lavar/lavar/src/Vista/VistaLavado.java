package Vista;

import Modelo.*;
import Controlador.LavadoDAO;
import Util.ConexionSQLite;

import java.util.Scanner;

public class VistaLavado {
    
    private LavadoDAO controlado ;
    private Scanner scanner;

    public VistaLavado() {
        controlado = new LavadoDAO();
        scanner = new Scanner(System.in);
    }
    
    // Menu del cliente
    
    public void menu(){
        int opcion;
        
        do{
            System.out.println("Menu de opciones: ");
            System.out.println("1. Registrar Lavados.");
            System.out.println("2. Mostrar lavados.");
            System.out.println("0. Salir ");
            opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: 
                        registrarLavado();
                        break;
                    case 2:
                        mostrarLavado();
                        break;
                    case 0:
                        System.out.println("Muchas gracias por usar el sistema.");
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida entre 1 y 2");
                        break;
                }
        }while(opcion != 0 );
       
    }
    
        public void registrarLavado() {
            scanner.nextLine();
            System.out.println("Ingresar los datos de lavados del auto: ");
            System.out.println("Ingresa la placa: ");
            String placa = scanner.nextLine();
            System.out.println("Ingresa la cliente: ");
            String cliente = scanner.nextLine();
            int op;
            System.out.println("Ingresa el tipo de lavado");
            System.out.println("1. Lavado Basico");
            System.out.println("2. Lavado Completo");
            System.out.println("3. Lavado Premium");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Lavado basico");
                    LavadoBasico lb = new LavadoBasico(placa,cliente);
                    lb.tipoLavado();
                    lb.precio();
                    controlado.registrarLavado(lb);
                    break;
                case 2:
                    System.out.println("Lavado Completo");
                    LavadoCompleto lc = new LavadoCompleto(placa,cliente);
                    lc.tipoLavado();
                    lc.precio();
                    controlado.registrarLavado(lc);
                    break;
                case 3:
                    System.out.println("Lavado Premium");
                    LavadoPremium lp = new LavadoPremium(placa,cliente);
                    lp.tipoLavado();
                    lp.precio();
                    controlado.registrarLavado(lp);
                    break;    
                default:
                    System.out.println("Ingrese un valor valido entre 1 - 3");
            }
            
            
        }

        public void mostrarLavado() {
             var lista = controlado.obtenerLavados();
        
             System.out.println("\n--- Lavados del día ---");
        
             if (lista.isEmpty()) {
                System.out.println("No hay registros.");
            } else {
                
                 for (String item : lista){
                    
                    System.out.println(item);
                
                    }


                    //lista.forEach(System.out::println);
            }
        }
    
}
