package ejecutarmecanica;

public class Revision extends Trabajo {
    private int plazo;

    public Revision(int plazo, String descripcion) {
        super(descripcion);
        this.plazo = plazo;
    }
    
    public double calcularPrecio(){
        return precioFijo() + 20.0;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }            
}
