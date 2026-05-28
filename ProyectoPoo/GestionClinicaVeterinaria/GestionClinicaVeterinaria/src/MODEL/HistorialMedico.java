/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;

public class HistorialMedico implements Serializable {

    private String idHistorial;
    private String fechaCreacion;
    private String antecedentes; // ← texto libre
    private ArrayList<ConsultaMedica> consultas;

    public HistorialMedico(String idHistorial, String fechaCreacion) {
        this.idHistorial = idHistorial;
        this.fechaCreacion = fechaCreacion;
        this.antecedentes = "";
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(ConsultaMedica consulta) {
        consultas.add(consulta);
    }

    public ArrayList<ConsultaMedica> obtenerAntecedentes() {
        return consultas;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getIdHistorial() {
        return idHistorial;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public ArrayList<ConsultaMedica> getConsultas() {
    return consultas;
}
}
