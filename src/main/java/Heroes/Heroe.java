package Heroes;

// TODO: Auto-generated Javadoc
/**
 * The Class Heroe.
 */
public class Heroe {
	
	/** The nombre. */
	//Atributos privados de la clase Heroe
    private String nombre;
    
    /** The vida. */
    private int vida;
    
    /** The tipo. */
    private String tipo;
    
    /** The armadura. */
    private int armadura;
    
    /**
     * Instantiates a new heroe.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param tipo the tipo
     * @param armadura the armadura
     */
    //Constructor
    public Heroe(String nombre, int vida, String tipo, int armadura) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        this.armadura = armadura;
    }
    
    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    //Getter y Setter
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Sets the nombre.
     *
     * @param nombre the new nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets the vida.
     *
     * @return the vida
     */
    public int getVida() {
        return vida;
    }
    
    /**
     * Sets the vida.
     *
     * @param vida the new vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Gets the armadura.
     *
     * @return the armadura
     */
    public int getArmadura() {
        return armadura;
    }
    
    /**
     * Sets the armadura.
     *
     * @param armadura the new armadura
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * Atacar.
     *
     * @return the int
     */
    //Método para simular un ataque entre 0 y 99, entre dos intentos el mayor
    public int atacar() {
        int ataque1 = (int) (Math.random() * 100);
        int ataque2 = (int) (Math.random() * 100);
        return Math.max(ataque1, ataque2);
    }
    
    /**
     * Atacar modificado.
     *
     * @param bestia the bestia
     * @return the int
     */
    public int atacarModificado(Bestias.Bestia bestia) {
        return atacar(); 
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return nombre + " - " + tipo + " - " + vida + " - " + armadura;
    }
}


