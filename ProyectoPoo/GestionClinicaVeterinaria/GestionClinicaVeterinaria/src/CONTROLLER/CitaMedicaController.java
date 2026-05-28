/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

public class CitaMedicaController {
    ArrayList<CitaMedica> citas = new ArrayList<>();

    public void agregar(String idCita, String fecha, String hora, 
                        String estado, String idMascota) {
        if (buscar(idCita) != null) return;
        CitaMedica c = new CitaMedica(idCita, fecha, hora, estado, idMascota);
        citas.add(c);
    }

    public CitaMedica buscar(String idCita) {
        for (CitaMedica c : citas) {
            if (c.getIdCita().equals(idCita)) return c;
        }
        return null;
    }

    public CitaMedica eliminar(String idCita) {
        CitaMedica c = buscar(idCita);
        if (c != null) {
            citas.remove(c);
            return c;
        }
        return null;
    }

    public void cambiarEstado(String idCita, String nuevoEstado) {
        CitaMedica c = buscar(idCita);
        if (c != null) c.setEstado(nuevoEstado);
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("dataCita.txt"));
            for (CitaMedica c : citas) salida.writeObject(c);
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }
    }

    public void cargar() {
        LeerCita lectura = new LeerCita("dataCita.txt");
        lectura.establecerListaCitas();
        citas = lectura.obtenerListaCitas();
    }

    public ArrayList<CitaMedica> getCitas() { return citas; }
}