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
    void deletePatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
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
    void insertPatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();

        Integer Report_ID = Integer.valueOf(RidText.getText());
        String date = RdateText.getValue().toString();
        Integer Test_ID = Integer.valueOf(TidText.getText());
        String result = TresultText.getText();

        Integer reportID = null;
        String reportIDText = RidText.getText();
        if (reportIDText != null && reportIDText.matches("\\d+")) {
            reportID = Integer.parseInt(reportIDText);
        } else {
            System.out.println("Invalid input for Report ID.");
        }

        String query = "INSERT INTO report (report_id, report_date, test_result, test_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query);
        statement.setInt(1, reportID);
        statement.setString(2, date);
        statement.setString(3, result);
        statement.setInt(4, Test_ID);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Report inserted successfully.");
        } else {
            System.out.println("Failed to insert Report.");
        }
    }


    @FXML
    void updatePatient(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();

        Integer Report_ID = Integer.valueOf(RidText.getText());
        String date = RdateText.getValue().toString();
        Integer Test_ID = Integer.valueOf(TidText.getText());
        String result = TresultText.getText();

        Integer reportID = null;
        String reportIDText = RidText.getText();
        if (reportIDText != null && reportIDText.matches("\\d+")) {
            reportID = Integer.parseInt(reportIDText);
        } else {
            System.out.println("Invalid input for Report ID.");
        }

        String query = "UPDATE report SET report_date=?, test_result=?, test_id=? WHERE report_id=?";
        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, result);
        statement.setInt(3, Test_ID);
        statement.setInt(4, reportID);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Report updated successfully.");
        } else {
            System.out.println("Failed to update Report.");
        }
    }}




