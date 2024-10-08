package Batalla_Controlador;

import Heroes.Heroe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import Batalla_Modelo.Guerra;
import Bestias.Bestia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class GuerraController.
 */
public class GuerraController {
    
    /** The logo image view. */
    @FXML
    private ImageView logoImageView;
    
    /** The btn info. */
    @FXML
    private Button btnInfo;
    
    /** The armadura heroe. */
    @FXML
    private TextField nombreHeroe, vidaHeroe, armaduraHeroe;
    
    /** The tipo heroe. */
    @FXML
    private ChoiceBox<String> tipoHeroe;
    
    /** The eliminar heroe. */
    @FXML
    private Button anadirHeroe, subirHeroe, bajarHeroe, eliminarHeroe;
    
    /** The equipo heroes. */
    @FXML
    private ListView<String> equipoHeroes;

    /** The armadura bestia. */
    @FXML
    private TextField nombreBestia, vidaBestia, armaduraBestia;
    
    /** The tipo bestia. */
    @FXML
    private ChoiceBox<String> tipoBestia;
    
    /** The eliminar bestia. */
    @FXML
    private Button anadirBestia, subirBestia, bajarBestia, eliminarBestia;
    
    /** The equipo bestias. */
    @FXML
    private ListView<String> equipoBestias;

    /** The txt batalla. */
    @FXML
    private TextArea txtBatalla;
    
    /** The luchar. */
    @FXML
    private Button luchar;

    /** The heroes list. */
    private ObservableList<String> heroesList = FXCollections.observableArrayList();
    
    /** The bestias list. */
    private ObservableList<String> bestiasList = FXCollections.observableArrayList();
    
    /** The guerra. */
    private Guerra guerra = new Guerra(); // Inicializa la instancia de Guerra
    
    /** The icon. */
    private final Image icon = new Image(getClass().getResourceAsStream("/Image/logo.png"));
    
    /** The ventana informacion. */
    private Stage ventanaInformacion;
    
 /** The media player. */
 // Añadido para la música de fondo
    private MediaPlayer mediaPlayer;

    /**
     * Initialize.
     */
    @FXML
    private void initialize() {       
        // Inicializa los ChoiceBox con los tipos disponibles
        tipoHeroe.getItems().addAll("Humano", "Elfo", "Hobbit", "Enano");
        tipoBestia.getItems().addAll("Orco", "Trasgo", "Uruk-Hai");

        // Asignar las listas observables a los ListView
        equipoHeroes.setItems(heroesList);
        equipoBestias.setItems(bestiasList);
        
        txtBatalla.setEditable(false);
        txtBatalla.setWrapText(true); // Asegura que el texto se ajuste al área
        txtBatalla.setStyle("-fx-font-family: monospace;"); // Usa una fuente monoespaciada para mejor visibilidad

        // Asociar los métodos a los eventos de los botones
        anadirHeroe.setOnAction(e -> anadirHeroe());
        anadirBestia.setOnAction(e -> anadirBestia());
        subirHeroe.setOnAction(e -> subirHeroe());
        bajarHeroe.setOnAction(e -> bajarHeroe());
        eliminarHeroe.setOnAction(e -> eliminarHeroe());
        subirBestia.setOnAction(e -> subirBestia());
        bajarBestia.setOnAction(e -> bajarBestia());
        eliminarBestia.setOnAction(e -> eliminarBestia());
        luchar.setOnAction(e -> luchar());
        btnInfo.setOnAction(e -> mostrarInformacion());
       
    }
    
    /**
     * Mostrar informacion.
     */
    private void mostrarInformacion() {
        // Si la ventana de información ya está abierta, solo la enfocamos
        if (ventanaInformacion != null && ventanaInformacion.isShowing()) {
            ventanaInformacion.toFront();
            return;
        }

        // Crea una nueva ventana 
        ventanaInformacion = new Stage();
        ventanaInformacion.setTitle("Información");

        // Crea un TextArea para mostrar el texto
        TextArea textoInformacion = new TextArea();
        textoInformacion.setWrapText(true); // Ajustar el texto al área
        textoInformacion.setEditable(false); // Hacer que el TextArea sea solo de lectura
        textoInformacion.setPrefSize(400, 300); // Ajustar el tamaño del TextArea

        // Carga el texto desde el archivo en resources
        try (InputStream inputStream = getClass().getResourceAsStream("/informacion.txt");
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textoInformacion.setText(sb.toString());

        } catch (IOException e) {
            textoInformacion.setText("Error al cargar la información.");
            e.printStackTrace();
        }

        // Crea un StackPane y agrega el TextArea
        StackPane root = new StackPane(textoInformacion);
        
        // Crea la escena con el StackPane
        Scene scene = new Scene(root, 400, 300);

        // Configura la ventana
        ventanaInformacion.setScene(scene);
        ventanaInformacion.getIcons().add(new Image(getClass().getResourceAsStream("/Image/logo.png")));
        ventanaInformacion.setResizable(false); // La ventana no se pueda redimensionar
        ventanaInformacion.show();
    }

