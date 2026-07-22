package Modelo;

public class LavadoCompleto extends Lavado {

    public LavadoCompleto(String placa, String cliente) {
        super(placa, cliente);
    }

    @Override
    public String tipoLavado() {
        
        return "Completo dura 2 horas";
    }

    @Override
    public double precio() {
        return 7.0;
    }
    
    
    
}
