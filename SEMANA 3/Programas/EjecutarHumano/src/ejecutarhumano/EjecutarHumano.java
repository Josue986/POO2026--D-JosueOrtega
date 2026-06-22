package ejecutarhumano;

public class EjecutarHumano {
    public static void main(String[] args) {
        
        Corazon c1 = new Corazon(); //creo objeto corazon
        
        Humano h1 = new Humano(); //creo objeto humano
        
        //asingar valores a corazon
        c1.setTamaño("20 x 10");
        c1.setColor("rojo");
        c1.setIdCorazon("001");
        c1.setPeso(2);
        c1.setEstado("sano");
        
        h1.setCedula("234567");
        h1.setNombres("Juan Garcia");
        h1.setEdad(30);
        h1.setC(c1);
        
        //imprimir resultados del tamaño del corazon
        System.out.println("El tamaño del corazon de " + h1.getNombres() + " es = " + h1.getC().getTamaño());
       
        
        Corazon c2 = new Corazon(); //creo objeto corazon
        
        Humano h2 = new Humano(); //creo objeto humano
        
        Pulmon p2 = new Pulmon();
        
        Ropa r2 = new Ropa();
        
        //asingar valores a corazon
        c2.setTamaño("15 x 11");
        c2.setColor("rojo");
        c2.setIdCorazon("030");
        c2.setPeso(2);
        c2.setEstado("sano");
        
        //asingar valores a pulmon
        p2.setTamaño("33 x 10");
        p2.setColor("color");        
        p2.setIdPulmon("015");
        p2.setPeso(3);
        p2.setEstado("sano");
        
        //asingar valores a ropa
        r2.setMarca("Adidas");
        r2.setColorRopa("Negro");
        r2.setTipo("Chompa");
        r2.setIdRopa("041");
        r2.setTalla(42);
        
        //asingar valores a humano
        h2.setCedula("757254");
        h2.setNombres("Josue Miguel");
        h2.setEdad(20);
        h2.setC(c2);
        
        //imprimir resultados del tamaño del corazon
        System.out.println("\nEl tamaño del corazon de " + h2.getNombres() + " es = " + h2.getC().getTamaño());
        System.out.println("Nombres: " + h2.getNombres());
        System.out.println("Cedula: " + h2.getCedula());
        System.out.println("Edad: " + h2.getEdad());
        System.out.println("\nID corazon: " + h2.getC().getIdCorazon());
        System.out.println("Peso corazon: " + h2.getC().getPeso());
        System.out.println("Color corazon: " + h2.getC().getIdCorazon());
        System.out.println("\nTamaño pulmon: " + h2.getC().getTamaño());
        System.out.println("Estado pulmon: " + h2.getC().getEstado());
        System.out.println("ID pulmon: " + h2.getP().getIdPulmon());
        System.out.println("Color pulmon: " + h2.getP().getColor());
        System.out.println("\nID ropa: " + h2.getR().getIdRopa());
        System.out.println("Marca: " + h2.getR().getMarca());
        System.out.println("Color: " + h2.getR().getColorRopa());
        System.out.println("Talla: " +h2.getR().getTalla());
    }   
}
