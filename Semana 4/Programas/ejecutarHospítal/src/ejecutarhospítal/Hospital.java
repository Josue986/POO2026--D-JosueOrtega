package ejecutarhospítal;

public class Hospital {
    private String nombreHospital;
    private String ciudad;
    private int numDoctores;
    private int numCamas;
    private double presupuesto;

    // Declarar constructor
    
    // Constructor Vacio        
    public Hospital (){
    
    }
    
    // Opcion 1 Quito sea valor por defecto
    public Hospital(String nombreHospital, int numDoctores, int numCamas, double presupuesto) {
        this.nombreHospital = nombreHospital;
        this.ciudad = "Quito";
        this.numDoctores = numDoctores;
        this.numCamas = numCamas;
        this.presupuesto = presupuesto;
    }
    
    //Opcion 2:
    public Hospital(String nombreHospital, int numDoctores, int numCamas) {
        this.nombreHospital = nombreHospital;
        this.ciudad = "Quito";
        this.numDoctores = numDoctores;
        this.numCamas = numCamas;
        this.presupuesto = 25000.10;
    }
    
    // Opcion 3:
    public Hospital(String nombreHospital, String ciudad, int numDoctores, int numCamas, double presupuesto) {
        this.nombreHospital = nombreHospital;
        this.ciudad = ciudad;
        this.numDoctores = numDoctores;
        this.numCamas = numCamas;
        this.presupuesto = presupuesto;
    }
    

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumDoctores() {
        return numDoctores;
    }

    public void setNumDoctores(int numDoctores) {
        this.numDoctores = numDoctores;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
    
}
