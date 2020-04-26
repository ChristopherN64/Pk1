package Praktikum_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Medienverwaltung_nicht_typisiert {

    private ArrayList medien;

    public Medienverwaltung_nicht_typisiert()
    {
        medien = new ArrayList();
    }

    public void aufnehmen(Medium m)
    {
        medien.add(m);
    }

    public void zeigeMedien()
    {
        Iterator it = medien.iterator();
        Medium mTemp;
        while(it.hasNext())
        {
            mTemp = (Medium) it.next();
            mTemp.druckeDaten();
        }
    }

    public void sucheNeuesMedium()
    {
        Collections.sort(medien);
        System.out.println();
        System.out.println("Jüngstes Medium:  ");
        ((Medium) medien.get(0)).druckeDaten();

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
            for(Object o : medien)
            {
                dSumme+=((Medium)o).getJahr();
            }
            dSumme/=medien.size();
            return dSumme;
        }
    }

}
