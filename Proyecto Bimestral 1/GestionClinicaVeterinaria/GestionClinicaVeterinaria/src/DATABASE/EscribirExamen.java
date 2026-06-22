package DATABASE;

import java.io.*;
import java.util.ArrayList;
import MODEL.*;

public class EscribirExamen {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private ArrayList<ExamenMedico> lista;

    public EscribirExamen(String n) {
        nombreArchivo = n;
        establecerLista();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            for (ExamenMedico e : lista) {
                salida.writeObject(e);
            }
        } catch (IOException ex) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerLista() {
        LeerExamen l = new LeerExamen(nombreArchivo);
        l.establecerListaExamenes();
        lista = l.obtenerListaExamenes();
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

    public ArrayList<ExamenMedico> obtenerLista() {
        return lista;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
}
