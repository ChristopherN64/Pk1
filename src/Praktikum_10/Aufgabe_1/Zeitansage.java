package Praktikum_10.Aufgabe_1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Zeitansage extends Application implements TimerListener {
    public int iZeit;
    public Zeitansage()
    {
        iZeit=0;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread timerThread = new Thread(new Timer(this));
        timerThread.start();

        MessageView mv = new MessageView(primaryStage,"Message","Zeitansage Stoppen");
        mv.showView();

        timerThread.interrupt();
        timerThread.join();
        System.out.println("Timer Thread ist terminiert");
    }

    public void signalPerformed() {
        iZeit++;
        System.out.println(iZeit+" Sekunden seit Start");

    }
}
