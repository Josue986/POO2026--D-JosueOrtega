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
public class propietarioController {

    ArrayList<Propietario> propietarios = new ArrayList<>();

    public void obtenerdatos(String cedula, String nombre, String telefono, String direccion) {

        if (mostrardatos(cedula) != null) {
            System.err.print("Nombre usuario ya existente en la base de datos");
            return;
        }
        Propietario p = new Propietario(cedula, nombre, telefono, direccion);
        propietarios.add(p);

    }

    public Propietario mostrardatos(String cedula) {

        for (int i = 0; i < propietarios.size(); i++) {
            Propietario p = propietarios.get(i);
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public Propietario Eliminar(String cedula) {
        for (int i = 0; i < propietarios.size(); i++) {
            Propietario p = propietarios.get(i);
            if (p.getCedula().equals(cedula)) {
                propietarios.remove(p);
                return p;
            }
        }
        return null;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream("dataPropietarios.txt"));
            for (Propietario p : propietarios) {
                salida.writeObject(p);
            }
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }

    }

    public void cargar() {
        LeerPropietario lectura = new LeerPropietario("dataPropietarios.txt");
        lectura.establecerListaPropietario();
        propietarios = lectura.obtenerListaPropietario();
    }

    public ArrayList<Propietario> getPropietario() {
        return propietarios;
    }
}
