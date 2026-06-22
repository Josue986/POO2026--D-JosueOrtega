/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATABASE;
import java.io.*;
import java.util.ArrayList;
import MODEL.*;

public class LeerExamen {
    private ObjectInputStream entrada;
    private ArrayList<ExamenMedico> examenes;
    private String nombreArchivo;

    public LeerExamen(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(n));
            } catch (IOException ex) {
                System.err.println("Error al abrir el archivo.");
            }
        }
    }

    public void establecerListaExamenes() {
        examenes = new ArrayList<>();
        File f = new File(nombreArchivo);
        if (f.exists()) {
            while (true) {
                try {
                    ExamenMedico registro = (ExamenMedico) entrada.readObject();
                    examenes.add(registro);
                } catch (EOFException ex) {
                    return;
                } catch (IOException | ClassNotFoundException ex) {
                    System.err.println("Error al leer: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }
    }

    public ArrayList<ExamenMedico> obtenerListaExamenes() { return examenes; }
    public String obtenerNombreArchivo() { return nombreArchivo; }
}