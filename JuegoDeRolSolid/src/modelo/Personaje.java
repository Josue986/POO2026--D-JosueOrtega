/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Sophi González
 */


import interfaces.IAtacante;
import interfaces.IHabilidadEspecial;
import servicios.ServicioInventario;

public abstract class Personaje implements IAtacante, IHabilidadEspecial {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected int experiencia;
    protected int energia;

    protected ServicioInventario inventario = new ServicioInventario();

    public Personaje(String nombre, int vida, int ataque, int defensa, int energia) {

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.energia = energia;

        this.nivel = 1;
        this.experiencia = 0;
    }

    public int getAtaqueTotal() {
        return ataque + inventario.getBonusAtaque();
    }

    public int getDefensaTotal() {
        return defensa + inventario.getBonusDefensa();
    }

    public void recibirDaño(int daño) {

        vida -= daño;

        if (vida < 0) {
            vida = 0;
        }

    }

    public void subirNivel() {

        if (experiencia >= 100) {

            nivel++;
            experiencia = 0;

            vida += 20;
            ataque += 5;
            defensa += 5;
            energia += 10;

            System.out.println(nombre + " subió al nivel " + nivel);

        }

    }

    public ServicioInventario getInventario() {
        return inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getEnergia() {
        return energia;
    }


    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

}