package ejecutarhumano;

public class Corazon {
    private String tamaño;
    private String color;
    private String idCorazon;
    private double peso;
    private String estado;

    public String getTamaño() {
        return tamaño;
    }

    public String getColor() {
        return color;
    }

    public String getIdCorazon() {
        return idCorazon;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstado() {
        return estado;
    }
    
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setIdCorazon(String idCorazon) {
        this.idCorazon = idCorazon;
    }

    public void setPeso(double pesso) {
        this.peso = pesso;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //metodo latir
    
    public void latir(){
        System.out.println("El corazon realiza 80 latidos/min ");
    }
}
