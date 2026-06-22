/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;

import MODEL.Factura;
import java.io.*;
import java.util.ArrayList;

public class LeerFactura {
    private ObjectInputStream entrada;
    private ArrayList<Factura> facturas;
    private String nombreArchivo;

    public LeerFactura(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(n));
            } catch (IOException ex) {
                System.err.println("Error al abrir: " + ex);
            }
        }
    }

    public void establecerListaFacturas() {
        facturas = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                try {
                    Factura registro = (Factura) entrada.readObject();
                    facturas.add(registro);
                } catch (EOFException ex) {
                    return;
                } catch (IOException | ClassNotFoundException ex) {
                    System.err.println("Error al leer: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }
    }

    public ArrayList<Factura> obtenerListaFacturas() { return facturas; }
}