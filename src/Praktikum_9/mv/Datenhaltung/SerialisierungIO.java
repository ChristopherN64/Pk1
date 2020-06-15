package Praktikum_9.mv.Datenhaltung;

import Praktikum_9.mv.fachlogik.Medium;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisierungIO implements IDao {

    private String file;

    public SerialisierungIO(String f)
    {
        this.file = f;
    }

    @Override
    //Funktion speichert die Übergebene Liste Serialisiert in dem Dateipfad des IO Objekts
    public void speichern(List<Medium> liste) throws PersistenzException {
        java.io.File file = new File(this.file);                        //Neues File Objekt mit Pfad des SerIO Objektes erzeugen
        try(
                //Output Streams zum Serialisieren und in Datei Schreiben öffnen und verknüpfen
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            //Übergebene Liste in Datei Serialisieren
            oos.writeObject(liste);
            System.out.println("Medien Erfolgreich gespeichert");
        }
        catch (Exception e)
        {
            throw new PersistenzException("Fehler: "+e.getMessage());
        }
    }

    @Override
    //Funktion lädt und Deserialisiert die Liste aus der Datei des IO Objekts und gibt diese Zurück
    public List<Medium> laden() throws PersistenzException {
        File file = new File(this.file);                              //Neues File Objekt mit Pfad des SerIO Objektes erzeugen
        ArrayList<Medium> geladeneListe;

        try(
                //Input Streams zum Deserialisieren und aus Datei lesen öffnen und verknüpfen
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {
            //Geöffnete Datei Deserialisieren und die Daraus gelesene Liste zurückgeben
            System.out.println("Medien geladen");
            geladeneListe = (ArrayList<Medium>)ois.readObject();
            return geladeneListe;
        }

        catch (FileNotFoundException e) {
            throw new PersistenzException("FileNotFound "+e.getMessage());
        }
        catch (IOException e) {
            throw new PersistenzException("IOException "+e.getMessage());
        }
        catch (ClassNotFoundException e) {
            throw new PersistenzException("Class Not Found "+e.getMessage());
        }
    }
}
