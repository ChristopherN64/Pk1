package VL_Aufgaben.VL8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Insets i = new Insets(5,5,5,5);

        ListView<String> lv = new ListView<>();
        Label lb1 = new Label("Label 1");
        Label lb2 = new Label("Label 2");
        TextField tf0 = new TextField("TextField 0");
        tf0.setMinWidth(250);
        TextField tf1 = new TextField("TextField 1");
        TextField tf3 = new TextField("TextField 2");
        Button button = new Button("Start");

        ArrayList<String> al= new ArrayList<>();
        for(int il=0; il<20; il++)
        {
            al.add("Element "+il);
        }
        ObservableList<String> list = FXCollections.observableList(al);
        lv.setItems(list);

        GridPane gp = new GridPane();
        GridPane.setHalignment(button, HPos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);

        gp.add(lv,0,0,1,6);
        gp.add(lb1,1,0);
        gp.add(lb2,1,1);
        gp.add(tf0,2,0);
        gp.add(tf1,2,1);
        gp.add(tf3,2,2);
        gp.add(button,2,7);



        Scene sc = new Scene(gp);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
