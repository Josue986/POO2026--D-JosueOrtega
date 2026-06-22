/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class Reparacion extends Trabajo {
    protected double costoMaterial;

    public Reparacion(double costoMaterial, String descripcion) {
        super(descripcion);
        this.costoMaterial = costoMaterial;
    }

    public double getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(double costoMaterial) {
        this.costoMaterial = costoMaterial;
    }
    public void AumentarcostoMat(double coste){
        if(finalizado){
            System.out.println("El trabajo con Id "+ Idtrabajo +"ya se ha finalizado");
        }else if (coste > 0){
            costoMaterial += coste; 
        }
    }
}
