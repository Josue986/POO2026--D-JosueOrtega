package ejecutarmecanica;

public class ReparacionChapasPintura extends Trabajo {
    private int plazo;

    public ReparacionChapasPintura(int plazo, String descripcion) {
        super(descripcion);
        this.plazo = plazo;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
    public double calcularPrecioChapas(){
        return precioFijo() * 1.3;
    }
}
