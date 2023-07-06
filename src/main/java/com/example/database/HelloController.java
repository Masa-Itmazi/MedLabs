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
            HelloApplication.changeScene("Customer-view.fxml", customerBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void onStaffBtnClick(ActionEvent event) {
    //we will change the scene to the staff scene
        //we will get the current scene

//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("staff-view.fxml"));
//            Parent newRoot = loader.load();
//            Scene scene = staffBtn.getScene();
//            scene.setRoot(newRoot);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            HelloApplication.changeScene("login-view.fxml", staffBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}