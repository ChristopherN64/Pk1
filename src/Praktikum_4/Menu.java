package Praktikum_4;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    private Medienverwaltung mv;

    public Menu()
    {
        this.mv = new Medienverwaltung();
    }
    public void showMenu()
    {
        boolean run=true;
        Scanner sc = new Scanner(System.in);
        int iWahl;
        while(run) {
            System.out.print("\n\n\nMedienverwaltung \n\n1. Audio Aufnehemn\n2. Bild aufnehmen\n3. Zeige alle Medien\n4. Zeige neues Medium\n5. Berechne Durchschnittliches Erscheinungsjahr\n6. Beenden\n\nBitte Menupunkt wählen:");
            iWahl = sc.nextInt();

                switch (iWahl) {
                    //Audio Aufnehem
                    case 1:
                        readAudio();
                        break;
                    case 2:
                        readBild();
                        break;
                    case 3:
                        mv.zeigeMedien();
                        break;
                    case 4:
                        mv.sucheNeuesMedium();
                        break;
                    case 5:
                        System.out.println("Durchschnittliches Erscheinungsjahr:" + mv.berechneErscheinungsjahr());
                        break;
                    case 6:
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
            sTitel = getTitel();
            iJahr= getErscheinungsjahr();
            sInterpret = getInterpret();
            iDauer=getDauer();
            mv.aufnehmen(new Audio(sTitel, iJahr, sInterpret, iDauer));
        }
        catch (Exception e)
        {
            if(e.getMessage().equals("Abbruch")) JOptionPane.showMessageDialog(null,"Die Medienaufnahne wurde abgebrochen!");
        }
    }

    public void readBild()
    {
        String sOrt,sTitel;
        int iJahr;
        try {
            sTitel=getTitel();
            sOrt=getOrt();
            iJahr=getErscheinungsjahr();
            mv.aufnehmen(new Bild(sTitel, iJahr, sOrt));
        }
        catch (Exception e)
        {
            if(e.getMessage().equals("Abbruch")) JOptionPane.showMessageDialog(null,"Die Medienaufnahne wurde abgebrochen!");
        }

    }


    public int getErscheinungsjahr() throws Exception
    {
        int iJahr=0;
        String sInput =JOptionPane.showInputDialog("Jahr:");
        if(sInput==null) throw new Exception("Abbruch");
        try
        {
            iJahr = Integer.parseInt(sInput);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Bitte gültiges Erscheinungsjahr angeben!");
            throw new Exception("Abbruch");
        }
        return iJahr;
    }


    public int getDauer() throws Exception
    {
        int iDauer=0;
        String sInput =JOptionPane.showInputDialog("Dauer");
        if(sInput==null) throw new Exception("Abbruch");
        try{
            iDauer=Integer.parseInt(sInput);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Bitte gültige Dauer angeben!");
            throw new Exception("Abbruch");
        }
        return iDauer;
    }

    public String getTitel() throws Exception
    {
        String sTitel = JOptionPane.showInputDialog("Titel");
        if(sTitel==null) throw new Exception("Abbruch");
        return sTitel;
    }

    public  String getOrt() throws Exception
    {
        String sOrt = JOptionPane.showInputDialog("Ort:");
        if(sOrt==null) throw new Exception("Abbruch");
        return sOrt;
    }

    public  String getInterpret() throws Exception
    {
        String sInterpret = JOptionPane.showInputDialog("Interpret:");
        if(sInterpret==null) throw new Exception("Abbruch");
        return sInterpret;
    }





}
