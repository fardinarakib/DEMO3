package ca.ucalgary.syeda.rakib.demo3gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Loads the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 700);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("path/to/aboutDialog.fxml"));

        // Loads the CSS file
        scene.getStylesheets().add(getClass().getResource("art.css").toExternalForm());

        // Sets the stage
        stage.setTitle("STUDENT MANAGEMENT INFORMATION!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
