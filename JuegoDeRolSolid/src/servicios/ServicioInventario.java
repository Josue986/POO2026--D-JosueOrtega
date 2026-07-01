package servicios;
import modelo.Arma;
import modelo.Armadura;
import modelo.Objeto;
import java.util.ArrayList;

/**
 *
 * @author jotue
 */
public class ServicioInventario {
    private ArrayList<Objeto> items;
    private Arma armaEquipada;
    private Armadura armaduraEquipada;

    public ServicioInventario() {
        this.items = new ArrayList<>();
    }

    public void agregarObjeto(Objeto objeto) {
        this.items.add(objeto);
        System.out.println("Guardado en el inventario: " + objeto.getNombre());
    }

    public void equipar(Objeto objeto) {
        if (!items.contains(objeto)) {
            System.out.println("No tienes este objeto en el inventario.");
            return;
        }

        if (objeto instanceof Arma) {
            this.armaEquipada = (Arma) objeto;
            System.out.println("Arma equipada: " + objeto.getNombre());
        } else if (objeto instanceof Armadura) {
            this.armaduraEquipada = (Armadura) objeto;
            System.out.println("Armadura equipada: " + objeto.getNombre());
        }
    }

    public void quitar(Objeto objeto) {
        if (objeto == armaEquipada) {
            this.armaEquipada = null;
        } else if (objeto == armaduraEquipada) {
            this.armaduraEquipada = null;
        }
    }

    // Métodos para que el sistema de combate consulte los bonus
    public int getBonusAtaque() {
        return (armaEquipada != null) ? armaEquipada.getBonificadorAtaque() : 0;
    }

    public int getBonusDefensa() {
        return (armaduraEquipada != null) ? armaduraEquipada.getBonificadorDefensa() : 0;
    }
}
