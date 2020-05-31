package Praktikum_7.Views;

import Praktikum_7.Audio;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AudioErfassungView extends Stage {
    private Stage primaryStage;
    private GridPane gp;
    private Scene scene;

    public AudioErfassungView(Audio audio, Stage primaryStage)
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
        Label lbJahr = new Label("Jahr:");
        Label lbInterpret = new Label("Interpret:");
        Label lbDauer = new Label("Dauer:");
        TextField tfTitel = new TextField();
        tfTitel.setMinWidth(250);
        TextField tfJahr = new TextField();
        TextField tfInterpret = new TextField();
        TextField tfDauer = new TextField();
        Button btNeu = new Button("Neu");
        Button btAbbrechen = new Button("Abbruch");


        //Hinzufügen der Controls zum Grid layout
        gp = new GridPane();
        gp.add(lbTitel,0,0);
        gp.add(lbInterpret,0,1);
        gp.add(lbJahr,0,2);
        gp.add(lbDauer,0,3);

        gp.add(tfTitel,1,0,4,1);
        gp.add(tfInterpret,1,1,4,1);
        gp.add(tfJahr,1,2,4,1);
        gp.add(tfDauer,1,3,4,1);

        gp.add(btNeu,2,4);
        gp.add(btAbbrechen,3,4);

        //Annpassen der Anordnung der einzelnen Elemente
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        GridPane.setHalignment(lbTitel, HPos.RIGHT);
        GridPane.setHalignment(lbInterpret, HPos.RIGHT);
        GridPane.setHalignment(lbJahr, HPos.RIGHT);
        GridPane.setHalignment(lbDauer, HPos.RIGHT);
        GridPane.setMargin(btNeu,new Insets(20,20,0,20));
        GridPane.setMargin(btAbbrechen,new Insets(20,0,0,0));

        //Scene der Stage (von sich selber) setzen
        scene = new Scene(gp);
        this.setScene(scene);
        this.show();
    }
}
