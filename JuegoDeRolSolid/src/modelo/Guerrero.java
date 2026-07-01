/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sophi González
 */

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {

        super(nombre, 300, 40, 30, 100);

    }

    @Override
    public void atacar(Personaje enemigo) {

        System.out.println(nombre + " ataca con espada.");

    }

    @Override
    public void usarHabilidadEspecial(Personaje enemigo) {

        System.out.println(nombre + " usa IRA DEL COLISEO.");

    }

}