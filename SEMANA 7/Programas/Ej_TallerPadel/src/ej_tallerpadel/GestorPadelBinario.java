package ej_tallerpadel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GestorPadelBinario {
    public static void guardarPartido(PartidoPadel partido, String rutaArchivo){
        try (
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            save.writeObject(partido);
            System.out.println("Partidos guardados en el archivo binario (.dat).");
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo binario: " + e.getMessage());
        }
    }

    public static PartidoPadel cargarPartido(String rutaArchivo) {
        try (ObjectInputStream view = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (PartidoPadel) view.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar desde el archivo binario: " + e.getMessage());
            return null;
        }
    }
}
