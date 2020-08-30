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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
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

    @FXML
    private Label flashMsg;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        password.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        confirmPassword.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        date.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        email.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        confirmEmail.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        message.setStyle("-fx-text-inner-color: #ffff; -fx-background-color: #4ebaaa");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(username.getText().isEmpty()){
                    flashMsg.setText("The username can not be empty");
                    flashMsg.setVisible(true);
                }else if(password.getText().isEmpty()){
                    flashMsg.setText("The password can not be empty");
                    flashMsg.setVisible(true);
                }else if(confirmPassword.getText().isEmpty()){
                    flashMsg.setText("You must confirm your password");
                    flashMsg.setVisible(true);
                }else if(!confirmPassword.getText().equals(password.getText())){
                    flashMsg.setText("The password are not the same");
                    flashMsg.setVisible(true);
                }else if(date.getValue() == null){
                    flashMsg.setText("The date can not be empty");
                    flashMsg.setVisible(true);
                } else if(email.getText().isEmpty()){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(confirmEmail.getText().isEmpty()){
                    flashMsg.setText("You must confirm your email");
                    flashMsg.setVisible(true);
                }else if(!confirmEmail.getText().equals(email.getText())){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(!checkbox.isSelected()){
                    flashMsg.setText("You need to accept our terms");
                    flashMsg.setVisible(true);
                }else{
                    flashMsg.setVisible(false);

                    submit.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/view/login.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage register = new Stage();
                    register.setScene(new Scene(root));

                    LoginController loginController = loader.getController();
                    loginController.setEmailText(email.getText());
                    loginController.setUsernameText(username.getText());

                    register.setTitle("Register Page");
                    register.setResizable(false);
                    register.show();
                }
            }
        });
    }
}

