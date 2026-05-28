/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

public class ArriendoLocalComida extends Arriendo {
    private double valorLuz;
    private double valorAgua;
    private double iva;
    private double arriendoMensualComida;
    
    public ArriendoLocalComida(String nombre, double cuotaB){
        establecerNombreArrendatario(nombre);
        establecerCuotaBase(cuotaB);
    }
    
    public void establecerValorLuz(double x){
        valorLuz = x;
    }
    
    public void establecerValorAgua(double x){
        valorAgua = x;
    }
    
    public void establecerIva(double x){
        iva = x;
    }
    
    
    public void establecerArriendoMensualComida(){
        double subtotal = obtenerValorAgua() + obtenerValorLuz() + 
                obtenerCuotaBase();
        arriendoMensualComida = subtotal + (subtotal * (obtenerIva()/100));
    }
    
    public double obtenerValorLuz(){
        return valorLuz;
    }
    
    public double obtenerValorAgua(){
        return valorAgua;
    }
    
    public double obtenerIva(){
        return iva;
    }
    
    public double obtenerArriendoMensualComida(){
        return arriendoMensualComida;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("Ariendo de Local Comida\n"
                + "Nombre Arrendatario: %s\n"
                + "Cuota base: %.2f\n"
                + "Valor luz: %.2f\n"
                + "Valor agua: %.2f\n"
                + "Porcentaje iva: %.2f\n"
                + "Arriendo Total: %.2f\n", 
                obtenerNombreArrendatario(),
                obtenerCuotaBase(),
                obtenerValorLuz(),
                obtenerValorAgua(),
                obtenerIva(),
                obtenerArriendoMensualComida());
        
        return cadena;
    }
    
        
}
