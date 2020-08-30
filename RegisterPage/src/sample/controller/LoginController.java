package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label username;

    @FXML
    private Label email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void setUsernameText(String username) {
        this.username.setText(username);
    }

    public void setEmailText(String email) {
        this.email.setText(email);
    }
}
