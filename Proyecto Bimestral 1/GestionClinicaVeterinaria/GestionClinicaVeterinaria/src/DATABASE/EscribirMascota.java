/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import MODEL.*;
import CONTROLLER.*;

public class EscribirMascota {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Mascota registro;
    private ArrayList<Mascota> lista;

    public EscribirMascota(String dataMascota) {
        nombreArchivo = dataMascota;
        establecerLista();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistro(Mascota m) {
        registro = m;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerLista() {
        LeerMascota l = new LeerMascota(obtenerNombreArchivo());
        l.establecerListaMascota();
        lista = l.obtenerListaMascota();
    }

    public String obtenerNombreArchivo() { return nombreArchivo; }
    public ArrayList<Mascota> obtenerLista() { return lista; }
    public ObjectOutputStream obtenerSalida() { return salida; }

    public void cerrarArchivo() {
        try {
            if (salida != null) salida.close();
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        }
    }
}