package Praktikum_7;

import Praktikum_7.Views.AudioErfassungView;
import Praktikum_7.Views.BildErfassungView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class start extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Bild b1 = null;
        Audio a1 = null;

        Pane root = new Pane();
        Scene sc = new Scene(root,400,200);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Hauptfenster");
        primaryStage.show();

        BildErfassungView bev = new BildErfassungView(b1,primaryStage);
        bev.setTitle("Bilderfassung");
        bev.showView();

        AudioErfassungView aev = new AudioErfassungView(a1,primaryStage);
        aev.setTitle("Audioerfassung");
        aev.showView();
    }
/*
    public static void main(String[] args) {

        Menu menu = new Menu();
        while(true) {
            try {
                menu.showMenu();
                break;
            } catch (Exception e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Bitte wählen sie einen Menuepunkt von 1 bis 6 aus!");
            }
        }


    }
  */

}
