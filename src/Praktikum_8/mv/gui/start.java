package Praktikum_8.mv.gui;

import Praktikum_8.mv.fachlogik.Audio;
import Praktikum_8.mv.fachlogik.Bild;
import Praktikum_8.mv.gui.AudioErfassungView;
import Praktikum_8.mv.gui.BildErfassungView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class start extends Application {
    private BorderPane root;
    private Scene sc;
    private MenuBar menuBar;

    @Override
    public void start(Stage primaryStage) throws Exception {

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

        root.setTop(menuBar);

        primaryStage.setScene(sc);
        primaryStage.setTitle("Medienverwaltung");
        primaryStage.show();




        Bild b = new Bild("Wald",2000,"Rom");
        Audio a = new Audio("Ich",200,"TestINterpret",333);

        BildErfassungView bev = new BildErfassungView(b,primaryStage);
        bev.setTitle("Bilderfassung");
        bev.showView();

        AudioErfassungView aev = new AudioErfassungView(a,primaryStage);
        aev.setTitle("Audioerfassung");
        aev.showView();

        miErscheinungsjahr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print(b);
                System.out.print(a);
            }
        });



    }
}
