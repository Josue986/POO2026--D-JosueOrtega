/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

public class ExamenMedicoController {
    ArrayList<ExamenMedico> examenes = new ArrayList<>();

    public void agregar(String idExamen, String tipo, String resultado, double costo) {
        if (buscar(idExamen) != null) return;
        ExamenMedico e = new ExamenMedico(idExamen, tipo, resultado, costo);
        examenes.add(e);
    }

    public ExamenMedico buscar(String idExamen) {
        for (ExamenMedico e : examenes) {
            if (e.getIdExamen().equals(idExamen)) return e;
        }
        return null;
    }

    public ExamenMedico eliminar(String idExamen) {
        ExamenMedico e = buscar(idExamen);
        if (e != null) {
            examenes.remove(e);
            return e;
        }
        return null;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("dataExamen.txt"));
            for (ExamenMedico e : examenes) salida.writeObject(e);
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }
    }

    public void cargar() {
        LeerExamen lectura = new LeerExamen("dataExamen.txt");
        lectura.establecerListaExamenes();
        examenes = lectura.obtenerListaExamenes();
    }

    public ArrayList<ExamenMedico> getExamenes() { return examenes; }
}
