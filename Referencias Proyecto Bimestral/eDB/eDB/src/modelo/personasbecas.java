package modelo;

public class personasbecas {

    private String cedula;
    private String nombres;
    private int edad;
    private String idBecas;
    private String nombreBeca;
    private double monto;
    
    public personasbecas() {
    }

    public personasbecas(String cedula, String nombres, int edad, String idBecas, String nombreBeca, double monto) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.idBecas = idBecas;
        this.nombreBeca = nombreBeca;
        this.monto = monto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdBecas() {
        return idBecas;
    }

    public void setIdBecas(String idBecas) {
        this.idBecas = idBecas;
    }

    public String getNombreBeca() {
        return nombreBeca;
    }

    public void setNombreBeca(String nombreBeca) {
        this.nombreBeca = nombreBeca;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    /*public void calcularSaldo(){
    
        saldo = monto * 1.15;
    
    }

    */
    
    @Override
    public String toString() {
        return "personasbecas{" + "cedula=" + cedula + ", nombres=" + nombres + ", edad=" + edad + ", idBecas=" + idBecas + ", nombreBeca=" + nombreBeca + ", monto=" + monto + '}';
    }
    
}
