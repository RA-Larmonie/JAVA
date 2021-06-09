/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbusy;

import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Joris
 */
public class BusyApplication extends Application {

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Button btn1;
    private Label label1;
    // new button
    private Button btn2;
    //object busyworker
    private BusyWorker bw;
    
    
    @Override
    public void start(Stage primaryStage) {
        label1 = new Label("");
        btn1 = new Button();
        btn1.setText("show current time");
        
        //new button
        btn2 = new Button();
        btn2.setText("create busyworker object");
        
        
        
        // TODO: VBox, Scene, Stage actions
        VBox vb = new VBox();
        ButtonHandler bh = new ButtonHandler();
        
        vb.setSpacing(25);        
        vb.setPadding(new Insets(10,20,30,40));
        
        Scene scene = new Scene(vb,300,300);
                
        vb.getChildren().addAll(label1,btn1,btn2);
         
        //you need to touch the edge of the box
        btn1.setOnAction(bh);
        btn2.setOnAction(bh);
                
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        label1.setText(Calendar.getInstance().getTime().toString()
                + "; milliseconds: "
                + Calendar.getInstance().get(Calendar.MILLISECOND));           
    }
    
    
    
    public class ButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){  
            if(e.getSource()==btn1){
            label1.setText(Calendar.getInstance().getTime().toString()
            + "; milliseconds: "
            + Calendar.getInstance().get(Calendar.MILLISECOND));          
            }
            else if(e.getSource()==btn2){
              bw = new BusyWorker(5000);  
              bw.busyJob();
            }
        }
    }
}

