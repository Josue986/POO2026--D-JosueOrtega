package problema_5_ejecutor;
import java.util.ArrayList;

public class Problema_5_Conflicto{
    private String nombre;
    private ArrayList<Problema_5_Evento> eventos = new ArrayList<>();
    private int numPaisesMundo = 195;

    public Problema_5_Conflicto(String nombre){ 
        this.nombre = nombre; 
    }

    public void agregarEvento(Problema_5_Evento evento){ 
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
        for(Problema_5_Evento evento : eventos) {
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

    public ArrayList<Problema_5_Evento> getEventos() {
        return eventos;
    }

    public int getNumPaisesMundo() {
        return numPaisesMundo;
    }
}
