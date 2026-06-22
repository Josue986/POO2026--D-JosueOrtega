package ejecutarjuegorol;

public abstract class Personajes {
    protected String id;
    protected String nombrePersonaje;
    protected String clase;
    protected int hp;
    protected int defensa;
    protected int ataque;

    public Personajes(String id, String nombrePersonaje, String clase, int hp, 
            int defensa, int ataque) {
        this.id = id;
        this.nombrePersonaje = nombrePersonaje;
        this.clase = clase;
        this.hp = hp;
        this.defensa = defensa;
        this.ataque = ataque;
    }
    
    public abstract int atacar();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
}
