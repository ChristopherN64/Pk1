package Praktikum_4;

import java.util.ArrayList;
import java.util.Collections;

public class Medienverwaltung {

    private ArrayList<Medium> medien;

    public Medienverwaltung()
    {
        medien = new ArrayList<Medium>();
    }

    public void aufnehmen(Medium m)
    {
        medien.add(m);
    }

    public void zeigeMedien()
    {
        Collections.sort(medien);
        for(Medium mTemp : medien)
        {
            mTemp.druckeDaten();
        }
    }

    public void sucheNeuesMedium()
    {
        Collections.sort(medien);
        System.out.println();
        System.out.print("Jüngstes Medium:  ");
        medien.get(medien.size()-1).druckeDaten();
    }

    public double berechneErscheinungsjahr()
    {
        if(this.medien == null)
        {
            return 0.0;
        }
        else
        {
            double dSumme=0;
            for(Medium o : medien)
            {
                dSumme+=o.getJahr();
            }
            dSumme/=medien.size();
            return dSumme;
        }
    }

}
