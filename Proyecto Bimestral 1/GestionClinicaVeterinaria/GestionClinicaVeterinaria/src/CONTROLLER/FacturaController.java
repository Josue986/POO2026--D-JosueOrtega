/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.*;
import DATABASE.*;
import java.util.ArrayList;

public class FacturaController {
    ArrayList<Factura> facturas = new ArrayList<>();

    public void agregar(String idFactura, String idConsulta, String idMascota,
                        String idPropietario, String fecha) {
        if (buscar(idFactura) != null) return;
        Factura f = new Factura(idFactura, idConsulta, idMascota, idPropietario, fecha);
        facturas.add(f);
    }

    public Factura buscar(String idFactura) {
        for (Factura f : facturas) {
            if (f.getIdFactura().equals(idFactura)) return f;
        }
        return null;
    }

    public Factura eliminar(String idFactura) {
        Factura f = buscar(idFactura);
        if (f != null) {
            facturas.remove(f);
            return f;
        }
        return null;
    }

    // Genera factura automáticamente desde una consulta
    public Factura generarDesdeConsulta(String idFactura, String fecha,
                                        ConsultaMedica consulta,
                                        String idPropietario) {
        if (buscar(idFactura) != null) return null;

        Factura f = new Factura(idFactura, consulta.getIdConsulta(),
                consulta.getIdMascota(), idPropietario, fecha);

        // Agregar costo base de la consulta
        f.agregarDetalle(new DetalleFactura(
                idFactura + "-C",
                "Consulta médica",
                1,
                consulta.getCostoBase()
        ));

        // Agregar examenes y medicamentos
        int i = 1;
        for (ExamenMedico e : consulta.getExamenes()) {
            f.agregarDetalle(new DetalleFactura(
                    idFactura + "-E" + i,
                    e.getTipo(),
                    1,
                    e.getCosto()
            ));
            i++;
        }

        facturas.add(f);
        return f;
    }

    public void guardar() {
        try {
            java.io.ObjectOutputStream salida = new java.io.ObjectOutputStream(
                    new java.io.FileOutputStream("dataFactura.txt"));
            for (Factura f : facturas) salida.writeObject(f);
            salida.close();
        } catch (java.io.IOException ex) {
            System.err.println("Error al guardar: " + ex);
        }
    }

    public void cargar() {
        LeerFactura lectura = new LeerFactura("dataFactura.txt");
        lectura.establecerListaFacturas();
        facturas = lectura.obtenerListaFacturas();
    }

    public ArrayList<Factura> getFacturas() { return facturas; }
}