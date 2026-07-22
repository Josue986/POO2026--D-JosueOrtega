/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemagestióntorneos;
import Modelo.EquipoDAO;
import Modelo.JugadorDAO;
import Modelo.PartidoDAO;
import Controlador.TorneoControlador;
import Vista.TorneoVista;
import Conexion.ConexionSQLite; 
/**
 *
 * @author jotue
 */
public class SistemaGestiónTorneos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Crear el archivo .db y sus tablas automáticamente si no existen
        ConexionSQLite.inicializarBaseDeDatos();

        // 2. Inicializar los traductores de la base de datos (Modelo)
        EquipoDAO eqDAO = new EquipoDAO();
        JugadorDAO jugDAO = new JugadorDAO();
        PartidoDAO partDAO = new PartidoDAO();

        // 3. Inicializar la interfaz de usuario (Vista)
        TorneoVista vista = new TorneoVista();

        // 4. Inicializar el cerebro del sistema (Controlador)
        TorneoControlador controlador = new TorneoControlador(eqDAO, jugDAO, partDAO, vista);

        // 5. Arrancar el menú interactivo
        vista.iniciarMenu(controlador);
    } 
}
