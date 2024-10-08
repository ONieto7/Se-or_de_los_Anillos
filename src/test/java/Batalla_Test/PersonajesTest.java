package Batalla_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Bestias.Bestia;
import Bestias.Orco;
import Bestias.Trasgo;
import Bestias.UrukHai;
import Heroes.Elfo;
import Heroes.Enano;
import Heroes.Hobbit;
import Heroes.Humano;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonajesTest.
 */
public class PersonajesTest {

    /** The elfo. */
    private Elfo elfo;
    
    /** The hobbit. */
    private Hobbit hobbit;
    
    /** The orco. */
    private Orco orco;
    
    /** The trasgo. */
    private Trasgo trasgo;

    /**
     * Sets the up.
     */
    @BeforeEach
    void setUp() {
        // Inicializa el Elfo y el Hobbit con valores de prueba
        elfo = new Elfo("Legolas", 100, 30);
        hobbit = new Hobbit("Frodo", 100, 50, 0);

        // Inicializa un Orco y un Trasgo como enemigos de prueba
        orco = new Orco("Orco", 100, 20);
        trasgo = new Trasgo("Trasgo", 100, 20);
    }

    /**
     * Test get armadura modificada.
     */
    @Test
    public void testGetArmaduraModificada() {
        // Crear un Orco con armadura específica
        Orco orco = new Orco("Orco1", 100, 50);

        // La armadura debería ser un 90% de la armadura original
        int armaduraModificadaEsperada = (int) (50 * 0.9);

        // Verificar que el valor modificado es correcto
        assertEquals(armaduraModificadaEsperada, orco.getArmaduraModificada(),
                "La armadura modificada debería ser un 90% de la armadura original.");
    }

    /**
     * Test crear bestia.
     */
    @Test
    public void testCrearBestia() {
        // Crear un Trasgo con valores específicos
        Trasgo trasgo = new Trasgo("Trasgo1", 80, 30);

        // Verificar que los valores han sido correctamente asignados
        assertEquals("Trasgo1", trasgo.getNombre(), "El nombre del Trasgo debería ser 'Trasgo1'.");
        assertEquals(80, trasgo.getVida(), "La vida del Trasgo debería ser 80.");
        assertEquals(30, trasgo.getArmadura(), "La armadura del Trasgo debería ser 30.");
        assertEquals("Trasgo", trasgo.getTipo(), "El tipo del Trasgo debería ser 'Trasgo'.");

        UrukHai urukhai = new UrukHai("UrukHai1", 100, 20);

        // Verificar que los valores han sido correctamente asignados
        assertEquals("UrukHai1", urukhai.getNombre(), "El nombre del UrukHai debería ser 'UrukHai1'.");
        assertEquals(100, urukhai.getVida(), "La vida del UrukHai debería ser 100.");
        assertEquals(20, urukhai.getArmadura(), "La armadura del UrukHai debería ser 20.");
        assertEquals("Uruk-Hai", urukhai.getTipo(), "El tipo del UrukHai debería ser 'Uruk-Hai'.");
    }

    /**
     * Test atacar modificado contra orco.
     */
    @Test
    void testAtacarModificado_ContraOrco() {
        int ataqueBaseFijo = 50; // Valor fijo para la prueba
        Elfo elfo = new Elfo("Elfo1", 100, 10, ataqueBaseFijo);
        Orco orco = new Orco("Orco1", 50, 50);

        // Calcula el ataque modificado
        int ataqueModificado = elfo.atacarModificado(orco);
        
        // Calcula el ataque esperado: ataque base más 10 contra un Orco
        int ataqueEsperado = ataqueBaseFijo + 10;
        
        // Verifica que el ataque modificado sea el esperado
        assertEquals(ataqueEsperado, ataqueModificado, "El ataque debería incrementarse en 10 contra un Orco.");
    }


    /**
     * Test atacar modificado contra trasgo.
     */
    @Test
    void testAtacarModificado_ContraTrasgo() {
        int ataqueBaseFijo = 50; // Valor fijo para la prueba
        Hobbit hobbit = new Hobbit("Hobbit1", 100, 10, ataqueBaseFijo);
        Trasgo trasgo = new Trasgo("Trasgo1", 50, 5);

        int ataqueModificado = hobbit.atacarModificado(trasgo);
        
        // Calcula el ataque esperado: ataque base menos 5 para Trasgo
        int ataqueModificadoEsperado = ataqueBaseFijo - 5;
        
        // Verifica que el ataque modificado sea el esperado
        assertEquals(ataqueModificadoEsperado, ataqueModificado, 
                     "El ataque contra Trasgo debería ser reducido en 5.");
    }



    /**
     * Test crear heroe.
     */
    @Test
    public void testCrearHeroe() {
        Enano enano = new Enano("Enano1", 100, 30);

        // Verificar que los valores han sido correctamente asignados
        assertEquals("Enano1", enano.getNombre(), "El nombre del Enano debería ser 'Enano1'.");
        assertEquals(100, enano.getVida(), "La vida del Enano debería ser 100.");
        assertEquals(30, enano.getArmadura(), "La armadura del Enano debería ser 30.");
        assertEquals("Enano", enano.getTipo(), "El tipo del Enano debería ser 'Enano'.");

        Humano humano = new Humano("Humano1", 80, 10);

        // Verificar que los valores han sido correctamente asignados
        assertEquals("Humano1", humano.getNombre(), "El nombre del Humano debería ser 'Humano1'.");
        assertEquals(80, humano.getVida(), "La vida del Humano debería ser 80.");
        assertEquals(10, humano.getArmadura(), "La armadura del Humano debería ser 10.");
        assertEquals("Humano", humano.getTipo(), "El tipo del Humano debería ser 'Humano'.");
    }
}

