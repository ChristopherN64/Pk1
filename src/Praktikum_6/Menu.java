package Praktikum_6;

import Praktikum_6.Exceptions.CancelException;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    private Medienverwaltung mv;
    private final int iMaxMenu=9;

    public Menu()
    {
        this.mv = new Medienverwaltung();
    }
    public void showMenu() throws Exception
    {
        boolean run=true;
        Scanner sc = new Scanner(System.in);
        int iWahl;
        while(run) {
            System.out.print("\n\n\nMedienverwaltung \n\n1. Audio Aufnehemn\n2. Bild aufnehmen\n3. Zeige alle Medien\n4. Medienliste in Datei schreiben\n5. Zeige neues Medium\n6. Berechne Durchschnittliches Erscheinungsjahr\n7. Medien Speichern\n8. Medien Laden\n9. Beenden\n\nBitte Menupunkt wählen:");
            iWahl = sc.nextInt();
            if(iWahl<1 || iWahl>iMaxMenu) throw new Exception("Fehler beiWahl");
                switch (iWahl) {
                    //Audio Aufnehem
                    case 1:
                        readAudio();
                        break;
                    //Bild aufnehmen
                    case 2:
                        readBild();
                        break;
                    //Medien Ausgeben
                    case 3:
                        mv.zeigeMedien();
                        break;
                    //Medien in Datei ausgeben
                    case 4:
                        mv.writeMedien();
                        break;
                    //Neustes Medium ausgeben
                    case 5:
                        mv.sucheNeuesMedium();
                        break;
                    //Durchschnittliches Erscheinungsjahr ausgeben
                    case 6:
                        System.out.println("Durchschnittliches Erscheinungsjahr:" + mv.berechneErscheinungsjahr());
                        break;
                    //Medien speichern
                    case 7:
                        mv.saveMedien();
                        break;
                    //Medien Laden
                    case 8:
                        mv.loadMedien();
                        break;
                    //Programm beenden
                    case 9:
                        run = false;
                        break;
                }
            }
        }


    public void readAudio()
    {
        String sTitel,sInterpret;
        int iDauer, iJahr;
        try {
            sTitel = getString("Titel");
            iJahr= getInt("Erscheinungsjahr");
            sInterpret = getString("Interpret");
            iDauer=getInt("Dauer");
            mv.aufnehmen(new Audio(sTitel, iJahr, sInterpret, iDauer));
        }
        catch (CancelException e)
        {
            JOptionPane.showMessageDialog(null,"Die Medienaufnahne wurde abgebrochen!");
        }
    }

    public void readBild()
    {
        String sOrt,sTitel;
        int iJahr;
        try {
            sTitel=getString("Titel");
            sOrt=getString("Ort");
            iJahr=getInt("Erscheinungsjahr");
            mv.aufnehmen(new Bild(sTitel, iJahr, sOrt));
        }
        catch (CancelException e)
        {
            JOptionPane.showMessageDialog(null,"Die Medienaufnahne wurde abgebrochen!");
        }

    }



    public int getInt(String sName) throws CancelException
    {
        int iTemp=0;
        while(true)
        {
            try{
                String sInput =JOptionPane.showInputDialog(sName);
                if(sInput==null) throw new CancelException();
                iTemp=Integer.parseInt(sInput);
                break;
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Bitte gültige "+sName+" angeben!");
            }
        }
        return iTemp;
    }

    private String getString(String sName) throws CancelException
    {
        String sTemp = JOptionPane.showInputDialog(sName);
        if(sTemp==null) throw new CancelException();
        return sTemp;
    }
}
