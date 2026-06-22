package ejecutarelectrodomesticos;

public class Lavadora extends Electrodomesticos{
    private double capacidad;
    private String cronometro;
    private String tiposLavado;

    public Lavadora(String numeroSerie, String modelo, String color, double capacidad, String cronometro, String tiposLavado) {
        super(numeroSerie, modelo, color);
        this.capacidad = capacidad;
        this.cronometro = cronometro;
        this.tiposLavado = tiposLavado;
    }
    
    public String lavar(){
        return "La lavadora lava la ropa con agua y detergente";
    }
    
    public void enguagar(){
        System.out.println("La lavadora enguaja la ropa");
    }
    
    public void tiposLavado(){
        System.out.println("La lavadora incluye los siguientes tipos de lavado: ");
        System.out.println("Lavado Rapido");
        System.out.println("Lavado Intensivo");
        System.out.println("Ropa Blanca");
        System.out.println("Ropa de Seda/Delicada");
    }
    
    public String lavadoSeleccionado(String tipoLavado){
        String d = "";
        if(tipoLavado.equalsIgnoreCase("Lavado Rapido")){
            d = "La lavadora lava rapido la ropa";
        } else {
            d = "La lavadora no hace nada";
        }
        
        return d;
    }
    
    //Getters
    public double getCapacidad() {
        return capacidad;
    }

    public String getCronometro() {
        return cronometro;
    }

    public String getTiposLavado() {
        return tiposLavado;
    }
    
    //Setters
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public void setCronometro(String cronometro) {
        this.cronometro = cronometro;
    }

    public void setTiposLavado(String tiposLavado) {
        this.tiposLavado = tiposLavado;
    }
    
}
