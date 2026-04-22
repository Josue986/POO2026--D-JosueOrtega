package ejecutartriangulos;

public class triangulos {    
    //Listar atributos
    private double base;
    private double altura;
    private double area;
    private double ladoUno;
    private double ladoDos;
    private double ladoTres;
    private double perimetro;

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getArea() {
        return area;
    }

    public double getLadoUno() {
        return ladoUno;
    }

    public double getLadoDos() {
        return ladoDos;
    }

    public double getLadoTres() {
        return ladoTres;
    }

    public double getPerimetro() {
        return perimetro;
    }
    
    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setArea(double area) {
            this.area = area;
    }

    public void setLadoUno(double ladoUno) {
        this.ladoUno = ladoUno;
    }

    public void setLadoDos(double ladoDos) {
        this.ladoDos = ladoDos;
    }

    public void setLadoTres(double ladoTres) {
        this.ladoTres = ladoTres;
    }
    
    /*public void calcularArea(){
        area = (base * altura)/2;
    }*/
    
    public double calcularArea(){
        return (base * altura)/2;
    }
    
    public void calcularPerimetro(){
        perimetro = ladoUno + ladoDos + ladoTres;
    }
    
}
