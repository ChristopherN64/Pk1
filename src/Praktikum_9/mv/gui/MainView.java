package Praktikum_9.mv.gui;

import Praktikum_9.mv.Datenhaltung.InDateiIO;
import Praktikum_9.mv.Datenhaltung.PersistenzException;
import Praktikum_9.mv.Datenhaltung.SerialisierungIO;
import Praktikum_9.mv.fachlogik.Audio;
import Praktikum_9.mv.fachlogik.Bild;
import Praktikum_9.mv.fachlogik.Medienverwaltung;
import Praktikum_9.mv.fachlogik.Medium;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainView extends Application {
    private Medienverwaltung medienverwaltung;
    private Controller controller;

    private BorderPane root;
    private Scene sc;
    private MenuBar menuBar;
    private ListView<Medium> listView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.medienverwaltung = new Medienverwaltung();
        this.controller = new Controller(primaryStage);
        this.listView = new ListView<Medium>();
        this.listView.getItems().addAll(medienverwaltung.getMedien());

        root= new BorderPane();
        sc = new Scene(root,400,200);
        menuBar = new MenuBar();
        Menu mDatei = new Menu("Datei");
            MenuItem miLaden = new MenuItem("Laden");
            MenuItem miSpeichern = new MenuItem("Speichern");
            SeparatorMenuItem smi = new SeparatorMenuItem();
            SeparatorMenuItem smi2 = new SeparatorMenuItem();
            MenuItem miMLiD = new MenuItem("Medienliste in Datei");
            MenuItem miBeenden = new MenuItem("Beenden");
        Menu mMedium = new Menu("Medium");
            MenuItem miAudioNeu = new MenuItem("Audio neu");
            MenuItem miBildNeu = new MenuItem("Bild Neu");
        Menu mAnzeige = new Menu("Anzeige");
        MenuItem miErscheinungsjahr = new MenuItem("Erscheinungsjahr");
        MenuItem miNeuesMedium = new MenuItem("Neues Medium");


        //Konfigurieren der Controls
        menuBar.getMenus().addAll(mDatei,mMedium,mAnzeige);
        mDatei.getItems().addAll(miLaden,miSpeichern,smi,miMLiD,smi2,miBeenden);
        mMedium.getItems().addAll(miAudioNeu,miBildNeu);
        mAnzeige.getItems().addAll(miErscheinungsjahr,miNeuesMedium);

        //Registrieren der EventHandler
        miSpeichern.setOnAction(new EventHandlerSpeichern());
        miLaden.setOnAction(new EventHandlerLaden());
        miMLiD.setOnAction(new EventHandlerInDatei());
        miAudioNeu.setOnAction(new EventHandlerNeueAudio());
        miBildNeu.setOnAction(new EventHandlerNeuesBild());
        miErscheinungsjahr.setOnAction(new EventHandlerErscheinungsjahr());
        miNeuesMedium.setOnAction(new EventHandlerNeustesMedium());

        root.setTop(menuBar);
        root.setCenter(listView);

        primaryStage.setScene(sc);
        primaryStage.setTitle("Medienverwaltung");
        primaryStage.show();

    }




    class EventHandlerLaden implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            try {
                medienverwaltung.lade("C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_9\\MedienDatei");
                //Alten List view Leereren und neue geladene Liste anzeigen
                listView.getItems().clear();
                listView.getItems().addAll(medienverwaltung.getMedien());
                medienverwaltung.zeigeMedien();
            } catch (PersistenzException e) {
                controller.showMessageView("Fehler","Die Datei konnte nicht geladen werden!");
            }
        }
    }

    class EventHandlerSpeichern implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {
            try {
                medienverwaltung.speichern("C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_9\\MedienDatei");
                controller.showMessageView("Erfolg","Liste Erfolgreich Serialisiert und geschrieben");
            } catch (PersistenzException e) {
                e.printStackTrace();
            }
        }
    }

    class EventHandlerInDatei implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            boolean readFilePath = true;
            while (readFilePath)
            {
            //Einlesen eines Pfades durch einen InputView
                String file = controller.showInputView("Pfadeingabe","Bitte geben sie den Pfad der Datei ein in die Geschrieben werden soll!","C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_9\\out.txt");
                //Wenn nicht Abbrechen gewählt wurde wird versucht zu schreiben
                if(file!=null)
                {
                        try {
                            medienverwaltung.speichernInDatei(file);
                            readFilePath=false;
                            controller.showMessageView("Erfolg","Liste Erfolgreich in Datei geschrieben");
                        } catch (PersistenzException e) {
                            controller.showMessageView("Fehler","Der angegebe Pfad ist ungültig");
                        }
                    }
                else
                {
                    System.out.println("Abbruch");
                    readFilePath = false;
                }

            }

        }
    }

    class EventHandlerNeueAudio implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            Audio a = new Audio();
            int iStatus = -1;
            while(iStatus<0)
            {
                iStatus=controller.showAudioErfassung(a);
                if(iStatus==1)
                {
                    medienverwaltung.aufnehmen(a);
                    listView.getItems().add(a);
                    controller.showMessageView("Erfolgreich","Neue Audio Erfolgreich aufgenommen");
                    medienverwaltung.zeigeMedien();
                }
                else if(iStatus==0) System.out.println("Abbruch");
                else if(iStatus==-1) controller.showMessageView("Fehler","Bitte geben sie die Daten im Richtigen Format an");
            }
        }
    }

    class EventHandlerNeuesBild implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            Bild b = new Bild();
            int iStatus = -1;
            while (iStatus<0)
            {
                iStatus = controller.showBildErfassung(b);
                if(iStatus==1)
                {
                    medienverwaltung.aufnehmen(b);
                    listView.getItems().add(b);
                    controller.showMessageView("Erfolgreich","Neues Bild Erfolgreich aufgenommen");
                    medienverwaltung.zeigeMedien();
                }
                else if(iStatus==0) System.out.println("Abbruch");
                else if(iStatus==-1) controller.showMessageView("Fehler","Bitte geben sie die Daten im Richtigen Format an");
            }
        }
    }

    class EventHandlerErscheinungsjahr implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            controller.showMessageView("Durchschnittliches Erscheinungsjahr","Das Durchschnittliche Erscheinungsjahr beträgt: "+medienverwaltung.berechneErscheinungsjahr());
        }
    }

    class EventHandlerNeustesMedium implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event) {
            controller.showMessageView("Neustes Medium",medienverwaltung.sucheNeuesMedium().toString());
        }
    }
}
