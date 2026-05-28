
package paqueteuno;

public class Arriendo {
    protected String nombreArrendatario;
    protected double cuotaBase;
    
       
    public void establecerNombreArrendatario(String nombre){
        nombreArrendatario = nombre;
    }
    
    public void establecerCuotaBase(double x){
        cuotaBase = x;
    }
    
      
    public String obtenerNombreArrendatario(){
        return nombreArrendatario;
    }
    
    public double obtenerCuotaBase(){
        return cuotaBase;
    }
    
    
    
    
}
