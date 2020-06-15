package Praktikum_9.mv.fachlogik;

import Praktikum_9.Exceptions.CancelException;
import Praktikum_9.Exceptions.EmptyFilenameException;
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

    public File readFile() throws EmptyFilenameException, CancelException, Exception
    {
        String sDatei = JOptionPane.showInputDialog("Bitte geben sie den Pfad für die Datei an!");
        if(sDatei==null)
        {
            throw new CancelException("Abbruch");
        }
        else if(sDatei.isEmpty())
        {
            throw new EmptyFilenameException("Leerer File Name");
        }
        File file = new File(sDatei);
        if(file.isFile())
        {
            return file;
        }
        else throw new Exception("Fehler beim zugriff auf File");
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
