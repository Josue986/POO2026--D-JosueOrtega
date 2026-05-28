package problema.pkg5_conflicto_ejecutor;

public class Problema5_Conflicto_Ejecutor {
    public static void main(String[] args) {
        Conflicto conflicto = new Conflicto("Tercera Guerra");
        conflicto.agregarEvento(new Evento("Batalla de Berlin", "Batalla"));
        
        System.out.println(conflicto);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(conflicto.mostrarEventos());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Estado segun paises (100 afectados): " + conflicto.evaluarSituacion(100));
    }
}
