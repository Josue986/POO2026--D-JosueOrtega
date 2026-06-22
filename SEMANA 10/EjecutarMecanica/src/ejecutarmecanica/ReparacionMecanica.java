package ejecutarmecanica;

public class ReparacionMecanica extends Trabajo {
    private int plazo;

    public ReparacionMecanica(int plazo, String descripcion) {
        super(descripcion);
        this.plazo = plazo;
    }
    
    public double calcularPrecioReparacionMecanica(){
        return precioFijo() * 1.1;
    }
    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
}
