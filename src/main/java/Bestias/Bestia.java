package Bestias;

// TODO: Auto-generated Javadoc
/**
 * The Class Bestia.
 */
public class Bestia {
	
	/** The nombre. */
	//Atributos privados de la clase Bestia
    private String nombre;
    
    /** The vida. */
    private int vida;
    
    /** The tipo. */
    private String tipo;
    
    /** The armadura. */
    private int armadura;
    
    /**
     * Instantiates a new bestia.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param tipo the tipo
     * @param armadura the armadura
     */
    //Constructor
    public Bestia(String nombre, int vida, String tipo, int armadura) {
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
     * Gets the armadura modificada.
     *
     * @return the armadura modificada
     */
    public int getArmaduraModificada() {
        return armadura;
    }

    /**
     * Atacar.
     *
     * @return the int
     */
    //Método para simular un ataque entre 0 y 89
    public int atacar() {
        return (int)(Math.random() * 90);
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
