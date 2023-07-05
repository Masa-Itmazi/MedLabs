package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField IDTf;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField userNameTf;

    @FXML
    void onSubmitBtnClick(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        DBConnector connector = new DBConnector();
        connector.myConnection.connectDB();
        //we will check if the user exists in the database based on the eid that is in the IDTf
        //if the user exists, we will change the scene to the main menu
        //if the user does not exist, we will display an error message

        String eid = IDTf.getText();
        String query = "SELECT * FROM employee WHERE eid = " + eid;
        ResultSet resSet = connector.myConnection.connectDB().createStatement().executeQuery(query);
        //if the query returns a result, then the user exists
        //if the query does not return a result, then the user does not exist
        //if the user exists, then we will change the scene to the main menu
        //if the user does not exist, then we will display an error message
        if (resSet.next()) {
            //the user exists
            //we will change the scene to the main menu
            HelloApplication.changeScene("staff-view.fxml", submitBtn);
        } else {
            //the user does not exist
            //we will display an error message
            System.out.println("The user does not exist");
        }


    }

}
