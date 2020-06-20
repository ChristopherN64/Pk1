package Praktikum_10.Aufgabe_2;

public class start {
    public static void main(String[] args) {
        Converyor converyor = new Converyor();
        Thread bottlingPlant = new Thread(new BottlingPlant(converyor,1000));
        Thread  labelingMaschine = new Thread( new LabelingMaschine(converyor,3000));
        bottlingPlant.start();
        labelingMaschine.start();

    }
}
