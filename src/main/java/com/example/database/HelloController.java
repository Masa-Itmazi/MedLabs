package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button customerBtn;

    @FXML
    private Button staffBtn;

    @FXML
    void onCustomerBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("customer-view.fxml", customerBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onStaffBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("login-view.fxml", staffBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}