package ejecutarpagos;

public abstract class Pago {
    protected String id;
    protected String nombre;
    protected String tipo;
    protected double valor;
    protected double cantidad;  
    protected double descuento;    
    protected double pago;

    public Pago(String id, String nombre, String tipo, double valor, double cantidad, double descuento) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.pago = 00.00;
    }
    
    //Metodo abstracto
    public abstract double calcularPago(); //Metodos abstract no tiene cuerpo (llaves) 
                                           //porque no se implementan en la clase padre
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPago() {
        return pago;
    }
    
}
