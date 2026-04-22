/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

/**
 *
 * @author SebastianCodena
 */
   public class Ceramica extends Artesania {

    private boolean esmalte;
    private double peso;

    public Ceramica(String id, String nombre, double precioBase, int stock, String creador,
                    Material material, boolean esmalte, double peso) {

        super(id, nombre, precioBase, stock, creador, material);
        this.esmalte = esmalte;
        this.peso = peso;
    }

    public void mostrarInfoCeramica() {
        System.out.println("Ceramica -> Esmalte: " + esmalte + ", Peso: " + peso);
    }
}