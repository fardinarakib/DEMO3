package ca.ucalgary.syeda.rakib.demo3gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 520);

        // Load the CSS file
        scene.getStylesheets().add(getClass().getResource("art.css").toExternalForm());

        // Set the stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
