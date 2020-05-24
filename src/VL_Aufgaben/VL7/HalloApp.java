package VL_Aufgaben.VL7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HalloApp extends Application {
    @Override
    public void start(Stage stage) {
        Label nachricht = new Label("Hallo Programmierkurs 1");
        StackPane sp = new StackPane();
        Button button = new Button("Test Button");
        nachricht.setFont(new Font(50));
        sp.getChildren().add(button);
        sp.getChildren().add(nachricht);
        Scene szene = new Scene(sp);

        stage.setScene(szene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
