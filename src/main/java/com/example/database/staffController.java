package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    }

    @FXML
    void onEquipmentBtnClick(ActionEvent event) {

    }

    @FXML
    void onReportBtnClick(ActionEvent event) {

    }

    @FXML
    void onTestBtnClick(ActionEvent event) {

    }

}
