package com.example.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
public class SignUpController {
        @FXML
        private Label NameLB;

        @FXML
        private Label IDLB;

        @FXML
        private Label EmailLB;

        @FXML
        private Label AdressLB;

        @FXML
        private Label NumberLB;

        @FXML
        private Label GenderLB;

        @FXML
        private Label DOBLB;

        @FXML
        private Label PasswordLB;

        @FXML
        private TextField NameTF;

        @FXML
        private TextField IDTF;

        @FXML
        private TextField EmailTF;

        @FXML
        private TextField AddressTF;

        @FXML
        private TextField NumberTF;

        @FXML
        private RadioButton MaleRB;

        @FXML
        private RadioButton FemaleRB;

        @FXML
        private TextField DOBTF;

        @FXML
        private TextField PassTF;

        @FXML
        private Button SignBT;

        @FXML
        private Button BackBT;
        void backClk1(ActionEvent event) {
        try {
            HelloApplication.changeScene("staff-view.fxml",BackBT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
