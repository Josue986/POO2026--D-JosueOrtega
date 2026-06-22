package ejecutarmenusrestaurante;

public class EjecutarMenusRestaurante {
    public static void main(String[] args) {
        Factura factura = new Factura("Josué Ortega", 0.15);
        
        //Crear Menus
        Menus platoCarta = new MenuCarta("Lomo Fino con Salsa de Champiñones", 10.00, 2.50, 1.50, 0.10); // 10% servicio
        Menus platoDia = new MenuDia("Seco de Pollo Criollo", 3.50, 1.00, 0.50);
        Menus platoNinos = new MenuNinos("Nuggets con Papas Fritas", 4.00, 1.25, 0.75);
        Menus platoEconomico = new MenuEconomico("Almuerzo Ejecutivo de Pescado", 3.00, 0.15); // 15% descuento

        //Detalles Facturas
        DetallesFactura det1 = new DetallesFactura(platoCarta, 1);
        DetallesFactura det2 = new DetallesFactura(platoDia, 2);
        DetallesFactura det3 = new DetallesFactura(platoNinos, 1);
        DetallesFactura det4 = new DetallesFactura(platoEconomico, 1);

        //Agregar Detalles de las Facturas
        factura.agregarDetalle(det1);
        factura.agregarDetalle(det2);
        factura.agregarDetalle(det3);
        factura.agregarDetalle(det4);

        //Imprimir las facturas
        factura.mostrarInfo();
    }
}
