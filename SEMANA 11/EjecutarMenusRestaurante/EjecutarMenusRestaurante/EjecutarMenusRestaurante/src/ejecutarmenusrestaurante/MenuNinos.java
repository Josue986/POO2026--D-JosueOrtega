package ejecutarmenusrestaurante;

public class MenuNinos extends Menus{
    private double costoHelado;
    private double costoPastel;

    public MenuNinos(String nombrePlato, double costoBase, double costoHelado, double costoPastel) {
        super(nombrePlato, costoBase);
        this.costoHelado = costoHelado;
        this.costoPastel = costoPastel;
    }
    
    //Getters
    public double getCostoHelado() {
        return costoHelado;
    }

    public double getCostoPastel() {
        return costoPastel;
    }
    
    //Setters
    public void setCostoHelado(double costoHelado) {
        this.costoHelado = costoHelado;
    }

    public void setCostoPastel(double costoPastel) {
        this.costoPastel = costoPastel;
    }

    @Override
    public double calcularCostoFinal() {
        return this.costoBase + this.costoHelado + this.costoPastel;
    }

    @Override
    public String toString() {
        return String.format("%s (Menú de Niños) [Helado: $%.2f, Pastel: $%.2f] -> Costo Total Menú: $%.2f", 
                super.toString(), costoHelado, costoPastel, calcularCostoFinal());
    }
}
