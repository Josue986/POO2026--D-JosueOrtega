
package paqueteuno;

public class ArriendoLocalComercial extends Arriendo{
    protected double arriendoMensualComercial;
    protected double valorAdicionalFijo;
    
    public ArriendoLocalComercial(String nombre, double cuotaB){
        establecerNombreArrendatario(nombre);
        establecerCuotaBase(cuotaB);
    }
    
    @Override
    public void establecerNombreArrendatario(String nombre){
        nombreArrendatario = nombre.toUpperCase();
    }
    
    public void establecerValorAdicionalFijo(double x){
        valorAdicionalFijo = x;
    }
    
    
    public void establecerArriendoMensualComercial(){
        arriendoMensualComercial = obtenerCuotaBase() + 
                obtenerValorAdicionalFijo();
    }
    
    public double obtenerValorAdicionalFijo(){
        return valorAdicionalFijo;
    }
    
    public double obtenerArriendoMensualComercial(){
        return arriendoMensualComercial;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("Ariendo de Local Comercial\n"
                + "Nombre Arrendatario: %s\n"
                + "Cuota base: %.2f\n"
                + "Valor adicional fijo: %.2f\n"
                + "Arriendo Total: %.2f\n", 
                obtenerNombreArrendatario(),
                obtenerCuotaBase(),
                obtenerValorAdicionalFijo(),
                obtenerArriendoMensualComercial());
        
        return cadena;
    }
}
