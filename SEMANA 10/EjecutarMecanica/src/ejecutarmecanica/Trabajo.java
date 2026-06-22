package ejecutarmecanica;

public class Trabajo {
    protected String idTrabajo;
    protected int contadorTrabajo = 0;
    protected String descripcion;
    protected int horas;
    protected boolean finalizado;

    public Trabajo(String descripcion) {
        this.idTrabajo = "" + contadorTrabajo;
        this.descripcion = descripcion;
        this.horas = horas;
        this.finalizado = finalizado;
    }
    
    public void aumentarHoras(int horasNuevas){
        if(this.finalizado){
            System.out.println("ERROR- ID: " + this.idTrabajo + " el trabajo " 
                    + this.descripcion + " se ah finalizado.");
        } else if(horasNuevas > 0) {
             this.horas += horasNuevas;
        }
    }
    
    public void trabajoFinalizado(){
        this.finalizado = true;
    }
    
    public double precioFijo(){
        return this.horas * 30.0;
    }

    public String getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(String idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public int getContadorTrabajo() {
        return contadorTrabajo;
    }

    public void setContadorTrabajo(int contadorTrabajo) {
        this.contadorTrabajo = contadorTrabajo;
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
    
}
