package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class staffController {
    @FXML
    private Button backBtn1;

    @FXML
    private Label empLabel;

    @FXML
    private Button employeeBtn;

    @FXML
    private Label eqLabel;
    @FXML
    private Label patientLabel;
    @FXML
    private Button patientBtn;

    @FXML
    private Button equipmentBtn;

    @FXML
    private Button reportBtn;

    @FXML
    private Label reportLabel;

    @FXML
    private Button testBtn;

    @FXML
    private Label testLabel;

    @FXML
    void onBackBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("hello-view.fxml", backBtn1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onEmpBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("Employee-view.fxml", employeeBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void onEquipmentBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("equipment-view.fxml", equipmentBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML
    void onPatientBtnClk(ActionEvent event) {
        try {
            HelloApplication.changeScene("patient.fxml", patientBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void onReportBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("report-view.fxml", patientBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onTestBtnClick(ActionEvent event) {
        try {
            HelloApplication.changeScene("test-view.fxml", patientBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
