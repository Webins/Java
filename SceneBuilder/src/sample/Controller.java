package sample;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button clickButton;

    @FXML
    private JFXButton materialButton;

    @FXML
    private JFXTextField firstLabel;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clickButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstLabel.setText("The normal button was clicked");
            }
        });
        materialButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                firstLabel.setText("The material button was clicked");
            }
        });
    }
}