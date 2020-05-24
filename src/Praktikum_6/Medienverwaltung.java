package Praktikum_6;

import Praktikum_6.Exceptions.CancelException;
import Praktikum_6.Exceptions.EmptyFilenameException;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Medienverwaltung {

    private ArrayList<Medium> medien;
    private static final String saveFile = "C:\\Users\\style\\OneDrive\\Studium\\Semester 2\\Programmierkurs 1\\Praktikum\\PraktikumProject\\src\\Praktikum_6\\MedienDatei";

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

    public void writeMedien()
    {
        Collections.sort(medien);
        File file;

        //Dateiname solange einlesen bis er gültig ist
        while(true)
        {
            try
            {
                file=readFile();
                //bei Gültigem Dateinanemn werden die Medien geschrieben
                try (OutputStream os = new FileOutputStream(file))
                {
                    for(Medium mTemp : medien)
                    {
                        mTemp.druckeDaten(os);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            catch(CancelException ce)
            {
                System.out.println("Abbruch der Ausgabe wegen CancelExeption");
                return;
            }
            catch(EmptyFilenameException ee)
            {
                int iWahl = JOptionPane.showConfirmDialog(null,"Der Dateiname darf nicht leer sein, wollen sie einen neuen Eingeben?","Eingabefehler",JOptionPane.YES_NO_OPTION);
                //Wenn der User Nein wählt wird abgebrochen
                if(iWahl==1)
                {
                    System.out.println("Abbruch der Ausgabe wegen leerem Namen");
                    return;
                }
            }
            catch (Exception e) { System.out.println(e.getMessage()); }
        }
    }

    public void sucheNeuesMedium()
    {
        Collections.sort(medien);
        System.out.println();
        System.out.print("Jüngstes Medium:  ");
        OutputStream os = new PrintStream(System.out);
        medien.get(medien.size()-1).druckeDaten(os);
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

    public void saveMedien()
    {
        File file = new File(saveFile);
        try(
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            oos.writeObject(medien);
            System.out.println("Medien Erfolgreich gespeichert");
        }
        catch (Exception e)
        {
            System.out.println("Fehler: "+e.getMessage());
        }
    }

    public void loadMedien()
    {
        File file = new File(saveFile);
        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            )
        {
            medien=(ArrayList<Medium>)ois.readObject();
            System.out.println("Medien Erfolgreich geladen");
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IOException: "+e.getMessage());
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class Not Foubd: "+e.getMessage());
            e.printStackTrace();
        }
    }

}
