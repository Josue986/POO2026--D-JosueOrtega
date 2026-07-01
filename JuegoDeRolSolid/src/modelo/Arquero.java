/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sophi González
 */

public class Arquero extends Personaje {

    public Arquero(String nombre) {

        super(nombre, 240, 35, 20, 120);

    }

    @Override
    public void atacar(Personaje enemigo) {

        System.out.println(nombre + " dispara una flecha.");

    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

        System.out.println(nombre + " usa LLUVIA DE FLECHAS.");

    }

}