package com.example.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController {
    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<Employee, String> addressC;

    @FXML
    private Button backBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TableColumn<Employee, Date> dotC;

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
    private TableView<Employee> employeeTBL;

    @FXML
    private Label enameLabel;

    @FXML
    private TextField enameText;

    @FXML
    private Label enumberLabel;

    @FXML
    private TextField enumberText;

    @FXML
    private TableColumn<Employee, Integer> idC;

    @FXML
    private TableColumn<Employee, String> nameC;

    @FXML
    private TableColumn<Employee, String> numberC;

    @FXML
    private Button updateBtn;



    @FXML
    void deleteEMP(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector1 = new DBConnector();
        connector1.myConnection.connectDB();
        String eid = eidText.getText();
        if(!isValidID(eid)){
            HelloApplication.AlertShow("Invalid ID", "Please enter a valid ID", Alert.AlertType.ERROR);
            return;
        }
        if(!employeeExists(eid)){
            HelloApplication.AlertShow("User Doesn't exist", "User Doesn't exist", Alert.AlertType.ERROR);
            return;
        }
        String query = "DELETE FROM employee WHERE eid=" +eid;

        int rowsAffected = connector1.myConnection.connectDB().createStatement().executeUpdate(query);

        if (rowsAffected > 0) {
            //we will make an alert to show that the employee was deleted successfully
            HelloApplication.AlertShow("Success", "Employee deleted successfully", Alert.AlertType.INFORMATION);
            HelloApplication.clearTextFields(eidText, enameText, eaddressText, edobText, enumberText);
        } else {
//we will make an alert to show that the employee was not deleted successfully
            HelloApplication.AlertShow("Failure", "Employee not deleted successfully", Alert.AlertType.ERROR);
        }
    }

    private boolean isValidID(String eid) {
        //id can't be empty and must be less than 64 characters, also can only contain numbers
        if (eid.isEmpty() || eid.length() > 64 || !eid.matches("[0-9]+")) {
            return false;
        }
        return true;
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
        //check that all forms are filled
        if (eid.isEmpty() || employee_name.isEmpty() || employee_address.isEmpty() || employee_dob.isEmpty() || employee_number.isEmpty()) {
            HelloApplication.AlertShow("Empty Fields", "Please fill in all fields", Alert.AlertType.ERROR);
            return;
        }
        //if the number already exists, we will show an error
        if(!isValidID(eid)){
            HelloApplication.AlertShow("Invalid ID", "Please enter a valid ID", Alert.AlertType.ERROR);
            return;
        }
        if(employeeExists(eid)){
            HelloApplication.AlertShow("User Already Exists", "User With this id Already Exists..", Alert.AlertType.ERROR);
            return;
        }
        //we will first check if the data is correctly formatted
        if (!isValidDate(employee_dob)) {
            HelloApplication.AlertShow("Invalid Date", "Please enter a valid date in the format YYYY-MM-DD", Alert.AlertType.ERROR);
            return;
        }
        if (!isValidNumber(employee_number)) {
            HelloApplication.AlertShow("Invalid Number", "Please enter a valid number", Alert.AlertType.ERROR);
            return;
        }
        if (!isValidName(employee_name)) {
            HelloApplication.AlertShow("Invalid Name", "Please enter a valid name", Alert.AlertType.ERROR);
            return;
        }

        String query1 = "INSERT into employee(eid,employee_name,employee_dob, employee_address,employee_number) VALUES(?,?,?,?,?)" ;
        //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);

        PreparedStatement statement = connector1.myConnection.connectDB().prepareStatement(query1);
        statement.setString(1, eid);
        statement.setString(2, employee_name);
        statement.setString(3, employee_dob);
        statement.setString(4, employee_address);
        statement.setString(5, employee_number);

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            //we will make an alert to show that the employee was added successfully
            HelloApplication.AlertShow("Employee Added", "Employee was added successfully", Alert.AlertType.INFORMATION);
            HelloApplication.clearTextFields(eidText, enameText, eaddressText, edobText, enumberText);
        } else {
            HelloApplication.AlertShow("Employee Not Added", "Employee was not added successfully", Alert.AlertType.ERROR);
        }

        statement.close();
    }

    @FXML
    void updateEMP(ActionEvent event)throws ClassNotFoundException, SQLException {
        DBConnector connector = new DBConnector();
        connector.myConnection.connectDB();
        String eid = eidText.getText();
        String query1 = "Update employee Set employee_name='Mohammad' WHERE eid= "+eid ;
        //ResultSet resultSet1 = connector1.myConnection.connectDB().createStatement().executeQuery(query1);
        int rowsAffected = connector.myConnection.connectDB().createStatement().executeUpdate(query1);

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
    @FXML
    public void backClk(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",backBtn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean isValidDate(String date) {
        // Check if the date matches the expected format 'YYYY-MM-DD'
        String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2}";
        return date.matches(dateFormatRegex);
    }
    private boolean isValidNumber(String number){
        //the number follows this format +XXXXXXXXXXXX
        String numberFormatRegex = "\\+\\d{12}";
        return number.matches(numberFormatRegex);
    }
    private boolean isValidName(String name){
        //the name can't contain numbers and can contain spaces
        String nameFormatRegex = "[a-zA-Z\\s]+";
        return name.matches(nameFormatRegex);
    }
    private boolean employeeExists(String eid) throws SQLException, ClassNotFoundException {
        DBConnector connector = new DBConnector();
        connector.myConnection.connectDB();
        String query = "SELECT COUNT(*) FROM employee WHERE eid = ?";
        PreparedStatement statement = connector.myConnection.connectDB().prepareStatement(query);
        statement.setString(1, eid);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        int count = resultSet.getInt(1);

        statement.close();
        resultSet.close();

        return count > 0;
    }
@FXML
    public void clearClk(ActionEvent event) {
        HelloApplication.clearTextFields(eidText, enameText, eaddressText, edobText, enumberText);
    }
    @FXML
    public void onReloadClk(ActionEvent event) throws SQLException, ClassNotFoundException {
        DBConnector connector = new DBConnector();
        connector.myConnection.connectDB();
        String query = "SELECT * FROM employee";
        PreparedStatement statement = connector.myConnection.connectDB().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            employeeList.add(new Employee(resultSet.getInt("eid"), resultSet.getString("employee_name"), resultSet.getDate("employee_dob"), resultSet.getString("employee_address"), resultSet.getString("employee_number")));
        }
        //we will set the cell value factory to the table
        //now we use our list to populate the table
        idC.setCellValueFactory(new PropertyValueFactory<>("eid"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("employee_name"));
        dotC.setCellValueFactory(new PropertyValueFactory<>("employee_dob"));
        addressC.setCellValueFactory(new PropertyValueFactory<>("employee_address"));
        numberC.setCellValueFactory(new PropertyValueFactory<>("employee_number"));
        employeeTBL.setItems(employeeList);
        statement.close();
        resultSet.close();
    }
}
