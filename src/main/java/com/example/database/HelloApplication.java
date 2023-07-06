package com.example.database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("staff-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 828, 629);
        stage.setTitle("Welcome to MedLabs!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConnector db = new DBConnector();
        db.myConnection.connectDB();
        Statement statement = db.myConnection.connectDB().createStatement();

        launch();
    }
    public static void changeScene(String fxml, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Parent newRoot = loader.load();
        Scene scene = button.getScene();
        scene.setRoot(newRoot);
    }
}