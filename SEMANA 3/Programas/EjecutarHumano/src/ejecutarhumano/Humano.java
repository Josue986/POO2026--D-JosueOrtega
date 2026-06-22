package ejecutarhumano;

public class Humano {
    private String cedula;
    private String nombres;
    private int edad;
    private Corazon c;
    private Pulmon p;
    private Ropa r;
    
    // get & set

    public String getCedula() {
        return cedula;
    }  

    public String getNombres() {
        return nombres;
    }

    public int getEdad() {
        return edad;
    }
    
    public Corazon getC(){
        return c;
    }

    public Pulmon getP() {
        return p;
    }

    public Ropa getR() {
        return r;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setC(Corazon c) {
        this.c = c;
    }   

    public void setP(Pulmon p) {
        this.p = p;
    }

    public void setR(Ropa r) {
        this.r = r;
    }
    
}
