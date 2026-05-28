package problema.pkg5_conflicto_ejecutor;

public class Evento {
    private String nombre;
    private String tipo; // Batalla, Tratado, etc.
    public Evento(String nombre, String tipo){ 
        this.nombre = nombre; 
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    
     
    @Override
    public String toString() {
        return "Evento: " + nombre + " | Eventos registrados: " + tipo + ". ";
    }
}
