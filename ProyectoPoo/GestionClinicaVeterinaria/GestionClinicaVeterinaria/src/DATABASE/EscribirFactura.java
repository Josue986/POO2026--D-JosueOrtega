/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;

import MODEL.Factura;
import java.io.*;
import java.util.ArrayList;

public class EscribirFactura {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<Factura> lista;

    public EscribirFactura(String n) {
        nombreArchivo = n;
        establecerLista();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            for (Factura f : lista) salida.writeObject(f);
        } catch (IOException ex) {
            System.err.println("Error al abrir: " + ex);
        }
    }

    public void establecerLista() {
        LeerFactura l = new LeerFactura(nombreArchivo);
        l.establecerListaFacturas();
        lista = l.obtenerListaFacturas();
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) salida.close();
        } catch (IOException ex) {
            System.err.println("Error al cerrar: " + ex);
        }
    }

    public ArrayList<Factura> obtenerLista() { return lista; }
}
