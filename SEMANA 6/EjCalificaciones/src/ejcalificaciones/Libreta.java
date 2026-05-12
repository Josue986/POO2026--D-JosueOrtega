package ejcalificaciones;


public class Libreta {
    private String nombreAlumno;
    private double promedio;
    private String promedioCualitativo;
    private calif[] cal;

    public Libreta(String nombreAlumno, double[] calif) {
        this.nombreAlumno = nombreAlumno;
        this.promedio = promedio;
        this.promedioCualitativo = promedioCualitativo;
        this.calif = calif;
    }
    
    
    
    public void calcularPromedioCualitativo(){
        
        if(promedio >= 0 && promedio < 3.1){
            promedioCualitativo = "Regular";
        } if(promedio >= 3.1 && promedio < 5.1) {
            promedioCualitativo = "Insuficiente";
        } else if(promedio >= 5.1 && promedio < 7.1){
            promedioCualitativo = "Bueno";    
        } else if(promedio >= 7.1 && promedio < 9.1){
            promedioCualitativo = "Muy Bueno";
        } else if(promedio >=9.1 && promedio < 10){
            promedioCualitativo = "Excelente";
        }
             
    }
    
    public void calcularPromedio(double[] calif) {
        int i;
        double suma = 0;
        for(i=0; i<calif.length; i++){
            suma += calif[i];
        }
        
        promedio = suma/calif.length;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public double getPromedio() {
        return promedio;
    }

    public String getPromedioCualitativo() {
        return promedioCualitativo;
    }

    public double[] getCalif() {
        return calif;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public void setCalif(double[] calif) {
        this.calif = calif;
    }
    
}
