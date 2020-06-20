package Praktikum_9.mv.fachlogik;

import Praktikum_9.Exceptions.CancelException;
import Praktikum_9.Exceptions.EmptyFilenameException;
import Praktikum_9.mv.Datenhaltung.IDao;
import Praktikum_9.mv.Datenhaltung.InDateiIO;
import Praktikum_9.mv.Datenhaltung.PersistenzException;
import Praktikum_9.mv.Datenhaltung.SerialisierungIO;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung {

    private ArrayList<Medium> medien;
    private static final String file = "C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_9\\MedienDatei";
    private IDao datenIO;

    public Medienverwaltung()
    {
        medien = new ArrayList<Medium>();
        medien.add(new Audio("TestAudio",2010,"Ich",333));
        medien.add(new Audio("TestAudio2",1910,"Ich",444));
        medien.add(new Bild("testBild2",2011,"Wald"));
        medien.add(new Bild("testBild",1999,"Wald"));
    }

    public void aufnehmen(Medium m)
    {
        medien.add(m);
    }

    public void zeigeMedien() {
        //Ausgeben aller Medien im medien array über den Standard System.out
            for (Medium mTemp : medien)
            {
                mTemp.druckeDaten(new PrintStream(System.out));
            }
    }


    public Medium sucheNeuesMedium()
    {
        Collections.sort(medien);
        return medien.get(medien.size()-1);
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

    public void speichern(String file) throws PersistenzException
    {
        datenIO = new SerialisierungIO(file);
        datenIO.speichern(this.getMedien());
        this.zeigeMedien();
    }
    public void speichernInDatei(String file) throws PersistenzException
    {
        datenIO = new InDateiIO(file);
        datenIO.speichern(this.getMedien());
        this.zeigeMedien();
    }

    public void lade(String file) throws PersistenzException
    {
        SerialisierungIO serIO = new SerialisierungIO(file);
        //Liste Laden und in Medienverwaltung einsetzetn
        this.setMedien((ArrayList<Medium>) serIO.laden());
        //Das Statische Attribut der Klasse Medium der Anzahl an gespeicherten Medien neu setzten da dieses ja nicht mehr mit der neu gelesenen Liste übereinsimmt
        Medium.setMediumCount(this.getMedien().size());
    }

    public List<Medium> getMedien() {
        return medien;
    }

    public void setMedien(ArrayList<Medium> medien) {
        this.medien = medien;
    }

    public Iterator<Medium> iterator()
    {
        return medien.iterator();
    }

}
