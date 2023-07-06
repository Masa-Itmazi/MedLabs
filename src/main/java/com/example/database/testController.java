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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class testController {




        @FXML
        private TableColumn<?, ?> Eid;

        @FXML
        private Label EidLabel;

        @FXML
        private TextField EidText;

        @FXML
        private TextField TIDText;

        @FXML
        private TableColumn<?, ?> TdateC;

        @FXML
        private Label TdateLabel;

        @FXML
        private DatePicker TdateText;

        @FXML
        private TableView<?> TestTBL;

        @FXML
        private TableColumn<?, ?> TidC;

        @FXML
        private Label TidLablel;

        @FXML
        private TableColumn<?, ?> TnameC;

        @FXML
        private Label TnameLabel;

        @FXML
        private TextField TnameText;

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

                void deletePatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
                        DBConnector connector1 = new DBConnector();
                        connector1.myConnection.connectDB();
                        String tid = TIDText.getText();

                        String query = "DELETE FROM test WHERE test_id=" +tid;

                        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query);

                        if (rowsAffected > 0) {
                                System.out.println("Test deleted successfully.");
                        } else {
                                System.out.println("No matching Test  found.");
                        }

                }



        @FXML
        void updatePatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
                DBConnector connector1 = new DBConnector();
                connector1.myConnection.connectDB();

                Integer ID = Integer.valueOf(TIDText.getText());
                String date = TdateText.getValue().toString();
                String name = TnameText.getText();

                Integer EID = null;
                String eidText = Eid.getText();
                if (eidText != null && eidText.matches("\\d+")) {
                        EID = Integer.parseInt(eidText);
                } else {
                        System.out.println("Invalid input for Equipment ID.");
                }

                Integer test_type_ID = null;
                String testTypeIDText = TtypeID.getText();
                if (testTypeIDText != null && testTypeIDText.matches("\\d+")) {
                        test_type_ID = Integer.parseInt(testTypeIDText);
                } else {
                        System.out.println("Invalid input for Test Type ID.");
                }

                String query1 = "UPDATE test SET test_date=?, test_name=?, equipment_id=?, test_type_id=? WHERE test_id=?";

                PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
                statement.setString(1, date);
                statement.setString(2, name);
                statement.setObject(3, EID);
                statement.setObject(4, test_type_ID);
                statement.setInt(5, ID);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                        System.out.println("Test updated successfully.");
                } else {
                        System.out.println("No matching Test found.");
                }

        }

        @FXML
        void insertPatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
                DBConnector connector1 = new DBConnector();
                connector1.myConnection.connectDB();

                Integer ID = Integer.valueOf(TIDText.getText());
                String date = TdateText.getValue().toString();
                String name = TnameText.getText();

                Integer EID = null;
                String eidText = Eid.getText();
                if (eidText != null && eidText.matches("\\d+")) {
                        EID = Integer.parseInt(eidText);
                } else {
                        System.out.println("Invalid input for Equipment ID.");
                }

                Integer test_type_ID = null;
                String testTypeIDText = TtypeID.getText();
                if (testTypeIDText != null && testTypeIDText.matches("\\d+")) {
                        test_type_ID = Integer.parseInt(testTypeIDText);
                } else {
                        System.out.println("Invalid input for Test Type ID.");
                }

                String query1 = "INSERT INTO test (test_id, test_date, test_name, equipment_id, test_type_id) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
                statement.setInt(1, ID);
                statement.setString(2, date);
                statement.setString(3, name);
                statement.setObject(4, EID);
                statement.setObject(5, test_type_ID);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                        System.out.println("Test inserted successfully.");
                } else {
                        System.out.println("Failed to insert Test.");
                }

                statement.close();
        }






}

