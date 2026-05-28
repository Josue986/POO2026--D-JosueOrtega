/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

public class ConsultaMedicaController {

    ArrayList<ConsultaMedica> consultas = new ArrayList<>();

    public void agregar(String idConsulta, String fecha, String motivo,
            String diagnostico, String idMascota, double costoBase) {
        if (buscar(idConsulta) != null) {
            return;
        }
        ConsultaMedica c = new ConsultaMedica(idConsulta, idMascota, fecha,
        motivo, diagnostico, costoBase);
        consultas.add(c);
    }

    public ConsultaMedica buscar(String idConsulta) {
        for (ConsultaMedica c : consultas) {
            if (c.getIdConsulta().equals(idConsulta)) {
                return c;
            }
        }
        return null;
    }

    public ConsultaMedica eliminar(String idConsulta) {
        ConsultaMedica c = buscar(idConsulta);
        if (c != null) {
            consultas.remove(c);
            return c;
        }
        return null;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream("dataConsulta.txt"));
            for (ConsultaMedica c : consultas) {
                salida.writeObject(c);
            }
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }
    }

    public void cargar() {
        LeerConsulta lectura = new LeerConsulta("dataConsulta.txt");
        lectura.establecerListaConsultas();
        consultas = lectura.obtenerListaConsultas();
    }

    public ArrayList<ConsultaMedica> getConsultas() {
        return consultas;
    }
}
