package com.example.database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 828, 629);
        stage.setTitle("Welcome to MedLabs!");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e->{
            e.consume();
            logout(stage);
        });
    }
//
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch();
    }
    public static void changeScene(String fxml, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Parent newRoot = loader.load();
        Scene scene = button.getScene();
        scene.setRoot(newRoot);

    }
    public static void AlertShow(String text, String title, Alert.AlertType  type) {
        Alert alert = new Alert (type);
        alert.setContentText ( text );
        alert.setTitle ( title );
        alert.show ();
    }
    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("log out");
        alert.setHeaderText("You are about to logout");


        alert.setContentText("Are you sure you want to quit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("successfully logged out");
            stage.close();        }
    }
    public static void clearTextFields(TextField... fields) {
        for (TextField f : fields) {
            f.clear ();
        }
    }
    public static boolean isTextFieldEmpty(TextField... fields) {
        for (TextField f : fields) {
            if (f == null || f.getText ().isEmpty () || f.getText ().isBlank ()) {
                return true;
            }
        }
        return false;
    }
}
