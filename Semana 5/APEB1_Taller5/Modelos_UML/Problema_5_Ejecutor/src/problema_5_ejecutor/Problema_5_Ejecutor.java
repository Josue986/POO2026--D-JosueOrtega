package problema_5_ejecutor;


public class Problema_5_Ejecutor {
    public static void main(String[] args) {
        Problema_5_Conflicto conflicto = new Problema_5_Conflicto("Tercera Guerra");
        conflicto.agregarEvento(new Problema_5_Evento("Batalla de Berlin", "Batalla"));
        
        System.out.println(conflicto);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(conflicto.mostrarEventos());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Estado segun paises (100 afectados): " + conflicto.evaluarSituacion(100));
    }
    
}
