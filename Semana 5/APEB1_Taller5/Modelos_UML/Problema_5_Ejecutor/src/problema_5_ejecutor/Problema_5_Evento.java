package problema_5_ejecutor;

public class Problema_5_Evento {
     private String nombre;
    private String tipo; // Batalla, Tratado, etc.
    public Problema_5_Evento(String nombre, String tipo){ 
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
