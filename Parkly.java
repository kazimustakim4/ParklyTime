package parkly;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

public class Parkly extends Application
    implements EventHandler<ActionEvent> {
        
    
    @Override
    public void start(Stage primaryStage)  {
        parkingMethod();
        
    }
    
    public void parkingMethod() {
        Stage window = new Stage();
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(10);
        
        
        Label prompt = new Label("Where do you want to park?");
        GridPane.setConstraints(prompt, 0, 0);
        
        Button btGarage = new Button("Garage");
        GridPane.setConstraints(btGarage, 0, 1);
        
        Button btStreet = new Button("Street");
        GridPane.setConstraints(btStreet, 1, 1);
        
        pane.getChildren().addAll(prompt, btGarage, btStreet);
        
        Scene scene = new Scene(pane, 400, 200);
        window.setTitle("Parking Method");
        window.setScene(scene);
        window.show();
        
        btStreet.setOnAction(e -> meterOrNoMeter(window, scene, pane));
        btGarage.setOnAction(e -> setPriceRange(window, pane));
    }
    
    public void meterOrNoMeter(Stage window, Scene scene, GridPane pane) {
        pane.getChildren().clear();
        Label prompt = new Label("Do you want to use a meter?");
        GridPane.setConstraints(prompt, 0, 0);
        
        Button btYes = new Button("Yes");
        GridPane.setConstraints(btYes, 0, 1);
        
        Button btNo = new Button("No");
        GridPane.setConstraints(btNo, 1, 1);
        
        pane.getChildren().addAll(prompt, btYes, btNo);
        
        window.setTitle("Meter or no Meter");
        window.setScene(scene);
        window.show();
        
        btYes.setOnAction(e -> submitStreet(true));
        btNo.setOnAction(e -> submitStreet(false));
    }
    
    public void setPriceRange(Stage window, GridPane pane){
        pane.getChildren().clear();
        Label label2 = new Label("What is your price range?");
        Slider slider = new Slider();
        
        //set min, max, and value
        slider.setMin(25);
        slider.setMax(100);
        slider.setValue(25);
        
        // enable TickLabels and Tick Marks
        slider.setShowTickLabels(true);
        //slider.setShowTickMarks(true);
        
        slider.setBlockIncrement(10);
      
        slider.valueProperty().addListener(
             new ChangeListener<Number>() {
  
            public void changed(ObservableValue <? extends Number > 
                      observable, Number oldValue, Number newValue)
            {
  
               // put your logic statements here
               // ...
            }
        });
        
        Button btnNext = new Button("next");
        
        VBox layout2 = new VBox(50);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(label2, slider, btnNext);
        Scene scene2 = new Scene(layout2, 400, 200);
        
        window.setScene(scene2);
        window.setTitle("Set Price Range");
        window.show();
        
        btnNext.setOnAction(e -> parkTime(window));
    }
    
    public void parkTime(Stage window){
        
        VBox layout3 = new VBox(50);
        
        layout3.setAlignment(Pos.CENTER);
        
        Label label3 = new Label("How long will you be parked? (in minutes)");
        TextField textField = new TextField();
        Button submit = new Button("submit");
        
        layout3.getChildren().addAll(label3, textField, submit);
        window.setScene(new Scene(layout3, 400, 200));
        window.setTitle("Event Handler");
        window.show();
        
        submit.setOnAction(e -> submitGarage(Integer.parseInt(textField.getText())));
    }

    public void submitGarage(int minutes) {
        Image map = null;
        try {
            map = new Image(new FileInputStream("Parking_garages.jpg"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parkly.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView garageMap = new ImageView(map);
        
        garageMap.setPreserveRatio(true);
        
        Group root = new Group(garageMap);
        
        Stage window = new Stage();
        
        Scene mapScene = new Scene(root, 1920, 1080);
        window.setScene(mapScene);
        window.setTitle("Street Parking");
        window.show();
    }
    
    public void submitStreet(boolean meter) {
        Image map = null;
        try {
            if(meter){
                map = new Image(new FileInputStream("Parking_meters.jpg"));
            }
            else 
                map = new Image(new FileInputStream("Parking_zones.jpg"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parkly.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView mapView = new ImageView(map);
        
        mapView.setPreserveRatio(true);
        
        Group root = new Group(mapView);
        
        Scene mapScene = new Scene(root, 640, 480);
        Stage window = new Stage();
        window.setScene(mapScene);
        window.setTitle("Street Parking");
        window.show();
    }
    
    public static void main(String[] args) throws Exception{
        Application.launch(args);
    }
        
    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
