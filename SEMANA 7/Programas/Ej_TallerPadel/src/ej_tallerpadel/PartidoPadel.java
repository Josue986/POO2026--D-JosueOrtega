package ej_tallerpadel;
import java.io.Serializable;


public class PartidoPadel implements Serializable {
    // serialVersionUID para la compatibilidad con serialización
    private static final long serialVersionUID = 1L;
    private String pareja1;
    private String pareja2;
    private String marcador; // Ej: "6-4 / 6-2"

    // Constructor.
    public PartidoPadel(String pareja1, String pareja2, String marcador) {
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.marcador = marcador;
    }

    // Getters y Setters.
    public String getPareja1(){ 
        return pareja1; 
    }
    public void setPareja1(String pareja1){ 
        this.pareja1 = pareja1; 
    }

    public String getPareja2(){ 
        return pareja2; 
    }
    
    public void setPareja2(String pareja2){ 
        this.pareja2 = pareja2; 
    }

    public String getMarcador(){ 
        return marcador; 
    }
    public void setMarcador(String marcador){ 
        this.marcador = marcador; 
    }

    @Override
    public String toString() {
        return pareja1 + " vs " + pareja2 + " | Marcador: " + marcador;
    }
}
