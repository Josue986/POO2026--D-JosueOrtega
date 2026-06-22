/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejecutarmecanica;

/**
 *
 * @author SebastianCodena
 */
public class EjecutarMecanica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Taller miTaller = new Taller();

        ReparacionMecanica m1 = new ReparacionMecanica(14, 0.0, "Cambio de pastillas de freno");
        m1.aumentarHoras(4);
        m1.AumentarcostoMat(85.50);
        miTaller.agregarMecanica(m1);

        ReparacionMecanica m2 = new ReparacionMecanica(14, 0.0, "Reparacion completa de motor");
        m2.aumentarHoras(14);
        m2.AumentarcostoMat(420.00);
        miTaller.agregarMecanica(m2);

        ReparacionChapasPintura cp1 = new ReparacionChapasPintura(21, 0.0, "Pintado de guardabarros izquierdo");
        cp1.aumentarHoras(8);
        cp1.AumentarcostoMat(50.00);
        miTaller.agregarChapaPintura(cp1);

        ReparacionChapasPintura cp2 = new ReparacionChapasPintura(21, 0.0, "Pulido de faros y correccion de rayones");
        cp2.aumentarHoras(3);
        cp2.AumentarcostoMat(15.00);
        miTaller.agregarChapaPintura(cp2);

        Revision r1 = new Revision(7, "Revision tecnica de los 10,000 KM");
        r1.aumentarHoras(2);
        miTaller.agregarRevision(r1);

        Revision r2 = new Revision(7, "Chequeo preventivo pre-viaje");
        r2.aumentarHoras(6);
        miTaller.agregarRevision(r2); // 🔥 FALTABA ESTO

        miTaller.mostrarOriginalYOrdenado();
    }
}