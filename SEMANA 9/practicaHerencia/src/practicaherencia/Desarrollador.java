package practicaherencia;


public class Desarrollador extends Empleado {
   private String lenguajeProgrmacion;
   private String rolEnEquipo;

    public Desarrollador(String idEmpleado, String nombre, int cargaHoraria, String lenguajeProgrmacion, String rolEnEquipo) {
        super(idEmpleado, nombre, cargaHoraria);
        this.lenguajeProgrmacion = lenguajeProgrmacion;
        this.rolEnEquipo = rolEnEquipo;
    }
    
    public void infoSuper(){
        super.info();
    }
    
    @Override
    public void info(){
        System.out.println("Lenguaje de Promgramacion que usa: " + this.lenguajeProgrmacion);
        System.out.println("Rol en el equipo de Desarrollo de Sowftware: " + this.rolEnEquipo);
    }
    
    //Getters
    public String getLenguajeProgrmacion() {
        return lenguajeProgrmacion;
    }

    public String getRolEnEquipo() {
        return rolEnEquipo;
    }
    
    //Setters
    public void setLenguajeProgrmacion(String lenguajeProgrmacion) {
        this.lenguajeProgrmacion = lenguajeProgrmacion;
    }

    public void setRolEnEquipo(String rolEnEquipo) {
        this.rolEnEquipo = rolEnEquipo;
    }
   
}
