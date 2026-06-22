/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class ReparacionChapasPintura extends Reparacion {
    private int plazo;

    public ReparacionChapasPintura(int plazo, double costoMaterial, String descripcion) {
        super(costoMaterial, descripcion);
        this.plazo = plazo;
    }

    

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
    public double CalcularPrecioChapas(){
        return PrecioFijo() + (costoMaterial * 1.3);
    }
}
