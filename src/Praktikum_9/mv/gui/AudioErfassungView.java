package Praktikum_9.mv.gui;

import Praktikum_9.mv.Datenhaltung.PersistenzException;
import Praktikum_9.mv.fachlogik.Audio;
import javafx.beans.binding.NumberBinding;
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

public class AudioErfassungView extends ModalStage {
    private Audio erfassteAudio;
    private int iStatus;

    private Stage primaryStage;
    private GridPane gp;
    private Scene scene;
    private Label lbTitel,lbJahr,lbInterpret,lbDauer;
    private TextField tfTitel,tfInterpret,tfJahr,tfDauer;
    private Button btNeu,btAbbrechen;

    public AudioErfassungView(Audio audio, Stage primaryStage)
    {
        super(primaryStage);
        this.primaryStage = primaryStage;
        //Erzeugen der Controls
         lbTitel = new Label("Titel:");
         lbJahr = new Label("Jahr:");
         lbInterpret = new Label("Interpret:");
         lbDauer = new Label("Dauer:");

         btNeu = new Button("Neu");
         btAbbrechen = new Button("Abbruch");

         if(audio!=null)
         {
             tfTitel = new TextField(audio.getTitel());
             tfJahr = new TextField(Integer.toString(audio.getJahr()));
             tfInterpret = new TextField(audio.getInterpert());
             tfDauer = new TextField(Integer.toString(audio.getDauer()));
         }
         else
         {
             tfTitel = new TextField();
             tfJahr = new TextField();
             tfInterpret = new TextField();
             tfDauer = new TextField();
         }
         erfassteAudio=audio;
    }

    public int showView()
    {
        //Konfigurieren der Controls
        tfTitel.setMinWidth(250);
        btNeu.setOnAction(new ButtonNewHandler());
        btAbbrechen.setOnAction(new ButtonAbbruchHandler());


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
        this.showAndWait();
        return iStatus;
    }


    class ButtonNewHandler implements EventHandler<ActionEvent>  {
        @Override
        public void handle(ActionEvent event ) {
            erfassteAudio.setTitel(tfTitel.getText());
            erfassteAudio.setInterpert(tfInterpret.getText());
            try{
                erfassteAudio.setJahr(Integer.valueOf(tfJahr.getText()));
                erfassteAudio.setDauer(Integer.valueOf(tfDauer.getText()));
                iStatus=1;
            }
            catch (NumberFormatException e)
            {
                iStatus=-1;
            }
            close();
        }
    }

    class ButtonAbbruchHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            iStatus=0;
            close();
        }
    }
}
