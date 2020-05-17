package VL_Aufgaben.VL6;

import java.io.Serializable;

public class Konto implements Serializable
{
    private double guthaben;

    public Konto(double ghb)
    {
        this.guthaben=ghb;
    }

    public double getGuthaben()
    {
        return this.guthaben;
    }

}
