/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import modelo.Personaje;
import interfaces.IEstadoAlterado;
import controlador.JuegoController;
import java.util.ArrayList;
import java.util.List;

public class ServicioCombate {
    private List<IEstadoAlterado> estadosP1 = new ArrayList<>();
    private List<IEstadoAlterado> estadosP2 = new ArrayList<>();
    private int cooldownHabilidadP1 = 0;
    private int cooldownHabilidadP2 = 0;
    private final int COOLDOWN_MAXIMO = 2; 

    public void iniciarCombate(Personaje p1, Personaje p2, JuegoController controller) {
        System.out.println("\n========================================");
        System.out.println("⚔️  ¡INICIA EL COMBATE EN EL COLISEO!  ⚔️");
        System.out.println("========================================");

        int ronda = 1;
        while (p1.getVida() > 0 && p2.getVida() > 0) {
            System.out.println("\n--- RONDA " + ronda + " ---");

            // --- TURNO JUGADOR 1 ---
            if (p1.getVida() > 0) {
                procesarEstados(p1, estadosP1);
                if (p1.getVida() > 0) {
                    if (estaCongelado(estadosP1)) {
                        System.out.println("❄️ " + p1.getClass().getSimpleName() + " está congelado y pierde su turno.");
                    } else {
                        if (cooldownHabilidadP1 > 0) cooldownHabilidadP1--;
                        controller.solicitarAccion(p1, p2, this, 1);
                    }
                }
            }

            if (p2.getVida() <= 0) break;

            // --- TURNO JUGADOR 2 ---
            if (p2.getVida() > 0) {
                procesarEstados(p2, estadosP2);
                if (p2.getVida() > 0) {
                    if (estaCongelado(estadosP2)) {
                        System.out.println("❄️ " + p2.getClass().getSimpleName() + " está congelado y pierde su turno.");
                    } else {
                        if (cooldownHabilidadP2 > 0) cooldownHabilidadP2--;
                        controller.solicitarAccion(p2, p1, this, 2);
                    }
                }
            }

            ronda++;
        }
        declararGanador(p1, p2);
    }

    private void procesarEstados(Personaje p, List<IEstadoAlterado> listaEstados) {
        listaEstados.removeIf(estado -> !estado.estaActivo());
        for (IEstadoAlterado estado : listaEstados) {
            estado.aplicarEfecto(p);
        }
    }

    private boolean estaCongelado(List<IEstadoAlterado> listaEstados) {
        return listaEstados.stream().anyMatch(e -> e.getNombre().contains("Congelado") && e.estaActivo());
    }

    public boolean ejecutarHabilidadEspecial(Personaje atacante, Personaje defensor, int nJugador) {
        int cooldownActual = (nJugador == 1) ? cooldownHabilidadP1 : cooldownHabilidadP2;
        int costoEnergia = 25; 

        if (cooldownActual > 0) {
            System.out.println("❌ Habilidad en enfriamiento. Faltan " + cooldownActual + " turnos.");
            return false;
        }
        if (atacante.getEnergia() < costoEnergia) {
            System.out.println("❌ Energía insuficiente. Requieres " + costoEnergia + " de energía.");
            return false;
        }

        atacante.usarHabilidadEspecial(defensor);
        atacante.setEnergia(atacante.getEnergia() - costoEnergia);
        
        if (nJugador == 1) cooldownHabilidadP1 = COOLDOWN_MAXIMO;
        else cooldownHabilidadP2 = COOLDOWN_MAXIMO;
        
        return true;
    }

    public void agregarEstadoAJugador(int nJugadorObjetivo, IEstadoAlterado estado) {
        if (nJugadorObjetivo == 1) estadosP1.add(estado);
        else estadosP2.add(estado);
    }
    public void procesarAtaqueBasico(Personaje atacante, Personaje defensor) {
    // Imprime el texto estético provisto por las clases de Sophi
    atacante.atacar(defensor); 
    
    // Calcula el daño aplicando los bonificadores de Josué
    int dañoCalculado = atacante.getAtaqueTotal() - defensor.getDefensaTotal();
    if (dañoCalculado < 0) dañoCalculado = 0;

    defensor.recibirDaño(dañoCalculado);
    System.out.println("   [Combate] " + atacante.getNombre() + " infligió " + dañoCalculado + " de daño real a " + defensor.getNombre() + ".");
}

    private void declararGanador(Personaje p1, Personaje p2) {
        System.out.println("\n========================================");
        if (p1.getVida() > 0) {
            System.out.println("🏆 ¡EL GANADOR ES JUGADOR 1 (" + p1.getClass().getSimpleName() + ")!");
        } else {
            System.out.println("🏆 ¡EL GANADOR ES JUGADOR 2 (" + p2.getClass().getSimpleName() + ")!");
        }
        System.out.println("========================================");
    }
}