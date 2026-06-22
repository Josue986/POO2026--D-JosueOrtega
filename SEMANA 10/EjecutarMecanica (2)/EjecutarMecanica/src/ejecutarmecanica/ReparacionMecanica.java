/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class ReparacionMecanica extends Reparacion {
    private int plazo;

    public ReparacionMecanica(int plazo, double costoMaterial, String descripcion) {
        super(costoMaterial, descripcion);
        this.plazo = plazo;
    }

    

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    public double CalcularPrecioReparacionMecanica(){
        return PrecioFijo() + (costoMaterial * 1.1); 
    }
}
