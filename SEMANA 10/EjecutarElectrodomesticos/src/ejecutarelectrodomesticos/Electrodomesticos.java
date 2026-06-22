/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarelectrodomesticos;

/**
 *
 * @author jotue
 */
public class Electrodomesticos {
    protected String numeroSerie;
    protected String modelo;
    protected String color;
    protected double precio;

    public Electrodomesticos(String numeroSerie, String modelo, String color) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.color = color;
        this.precio = 0;
    }
    
    public String costoEnergia(int tiempo){
        double costoWatt = 0.3; // costo por hora
        double descuento = 5;
        String d = "";
        
        if(tiempo > 0 && tiempo < 100){
            d = "El consumi energetico es bajo y el precio es " + precio;
        } else { 
            d = "El consumi energetico es alto y el precio es" + precio;
        }
        return d;
    }
    
    public void consumirEnergia(){
        System.out.println("Todos los elegtrodomesticos en Ecuador consumen enrgia con un voltaje de 110");
    }
    
    public void encender(){
        System.out.println("Todos los elegtrodomesticos encienen en menos de 1 segundo");
    }
    public void encender(double precio){
        
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
