package modelo;

public class estudiante {

    private String cedula;
    private String nombre;
    private int edad;
    private String idBecas;
    private String nombreBeca;
    private double monto;

    public estudiante() {
    }

    public estudiante(String cedula, String nombre, int edad, String idBecas, String nombreBeca, double monto) {
        this.cedula = cedula;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "estudiante{" + "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + ", idBecas=" + idBecas + ", nombreBeca=" + nombreBeca + ", monto=" + monto + '}';
    }
    
    
}
