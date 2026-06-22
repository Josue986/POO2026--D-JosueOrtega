/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

/**
 *
 * @author SebastianCodena
 */
public class Joyeria extends Artesania {

    private String prenda;
    private double talla;
    private String piedras;

    public Joyeria(String id, String nombre, double precioBase, int stock, String creador,
                   Material material, String prenda, double talla, String piedras) {

        super(id, nombre, precioBase, stock, creador, material);
        this.prenda = prenda;
        this.talla = talla;
        this.piedras = piedras;
    }

    public void solicitarGrabado(String mensaje, String estiloFuente) {
        System.out.println("Grabado solicitado: " + mensaje + " con estilo " + estiloFuente);
    }
}
