/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;

import java.io.*;
import java.util.ArrayList;
import MODEL.*;

public class LeerCita {

    private ObjectInputStream entrada;
    private ArrayList<CitaMedica> citas;
    private String nombreArchivo;

    public LeerCita(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(n));
            } catch (IOException ex) {
                System.err.println("Error al abrir el archivo.");
            }
        }
    }

    public void establecerListaCitas() {
        citas = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                try {
                    CitaMedica registro = (CitaMedica) entrada.readObject();
                    citas.add(registro);
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

    public ArrayList<CitaMedica> obtenerListaCitas() {
        return citas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
}
