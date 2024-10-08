package Batalla_Test;

import Batalla_Modelo.Guerra;
import Heroes.Heroe;
import Bestias.Bestia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Auto-generated Javadoc
/**
 * The Class GuerraTest.
 */
public class GuerraTest {

    /** The guerra. */
    private Guerra guerra;

    /**
     * Sets the up.
     */
    @BeforeEach
    void setUp() {
        guerra = new Guerra();
    }

    /**
     * Test añadir heroe.
     */
    @Test
    void testAnadirHeroe() {
        Heroe elfo = new Heroe("Elfo", 120, "Elfo", 15);
        guerra.anadirHeroe(elfo);
        assertTrue(guerra.getHeroes().contains(elfo), "El héroe Elfo debería ser añadido a la lista de héroes.");
    }

    /**
     * Test eliminar heroe.
     */
    @Test
    void testEliminarHeroe() {
        Heroe hobbit = new Heroe("Hobbit", 80, "Hobbit", 5);
        guerra.anadirHeroe(hobbit);
        guerra.eliminarHeroe(0);
        assertTrue(guerra.getHeroes().isEmpty(), "La lista de héroes debería estar vacía después de eliminar el Hobbit.");
    }

    /**
     * Test bajar heroe.
     */
    @Test
    void testBajarHeroe() {
        Heroe humano = new Heroe("Humano", 100, "Humano", 10);
        Heroe elfo = new Heroe("Elfo", 120, "Elfo", 15);
        guerra.anadirHeroe(humano);
        guerra.anadirHeroe(elfo);
        guerra.bajarHeroe(0);
        assertEquals(elfo, guerra.getHeroes().get(0), "El héroe Elfo debería haber sido movido hacia abajo en la lista.");
    }

    /**
     * Test añadir bestia.
     */
    @Test
    void testAnadirBestia() {
        Bestia orco = new Bestia("Orco", 150, "Orco", 20);
        guerra.anadirBestia(orco);
        assertTrue(guerra.getBestias().contains(orco), "La bestia Orco debería ser añadida a la lista de bestias.");
    }

    /**
     * Test eliminar bestia.
     */
    @Test
    void testEliminarBestia() {
        Bestia trasgo = new Bestia("Trasgo", 120, "Trasgo", 15);
        guerra.anadirBestia(trasgo);
        guerra.eliminarBestia(0);
        assertTrue(guerra.getBestias().isEmpty(), "La lista de bestias debería estar vacía después de eliminar el Trasgo.");
    }

    /**
     * Test subir bestia.
     */
    @Test
    void testSubirBestia() {
        Bestia orco = new Bestia("Orco", 150, "Orco", 20);
        Bestia trasgo = new Bestia("Trasgo", 120, "Trasgo", 15);
        guerra.anadirBestia(orco);
        guerra.anadirBestia(trasgo);
        guerra.subirBestia(1);
        assertEquals(orco, guerra.getBestias().get(1), "La bestia Trasgo debería haber sido movida hacia arriba en la lista.");
    }

    /**
     * Test bajar bestia.
     */
    @Test
    void testBajarBestia() {
        Bestia orco = new Bestia("Orco", 150, "Orco", 20);
        Bestia trasgo = new Bestia("Trasgo", 120, "Trasgo", 15);
        guerra.anadirBestia(orco);
        guerra.anadirBestia(trasgo);
        guerra.bajarBestia(0);
        assertEquals(trasgo, guerra.getBestias().get(0), "La bestia Trasgo debería haber sido movida hacia abajo en la lista.");
    }

    /**
     * Test luchar.
     */
    @Test
    void testLuchar() {
        Heroe elfo = new Heroe("Elfo", 120, "Elfo", 15);
        Bestia urukhai = new Bestia("Urukhai", 180, "Urukhai", 25);
        guerra.anadirHeroe(elfo);
        guerra.anadirBestia(urukhai);

        String resultado = guerra.luchar();
        assertTrue(resultado.contains("Turno"), "El resultado de la lucha debería contener información sobre los turnos.");
        assertTrue(resultado.contains("Victoria de los Heroes") || resultado.contains("Victoria de las Bestias") || resultado.contains("Es un empate"), "El resultado de la lucha debería indicar el resultado de la batalla.");
    }
}

