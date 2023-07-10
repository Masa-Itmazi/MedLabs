package com.example.database;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URI;
import java.sql.*;
import java.util.ResourceBundle;

public class reservationController {
ObservableList<String> str= FXCollections.observableArrayList(  "Blood Test", "CT Scan", "Mammogram", "Echocardiogram", "Pulmonary Function Test", "Colonoscopy");
                private TextField reservationDateTf;

                @FXML
                private TextField reservationTimeTf;

                @FXML
                private ChoiceBox<String> testTypeChoiceBox;

                @FXML
                private Button backBT;

                @FXML
                private Button clearBT;

                // Add your code here for event handling, initialization, etc.



        @FXML
        private void initialize() {
            // Initialization code if needed

                testTypeChoiceBox.setItems(str);
        }

        @FXML
        private void handleBackButtonAction() {
            // Handle back button action
        }

        @FXML
        private void handleClearButtonAction() {
            // Handle clear button action
                reservationDateTf.clear();
                reservationTimeTf.clear();
                testTypeChoiceBox.getSelectionModel().clearSelection();
        }
    }

