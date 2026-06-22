package CONTROLLER;
import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

public class MascotaController {
    ArrayList<Mascota> mascotas = new ArrayList<>();

    public void agregar(String idMascota, String nombre, 
                        String fechaNacimiento, double peso, 
                        Especie especie, String cedulaPropietario) { 
        if (buscar(idMascota) != null) {
            return;
        }
        Mascota m = new Mascota(idMascota, nombre, fechaNacimiento, 
                                peso, especie, cedulaPropietario); 
        mascotas.add(m);
    }

    public Mascota buscar(String id) {
        for (Mascota m : mascotas) {
            if (m.getIdMas().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Mascota eliminar(String id) {
        Mascota m = buscar(id);
        if (m != null) {
            mascotas.remove(m);
            return m;
        }
        return null;
    }

    // ← método nuevo para filtrar por propietario
    public ArrayList<Mascota> getMascotasPorPropietario(String cedula) {
        ArrayList<Mascota> resultado = new ArrayList<>();
        for (Mascota m : mascotas) {
            if (m.getCedulaPropietario().equals(cedula)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                new java.io.FileOutputStream("dataMascota.txt"));
            for (Mascota m : mascotas) {
                salida.writeObject(m);
            }
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }
    }

    public void cargar() {
        LeerMascota lectura = new LeerMascota("dataMascota.txt");
        lectura.establecerListaMascota();
        mascotas = lectura.obtenerListaMascota();
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
}