/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejecutarelectrodomesticos;

/**
 *
 * @author jotue
 */
public class Televisor extends Electrodomesticos {
    private String tamanoTv;
    private String tipoPanel;

    public Televisor(String tamanoTv, String tipoPanel, String numeroSerie, String modelo, String color) {
        super(numeroSerie, modelo, color);
        this.tamanoTv = tamanoTv;
        this.tipoPanel = tipoPanel;
    }
    
    public void cammbiarCanal(){
        System.out.println("Con el control remoto");
    }
    
    public void subirVolmen(){
        System.out.println("Con el control remoto");
    }
     
    public double calcularTiempoPelicula(){
        int sumaPeli = 0;
        
        for(int i=0; i<7; i++){
            if(i == 0){
                System.out.println("El lunes viste 2 horas de Transformers 3 Dark of The Moon");
                sumaPeli += 2;
            } else if (i == 1){
                System.out.println("El martes viste 3.3 horas de Cars 2");
                sumaPeli += 3.3;
            } else if (i == 2){
                System.out.println("El miercoles viste 2.5 horas de Rapidos y Furiosos 5");
                sumaPeli += 2.5;
            } else if (i == 3){
                System.out.println("El jueves viste 3 horas de Como Entrenar a Tu Dragon");
                sumaPeli += 3;
            } else if (i == 4){
                System.out.println("El viernes no viste peliculas");
                sumaPeli += 0;
            } else if (i == 5){
                System.out.println("El sabado viste 5.3 horas de Avengers");
                sumaPeli += 5.3;
            } else if (i == 6){
                System.out.println("El sabado viste 3 horas de El señor de los anillos el retorno del rey");
                sumaPeli += 3;
            }
        }
        return sumaPeli;
    }

    public String getTamanoTv() {
        return tamanoTv;
    }

    public String getTipoPanel() {
        return tipoPanel;
    }
    
}
