package Heroes;

// TODO: Auto-generated Javadoc
/**
 * The Class Elfo.
 */
public class Elfo extends Heroe {
    
    /** The ataque fijo. */
    private int ataqueFijo;

    /**
     * Instantiates a new elfo.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param armadura the armadura
     */
    public Elfo(String nombre, int vida, int armadura) {
        super(nombre, vida, "Elfo", armadura);
    }

    /**
     * Instantiates a new elfo Prueba.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param armadura the armadura
     * @param ataqueFijo the ataque fijo
     */
    public Elfo(String nombre, int vida, int armadura, int ataqueFijo) {
        super(nombre, vida, "Elfo", armadura);
        this.ataqueFijo = ataqueFijo;
    }

    /**
     * Atacar.
     *
     * @return the int
     */
    @Override
    public int atacar() {
        return ataqueFijo != 0 ? ataqueFijo : super.atacar();
    }

    /**
     * Atacar modificado.
     *
     * @param bestia the bestia
     * @return the int
     */
    @Override
    public int atacarModificado(Bestias.Bestia bestia) {
        int ataqueBase = atacar();
        if (bestia.getTipo().equals("Orco")) {
            return ataqueBase + 10;
        }
        return ataqueBase;
    }
}

