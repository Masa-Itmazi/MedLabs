package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class reportController {
    @FXML
    private DatePicker RdateText;
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
    void deletePatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String rid = RidText.getText();

        String query = "DELETE FROM report WHERE report_id=" + rid;

        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query);

        if (rowsAffected > 0) {
            System.out.println("Report deleted successfully.");
        } else {
            System.out.println("No matching Report  found.");
        }
    }

    @FXML
    void insertPatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String Report_ID = RidText.getText();
        LocalDate date = RdateText.getValue();
        String Test_ID = TidText.getText();
        String result = TresultText.getText();


        String query1 = "INSERT into report (report_id,report_date,test_result,test_id) VALUES(?,?,?,?)";


        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, Report_ID);
        statement.setString(2, String.valueOf(date));
        statement.setString(3,Test_ID);
        statement.setString(4, result);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Report inserted successfully.");
        } else {
            System.out.println("Failed to insert Report.");
        }

        statement.close();
    }

    @FXML
    void updatePatient(ActionEvent event)throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String Report_ID = RidText.getText();
        String date = RdateText.getValue().toString();
        String Test_ID = TidText.getText();
        String result = TresultText.getText();

        String query1 = "UPDATE report SET report_id=?,report_datem=?,test_result=?,test_id=? WHERE equipment_id=?";

        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, Report_ID);
        statement.setString(2, date);
        statement.setString(3,Test_ID);
        statement.setString(4, result);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Report updated successfully.");
        } else {
            System.out.println("No matching Report found.");
        }
        statement.close();
    }

}


