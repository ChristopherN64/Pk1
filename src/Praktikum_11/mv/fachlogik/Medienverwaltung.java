package Praktikum_11.mv.fachlogik;

import Praktikum_11.mv.Datenhaltung.IDao;
import Praktikum_11.mv.Datenhaltung.InDateiIO;
import Praktikum_11.mv.Datenhaltung.PersistenzException;
import Praktikum_11.mv.Datenhaltung.SerialisierungIO;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Medienverwaltung {

    private ArrayList<Medium> medien;
    private static final String file = "C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_11\\MedienDatei";
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

    public void zeigeMedien(OutputStream stream) {
        //Ausgeben aller Medien im medien array über den Standard System.out
        medien.forEach((mTemp)->mTemp.druckeDaten(new PrintStream(stream)));
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
        this.zeigeMedien(System.out);
    }
    public void speichernInDatei(String file) throws PersistenzException
    {
        datenIO = new InDateiIO(file);
        datenIO.speichern(this.getMedien());
        this.zeigeMedien(System.out);
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
