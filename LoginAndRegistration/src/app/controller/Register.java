package app.controller;

import app.db.CRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Register implements Initializable {

    @FXML
    private JFXButton goBack;

    @FXML
    private Label flashMsg;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField confirmPassword;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField confirmEmail;

    @FXML
    private JFXTextField instagram;

    @FXML
    private JFXTextField github;

    @FXML
    private JFXTextField twitter;

    @FXML
    private JFXTextArea bio;

    @FXML
    private JFXButton submit;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                goBack.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/app/view/login.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage login = new Stage();
                login.setScene(new Scene(root));
                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                login.setWidth(primaryScreenBounds.getWidth());
                login.setHeight(primaryScreenBounds.getHeight());
                login.setTitle("Login");
                login.setResizable(false);
                login.show();
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(username.getText().isEmpty()){
                    flashMsg.setText("The username can not be empty");
                    flashMsg.setVisible(true);
                }else if(name.getText().isEmpty()){
                    flashMsg.setText("The name can not be empty");
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
                }else if(email.getText().isEmpty()){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(confirmEmail.getText().isEmpty()){
                    flashMsg.setText("You must confirm your email");
                    flashMsg.setVisible(true);
                }else if(!instagram.getText().equals(email.getText())){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(!twitter.getText().equals(email.getText())){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(!github.getText().equals(email.getText())){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else if(!bio.getText().equals(email.getText())){
                    flashMsg.setText("The email can not be empty");
                    flashMsg.setVisible(true);
                }else{
                    flashMsg.setVisible(false);
                    CRUD crud = new CRUD();
                    ArrayList<Object> insert = new ArrayList<>();
                    insert.add(username.getText());
                    insert.add(name.getText());
                    insert.add(password.getText());
                    insert.add(email.getText());
                    insert.add(instagram.getText());
                    insert.add(twitter.getText());
                    insert.add(github.getText());

                    try {
                        crud.Insert("Users", insert, "username", "name", "password", "email", "instagram", "twitter", "github");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    submit.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/app/view/successRegistration.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage success = new Stage();
                    success.setScene(new Scene(root));

                    SuccessRegistration successRegistration = loader.getController();
                    
                    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                    success.setWidth(primaryScreenBounds.getWidth());
                    success.setHeight(primaryScreenBounds.getHeight());
                    success.setTitle("Success");
                    success.setResizable(false);
                    success.show();
                }
            }
        });
    }
}

