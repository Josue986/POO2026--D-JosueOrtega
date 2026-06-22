/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarpagos;

/**
 *
 * @author jotue
 */
public class Tarjeta extends Pago {
    private String titular;
    private String tipoTarjeta;
    private String numeroTarjeta;
    private String fechaCaducidad;
    private int codigoSeguridad;

    public Tarjeta(String id, String nombre, String tipo, double valor, 
            
            double cantidad, double descuento, String titular, String tipoTarjeta, 
            
            String numeroTarjeta, String fechaCaducidad, int codigoSeguridad) {
        
        super(id, nombre, tipo, valor, cantidad, descuento);
        this.titular = titular;
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
        this.codigoSeguridad = codigoSeguridad;
    }
    
    @Override
    public double calcularPago() {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            
        if(tipoTarjeta.equals("Visa")){
            //20% si es visa
            descuento = (valor * cantidad) * 0.2;
        } else if(tipoTarjeta.equals("Mastercard")){
            //17% si es visa
            descuento = (valor * cantidad) * 0.17;
        } else if(tipoTarjeta.equals("Diners")){
            //8% si es visa
            descuento = (valor * cantidad) * 0.08;
        }
        
        double fondos  = 1100;
        pago = (valor * cantidad) - descuento;
        
        if(fondos > pago){
            return pago;
        } else {
            return 0;
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
}
