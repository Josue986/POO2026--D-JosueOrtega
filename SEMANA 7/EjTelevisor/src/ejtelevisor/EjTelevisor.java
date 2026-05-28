package ejtelevisor;
import java.util.ArrayList;

public class EjTelevisor {
    public static void main(String[] args) {
        ArrayList <Televisor> tv = new ArrayList<>();
        Televisor t = new Televisor("001", 55, 650, "QLED");
        
        tv.add(t); //Agrego mi objeto televisor
        tv.add(new Televisor("002", 45, 500, "QLED"));
        tv.add(new Televisor("002", 75, 900, "QLED"));
        
        System.out.println("Precio del televisor JODETE:" + tv.get(0));
        System.out.println("Precio del televisor JODETE:" + tv.get(1));
        System.out.println("Precio del televisor JODETE:" + tv.get(2));
        
        System.out.println("\nUsando un for para imprimir: ");
        for(int i=0; i<tv.size(); i++){
            System.out.println("Precio del televisor JODETE:" + tv.get(i));
        }
    }
    
}
