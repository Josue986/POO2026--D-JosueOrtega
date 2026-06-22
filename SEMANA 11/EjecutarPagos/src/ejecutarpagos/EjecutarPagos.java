/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecutarpagos;

/**
 *
 * @author jotue
 */
public class EjecutarPagos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Efectivo efectivo = new Efectivo("1", "Nicole", "pago en linea", 2.5, 3, 0.0, 20);
        
        Tarjeta tarjeta = new Tarjeta("2", "Juan", "pago en linea", 450, 3, 0, "Juan", "Visa", "262642", "12/31", 223);
        
        Transferencia transferencia = new Transferencia("3", "karla", "pago en linea", 7, 9, 0, "Loja");
        
        double pagoEfectivo = efectivo.calcularPago();
        double pagoTarjeta = tarjeta.calcularPago();
        double pagoTransferencia = transferencia.calcularPago();
        
        System.out.println(" El pago de " + efectivo.getNombre() 
                + " tipo " + efectivo.getTipo() + ", debe pagar: " + efectivo.getPago());
        System.out.println("-------------------------------------------------------------");
        
        if(pagoTarjeta > 0){
            System.out.println("\nEl pago de " + tarjeta.getNombre() 
                + " tipo " + tarjeta.getTipo() + ", debe pagar: " + tarjeta.getPago());
            
        } else {
            System.out.println("ERROR: fondos insuficientes");
        }
        System.out.println("-------------------------------------------------------------");
        
        System.out.println("\nEl pago de " + transferencia.getNombre() 
                + " tipo " + transferencia.getTipo() + ", debe pagar: " + transferencia.getPago());
        System.out.println("-------------------------------------------------------------");
    }
    
}
