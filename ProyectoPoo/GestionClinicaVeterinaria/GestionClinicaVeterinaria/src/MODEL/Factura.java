/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    private String idFactura;
    private String idConsulta;
    private String idMascota;
    private String idPropietario;
    private String fecha;
    private ArrayList<DetalleFactura> detalles;

    public Factura(String idFactura, String idConsulta, String idMascota, 
                   String idPropietario, String fecha) {
        this.idFactura = idFactura;
        this.idConsulta = idConsulta;
        this.idMascota = idMascota;
        this.idPropietario = idPropietario;
        this.fecha = fecha;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleFactura d) {
        detalles.add(d);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleFactura d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    public String getIdFactura() { return idFactura; }
    public void setIdFactura(String idFactura) { this.idFactura = idFactura; }

    public String getIdConsulta() { return idConsulta; }
    public void setIdConsulta(String idConsulta) { this.idConsulta = idConsulta; }

    public String getIdMascota() { return idMascota; }
    public void setIdMascota(String idMascota) { this.idMascota = idMascota; }

    public String getIdPropietario() { return idPropietario; }
    public void setIdPropietario(String idPropietario) { this.idPropietario = idPropietario; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public ArrayList<DetalleFactura> getDetalles() { return detalles; }
}