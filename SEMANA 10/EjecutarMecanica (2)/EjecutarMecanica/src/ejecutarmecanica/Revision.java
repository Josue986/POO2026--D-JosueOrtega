/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class Revision extends Trabajo {
   private int plazo;

    public Revision(int plazo, String descripcion) {
        super(descripcion);
        this.plazo = plazo;
    }

    

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
   
   public double calcularPrecioRevision(){
       return PrecioFijo() + 20;
       
   }
}
