package ca.ucalgary.syeda.rakib.demo3gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class MainController {

    @FXML private MenuItem itemLoad;
    @FXML private MenuItem itemSave;
    @FXML private MenuItem itemQuit;

    @FXML private Button nameField;
    @FXML private Button yearField;
    @FXML private Button majorField;
    @FXML private Button idField;
    @FXML private Button ageField;
    @FXML private Button daysField;
    @FXML private Button amountField;
    @FXML private Button assignmentField;
    @FXML private Button printNameField;

    @FXML private ListView<String> studentListView;


    @FXML
    private void handleAddStudent(ActionEvent event) {
        showInputDialog("New Student", "Enter New Student Details", "Name:").ifPresent(
                name -> studentListView.getItems().add("Name: " + name));
    }
//adds name
    @FXML
    private void addYear(ActionEvent event) {
        showInputDialog("Year of Study", "Enter Current Year of Study", "Year:").ifPresent(
                year -> studentListView.getItems().add("Year: " + year));
    }
//adds year
    @FXML
    private void addMajor(ActionEvent event) {
        showInputDialog("Major", "Enter Major", "Major:").ifPresent(
                major -> studentListView.getItems().add("Major: " + major));
    }
//adds major
    @FXML
    private void addUcid(ActionEvent event) {
        showInputDialog("UCID", "Enter UCID", "UCID:").ifPresent(
                ucid -> studentListView.getItems().add("UCID: " + ucid));
    }
//adds id
    @FXML
    private void addAge(ActionEvent event) {
        showInputDialog("Age", "Enter Age", "Age:").ifPresent(
                age -> studentListView.getItems().add("Age: " + age));
    }
//adds age
    @FXML
    private void addDays(ActionEvent event) {
        showInputDialog("Personal Days Used", "Enter the Amount of Personal Days Used", "Days:").ifPresent(
                days -> studentListView.getItems().add("Days Used: " + days));
    }
//adds days
    @FXML
    private void addHours(ActionEvent event) {
        showInputDialog("Study Hours", "Enter the Amount of Hours Studied in One Week", "Hours:").ifPresent(
                hours -> studentListView.getItems().add("Study Hours: " + hours));
    }
//adds hour
    @FXML
    private void addAmount(ActionEvent event) {
        showInputDialog("Assignments Done", "Enter the Amount of Assignments Done", "Assignments:").ifPresent(
                assignments -> studentListView.getItems().add("Assignments: " + assignments));
    }
//amount of days studied
    @FXML
    private void printNames(ActionEvent event) {
        System.out.println("Printing all student names:");
        studentListView.getItems().forEach(System.out::println);
    }
//prints all info
    @FXML
    private void handleItemLoad(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file.toURI()));
                studentListView.getItems().setAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void itemSave(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("students.csv");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String name : studentListView.getItems()) {
                    writer.write(name + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void itemQuit(ActionEvent event) {
        System.exit(0);
    }

    private Optional<String> showInputDialog(String title, String header, String content) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(content);
        return dialog.showAndWait();
    }
}
//minor bug fixes from chatgpt
//minor concept reviews from youtube
//subtle changes in knowledge to stackoverflow.com
//minor solution for the inital errors from reddit