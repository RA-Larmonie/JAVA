package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application implements EventHandler<ActionEvent> {
    public static void main(String[] args) { launch(args);}

    private Button b;
    private Label l;
    private  TextField tf;
    private int no = 0;


    @Override
    public void start(Stage primaryStage) /*throws Exception*/{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));*/
        primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        b = new Button("click me!");
        l = new Label("<input from text field>");

        tf = new TextField();
        tf.setMaxWidth(110);

        b.setOnAction(this);    //Whenever a b is clicked, it would go through here to handle class.

        VBox vb = new VBox(25);  //vb.setSpacing(25);
        vb.getChildren().addAll(l,tf,b); // add all the items to vertical box

        Scene s = new Scene(vb,200,150);    // scene is C# Forms
        primaryStage.setScene(s);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(b)) {
            if (!tf.getText().equals("")) {
                l.setText(tf.getText());
                b.setText("press me " + this.no);
                this.no++;
            }
        }
    }
}
