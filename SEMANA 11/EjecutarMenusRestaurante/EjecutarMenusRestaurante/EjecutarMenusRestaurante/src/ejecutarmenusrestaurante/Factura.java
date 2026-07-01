package ejecutarmenusrestaurante;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String nombreCliente;
    private double iva; 
    private double total;
    private List<DetallesFactura> detalles; 

    public Factura(String nombreCliente, double iva) {
        this.nombreCliente = nombreCliente;
        this.iva = iva;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarDetalle(DetallesFactura detalle) {
        this.detalles.add(detalle);
    }

    public void calcularTotal() {
        double sumaSubtotales = 0;
        for (DetallesFactura det : detalles) {
            sumaSubtotales += det.getSubtotal();
        }
        
        double valorIva = sumaSubtotales * this.iva;
        this.total = sumaSubtotales + valorIva;
    }

    public void mostrarInfo() {
        System.out.println(this.toString());
    }
    
    //Getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    public List<DetallesFactura> getDetalles() {
        return detalles;
    }
    
    //Setters
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        calcularTotal(); 
        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("               FACTURA DE CONSUMO                 \n");
        sb.append("==================================================\n");
        sb.append("Cliente: ").append(nombreCliente).append("\n");
        sb.append("Detalle de Consumo:\n");
        
        double subtotalSinIva = 0;
        for (DetallesFactura det : detalles) {
            sb.append(det.toString()).append("\n");
            subtotalSinIva += det.getSubtotal();
        }
        
        double valorIva = subtotalSinIva * this.iva;
        
        sb.append("--------------------------------------------------\n");
        sb.append(String.format("Subtotal Neto:  $%.2f\n", subtotalSinIva));
        sb.append(String.format("IVA (%.1f%%):     $%.2f\n", (iva * 100), valorIva));
        sb.append(String.format("VALOR A PAGAR:  $%.2f\n", total));
        sb.append("==================================================\n");
        return sb.toString();
    }
}
