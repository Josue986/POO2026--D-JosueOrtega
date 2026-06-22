package ejecutarmecanica;

public class Reparacion extends Trabajo {
    private double costoMaterial;

    public Reparacion(String descripcion, double costoMaterial) {
        super(descripcion);
        this.costoMaterial = costoMaterial;
    }
    
    public void aumentarCostoMat(double coste){
        if(finalizado){
            System.out.println("ERROR- ID: " + idTrabajo + " el trabajo " 
                    + this.descripcion + " se ah finalizado.");
        } else if(coste > 0){
            costoMaterial += coste;
        }
        
    }

    public double getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(double costoMaterial) {
        this.costoMaterial = costoMaterial;
    }
}