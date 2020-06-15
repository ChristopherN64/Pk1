package Praktikum_9.mv.gui;

import Praktikum_9.mv.fachlogik.Audio;
import Praktikum_9.mv.fachlogik.Bild;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Connection;

public class Controller {
    private Stage primaryStage;

    public Controller(Stage ps)
    {
        this.primaryStage=ps;
    }

    public String showInputView(String titel, String nachicht, String inhalt)
    {
        InputView iv = new InputView(primaryStage,titel,nachicht,inhalt);
        return iv.showView();
    }

    public void showMessageView(String titel, String nachicht)
    {
        MessageView mv = new MessageView(primaryStage,titel,nachicht);
        mv.showView();
    }

    public int showBildErfassung(Bild b)
    {
        BildErfassungView bev = new BildErfassungView(b,primaryStage);
        bev.setTitle("Bilderfassung");
        return bev.showView();
    }

    public int showAudioErfassung(Audio a)
    {
        AudioErfassungView aev = new AudioErfassungView(a,primaryStage);
        aev.setTitle("Audioerfassung");
        return aev.showView();
    }
}
