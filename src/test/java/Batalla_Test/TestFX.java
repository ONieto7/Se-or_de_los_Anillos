package Batalla_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import Batalla_Vista.GuerraVista;

// TODO: Auto-generated Javadoc
/**
 * The Class TestFX.
 */
public class TestFX extends ApplicationTest {

    /** The app. */
    private GuerraVista app;

    /**
     * Start.
     *
     * @param stage the stage
     * @throws Exception the exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        app = new GuerraVista();
        app.start(stage);
    }

    /**
     * Test FXML loader.
     *
     * @throws Exception the exception
     */
    @Test
    void testFXMLLoader() throws Exception {
        // Verifica que el archivo FXML se carga correctamente
        Scene scene = app.getScene(); // Necesitarás un getter en GuerraVista para obtener la escena
        assertNotNull(scene.getRoot(), "El archivo FXML debería cargarse correctamente y no ser null.");
    }

    /**
     * Test icono carga.
     */
    @Test
    void testIconoCarga() {
        // Verifica que la imagen del icono se carga correctamente
        Image icon = new Image(GuerraVista.class.getResourceAsStream("/Image/logo.png"));
        assertNotNull(icon, "El icono debería cargarse correctamente desde el recurso.");
    }

    /** The Constant TOLERANCE. */
    private static final double TOLERANCE = 1; // Tolerancia permitida en las dimensiones de la escena

    /**
     * Test scene setup.
     */
    @Test
    void testSceneSetup() {
        Scene scene = app.getScene(); // Necesitarás un getter en GuerraVista para obtener la escena
        assertEquals(600, scene.getWidth(), TOLERANCE, "El ancho de la escena debería ser 600.");
        assertEquals(705, scene.getHeight(), TOLERANCE, "La altura de la escena debería ser 705.");
    }

    /**
     * Test ventana visible.
     */
    @Test
    void testVentanaVisible() {
        // Verifica que la ventana principal se muestra y no es redimensionable
        Stage primaryStage = (Stage) app.getScene().getWindow(); // Necesitarás un getter en GuerraVista para la escena
        assertNotNull(primaryStage, "La ventana principal debería existir.");
        assertEquals("Batalla en la Tierra Media", primaryStage.getTitle(), "El título de la ventana debería ser 'Batalla en la Tierra Media'.");
        assertEquals(false, primaryStage.isResizable(), "La ventana no debería ser redimensionable.");
    }
}
