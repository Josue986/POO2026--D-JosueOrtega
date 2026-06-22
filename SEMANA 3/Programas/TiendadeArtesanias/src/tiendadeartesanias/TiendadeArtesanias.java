/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendadeartesanias;

import java.util.Scanner;

/**
 *
 * @author SebastianCodena
 */
public class TiendadeArtesanias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
   
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SISTEMA DE ARTESANIAS =====");

        // Crear material
        System.out.print("Ingrese tipo de material: ");
        String tipo = sc.nextLine();

        System.out.print("Ingrese costo del material: ");
        double costo = sc.nextDouble();
        sc.nextLine();

        Material material = new Material("M01", tipo, costo);

        // Crear artesanía
        System.out.print("Ingrese nombre de la artesania: ");
        String nombre = sc.nextLine();

        Artesania art = new Artesania("A01", nombre, 100, 5, "Artesano", material);
        Material oro = new Material("M01", "Oro", 50);

// JOYERIA
    Joyeria anillo = new Joyeria(
    "A01", "Anillo", 100, 5, "Luis",
    oro, "Anillo", 7.5, "Diamante"
);

// CERAMICA
Ceramica taza = new Ceramica(
    "A02", "Taza", 50, 10, "Maria",
    oro, true, 1.2
);

        // Crear cliente
        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        Cliente cliente = new Cliente("C01", nombreCliente, "Perez", "123", 500);

        // Crear tienda
        TiendaArtesanias tienda = new TiendaArtesanias("T01", "ArteLoja", "Centro");

        System.out.println("\nRegistrando artesania...");
        tienda.registrarArtesania(art);

        System.out.println("\nIntentando vender producto...");
        tienda.venderProducto(cliente, art, 2);

        System.out.println("\n===== FIN DEL PROCESO =====");
    }
}
