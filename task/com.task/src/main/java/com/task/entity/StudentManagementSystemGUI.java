package com.task.entity;

import javax.swing.text.html.ListView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentManagementSystemGUI extends Application {
      
	private ListView<String> studentListView;
    private TextField nameField;
    private TextField rollNumberField;
    private TextField gradeField;
    private StudentManagementSystem sms;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        sms = new StudentManagementSystem();

        // Create UI components
        BorderPane root = new BorderPane();

        studentListView = new ListView<>();
        updateStudentListView();

        VBox inputFields = new VBox(10);
        inputFields.setPrefWidth(200);

        nameField = new TextField();
        nameField.setPromptText("Name");
        rollNumberField = new TextField();
        rollNumberField.setPromptText("Roll Number");
        gradeField = new TextField();
        gradeField.setPromptText("Grade");

        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> addStudent());
        Button removeButton = new Button("Remove Student");
        removeButton.setOnAction(e -> removeStudent());
        Button searchButton = new Button("Search Student");
        searchButton.setOnAction(e -> searchStudent());

        inputFields.getChildren().addAll(nameField, rollNumberField, gradeField, addButton, removeButton, searchButton);

        root.setLeft(studentListView);
        root.setCenter(inputFields);

        // Create the scene and stage
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Student Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addStudent() {
        String name = nameField.getText();
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        char grade = gradeField.getText().charAt(0);

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
        updateStudentListView();
        clearInputFields();
    }

    private void removeStudent() {
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        sms.removeStudent(rollNumber);
        updateStudentListView();
        clearInputFields();
    }

    private void searchStudent() {
        int rollNumber = Integer.parseInt(rollNumberField.getText());
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Result");
            alert.setHeaderText(null);
            alert.setContentText("Student found:\n" + student.toString());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search Result");
            alert.setHeaderText(null);
            alert.setContentText("Student not found.");
            alert.showAndWait();
        }
    }

    private void updateStudentListView() {
        studentListView.getItems().clear();
        for (student student : sms.getAllStudents()) {
            studentListView.getItems().add(student.toString());
        }
    }

    private void clearInputFields() {
        nameField.clear();
        rollNumberField.clear();
        gradeField.clear();
    }
	
	
}
