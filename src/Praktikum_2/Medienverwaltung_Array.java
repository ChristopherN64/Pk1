package Praktikum_2;

import java.util.Arrays;
import java.util.Collections;

public class Medienverwaltung_Array {

    private Medium[] medien;
    private int medienCount;

    public Medienverwaltung_Array()
    {
        medien=new Medium[10];
        medienCount=0;
    }

    public void aufnehmen(Medium m)
    {
        if(medienCount<medien.length-1)
        {
            medien[medienCount]=m;
            medienCount++;
        }
        else
        {
            System.out.println("Medium kann nicht hinzugefügt werden da Medienverwaltung voll");
        }
    }

    public void zeigeMedien()
    {
        for(int il=0;il<medienCount;il++)
        {
            medien[il].druckeDaten();
        }
    }

    public void sucheNeuesMedium()
    {
       Medium m = medien[0];
       for(int il=1;il<medienCount;il++)
       {
            if(medien[il].getJahr()>m.getJahr())
            {
                m=medien[il];
            }
       }
       System.out.println();
        System.out.println("Jüngstes Medium:  ");
        m.druckeDaten();
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
            for(int il=0;il<medienCount;il++)
            {
                dSumme+=medien[il].getJahr();
            }
            dSumme/=medienCount;
            return dSumme;
        }
    }

}
