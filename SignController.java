package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SignController {
    @FXML
    private Label userLB;

    @FXML
    private Label PSLB;

    @FXML
    private Label notLB;

    @FXML
    private TextField usernameTf;

    @FXML
    private TextField passwordTf;

    @FXML
    private Button SignUPBT;

    @FXML
    private Button SignBT;

    @FXML
    private Button backBT;

    @FXML
    void backClk1(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",backBT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
