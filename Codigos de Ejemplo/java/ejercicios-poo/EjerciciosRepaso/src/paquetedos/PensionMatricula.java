/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

public class PensionMatricula {

    private double pensionFinal;
    private double pensionBasica;
    private String nombreAlumno;
    private int edadAlumno;
    private double descuento;

    public PensionMatricula(String nombre, int e) {
        pensionBasica = 100;
        nombreAlumno = nombre;
        edadAlumno = e;
    }

    public PensionMatricula(String nombre, int e, double pensionB) {
        pensionBasica = pensionB;
        nombreAlumno = nombre;
        edadAlumno = e;
    }
    
    public void establecerEdad(int n) {
        edadAlumno = n;
    }

    public void establecerNombreAlumno(String n) {
        nombreAlumno = n;
    }
    
    public void establecerPensionBasica(double n) {
        pensionBasica = n;
    }
    
    public void establecerPensionFinal() {
        pensionFinal = pensionBasica - ((descuento * pensionBasica) / 100);
    }
    
    public void establecerDescuento() {
        if(edadAlumno<=5){
            descuento = 30;
        }else{
            if( (edadAlumno>5) && (edadAlumno<=10) ){
                descuento = 20;
            }else{
                descuento = 10;
            }
            
        }
    }
    
    public int obtenerEdad() {
        return edadAlumno;
    }

    public String obtenerNombreAlumno() {
        return nombreAlumno;
    }
    
    public double obtenerPensionBasica() {
        return pensionBasica;
    }
    
    public double obtenerPensionFinal() {
        return pensionFinal;
    }
    
    public double obtenerDescuento() {
        return descuento;
    }
    

}
