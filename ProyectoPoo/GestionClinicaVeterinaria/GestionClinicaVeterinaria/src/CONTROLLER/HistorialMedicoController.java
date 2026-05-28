/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
import MODEL.*;
import java.util.ArrayList;
import DATABASE.*;

public class HistorialMedicoController {

    public void registrarAntecedentes(Mascota mascota, String antecedentes) {
        mascota.obtenerHistorial().setAntecedentes(antecedentes);
    }

    public String getAntecedentes(Mascota mascota) {
        return mascota.obtenerHistorial().getAntecedentes();
    }

    public void agregarConsulta(Mascota mascota, ConsultaMedica consulta) {
        mascota.obtenerHistorial().agregarConsulta(consulta);
    }

    public ArrayList<ConsultaMedica> obtenerConsultas(Mascota mascota) {
        return mascota.obtenerHistorial().obtenerAntecedentes();
    }
}