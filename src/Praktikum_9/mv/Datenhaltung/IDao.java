package Praktikum_9.mv.Datenhaltung;

import Praktikum_9.mv.fachlogik.Medium;

import java.util.List;

public interface IDao {
    void speichern(List<Medium> liste) throws PersistenzException;
    List<Medium> laden() throws PersistenzException;
}
