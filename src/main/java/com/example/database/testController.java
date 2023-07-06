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
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        void insertPatient(ActionEvent event)throws SQLException, ClassNotFoundException, IOException {
                DBConnector connector1 = new DBConnector();
                connector1.myConnection.connectDB();
                String ID = TIDText.getText();
                String date = TdateText.getValue().toString();
                String name = TnameText.getText();
                String EID = Eid.getText();
                String test_type_ID = TtypeID.getText();

                String query1 = "INSERT into test (test_id,test_date,test_name,equipment_id,test_type_id) VALUES(?,?,?,?,?)";
                //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);

                PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
                statement.setString(1, ID);
                statement.setString(2, date);
                statement.setString(3, name);
                statement.setString(4, EID);
                statement.setString(5, test_type_ID);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                        System.out.println("Testt inserted successfully.");
                } else {
                        System.out.println("Failed to insert Test.");
                }
                statement.close();
        }

        @FXML


        void updatePatient(ActionEvent event)throws SQLException, ClassNotFoundException, IOException {
                DBConnector connector1 = new DBConnector();
                connector1.myConnection.connectDB();
                String ID = TIDText.getText();
                String date = TdateText.getValue().toString();
                String name = TnameText.getText();
                String EID = Eid.getText();
                String test_type_ID = TtypeID.getText();

                String query1 = "UPDATE test SET test_date=?,test_name=?,equipment_id=?,test_type_id=? WHERE test_id=?";

                PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
                statement.setString(1, date);
                statement.setString(2, name);
                statement.setString(3, EID);
                statement.setString(4, test_type_ID);
                statement.setInt(5, Integer.parseInt(ID));

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                        System.out.println("Test updated successfully.");
                } else {
                        System.out.println("No matching Test found.");
                }
                statement.close();
        }
}

