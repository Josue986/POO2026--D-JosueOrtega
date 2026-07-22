package lavar;

import Vista.VistaLavado;

public class Lavar {

    public static void main(String[] args) {

        /*LavadoBasico lb = new LavadoBasico("LBC123", "XB");  
        lb.tipoLavado();
        lb.precio();
        
        LavadoCompleto lc = new LavadoCompleto ("LBB456", "BF"); 
        lc.tipoLavado();
        lc.precio();
        
        LavadoPremium lp = new LavadoPremium("LCC678", "EB");
        lp.tipoLavado();
        lp.precio();
        
        
        System.out.println("Lavado " + lb.tipoLavado()+ " del cliente: " + lb.getCliente() + " le costo $ " + lb.precio());
        System.out.println("Lavado " + lc.tipoLavado()+ " del cliente: " + lc.getCliente() + " le costo $ " + lc.precio());
        System.out.println("Lavado " + lp.tipoLavado()+ " del cliente: " + lp.getCliente() + " le costo $ " + lp.precio());
        */
        
       new VistaLavado().menu();
        
       
        
        
    }
    
}
