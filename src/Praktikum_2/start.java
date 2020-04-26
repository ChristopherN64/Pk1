package Praktikum_2;

public class start {

    public static void main(String[] args) {
        MedienVerwaltung_Typsicher mva = new MedienVerwaltung_Typsicher();
        mva.aufnehmen(new Bild("Bäume",2000,"Wald"));
        mva.aufnehmen(new Bild("Auto",1989,"Autohaus"));
        mva.aufnehmen(new Bild("vogel",2010,"Zoo"));

        mva.aufnehmen(new Audio("Audio",2019,"ich",314));
        mva.aufnehmen(new Audio("mp3",2015,"dt",215));

        mva.zeigeMedien();
        mva.sucheNeuesMedium();
        System.out.println("Durchschnittliches Jahr: " + mva.berechneErscheinungsjahr());
    }

}
