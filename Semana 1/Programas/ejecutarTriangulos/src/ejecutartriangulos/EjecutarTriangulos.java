package ejecutartriangulos;
import java.util.Scanner;


public class EjecutarTriangulos {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Triangulo 1.");
        
        triangulos objuno = new triangulos();
        
        double base = 0;
        double altura = 0;
        double area = 0;
        double ladoUno, ladoDos, ladoTres;
        
        //variables para pasarle al objeto los valores
        System.out.print("Ingrese la base: ");
        base =sc.nextDouble();
        
        System.out.print("Ingrese la altura: ");
        altura = sc.nextDouble();
        
        System.out.println("Ingrese longitud del lado 1: ");
        ladoUno = sc.nextDouble();
        System.out.println("Ingrese longitud del lado 2: ");
        ladoDos = sc.nextDouble();
        System.out.println("Ingrese longitud del lado 3: ");
        ladoTres = sc.nextDouble();
        // Enviar Datos al objeto
        objuno.setBase(base);
        objuno.setAltura(altura);
        objuno.setLadoUno(ladoUno);
        objuno.setLadoDos(ladoDos);
        objuno.setLadoTres(ladoTres);
        
        //Invoco metodo para calcular area
        area = objuno.calcularArea();
        
        objuno.calcularPerimetro();
        
        objuno.setArea(area);
        
        System.out.println("Area del Triangulo: " + objuno.getArea());
        
        triangulos objdos = new triangulos();        
        
        System.out.println("Perimetro del Triangulo: " + objuno.getPerimetro());
        
        System.out.println("\nTriangulo 2.");
        
        //variables para pasarle al objeto los valores
        System.out.print("Ingrese la base: ");
        base =sc.nextDouble();
        
        System.out.print("Ingrese la altura: ");
        altura = sc.nextDouble();
        
        // Enviar Datos al objeto
        objdos.setBase(base);
        objdos.setAltura(altura);
        
        //Invoco metodo para calcular area
        area = objdos.calcularArea();

        objdos.setArea(area);
        
        System.out.println("Area del Triangulo: " + objdos.getArea());
    }    
}
