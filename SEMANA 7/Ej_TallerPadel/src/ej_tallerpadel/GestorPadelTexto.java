package ej_tallerpadel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorPadelTexto {
    public static void guardarPartido(PartidoPadel partido, String rutaArchivo){
        try (  
            BufferedWriter write = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir los atributos separados por (;)
            String linea = partido.getPareja1() + ";" + partido.getPareja2() + ";" + partido.getMarcador();
            write.write(linea);
            System.out.println("Partido guardado en el archivo de texto plano (.txt).");
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo de texto: " + e.getMessage());
        }
    }

    public static PartidoPadel cargarPartido(String rutaArchivo) {
        try (
            BufferedReader read = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea =  read.readLine();
            if (linea != null) {
                // Parsing: separamos la cadena usando el delimitador
                String[] datos = linea.split(";");
                if (datos.length == 3){
                    return new PartidoPadel(datos[0], datos[1], datos[2]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar desde el archivo de texto: " + e.getMessage());
        }
        return null;
    }
}
