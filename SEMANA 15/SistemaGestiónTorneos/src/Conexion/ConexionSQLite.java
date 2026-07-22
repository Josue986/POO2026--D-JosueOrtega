package Conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {

    private static final String URL = "jdbc:sqlite:SportTrack.db";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static void inicializarBaseDeDatos() {
        String tablaEquipos = "CREATE TABLE IF NOT EXISTS equipos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT NOT NULL UNIQUE);";

        String tablaJugadores = "CREATE TABLE IF NOT EXISTS jugadores ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cedula TEXT NOT NULL UNIQUE, "
                + "nombre TEXT NOT NULL, "
                + "apellido TEXT NOT NULL, "
                + "id_equipo INTEGER, "
                + "num_camiseta INTEGER, "
                + "FOREIGN KEY(id_equipo) REFERENCES equipos(id));";

        String tablaPartidos = "CREATE TABLE IF NOT EXISTS partidos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_equipo_local INTEGER, "
                + "id_equipo_visita INTEGER, "
                + "fecha TEXT NOT NULL, "
                + "sede TEXT NOT NULL, "
                + "arbitro_cedula TEXT, "
                + "arbitro_nombre TEXT, "
                + "arbitro_apellido TEXT, "
                + "arbitro_licensia TEXT, "
                + "goles_local INTEGER DEFAULT NULL, "
                + "goles_visita INTEGER DEFAULT NULL, "
                + "FOREIGN KEY(id_equipo_local) REFERENCES equipos(id), "
                + "FOREIGN KEY(id_equipo_visita) REFERENCES equipos(id));";

        try (Connection conn = conectar(); Statement stmt = conn.createStatement()) {

            stmt.execute(tablaEquipos);
            stmt.execute(tablaJugadores);
            stmt.execute(tablaPartidos);
            System.out.println("[BD] Estructura de tablas verificada/creada con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al inicializar las tablas: " + e.getMessage());
        }
    }
}
