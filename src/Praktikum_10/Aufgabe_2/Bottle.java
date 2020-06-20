package Praktikum_10.Aufgabe_2;

public class Bottle {
    private Lable lable;

    public Bottle(Lable lb)
    {
        this.lable=lb;
    }

    public void printLable()
    {
        System.out.println(lable.getType()+" Ablaufdatum "+lable.getBestBefore());
    }
}
