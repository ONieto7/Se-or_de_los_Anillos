package Bestias;

// TODO: Auto-generated Javadoc
/**
 * The Class Orco.
 */
public class Orco extends Bestia {
    
    /**
     * Instantiates a new orco.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param armadura the armadura
     */
    public Orco(String nombre, int vida, int armadura) {
    	//Se utiliza para llamar al constructor de la clase base Bestia
        super(nombre, vida, "Orco", armadura);
    }
    
    /**
     * Gets the armadura modificada.
     *
     * @return the armadura modificada
     */
    @Override
    public int getArmaduraModificada() {
        
        return (int) (super.getArmadura() * 0.9);
    }
}
