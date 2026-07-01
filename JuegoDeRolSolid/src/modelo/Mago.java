/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sophi González
 */
public class Mago extends Personaje {

    public Mago(String nombre) {

        super(nombre, 200, 50, 15, 150);

    }

    @Override
    public void atacar(Personaje enemigo) {

        System.out.println(nombre + " lanza un hechizo.");

    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

        System.out.println(nombre + " usa METEORO.");

    }

}