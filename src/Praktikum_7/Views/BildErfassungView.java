package Praktikum_7.Views;

import Praktikum_7.Bild;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import  javafx.scene.control.*;

public class BildErfassungView extends Stage {
    private Stage primaryStage;
    private GridPane gp;
    private Scene scene;

    public BildErfassungView(Bild bild,Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void showView()
    {
        //Sich selber als Modales Fenster der Hauptstage festlegen
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);

        //Erzeugen der Controls
        Label lbTitel = new Label("Titel:");
        Label lbOrt = new Label("Ort:");
        Label lbAufnahmejahr = new Label("Aufnahmejahr:");
        TextField tfTitel = new TextField();
        tfTitel.setMinWidth(250);
        TextField tfOrt = new TextField();
        TextField tfAufnahmejahr = new TextField();
        Button btNeu = new Button("Neu");
        Button btAbbrechen = new Button("Abbruch");


        //Hinzufügen der Controls zum Grid layout
        gp = new GridPane();
        gp.add(lbTitel,0,0);
        gp.add(lbOrt,0,1);
        gp.add(lbAufnahmejahr,0,2);
        gp.add(tfTitel,1,0,4,1);
        gp.add(tfOrt,1,1,4,1);
        gp.add(tfAufnahmejahr,1,2,4,1);
        gp.add(btNeu,2,3);
        gp.add(btAbbrechen,3,3);

        //Annpassen der Anordnung der einzelnen Elemente
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        GridPane.setHalignment(lbTitel, HPos.RIGHT);
        GridPane.setHalignment(lbOrt, HPos.RIGHT);
        GridPane.setHalignment(lbAufnahmejahr, HPos.RIGHT);
        GridPane.setMargin(btNeu,new Insets(20,20,0,20));
        GridPane.setMargin(btAbbrechen,new Insets(20,0,0,0));

        //Scene der Stage (von sich selber) setzen
        scene = new Scene(gp);
        this.setScene(scene);
        this.show();
    }
}
