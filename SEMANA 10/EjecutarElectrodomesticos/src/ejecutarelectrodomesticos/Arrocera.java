/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarelectrodomesticos;

/**
 *
 * @author jotue
 */
public class Arrocera extends Electrodomesticos{
    private double capacidad;
    private String tiempoCoccion;

    public Arrocera(double capacidad, String tiempoCoccion, String numeroSerie, String modelo, String color) {
        super(numeroSerie, modelo, color);
        this.capacidad = capacidad;
        this.tiempoCoccion = tiempoCoccion;
    }

    public void hacerArroz(){
        System.out.println("La arrocere hace arros, es delicioso si el tiempo de coccion es ");
        if(tiempoCoccion.equalsIgnoreCase("Baja")){
            System.out.println("El arroz sale crudo");
        } else if(tiempoCoccion.equalsIgnoreCase("Medio")){
            System.out.println("El arroz sale graneado");
        } else if(tiempoCoccion.equalsIgnoreCase("Alto")){
            System.out.println("El arroz sale cocolon");
        }
    }

    public double getCapacidad() {
        return capacidad;
    }

    public String getTiempoCoccion() {
        return tiempoCoccion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public void setTiempoCoccion(String tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }
    
}
