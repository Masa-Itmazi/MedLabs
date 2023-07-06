package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    void deleteEMP(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String eid = eidText.getText();

        String query = "DELETE FROM employee WHERE eid=" +eid;

        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query);

        if (rowsAffected > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("No matching employee found.");
        }
    }

    @FXML
    void insertEMP(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String eid = eidText.getText();
        String employee_name = enameText.getText();
        String employee_address = eaddressText.getText();
        String employee_dob = edobText.getText();
        String employee_number = enumberText.getText();

        String query1 = "INSERT into Employee(eid,employee_name,employee_dob, employee_address,employee_number) VALUES(?,?,?,?,?)" ;
        //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);

        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, eid);
        statement.setString(2, employee_name);
        statement.setString(3, employee_dob);
        statement.setString(4, employee_address);
        statement.setString(5, employee_number);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Failed to insert employee.");
        }

        statement.close();
    }

    @FXML
    void updateEMP(ActionEvent event)throws ClassNotFoundException, SQLException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String eid = eidText.getText();

        String query1 = "Update employee Set employee_name='Mohammad' WHERE eid= "+eid ;
        //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);

        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query1);

        if (rowsAffected > 0) {
            System.out.println("Employee name updated successfully.");
        } else {
            System.out.println("No matching employee found.");
        }

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
