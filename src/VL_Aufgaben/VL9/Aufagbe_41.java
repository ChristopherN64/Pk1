package VL_Aufgaben.VL9;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Aufagbe_41 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane p = new Pane();


        Scene sc = new Scene(p);
        primaryStage.setScene(sc);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        p.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                p.getChildren().add(new Rectangle(event.getX(),event.getY(),50,50));
            }
        });


        primaryStage.show();



    }
}
