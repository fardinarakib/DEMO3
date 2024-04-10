package ca.ucalgary.syeda.rakib.demo3gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.util.ArrayList;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


public class helloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField studentNameField, studentMajorField, studentYearField; // Add fields as per your requirements
    @FXML
    private Button addButton, viewAllButton; // Buttons for adding and viewing data
    @FXML
    private ListView<String> studentListView; // To display the list of students or other data


    private Data data = new Data();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onAddButtonClick() {
        // Read data from text fields
        String name = studentNameField.getText();
        String major = studentMajorField.getText();
        String year = studentYearField.getText();


        data.addStudent(name, major, year);

        studentNameField.clear();
        studentMajorField.clear();
        studentYearField.clear();

        welcomeText.setText("Student added successfully!");
    }

    @FXML
    protected void onViewAllButtonClick() {


        ArrayList<String> allStudents = data.getAllStudentsAsStringList();


        studentListView.getItems().clear();
        for (String student : allStudents) {
            studentListView.getItems().add(student);
        }
    }

    @FXML
    public void initialize() {

    }}}
