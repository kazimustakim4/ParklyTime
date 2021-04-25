package my;
import javafx.event.*;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
public class EventHandlerExample extends Application
{
@Override
public void start(Stage stage){
     
      Button button = new Button("How Long you will be park?");
      button.setOnAction(new SimpleEventHandler());
 
      VBox vBox = new VBox();
      
      vBox.setAlignment(Pos.CENTER);
      vBox.getChildren().add(button);
      
      stage.setScene(new Scene(vBox, 250, 250));
      stage.setTitle("Event Handler");
      stage.show();
       HBox box = new HBox(5);


    }
}
class SimpleEventHandler implements EventHandler<ActionEvent>{
       @Override
      public void handle(ActionEvent event){
           JOptionPane.showMessageDialog(null, "Enter Time Amount");
       }
}
