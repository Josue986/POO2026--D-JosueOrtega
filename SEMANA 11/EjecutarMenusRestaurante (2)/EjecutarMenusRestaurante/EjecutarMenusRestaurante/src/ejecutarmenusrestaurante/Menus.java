package ejecutarmenusrestaurante;

public abstract class Menus {
    protected String nombrePlato;
    protected double costoBase;

    public Menus(String nombrePlato, double costoBase) {
        this.nombrePlato = nombrePlato;
        this.costoBase = costoBase;
    }

    //Método abstracto
    public abstract double calcularCostoFinal();
    
    //Getters
    public String getNombrePlato() {
        return nombrePlato;
    }  
    
    public double getCostoBase() {
        return costoBase;
    }

    //Setters
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public String toString() {
        return String.format("Plato: %s | Costo Base: $%.2f", nombrePlato, costoBase);
    }
}
