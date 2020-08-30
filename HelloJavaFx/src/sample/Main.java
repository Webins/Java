package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class Main extends Application {
    private Label label;
    private TextField textField;
    public int click =2;
    public String newTitle="";
    public String oldTitle="";
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello from JavaFx");
        Button button = new Button(); //element
        Label label = new Label();
        TextField textField = new TextField();

        textField.setPromptText("Enter a new title");

        label.setText("Click : 0");
        button.setText("Click me to change the title");
        // the way to handle events in JavaFx

        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                if(!textField.getText().isEmpty()){
                    if(!newTitle.isEmpty()){
                        oldTitle = newTitle;
                    }else{
                        oldTitle = "Hello from JavaFx";
                    }
                    newTitle = textField.getText();
                    textField.clear();
                }

                if(!newTitle.isEmpty()){
                    if(click % 2 == 0) {
                        primaryStage.setTitle(newTitle);
                        button.setText("Back to original title");
                        label.setText("Click : " + (click -1));
                    }
                    else {
                        primaryStage.setTitle(oldTitle);
                        button.setText("Click me to change the title");
                        label.setText("Click : " + (click -1));
                    }
                }
                else {
                    if(click % 2 == 0) {
                        primaryStage.setTitle("Title changed by your click");
                        button.setText("Back to original title");
                        label.setText("Click : " + (click -1));
                    }
                    else {
                        primaryStage.setTitle("Hello from JavaFx");
                        button.setText("Click me to change the title");
                        label.setText("Click : " + (click -1));
                    }
                }
                click++;
            }
        });
       // StackPane root = new StackPane(); // stack pane
        /*Because stack pane group everything inside we use a flowPane */
        FlowPane root = new FlowPane(50,5);
        root.setAlignment(Pos.CENTER);
        //root.getChildren().add(button); // stack pane element
        ObservableList list = root.getChildren();
        list.add(button); // is the same as the above
        list.add(label);
        list.add(textField);
        Scene scene = new Scene(root, 250, 200); // scene stack pane element
        primaryStage.setScene(scene); // stage scene stack pane element
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
