package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class Main extends Application implements EventHandler {
    private FlowPane root;
    private Scene scene;
    private Label title;
    private Label response;
    private Label selected;
    private CheckBox bananaCB;
    private CheckBox mangoCB;
    private CheckBox papayaCB;
    private CheckBox grapefruitCB;
    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;
    private Button normalButton;
    private FlowPane fruitsDiv;
    public Rotate rotate;
    public BoxBlur blur;
    public Scale scale;
    public Reflection reflection;
    public double angle = 0.0;
    public double blurval = 0.0;
    private double scaleFactor = 1.0;
    public ArrayList<CheckBox> checkBoxes;
    public ArrayList<Button> buttons;
    public String fruits = "";

    @Override
    public void start(Stage primaryStage) throws Exception{
        checkBoxes = new ArrayList<>();
        buttons = new ArrayList<>();
        primaryStage.setTitle("Favorite fruits");

        /*Path for images*/
        File bananaPath = new File("src/banana.png");
        File mangoPath = new File("src/mango.png");
        File papayaPath = new File("src/papaya.png");
        File grapeFruitPath = new File("src/grapefruit.png");

        Image bananaImg = new Image(bananaPath.toURI().toString());
        Image mangoImg = new Image(mangoPath.toURI().toString());
        Image papayaImg = new Image(papayaPath.toURI().toString());
        Image grapeFruitImg = new Image(grapeFruitPath.toURI().toString());

        /*Image Views*/
        ImageView img1 = new ImageView(bananaImg);
        img1.setFitHeight(60);
        img1.setFitWidth(100);
        ImageView img2 = new ImageView(mangoImg);
        img2.setFitHeight(60);
        img2.setFitWidth(100);
        ImageView img3 = new ImageView(papayaImg);
        img3.setFitHeight(60);
        img3.setFitWidth(100);
        ImageView img4 = new ImageView(grapeFruitImg);
        img4.setFitHeight(60);
        img4.setFitWidth(100);


        /*Elements initialization*/
        root = new FlowPane(Orientation.VERTICAL, 5, 5); // orientation
        fruitsDiv = new FlowPane(Orientation.HORIZONTAL, 15 , 10);

        scene = new Scene(root, 1024, 620);
        title = new Label("What fruits do you like?");
        response = new Label("");
        selected = new Label("");
        bananaCB = new CheckBox("Banana");
        mangoCB = new CheckBox("Mango");
        papayaCB = new CheckBox("Papaya");
        grapefruitCB = new CheckBox("Grape fruit");

        rotateButton = new Button("", img1);
        blurButton = new Button("", img2);
        scaleButton = new Button("", img3);
        normalButton = new Button("",img4);


        rotate = new Rotate();
        blur = new BoxBlur(1.0, 1.0, 1);
        scale = new Scale(scaleFactor, scaleFactor);
        reflection = new Reflection();


        /*Elements Properties*/
        fruitsDiv.setPrefWidth(820);
        root.setAlignment(Pos.CENTER);
        rotateButton.setId("r");
        blurButton.setId("b");
        scaleButton.setId("s");
        normalButton.setId("n");
        normalButton.setDisable(true);
        rotateButton.getTransforms().add(rotate);
        scaleButton.getTransforms().add(scale);
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        /*response.setEffect(reflection);*/
        rotateButton.setPrefHeight(60);
        rotateButton.setPrefWidth(100);
        blurButton.setMinWidth(rotateButton.getPrefWidth());
        blurButton.setMinHeight(rotateButton.getPrefHeight());
        scaleButton.setMinWidth(rotateButton.getPrefWidth());
        scaleButton.setMinHeight(rotateButton.getPrefHeight());
        normalButton.setMinWidth(rotateButton.getPrefWidth());
        normalButton.setMinHeight(rotateButton.getPrefHeight());

        checkBoxes.add(bananaCB);
        checkBoxes.add(mangoCB);
        checkBoxes.add(papayaCB);
        checkBoxes.add(grapefruitCB);

        buttons.add(rotateButton);
        buttons.add(blurButton);
        buttons.add(scaleButton);
        buttons.add(normalButton);

        /*Event Listeners*/
        for(CheckBox element: checkBoxes){
            element.setOnAction(this::handle);
        }
        for(Button element: buttons){
            element.setOnAction(this::handle);
        }

        /*List of elements*/
        ObservableList list = root.getChildren();
        list.add(title);
        list.addAll(bananaCB, mangoCB, papayaCB, grapefruitCB, response, selected);
        fruitsDiv.getChildren().addAll(rotateButton, blurButton, scaleButton, normalButton);
        list.add(fruitsDiv);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Object check = event.getSource();
        /*Checkboxes*/
        for(CheckBox element: checkBoxes){
            if(element.equals(check)){
                if(element.isSelected()){
                    response.setText(element.getText() + " selected!\n\n");
                    fruits += element.getText() + " ";
                    selected.setText(fruits);
                }else{
                    fruits = fruits.replace(element.getText() + " ", "");
                    selected.setText("\n\n" + fruits);
                    response.setText(element.getText() + " cleared");
                }
            }
        }
        /*Buttons*/
        for(Button element: buttons){
            if(element.equals(check)){
                if(element.getId() == "r"){
                    angle+= 15.0;
                    rotate.setAngle(angle);
                    rotate.setPivotX(element.getWidth() / 2);
                    rotate.setPivotY(element.getHeight() / 2);
                }else if(element.getId() == "s"){
                    scaleFactor += 0.1;
                    if(scaleFactor > 2.0) scaleFactor = 1.0;
                    scale.setX(scaleFactor);
                    scale.setY(scaleFactor);

                }else if(element.getId() == "b"){
                    if(blurval == 10.0){
                        blurval=1.0;
                        element.setEffect(null);
                    }else{
                        blurval++;
                        element.setEffect(blur);
                    }
                    blur.setWidth(blurval);
                    blur.setHeight(blurval);
                }else if(element.getId() == "n" && element.isHover()){
                    for(int i =0; i < 4; i++) {
                        angle += 15.0;
                        rotate.setAngle(angle);
                        rotate.setPivotX(element.getWidth() / 2);
                        rotate.setPivotY(element.getHeight() / 2);

                        if (blurval == 80.0) {
                            blurval = 1.0;
                            element.setEffect(null);
                        } else {
                            blurval += 2;
                            element.setEffect(blur);
                        }
                        blur.setWidth(blurval);
                        blur.setHeight(blurval);
                    }
                }
            }
        }
    }
}
