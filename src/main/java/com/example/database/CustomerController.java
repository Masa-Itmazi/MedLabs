package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CustomerController {
    @FXML
    private Button reservationBtn;

    @FXML
    private Label reservationLabel;

    @FXML
    private Button resultBtn;

    @FXML
    private Label resultLabel;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button back2;

    @FXML
    void reservationClk(ActionEvent event) {

    }

    @FXML
    void resultClick(ActionEvent event) {

    }
    @FXML
    void backClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("hello-view.fxml", back2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}