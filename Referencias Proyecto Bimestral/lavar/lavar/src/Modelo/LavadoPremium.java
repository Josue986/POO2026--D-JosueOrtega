package Modelo;

public class LavadoPremium extends Lavado {

    public LavadoPremium(String placa, String cliente) {
        super(placa, cliente);
    }

    @Override
    public String tipoLavado() {
        
        return "Premium dura 3 horas";
        
    }

    @Override
    public double precio() {
        return 13.0;
    }
    
    
    
}
