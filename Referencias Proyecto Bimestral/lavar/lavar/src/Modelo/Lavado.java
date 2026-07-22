package Modelo;

public abstract class Lavado {
    
    protected String placa;
    protected String cliente;

    public Lavado(String placa, String cliente) {
        this.placa = placa;
        this.cliente = cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public abstract String tipoLavado();
    public abstract double precio();
    
}
