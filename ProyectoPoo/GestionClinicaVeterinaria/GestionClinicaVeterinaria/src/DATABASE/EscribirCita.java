/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;

import java.io.*;
import java.util.ArrayList;
import MODEL.*;

public class EscribirCita {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<CitaMedica> lista;

    public EscribirCita(String n) {
        nombreArchivo = n;
        establecerLista();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            for (CitaMedica c : lista) {
                salida.writeObject(c);
            }
        } catch (IOException ex) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerLista() {
        LeerCita l = new LeerCita(nombreArchivo);
        l.establecerListaCitas();
        lista = l.obtenerListaCitas();
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ex) {
            System.err.println("Error al cerrar el archivo.");
        }
    }

    public ArrayList<CitaMedica> obtenerLista() {
        return lista;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
}
