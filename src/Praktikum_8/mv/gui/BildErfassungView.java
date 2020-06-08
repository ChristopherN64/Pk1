package Praktikum_8.mv.gui;

import Praktikum_8.mv.fachlogik.Bild;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.omg.CORBA.INTERNAL;

public class BildErfassungView extends Stage {
    private Bild erfasstesBild;

    private Stage primaryStage;
    private GridPane gp;
    private Scene scene;
    private Label lbTitel,lbOrt, lbJahr;
    private TextField tfTitel, tfOrt, tfJahr;
    private Button btNeu,btAbbrechen;

    public BildErfassungView(Bild bild, Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        //Erzeugen der Controls
        lbTitel = new Label("Titel:");
        lbOrt = new Label("Ort:");
        lbJahr = new Label("Aufnahmejahr:");

        btNeu = new Button("Neu");
        btAbbrechen = new Button("Abbruch");
       if(bild!=null)
       {
           tfTitel = new TextField(bild.getTitel());
           tfOrt = new TextField(bild.getOrt());
           tfJahr = new TextField(Integer.toString(bild.getJahr()));
       }
       else
       {
           tfTitel = new TextField();
           tfOrt = new TextField();
           tfJahr = new TextField();
       }
       erfasstesBild=bild;
    }

    public void showView()
    {
        //Sich selber als Modales Fenster der Hauptstage festlegen
        this.initOwner(primaryStage);
        this.initModality(Modality.WINDOW_MODAL);


        //Konfigurieren der Controlls
        tfTitel.setMinWidth(250);
        btNeu.setOnAction(new ButtonNewHandler());

        //Hinzufügen der Controls zum Grid layout
        gp = new GridPane();
        gp.add(lbTitel,0,0);
        gp.add(lbOrt,0,1);
        gp.add(lbJahr,0,2);
        gp.add(tfTitel,1,0,4,1);
        gp.add(tfOrt,1,1,4,1);
        gp.add(tfJahr,1,2,4,1);
        gp.add(btNeu,2,3);
        gp.add(btAbbrechen,3,3);

        //Annpassen der Anordnung der einzelnen Elemente
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        GridPane.setHalignment(lbTitel, HPos.RIGHT);
        GridPane.setHalignment(lbOrt, HPos.RIGHT);
        GridPane.setHalignment(lbJahr, HPos.RIGHT);
        GridPane.setMargin(btNeu,new Insets(20,20,0,20));
        GridPane.setMargin(btAbbrechen,new Insets(20,0,0,0));

        //Scene der Stage (von sich selber) setzen
        scene = new Scene(gp);
        this.setScene(scene);
        this.show();
    }



    class ButtonNewHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            erfasstesBild.setTitel(tfTitel.getText());
            erfasstesBild.setOrt(tfOrt.getText());
            erfasstesBild.setJahr(Integer.valueOf(tfJahr.getText()));
        }
    }
}
