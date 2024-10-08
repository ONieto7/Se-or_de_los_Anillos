package Heroes;

// TODO: Auto-generated Javadoc
/**
 * The Class Hobbit.
 */
public class Hobbit extends Heroe {
    
    /** The ataque fijo. */
    private int ataqueFijo;

    /**
     * Instantiates a new hobbit.
     *
     * @param nombre the nombre
     * @param vida the vida
     * @param armadura the armadura
     * @param ataqueFijo the ataque fijo
     */
    public Hobbit(String nombre, int vida, int armadura, int ataqueFijo) {
        super(nombre, vida, "Hobbit", armadura);
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
        if (bestia.getTipo().equals("Trasgo")) {
            return ataqueBase - 5;
        }
        return ataqueBase;
    }
}