package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class testController {



        @FXML
        private TableColumn<?, ?> Eid;

        @FXML
        private Label EidLabel;

        @FXML
        private TextField RidText;

        @FXML
        private TableColumn<?, ?> TdateC;

        @FXML
        private Label TdateLabel;

        @FXML
        private TableView<?> TestTBL;

        @FXML
        private TableColumn<?, ?> TidC;

        @FXML
        private Label TidLablel;

        @FXML
        private TextField TidText;

        @FXML
        private TableColumn<?, ?> TnameC;

        @FXML
        private Label TnameLabel;

        @FXML
        private TextField TresultText;

        @FXML
        private Label TtypeID;

        @FXML
        private Button addBtn;

        @FXML
        private Button back3;

        @FXML
        private Button clearBtn;

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
