package titify.ajgarcia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage rootstage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("pantalla_login"), 1280, 720);
        stage.getIcons().add(new Image("https://favicon-generator.org/favicon-generator/htdocs/favicons/2021-10-29/30189ed65c392e1be4e1c674cd02ad72.ico.png"));
        stage.setTitle("TitiFy");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}