package VL_Aufgaben.VL6;

import VL_Aufgaben.VL6.Konto;

import java.io.Serializable;

public class Kunde implements Serializable {
    private String nachname;
    private Konto konto;

    public Kunde(String n, double ghb)
    {
        this.konto=new Konto(ghb);
        this.nachname=n;
    }

    public void druckeDaten()
    {
        System.out.println("Konto von: "+nachname+"  Kontoguthaben: " +this.konto.getGuthaben());
    }


}
