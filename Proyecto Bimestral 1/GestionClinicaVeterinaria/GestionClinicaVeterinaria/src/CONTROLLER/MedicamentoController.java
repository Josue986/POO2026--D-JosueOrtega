/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

/**
 *
 * @author Pablo
 */
public class MedicamentoController {

    ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public void agregar(String id, String nombre, double precio, int stock) {
        if (buscar(id) != null) {
        return; // ya existe, no agrega
    }
    Medicamento m = new Medicamento(id, nombre, precio, stock);
    medicamentos.add(m);

    }

    public Medicamento buscar(String id) {
        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento m = medicamentos.get(i);
            if (m.getIdMed().equals(id)) {
                return m;
            }
        }
        return null;
    }
    public Medicamento eliminar(String id) {
        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento m = medicamentos.get(i);
            if (m.getIdMed().equals(id)) {
                medicamentos.remove(m);
                return m;
            }
        }
        return null;
    }
    public void entregar(String id, int cantidad) {
    Medicamento m = buscar(id);
    if (m != null) {
        if (m.verificarDisponibilidad()) {
            m.reducirStock(cantidad);
            guardar();
        } else {
            System.err.println("Stock insuficiente");
        }
    }
}
    public void recargarMedicamentos(String id,int cantidad) {
        Medicamento m = buscar(id);
    if (m != null) {
        m.setStock(m.getStock()+cantidad);
    }
        
    }
    public void recetar(String idMed, String idConsulta, int cantidad, 
                    ConsultaMedicaController controllerConsulta) {
    Medicamento m = buscar(idMed);
    if (m != null) {
        if (m.verificarDisponibilidad()) {
            m.reducirStock(cantidad);
            guardar();
            ConsultaMedica c = controllerConsulta.buscar(idConsulta);
            if (c != null) {
                ExamenMedico examen = new ExamenMedico(
                    idMed,
                    "Medicamento: " + m.getNombreMed(),
                    "Cantidad: " + cantidad,
                    m.getPrecioMed() * cantidad
                );
                c.agregarExamen(examen);
                controllerConsulta.guardar();
            }
        } else {
            System.err.println("Stock insuficiente");
        }
    }
}
    public void guardar() {
    try {
        java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
            new java.io.FileOutputStream("dataMedicamentos.txt"));
        for (Medicamento m : medicamentos) {
            salida.writeObject(m);
        }
        salida.close();
    } catch (java.io.IOException ex) {
        System.err.println("Error al guardar: " + ex);
    }
}

public void cargar() {
    LeerMedicamentos lectura = new LeerMedicamentos("dataMedicamentos.txt");
    lectura.establecerListaMedicamentos();
    medicamentos = lectura.obtenerListaMedicamento();
}
public ArrayList<Medicamento> getMedicamentos() {
    return medicamentos;
}

}
