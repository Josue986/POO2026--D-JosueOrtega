package Modelo;

public class LavadoBasico extends Lavado {

    public LavadoBasico(String placa, String cliente) {
        super(placa, cliente);
    }

    @Override
    public String tipoLavado() {
    
        return "Basico dura 1 hora";
        
    }

    @Override
    public double precio() {
   
        return 3.0;
        
    }
    
    
    
}
