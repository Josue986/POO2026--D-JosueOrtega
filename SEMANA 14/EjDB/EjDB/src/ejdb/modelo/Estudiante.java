package ejdb.modelo;

public class Estudiante {

    private String cedula;
    private String nombres;
    private int matricula;
    private double pago;

    public Estudiante() {
    }

    public Estudiante(String cedula, String nombres, int matricula, double pago) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.matricula = matricula;
        this.pago = pago;
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return String.format(
                "Cedula: %s | Nombres: %s | Matricula: %d | Pago: %.2f",
                cedula, nombres, matricula, pago
        );
    }
}
