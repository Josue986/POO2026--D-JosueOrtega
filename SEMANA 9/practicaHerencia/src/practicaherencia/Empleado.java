package practicaherencia;


public class Empleado {
    protected String idEmpleado;
    protected String nombre;
    protected double salarioBase;
    protected int cargaHoraria;

    public Empleado(String idEmpleado, String nombre, int cargaHoraria) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salarioBase = 1300.00;
        this.cargaHoraria = cargaHoraria;
    }
    
    
    public void info(){
        System.out.println("ID: " + this.idEmpleado);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Salario Base: " + this.salarioBase);
        System.out.println("Carga Horaria: " + this.cargaHoraria);
    }
    
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
