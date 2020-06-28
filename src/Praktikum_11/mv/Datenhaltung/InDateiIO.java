package Praktikum_11.mv.Datenhaltung;

import Praktikum_11.mv.fachlogik.Medium;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class InDateiIO implements IDao {
    private String file;

    public InDateiIO(String f)
    {
        this.file=f;
    }

    @Override
    public void speichern(List<Medium> liste) throws PersistenzException {
        System.out.println("Versuche Medienliste in Datei zu schreiben");
        try (OutputStream os = new FileOutputStream(file))
        {
            for(Medium mTemp : liste)
            {
                mTemp.druckeDaten(os);
            }
        }
        catch (Exception e) {
           throw new PersistenzException(e.getMessage());
        }
    }

    @Override
    public List<Medium> laden() throws PersistenzException {
        return null;
    }
}
