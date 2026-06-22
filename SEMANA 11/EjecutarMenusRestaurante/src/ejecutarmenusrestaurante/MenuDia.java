package ejecutarmenusrestaurante;

public class MenuDia extends Menus{
    private double costoPostre;
    private double costoBebida;

    public MenuDia(String nombrePlato, double costoBase, double costoPostre, double costoBebida) {
        super(nombrePlato, costoBase);
        this.costoPostre = costoPostre;
        this.costoBebida = costoBebida;
    }
    
    //Getters
    public double getCostoPostre() {
        return costoPostre;
    }
    
    public double getCostoBebida() {    
        return costoBebida;
    }
    
    //Setters
    public void setCostoPostre(double costoPostre) {
        this.costoPostre = costoPostre;
    }

    public void setCostoBebida(double costoBebida) {
        this.costoBebida = costoBebida;
    }

    @Override
    public double calcularCostoFinal() {
        return this.costoBase + this.costoPostre + this.costoBebida;
    }

    @Override
    public String toString() {
        return String.format("%s (Menú del Día) [Postre: $%.2f, Bebida: $%.2f] -> Costo Total Menú: $%.2f", 
                super.toString(), costoPostre, costoBebida, calcularCostoFinal());
    }
}
