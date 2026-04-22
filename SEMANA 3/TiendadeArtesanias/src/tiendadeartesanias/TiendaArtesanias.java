/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendadeartesanias;

import java.util.ArrayList;

/**
 *
 * @author SebastianCodena
 */
public class TiendaArtesanias {
     private String id;
    private String nombre;
    private String direccion;
    private ArrayList<Artesania> inventario = new ArrayList<>();

    public TiendaArtesanias(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void registrarArtesania(Artesania a) {
        inventario.add(a);
        System.out.println("Artesania registrada: " + a.getNombre());
    }

    public boolean venderProducto(Cliente cliente, Artesania a, int cantidad) {
        if (!a.reducirStock(cantidad)) return false;

        Venta venta = new Venta("V01", a, cantidad);

        if (!cliente.puedeComprar(venta.getTotal())) {
            System.out.println("Cliente sin dinero suficiente");
            return false;
        }

        cliente.pagar(venta.getTotal());

        System.out.println("Venta realizada con éxito");
        return true;
    }
}