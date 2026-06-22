package ejecutarpagos;

public class Transferencia extends Pago {
    private String banco;
    private double comision;

    public Transferencia(String id, String nombre, String tipo, double valor, 
            double cantidad, double descuento, String banco) {
        super(id, nombre, tipo, valor, cantidad, descuento);
        this.banco = banco;
        this.comision = 00.00;
    }
    
    @Override //Implemento Metodo Abstract
    public double calcularPago() {
        //Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(banco.equals("Loja")){
            comision = 0;
        } else {
            comision = 0.5; 
        }
        pago = (valor * cantidad) + comision;
        return pago;
    }
    
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getComision() {
        return comision;
    }
}
