package juegoderolsolid;

import modelo.*;
import servicios.ServicioCombate;
import controlador.JuegoController;

public class JuegoDeRolSolid {
    public static void main(String[] args) {
        // 1. Inicializar el controlador y el servicio de combate
        JuegoController controller = new JuegoController();
        ServicioCombate coliseo = new ServicioCombate();

        System.out.println("====================================================");
        System.out.println(" ⚔️ CONFIGURANDO PERSONAJES Y EQUIPAMIENTO (SOLID) ⚔️");
        System.out.println("====================================================\n");

        // 2. Crear los personajes de la jerarquía (Polimorfismo / LSP - Parte de Sophi)
        Personaje guerrero = new Guerrero("Thorin El Valiente");
        Personaje mago = new Mago("Gandalf El Gris");

        // 3. Crear los objetos del inventario (Parte de Josué)
        Espada espadaAcero = new Espada("Espada de Acero Real", 20); 
        Pechera pecheraPlata = new Pechera("Pechera de Plata", 20);
        Baston bastonRunico = new Baston("Bastón Rúnico de Fuego", 35);

        // 4. Equipar a cada personaje en su propio inventario
        // -- Equipamiento del Guerrero --
        guerrero.getInventario().agregarObjeto(espadaAcero);
        guerrero.getInventario().agregarObjeto(pecheraPlata);
        guerrero.getInventario().equipar(espadaAcero);
        guerrero.getInventario().equipar(pecheraPlata);

        // -- Equipamiento del Mago --
        mago.getInventario().agregarObjeto(bastonRunico);
        mago.getInventario().equipar(bastonRunico);

        // 5. Mostrar estadísticas iniciales de verificación (Puntos extra por orden)
        System.out.println(guerrero.getNombre() + " listo. ATK Base + Ítems: " + guerrero.getAtaqueTotal() + " | DEF Total: " + guerrero.getDefensaTotal());
        System.out.println(mago.getNombre() + " listo. ATK Base + Ítems: " + mago.getAtaqueTotal() + " | DEF Total: " + mago.getDefensaTotal());
        System.out.println("\n----------------------------------------------------");
        System.out.println("          ¡EL COMBATE VA A COMENZAR!                ");
        System.out.println("----------------------------------------------------\n");

        // 6. Arrancar el motor de combate (Inversión de Dependencias / DIP)
        coliseo.iniciarCombate(guerrero, mago, controller);
    }
}