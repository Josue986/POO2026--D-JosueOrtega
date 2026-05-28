/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Especie;
import MODEL.Mascota;
import java.util.ArrayList;
import DATABASE.*;

/**
 *
 * @author Pablo
 */
public class EspecieController {

    ArrayList<Especie> especies = new ArrayList<>();

    public void agregar(String id, String nombre) {
        if (buscar(id) != null) {
            return; // ya existe, no agrega
        }
        Especie e = new Especie(id, nombre);
        especies.add(e);
    }

    public Especie buscar(String id) {

        for (int i = 0; i < especies.size(); i++) {
            Especie e = especies.get(i);
            if (e.getIdEspecie().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public Especie eliminar(String id) {

        for (int i = 0; i < especies.size(); i++) {
            Especie e = especies.get(i);
            if (e.getIdEspecie().equals(id)) {
                especies.remove(e);
                return e;
            }
        }
        return null;
    }

    public Especie buscarPorNombre(String nombre) {
        for (int i = 0; i < especies.size(); i++) {
            Especie e = especies.get(i);
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    public int contarMascotasPorEspecie(String nombre, ArrayList<Mascota> mascotas) {
        int contador = 0;
        for (Mascota m : mascotas) {
            if (m.getE().getNombre().equals(nombre)) {
                contador++;
            }
        }
        return contador;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream("dataEspecie.txt"));
            for (Especie e : especies) {
                salida.writeObject(e);
            }
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }

    }

    public void cargar() {
        LeerEspecie lectura = new LeerEspecie("dataEspecie.txt");
        lectura.establecerListaEspecies();
        especies = lectura.obtenerListaEspecies();
    }

    public ArrayList<Especie> getEspecies() {
        return especies;
    }
}
