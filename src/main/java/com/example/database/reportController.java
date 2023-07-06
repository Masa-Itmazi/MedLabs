package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class reportController {

    @FXML
    private TableColumn<?, ?> RdateC;

    @FXML
    private Label RdateLabel;

    @FXML
    private TableView<?> ReportTBL;

    @FXML
    private TableColumn<?, ?> RidC;

    @FXML
    private Label RidLablel;

    @FXML
    private TextField RidText;

    @FXML
    private TableColumn<?, ?> TidC;

    @FXML
    private Label TidLabel;

    @FXML
    private TextField TidText;

    @FXML
    private TableColumn<?, ?> TresultC;

    @FXML
    private Label TresultLabel;

    @FXML
    private TextField TresultText;

    @FXML
    private Button addBtn;

    @FXML
    private Button back3;

    @FXML
    private Button deleteBtn;

    @FXML
    private Label eLabel;

    @FXML
    private Button updateBtn;

    @FXML
    void backClk(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml", back3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void clearClk(ActionEvent event) {

    }

    @FXML
    void deletePatient(ActionEvent event) {

    }

    @FXML
    void insertPatient(ActionEvent event) {

    }

    @FXML
    void updatePatient(ActionEvent event) {

    }

}
