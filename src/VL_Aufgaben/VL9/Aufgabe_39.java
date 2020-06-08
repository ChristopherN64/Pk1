package VL_Aufgaben.VL9;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;


public class Aufgabe_39 extends Application implements EventHandler<ActionEvent> {

    private Rectangle rc = new Rectangle(100,100);
    private  Button btn = new Button("Farbwechsel");

    @Override
    public void start(Stage primaryStage) throws Exception {

        rc.setFill(Color.GREEN);
        btn.setOnAction(this);

        BorderPane bp = new BorderPane();
        bp.setCenter(rc);
        bp.setBottom(btn);
        bp.setAlignment(btn,Pos.CENTER);

        Scene sc = new Scene(bp);
        primaryStage.setScene(sc);

        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        rc.setFill(Color.rgb(ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1),ThreadLocalRandom.current().nextInt(0, 255 + 1)));

    }
}