    /**
     * Validar Y añadir.
     *
     * @param tipo the tipo
     * @param nombre the nombre
     * @param vidaTexto the vida texto
     * @param armaduraTexto the armadura texto
     * @param esHeroe the es heroe
     * @return true, if successful
     */
    private boolean validarYAnadir(String tipo, String nombre, String vidaTexto, String armaduraTexto, boolean esHeroe) {
        // Verifica que se ha seleccionado un tipo
        if (tipo == null || tipo.isEmpty()) {
            mostrarAlerta(esHeroe ? "Tipo de Héroe Requerido" : "Tipo de Bestia Requerido",
                          esHeroe ? "Por favor, elija un tipo de héroe." : "Por favor, elija un tipo de bestia.");
            return false;
        }

        // Verifica que los campos vida y armadura sean numéricos y dentro del rango
        int vida;
        int armadura;

        try {
            vida = Integer.parseInt(vidaTexto);
            armadura = Integer.parseInt(armaduraTexto);

            if (vida < 1 || vida > 300) {
                mostrarAlerta("Vida Inválida", "La vida debe estar entre 1 y 300.");
                return false;
            }
            if (armadura < 0 || armadura > 50) {
                mostrarAlerta("Armadura Inválida", "La armadura debe estar entre 0 y 50.");
                return false;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Entrada Inválida", "Vida y armadura deben ser números válidos.");
            return false;
        }

        if (esHeroe) {
            Heroe heroe = new Heroe(nombre, vida, tipo, armadura);
            guerra.anadirHeroe(heroe);
            limpiarFormularioHeroe();
        } else {
            Bestia bestia = new Bestia(nombre, vida, tipo, armadura);
            guerra.anadirBestia(bestia);
            limpiarFormularioBestia();
        }
        actualizarListas();
        return true;
    }
    
    /**
     * Añadir heroe.
     */
    private void anadirHeroe() {
        String tipo = tipoHeroe.getValue();
        String nombre = nombreHeroe.getText();
        String vidaTexto = vidaHeroe.getText();
        String armaduraTexto = armaduraHeroe.getText();

        if (validarYAnadir(tipo, nombre, vidaTexto, armaduraTexto, true)) {
        	// Se añadio correctamente
        }
    }

    /**
     * Añadir bestia.
     */
    private void anadirBestia() {
        String tipo = tipoBestia.getValue();
        String nombre = nombreBestia.getText();
        String vidaTexto = vidaBestia.getText();
        String armaduraTexto = armaduraBestia.getText();

        if (validarYAnadir(tipo, nombre, vidaTexto, armaduraTexto, false)) {
            // Se añadio correctamente
        }
    }

    /**
     * Subir heroe.
     */
    private void subirHeroe() {
        int selectedIndex = equipoHeroes.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            guerra.subirHeroe(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Bajar heroe.
     */
    private void bajarHeroe() {
        int selectedIndex = equipoHeroes.getSelectionModel().getSelectedIndex();
        if (selectedIndex < heroesList.size() - 1) {
            guerra.bajarHeroe(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Eliminar heroe.
     */
    private void eliminarHeroe() {
        int selectedIndex = equipoHeroes.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            guerra.eliminarHeroe(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Subir bestia.
     */
    private void subirBestia() {
        int selectedIndex = equipoBestias.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 0) {
            guerra.subirBestia(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Bajar bestia.
     */
    private void bajarBestia() {
        int selectedIndex = equipoBestias.getSelectionModel().getSelectedIndex();
        if (selectedIndex < bestiasList.size() - 1) {
            guerra.bajarBestia(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Eliminar bestia.
     */
    private void eliminarBestia() {
        int selectedIndex = equipoBestias.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            guerra.eliminarBestia(selectedIndex);
            actualizarListas();
        }
    }

    /**
     * Luchar.
     */
    // Método para iniciar la batalla y mostrar el resultado en el TextArea
    private void luchar() {
    	
    	// Reproduce la música de fondo cuando comienza la batalla
        String path = getClass().getResource("/The_Lord_Of_The_Rings.mp3").toExternalForm();
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5); // Ajusta el volumen (0.0 a 1.0)
        mediaPlayer.play();
    	
        String resultadoBatalla = guerra.luchar();
        
        
        guerra.limpiarEquipos(); 
        heroesList.clear();
        bestiasList.clear();
        
        // Actualiza el texto de manera gradual y luego mostrar la imagen
        actualizarTextoGradualmente(resultadoBatalla, () -> {
        	
        mostrarImagen(resultadoBatalla);
        
        mediaPlayer.stop();
        });
    }

    /**
     * Actualizar texto gradualmente.
     *
     * @param resultadoBatalla the resultado batalla
     * @param onComplete the on complete
     */
    private void actualizarTextoGradualmente(String resultadoBatalla, Runnable onComplete) {
        txtBatalla.clear();
        
        Task<Void> tareaActualizarTexto = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Configuracion de la duracion entre caracteres
                int retrasoEntreCaracteres = 23; // en milisegundos
                
                // Agrega el texto caracter por caracter
                StringBuilder textoBuilder = new StringBuilder();
                for (char c : resultadoBatalla.toCharArray()) {
                    textoBuilder.append(c);
                    // Actualizar el contenido del TextArea en la interfaz gráfica
                    final String texto = textoBuilder.toString();
                    javafx.application.Platform.runLater(() -> {
                        txtBatalla.setText(texto);
                        txtBatalla.setScrollTop(Double.MAX_VALUE); // Mantener el TextArea al final
                    });
                    // Espera antes de agregar el siguiente carácter
                    Thread.sleep(retrasoEntreCaracteres);
                }
                
                // Ejecuta la acción de finalización después de que el texto se haya actualizado completamente
                javafx.application.Platform.runLater(onComplete);
                
                return null;
            }
        };
        
        Thread hiloTexto = new Thread(tareaActualizarTexto);
        hiloTexto.setDaemon(true); // Permite que el hilo termine cuando la aplicación termina
        hiloTexto.start();
    }

    /**
     * Mostrar imagen.
     *
     * @param resultadoBatalla the resultado batalla
     */
    private void mostrarImagen(String resultadoBatalla) {
        Image imagen;
        if (resultadoBatalla.contains("Victoria de las Bestias")) {
            imagen = new Image(getClass().getResourceAsStream("/Image/orcs.jpg"));
        } else if (resultadoBatalla.contains("Victoria de los Heroes")) {
            imagen = new Image(getClass().getResourceAsStream("/Image/heroes.jpg"));
        } else {
            imagen = new Image(getClass().getResourceAsStream("/Image/empate.jpeg"));
        }

        ImageView imageView = new ImageView(imagen);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 600, 400);
        
        Stage imageStage = new Stage();
        imageStage.setTitle("Resultado de la Batalla");
        imageStage.setScene(scene);
        imageStage.getIcons().add(icon);
        imageStage.setResizable(false);
        imageStage.show();
    }

    /**
     * Limpiar formulario heroe.
     */
    private void limpiarFormularioHeroe() {
        nombreHeroe.clear();
        vidaHeroe.clear();
        armaduraHeroe.clear();
        tipoHeroe.setValue(null);
    }

    /**
     * Limpiar formulario bestia.
     */
    private void limpiarFormularioBestia() {
        nombreBestia.clear();
        vidaBestia.clear();
        armaduraBestia.clear();
        tipoBestia.setValue(null);
    }

    /**
     * Actualizar listas.
     */
    private void actualizarListas() {
        heroesList.clear();
        bestiasList.clear();

        for (Heroe heroe : guerra.getHeroes()) {
            heroesList.add(heroe.toString());
        }

        for (Bestia bestia : guerra.getBestias()) {
            bestiasList.add(bestia.toString());
        }
    }
    
    /**
     * Mostrar alerta.
     *
     * @param titulo the titulo
     * @param mensaje the mensaje
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo); //Titulo
        alerta.setHeaderText(null); //Encabezado
        alerta.setContentText(mensaje); //Mensaje
        alerta.showAndWait(); // Muestra la alerta y espera a que el usuario la cierre
    }
}