/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estrategias;
import interfaces.IEstadoAlterado;
import modelo.Personaje;

public class Envenenado implements IEstadoAlterado {
    private int turnosRestantes = 3;

    @Override
    public String getNombre() { return "Envenenado 🧪"; }

    @Override
    public void aplicarEfecto(Personaje personaje) {
        if (estaActivo()) {
            int dañoVeneno = 10;
            personaje.recibirDaño(dañoVeneno);
            System.out.println("   [Estado] " + personaje.getClass().getSimpleName() + " sufrió " + dañoVeneno + " de daño por veneno.");
            disminuirTurno();
        }
    }

    @Override
    public void disminuirTurno() { turnosRestantes--; }

    @Override
    public boolean estaActivo() { return turnosRestantes > 0; }
}