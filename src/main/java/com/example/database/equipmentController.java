package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    void deleteEquipment(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String pid = pidText.getText();

        String query = "DELETE FROM employee WHERE eid=" + pid;

        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query);

        if (rowsAffected > 0) {
            System.out.println("Equipment deleted successfully.");
        } else {
            System.out.println("No matching Equipment  found.");
        }
    }





    @FXML
    void insertEquipment(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String ID = pidText.getText();
        String date_of_purchase = pnameText.getText();
        String Equipment_name = paddressText.getText();
        String model = pdobText.getText();
        String price = pnumberText.getText();

        String query1 = "INSERT into equipment (equipment_id,date_of_purchase,Equipment_name, model,price) VALUES(?,?,?,?,?)";
        //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);

        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, ID);
        statement.setString(2, date_of_purchase);
        statement.setString(3, Equipment_name);
        statement.setString(4, model);
        statement.setString(5, price);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Failed to insert employee.");
        }

        statement.close();
    }

    @FXML
    void updateEquipment(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String ID = pidText.getText();
        String date_of_purchase = pnameText.getText();
        String Equipment_name = paddressText.getText();
        String model = pdobText.getText();
        String price = pnumberText.getText();

        String query1 = "UPDATE equipment SET date_of_purchase=?, equipment_name=?, model=?, price=? WHERE equipment_id=?";

        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, date_of_purchase);
        statement.setString(2, Equipment_name);
        statement.setString(3, model);
        statement.setString(4, price);
        statement.setInt(5, Integer.parseInt(ID));

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Equipment updated successfully.");
        } else {
            System.out.println("No matching equipment found.");
        }
        statement.close();
    }
}