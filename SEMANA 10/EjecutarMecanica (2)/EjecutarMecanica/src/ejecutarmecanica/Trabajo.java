/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class Trabajo {
   protected static int contadorId = 0;
   protected int Idtrabajo;
   protected String descripcion;
   protected int horas;
   protected boolean finalizado; 

    public Trabajo(String descripcion) {
        this.Idtrabajo = contadorId;
        contadorId++;
        this.descripcion = descripcion;
        this.horas = 0;
        this.finalizado = false;
    }

    public int getContadorId() {
        return contadorId;
    }

    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }

    public int getIdtrabajo() {
        return Idtrabajo;
    }

    public void setIdtrabajo(int Idtrabajo) {
        this.Idtrabajo = Idtrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    
    public void aumentarHoras(int horasNuevas){
        if(finalizado){
            System.out.println("Erro el trabajo con ID "+Idtrabajo + "ya se ha finalizado");
        }else if(horasNuevas>0 ){
            horas += horasNuevas;
        }
            
    }
    
    public void TrabajoFinzalizado(){
        finalizado = true;
    }
    
    public double PrecioFijo(){
        return horas *30;
    }
   
}
