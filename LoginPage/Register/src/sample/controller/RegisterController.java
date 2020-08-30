package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField confirmPassword;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField confirmEmail;

    @FXML
    private JFXTextArea message;

    @FXML
    private JFXCheckBox checkbox;

    @FXML
    private JFXButton submit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setStyle("-fx-text-inner-color: #ffff");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.printf("Submit clicked");
            }
        });
    }
}

