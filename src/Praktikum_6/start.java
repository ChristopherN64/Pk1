package Praktikum_6;

import javax.swing.*;

public class start {

    public static void main(String[] args) {
        Menu menu = new Menu();
        while(true) {
            try {
                menu.showMenu();
                break;
            } catch (Exception e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Bitte wählen sie einen Menuepunkt von 1 bis 6 aus!");
            }
        }
    }

}
