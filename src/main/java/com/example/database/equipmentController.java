package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class equipmentController {

    @FXML
    private Label EQdopLabel;

    @FXML
    private Label EQidLablel;

    @FXML
    private Label EQnameLabel;

    @FXML
    private Label EqmodelLabel;

    @FXML
    private Label EqpriceLabel;

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> addressC;

    @FXML
    private Button backBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<?, ?> dotC;

    @FXML
    private Label eLabel;

    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private TableColumn<?, ?> nameC;

    @FXML
    private TableColumn<?, ?> numberC;

    @FXML
    private TextField paddressText;

    @FXML
    private TableView<?> patientTBL;

    @FXML
    private TextField pdobText;

    @FXML
    private TextField pidText;

    @FXML
    private TextField pnameText;

    @FXML
    private TextField pnumberText;

    @FXML
    private Button updateBtn;

    @FXML
    void backClk(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",backBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void clearClk(ActionEvent event) {

    }

    @FXML
    void deleteEquipment(ActionEvent event) {

    }

    @FXML
    void insertEquipment(ActionEvent event) {

    }

    @FXML
    void updateEquipment(ActionEvent event) {

    }
}