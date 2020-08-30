package app.controller;

import app.db.CRUD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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

public class Login implements Initializable {
    static public String usernameLog;
    static public String passwordLog;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton forgotPassword;

    @FXML
    private JFXButton register;

    @FXML
    private Label flashMsg;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                login.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/app/view/register.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage register = new Stage();
                register.setScene(new Scene(root));
                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                register.setWidth(primaryScreenBounds.getWidth());
                register.setHeight(primaryScreenBounds.getHeight());
                register.setTitle("Registration");
                register.setResizable(false);
                register.show();
            }
        });
        forgotPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(username.getText().isEmpty()){
                    flashMsg.setVisible(true);
                    flashMsg.setText("The username can not be empty");
                }else if(password.getText().isEmpty()){
                    flashMsg.setVisible(true);
                    flashMsg.setText("The Password can not be empty");
                }else{
                    ArrayList<Object> list = new ArrayList<>();
                    CRUD  crud = new CRUD();
                    try {
                        list = crud.Select("SELECT password FROM Users WHERE password");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    if(password.equals(passwordLog) && username.equals(usernameLog)){
                        //return home page
                        login.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/app/view/home.fxml"));
                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage home = new Stage();
                        home.setScene(new Scene(root));

                        Home homeInfo = loader.getController();
                        //homeInfo.setName(email.getText());

                        home.setTitle("Home");
                        home.setResizable(false);
                        home.show();
                    }else{
                        //show that this user doesnt exist
                        flashMsg.setVisible(true);
                        flashMsg.setText("The Password or Username are not correct");
                    }
                }
            }
        });
    }
}
