/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.io.Serializable;
import java.util.ArrayList;

public class ConsultaMedica implements Serializable {
    private String idConsulta;
    private String idMascota;
    private String fecha;
    private String motivo;
    private String diagnostico;
    private double costoBase;
private ArrayList<ExamenMedico> examenes;

    public ConsultaMedica(String idConsulta, String idMascota, String fecha, String motivo, String diagnostico, double costoBase) {
        this.idConsulta = idConsulta;
    this.idMascota = idMascota;
    this.fecha = fecha;
    this.motivo = motivo;
    this.diagnostico = diagnostico;
    this.costoBase = costoBase;
    this.examenes = new ArrayList<>();
    }
 

   
    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }
     public void agregarExamen(ExamenMedico e) {
        examenes.add(e);
    }

    public ArrayList<ExamenMedico> getExamenes() {
        return examenes;
    }

    public double calcularTotalExamenes() {
        double total = 0;
        for (ExamenMedico e : examenes) {
            total += e.getCosto();
        }
        return total;
    }
    
}