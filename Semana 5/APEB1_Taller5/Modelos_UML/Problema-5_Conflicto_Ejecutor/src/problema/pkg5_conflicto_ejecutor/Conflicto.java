package problema.pkg5_conflicto_ejecutor;
import java.util.ArrayList;

public class Conflicto {
    private String nombre;
    private ArrayList<Evento> eventos = new ArrayList<>();
    private int numPaisesMundo = 195;

    public Conflicto(String nombre){ 
        this.nombre = nombre; 
    }

    public void agregarEvento(Evento evento){ 
        eventos.add(evento); 
    }

    public String evaluarSituacion(int paisesAfectados){
        double porcentaje = (double) paisesAfectados/numPaisesMundo;
        if (porcentaje > 0.5){
            return "GUERRA MUNDIAL";
        }
        if (porcentaje >= 0.3){
                return "REUNION URGENTE ONU.";
        }
        return "Conflicto Local/Regional.";
    }
    
    public String mostrarEventos(){
        if(eventos.isEmpty()){
            return "No hay eventos registrados en este conflicto.";
        }
        
        String listado = "Lista de Eventos para: " + this.nombre + "\n";
        for(Evento evento : eventos) {
            listado += " - " + evento.toString();
        }
        return listado;
    }

    @Override
    public String toString() {
        return "Conflicto: " + nombre + " | Eventos registrados: " + eventos.size() + ". ";
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public int getNumPaisesMundo() {
        return numPaisesMundo;
    }
}
