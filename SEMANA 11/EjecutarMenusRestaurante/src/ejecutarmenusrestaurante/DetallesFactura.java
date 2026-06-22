package ejecutarmenusrestaurante;

public class DetallesFactura {
    private Menus menus; //Objeto de tipo Menus (Polimorfismo)
    private int cantidad;
    private double subtotal;

    public DetallesFactura(Menus menus, int cantidad) {
        this.menus = menus;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }
    
    public double calcularSubtotal() {
        return this.menus.calcularCostoFinal() * this.cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    //Getters
    public Menus getMenus() {
        return menus;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    //Setters
    public void setMenus(Menus menus) {
        this.menus = menus;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    @Override
    public String toString() {
        return String.format("- %d x %s", cantidad, menus.toString());
    }
}
