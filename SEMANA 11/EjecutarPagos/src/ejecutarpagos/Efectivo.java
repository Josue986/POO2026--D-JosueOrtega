/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarpagos;

/**
 *
 * @author jotue
 */
public class Efectivo extends Pago{
    private double valorPagar;
    private double cambio;

    public Efectivo(String id, String nombre, String tipo, double valor, 
            double cantidad, double descuento, double valorPagar) {
        super(id, nombre, tipo, valor, cantidad, descuento);
        this.valorPagar = valorPagar;
        this.cambio = 00.00;
    }
    
     @Override
    public double calcularPago() {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        //calcular cuanto se debe pagar
        pago = (valor * cantidad) - descuento;
        
        //calcular cual es el cambio/vuelto
        cambio = valorPagar - pago;
        
        return pago;
    }
    
    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public double getCambio() {
        return cambio;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }
}
