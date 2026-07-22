/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jotue
 */
public class Partido {
    private int id;
    private Equipo equipoLocal;       //Conexión/Asociación a Equipo
    private Equipo equipoVisitante;   //Conexión/Asociación a Equipo
    private Arbitro arbitro;          //Conexión/Asociación a Árbitro
    private String fecha;
    private String sede;
    private Integer golesLocal;       //Uso Integer porque inicialmente es null (no hay goles)
    private Integer golesVisitante;

    public Partido(int id, Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, String fecha, String sede) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.sede = sede;
        this.golesLocal = null;
        this.golesVisitante = null;
    }

    // Lógica de negocio: "Determinar automáticamente el ganador"
    public String obtenerResultado() {
        if(golesLocal == null || golesVisitante == null) {
            return "Partido no disputado";
        }
        
        if(golesLocal > golesVisitante){
            return "Ganador: " + equipoLocal.getNombreEq();
        } else if(golesVisitante > golesLocal){
            return "Ganador: " + equipoVisitante.getNombreEq();
        } else{
            return "Empate";
        }
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Equipo getEquipoLocal() { return equipoLocal; }

    public void setEquipoLocal(Equipo equipoLocal) { this.equipoLocal = equipoLocal; }

    public Equipo getEquipoVisitante() { return equipoVisitante; }

    public void setEquipoVisitante(Equipo equipoVisitante) { this.equipoVisitante = equipoVisitante; }

    public Arbitro getArbitro() { return arbitro; }

    public void setArbitro(Arbitro arbitro) { this.arbitro = arbitro; }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getSede() { return sede; }

    public void setSede(String sede) { this.sede = sede; }

    public Integer getGolesLocal() { return golesLocal; }

    public void setGolesLocal(Integer golesLocal) { this.golesLocal = golesLocal; }

    public Integer getGolesVisitante() { return golesVisitante; }

    public void setGolesVisitante(Integer golesVisitante) { this.golesVisitante = golesVisitante; }
}
