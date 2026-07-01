package ejecutarmenusrestaurante;


public class MenuCarta extends Menus{
    private double costoGuarnicion;
    private double costoBebida;
    private double costoExtraServicio; 

    public MenuCarta(String nombrePlato, double costoBase, double costoGuarnicion, double costoBebida, double porcentajeServicio) {
        super(nombrePlato, costoBase);
        this.costoGuarnicion = costoGuarnicion;
        this.costoBebida = costoBebida;
        this.costoExtraServicio = porcentajeServicio;
    }
    
    //Getters
    public double getCostoGuarnicion() {
        return costoGuarnicion;
    }

    public double getCostoBebida() {
        return costoBebida;
    }

    public double getCostoExtraServicio() {
        return costoExtraServicio;
    }
    
    //Setters
    public void setCostoGuarnicion(double costoGuarnicion) {
        this.costoGuarnicion = costoGuarnicion;
    }

    public void setCostoBebida(double costoBebida) {
        this.costoBebida = costoBebida;
    }

    public void setCostoExtraServicio(double costoExtraServicio) {
        this.costoExtraServicio = costoExtraServicio;
    }
    
    @Override
    public double calcularCostoFinal() {
        double servicio = this.costoBase * this.costoExtraServicio;
        return this.costoBase + this.costoGuarnicion + this.costoBebida + servicio;
    }

    @Override
    public String toString() {
        return String.format("%s (Menú a la Carta) [Guarnición: $%.2f, Bebida: $%.2f, Servicio: %.1f%%] -> Costo Total Menú: $%.2f", 
                super.toString(), costoGuarnicion, costoBebida, (costoExtraServicio * 100), calcularCostoFinal());
    }
}
