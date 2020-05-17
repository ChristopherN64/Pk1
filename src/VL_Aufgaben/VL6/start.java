package VL_Aufgaben.VL6;

import java.io.*;

public class start {

    public static void main(String[] args) {
        boolean write=true;

        //Objekt Serialisieren

        if(write) {
            Kunde k = new Kunde("Nieder", 20000);
            k.druckeDaten();

            File file = new File("C:\\Users\\style\\Desktop\\ser.txt");
            try (FileOutputStream fos = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(k);
                System.out.println("Objekt geschrieben");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            //Objekt Deserialisieren
            Kunde k;
            File file = new File("C:\\Users\\style\\Desktop\\ser.txt");
            try(FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis))
            {
                k= (Kunde)ois.readObject();
                k.druckeDaten();
                System.out.println("Objekt gelesen");
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
            catch (ClassNotFoundException cnfe)
            {
                System.out.println("Klasse nicht gefunden!");
            }
        }
    }




}
