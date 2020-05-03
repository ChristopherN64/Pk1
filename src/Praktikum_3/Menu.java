package Praktikum_3;

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
        while(run)
        {
            System.out.print("\n\n\nMedienverwaltung \n\n1. Audio Aufnehemn\n2. Bild aufnehmen\n3. Zeige alle Medien\n4. Zeige neues Medium\n5. Berechne Durchschnittliches Erscheinungsjahr\n6. Beenden\n\nBitte Menupunkt wählen:");
            iWahl=sc.nextInt();
            switch(iWahl)
            {
                //Audio Aufnehem
                case 1:
                    System.out.println("Audio");
                    String sTitel = JOptionPane.showInputDialog("Titel");
                    int iJahr= Integer.parseInt(JOptionPane.showInputDialog("Jahr:"));
                    String sInterpret = JOptionPane.showInputDialog("Interpret:");
                    int iDauer = Integer.parseInt(JOptionPane.showInputDialog("Dauer"));
                    mv.aufnehmen(new Audio(sTitel,iJahr,sInterpret,iDauer));
                    break;
                case 2:
                    String sTitelB = JOptionPane.showInputDialog("Titel");
                    int iJahrB = Integer.parseInt(JOptionPane.showInputDialog("Jahr:"));
                    String sOrt = JOptionPane.showInputDialog("Ort");
                    mv.aufnehmen(new Bild(sTitelB,iJahrB,sOrt));
                    break;
                case 3:
                    mv.zeigeMedien();
                    break;
                case 4:
                    mv.sucheNeuesMedium();
                    break;
                case 5:
                    System.out.println("Durchschnittliches Erscheinungsjahr:"+mv.berechneErscheinungsjahr());
                    break;
                case 6:
                    run=false;
                    break;

            }
        }
    }

}
