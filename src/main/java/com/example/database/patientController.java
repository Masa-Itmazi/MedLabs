package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class patientController {
    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> addressC;

    @FXML
    private Button backBtn1;

    @FXML
    private Button clearBtn1;

    @FXML
    private Button deleteBtn;

    @FXML Button reloadBtn;

    @FXML
    private TableColumn<?, ?> dotC;

    @FXML
    private Label eLabel;

    @FXML
    private TableColumn<?, ?> emailC;

    @FXML
    private TableColumn<?, ?> genderC;

    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private TableColumn<?, ?> nameC;

    @FXML
    private TableColumn<?, ?> numberC;

    @FXML
    private TextField paddressText;

    @FXML
    private Label padrdressLabel;

    @FXML
    private TableView<?> patientTBL;

    @FXML
    private Label pdobLabel;

    @FXML
    private TextField pdobText;

    @FXML
    private Label pemailLabel;

    @FXML
    private TextField pemailText;

    @FXML
    private Label pgenderLabel;

    @FXML
    private TextField pgenderText;

    @FXML
    private Label pidLablel;

    @FXML
    private TextField pidText;

    @FXML
    private Label pnameLabel;

    @FXML
    private TextField pnameText;

    @FXML
    private Label pnumberLabel;

    @FXML
    private TextField pnumberText;

    @FXML
    private Button updateBtn;

    @FXML
    void backClk1(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",backBtn1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void clearClk1(ActionEvent event) {

    }
    @FXML
    void reloadClk(ActionEvent event) {

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