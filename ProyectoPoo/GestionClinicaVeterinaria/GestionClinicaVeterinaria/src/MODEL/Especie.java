/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.io.Serializable;
/**
 *
 * @author Pablo
 */
public class Especie implements Serializable{
   private String idEspecie ;
   private String nombre ;

    public Especie(String idEspecie, String nombre) {
        this.idEspecie = idEspecie;
        this.nombre = nombre;
    }

    public String getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(String idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
    
}
