package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class EmplyeeController {
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
    private TextField eaddressText;

    @FXML
    private Label eadrdressLabel;

    @FXML
    private Label edobLabel;

    @FXML
    private TextField edobText;

    @FXML
    private Label eidLablel;

    @FXML
    private TextField eidText;

    @FXML
    private TableView<?> employeeTBL;

    @FXML
    private Label enameLabel;

    @FXML
    private TextField enameText;

    @FXML
    private Label enumberLabel;

    @FXML
    private TextField enumberText;

    @FXML
    private TableColumn<?, ?> idC;

    @FXML
    private TableColumn<?, ?> nameC;

    @FXML
    private TableColumn<?, ?> numberC;

    @FXML
    private Button updateBtn;



    @FXML
    void deleteEMP(ActionEvent event) {

    }



    @FXML
    void insertEMP(ActionEvent event) {

    }

    @FXML
    void updateEMP(ActionEvent event) {

    }

@FXML
    public void back(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",backBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
