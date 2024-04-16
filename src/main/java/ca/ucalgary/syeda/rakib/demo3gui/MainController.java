package ca.ucalgary.syeda.rakib.demo3gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class MainController {

    public Button UpdateStudentDetails;
    public Button SaveToCSV;
    public Button LoadFromCSV;
    public Button printSortedStudentsButton;
    public Button predictNextYearStudyHoursButton;
    public Button printStudentsNeedingAttentionButton;
    public Button printAverageAgeButton;
    public Button printNamesButton;
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


    @FXML
    public void printAverageAge(ActionEvent event) {

        double averageAge = Data.calculateAverageAge();
        studentListView.getItems().add("Average Age: " + averageAge);
    }
    @FXML
    public void printStudentsNeedingAttention(ActionEvent event) {
        List<String> students = Data.getStudentsNeedingAttention();
        students.forEach(student -> studentListView.getItems().add(student));
    }

    @FXML
    public void predictNextYearStudyHours(ActionEvent event) {
        List<String> predictions = Data.predictNextYearStudyHours();
        predictions.forEach(prediction -> studentListView.getItems().add(prediction));
    }

    @FXML
    public void printSortedStudents(ActionEvent event) {
        List<String> sorted = Data.printSortedStudents();
        sorted.forEach(student -> studentListView.getItems().add(student));
    }

    // Utility method to show input dialog
    private Optional<String> showInputDialog(String title, String header, String content) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(content);
        return dialog.showAndWait();
    }

    @FXML
    public void handleUpdateStudentDetails(ActionEvent actionEvent) {

        Optional<String> idInput = showInputDialog("Update Student", "Enter Student ID", "ID:");
        idInput.ifPresent(id -> {
            try {
                int studentId = Integer.parseInt(id);
                Object[] studentData = Data.getStudent(studentId);
                if (studentData != null) {
                    Optional<String> newAge = showInputDialog("Update Student", "Enter New Age", "Age:");
                    newAge.ifPresent(age -> {
                        int ageValue = Integer.parseInt(age);
                        Data.enterAge(studentId, ageValue);
                        studentListView.getItems().add("Updated Age for ID " + id + ": " + age);
                    });
                } else {
                    studentListView.getItems().add("Student ID " + id + " not found.");
                }
            } catch (NumberFormatException e) {
                studentListView.getItems().add("Invalid ID entered.");
            }
        });
    }
    @FXML
    public void handleSaveToCSV(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("students.csv");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            Data.saveToCSV(file.getAbsolutePath());
            studentListView.getItems().add("Data saved to " + file.getAbsolutePath());
        }
    }

    @FXML
    public void handleLoadFromCSV(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Data.loadFromCSV(file.getAbsolutePath());
            studentListView.getItems().add("Data loaded from " + file.getAbsolutePath());
        }
    }


        @FXML
        private void showAboutDialog(ActionEvent event) {
            // Load the About dialog FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aboutDialog.fxml"));
            Parent root;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("About");
            stage.show();
        }
    }

//minor bug fixes from chatgpt
//minor concept reviews from youtube
//subtle changes in knowledge to stackoverflow.com
//minor solution for the inital errors from reddit