package ejecutarmenusrestaurante;

public class MenuEconomico extends Menus{
    private double descuento; 

    public MenuEconomico(String nombrePlato, double costoBase, double descuento) {
        super(nombrePlato, costoBase);
        this.descuento = descuento;
    }
    
    public double getDescuento() {
        return descuento;
    }
     
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    @Override
    public double calcularCostoFinal() {
        double valorDescuento = this.costoBase * this.descuento;
        return this.costoBase - valorDescuento;
    }

    @Override
    public String toString() {
        return String.format("%s (Menú Económico) [Descuento: %.1f%%] -> Costo Total Menú: $%.2f", 
                super.toString(), (descuento * 100), calcularCostoFinal());
    }
}
