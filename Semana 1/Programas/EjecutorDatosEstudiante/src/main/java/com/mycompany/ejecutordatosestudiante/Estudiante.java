package com.mycompany.ejecutordatosestudiante;

public class Estudiante {
    private String nombre;
    private String id;
    private String añoEstudiantil;
    private float promedio;

    public Estudiante(String nombre, String id, String añoEstudiantil) {
        this.nombre = nombre;
        this.id = id;
        this.añoEstudiantil = añoEstudiantil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getAñoEstudiantil() {
        return añoEstudiantil;
    }

    public float getPromedio() {
        return promedio;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
    public void setAñoEstudiantil(String añoEstudiantil) {
        this.añoEstudiantil = añoEstudiantil;
    }
    
    public void calcularPromedio(float nota1, float nota2, float nota3){
        this.promedio = (nota1+nota2+nota3)/3;
    }
}
