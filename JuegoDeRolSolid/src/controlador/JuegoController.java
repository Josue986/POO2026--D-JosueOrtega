/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Personaje;
import servicios.ServicioCombate;
import estrategias.Envenenado;

import java.util.Scanner;

public class JuegoController {
    private Scanner scanner = new Scanner(System.in);

    public void solicitarAccion(Personaje activo, Personaje enemigo, ServicioCombate servicio, int nJugador) {
        boolean accionValida = false;

        while (!accionValida) {
            System.out.println("\n[ Turno de Jugador " + nJugador + " (" + activo.getClass().getSimpleName() + ") ]");
            System.out.println("HP: " + activo.getVida() + " | Energía: " + activo.getEnergia());
            System.out.println("1. Ataque Básico");
            System.out.println("2. Usar Habilidad Especial (Gasta 25 Energía)");
            System.out.println("3. Lanzar Hechizo de Estado");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
    
                servicio.procesarAtaqueBasico(activo, enemigo);
                accionValida = true;
                break;
                case 2:
                    accionValida = servicio.ejecutarHabilidadEspecial(activo, enemigo, nJugador);
                    break;
                case 3:
                    System.out.println("¿Qué estado deseas usar?");
                    System.out.println("1. Envenenar 🧪 (Al enemigo)");
                    System.out.println("2. Congelar ❄️ (Al enemigo)");
                    System.out.println("3. Aumentar Fuerza 💪 (A ti mismo)");
                    System.out.print("Selección: ");
                    int opEstado = scanner.nextInt();
                    
                    int rival = (nJugador == 1) ? 2 : 1;
                    if (opEstado == 1) {
                        servicio.agregarEstadoAJugador(rival, new Envenenado());
                        System.out.println("🧪 Estado Envenenado listo para aplicarse al rival.");
                    }
                    accionValida = true;
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        }
    }
}