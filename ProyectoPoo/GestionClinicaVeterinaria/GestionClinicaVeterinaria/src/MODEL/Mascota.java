package MODEL;
import java.io.Serializable;

public class Mascota implements Serializable {
    private String idMas;
    private String nombre;
    private String fechadenacimiento;
    private double peso;
    private Especie e;
    private String cedulaPropietario; 
    private HistorialMedico historial; 

    public Mascota(String idMas, String nombre, String fechadenacimiento, 
               double peso, Especie e, String cedulaPropietario) {
    this.idMas = idMas;
    this.nombre = nombre;
    this.fechadenacimiento = fechadenacimiento;
    this.peso = peso;
    this.e = e;
    this.cedulaPropietario = cedulaPropietario;
    this.historial = new HistorialMedico(idMas + "-H", fechadenacimiento); // ← dentro
}

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public void setCedulaPropietario(String cedulaPropietario) {
        this.cedulaPropietario = cedulaPropietario;
    }

    public String getIdMas() {
        return idMas;
    }

    public void setIdMas(String idMas) {
        this.idMas = idMas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Especie getE() {
        return e;
    }

    public void setE(Especie e) {
        this.e = e;
    }
    

// Agregar método:
public HistorialMedico obtenerHistorial() {
    return historial;
}

public void setHistorial(HistorialMedico historial) {
    this.historial = historial;
}
}