package ejecutarmenusrestaurante;

import java.util.Scanner;

public class EjecutarMenusRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==================================================");
        System.out.println("       SISTEMA DE FACTURACION - RESTAURANTE       ");
        System.out.println("==================================================");
    
        System.out.print("Ingrese el nombre del cliente: ");
        String cliente = scanner.nextLine();
        
       
        Factura factura = new Factura(cliente, 0.15);
        
        Menus platoCarta = new MenuCarta("Lomo Fino con Champiñones", 10.00, 2.50, 1.50, 0.10);
        Menus platoDia = new MenuDia("Seco de Pollo Criollo", 3.50, 1.00, 0.50);
        Menus platoNinos = new MenuNinos("Nuggets con Papas Fritas", 4.00, 1.25, 0.75);
        Menus platoEconomico = new MenuEconomico("Almuerzo de Pescado", 3.00, 0.15);

        boolean agregandoPlatos = true;  

            while (agregandoPlatos) {
                System.out.println("\n========================================================================================================");
                System.out.println("                                      NUESTRO MENU DEL DIA                                              ");
                System.out.println("========================================================================================================");

           
                System.out.println("1. " + platoCarta);
                System.out.println("2. " + platoDia);
                System.out.println("3. " + platoNinos);
                System.out.println("4. " + platoEconomico);
                System.out.println("5. [ Finalizar pedido y generar Factura]");
                System.out.println("========================================================================================================");
                System.out.print("Seleccione una opción (1-5): ");

                int opcion = scanner.nextInt();
            
            if (opcion == 5) {
                agregandoPlatos = false; 
            } else if (opcion >= 1 && opcion <= 4) {
                System.out.print("¿Que cantidad desea solicitar de este plato?: ");
                int cantidad = scanner.nextInt();     
              
                Menus platoSeleccionado = null;
                switch (opcion) {
                    case 1: platoSeleccionado = platoCarta; break;
                    case 2: platoSeleccionado = platoDia; break;
                    case 3: platoSeleccionado = platoNinos; break;
                    case 4: platoSeleccionado = platoEconomico; break;
                }   
             
                DetallesFactura nuevoDetalle = new DetallesFactura(platoSeleccionado, cantidad);
                factura.agregarDetalle(nuevoDetalle);
                System.out.println("️ ¡Plato añadido con exito al pedido!");
            } else {
                System.out.println(" Opcion no valida. Intente nuevamente.");
            }
        }
        
        System.out.println("\nGenerando comprobante electronico...");
        factura.mostrarInfo();
        
        scanner.close();
    }
}