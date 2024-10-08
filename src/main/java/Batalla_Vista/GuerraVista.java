package Batalla_Vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class GuerraVista.
 */
public class GuerraVista extends Application {

    /** The scene. */
    private Scene scene;

    /**
     * Start.
     *
     * @param primaryStage the primary stage
     * @throws Exception the exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga el archivo FXML para definir la interfaz de usuario
        Parent root = FXMLLoader.load(getClass().getResource("/Proyecto.fxml"));

        // Crea una escena con el root cargado del archivo FXML
        scene = new Scene(root, 600, 705); 
        
        //Configura el icono de la ventana principal
        Image icon = new Image(getClass().getResourceAsStream("/Image/logo.png"));
        primaryStage.getIcons().add(icon);
        
        // Carga el archivo CSS
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        
        // Configura el escenario
        primaryStage.setTitle("Batalla en la Tierra Media");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);// Desactiva la posibilidad de redimensionar la ventana
        primaryStage.show();
    }

    /**
     * Gets the scene.
     *
     * @return the scene
     */
    // Método getter para acceder a la escena desde las pruebas
    public Scene getScene() {
        return scene;
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        // Lanza la aplicación JavaFX
        launch(args);
    }
}
