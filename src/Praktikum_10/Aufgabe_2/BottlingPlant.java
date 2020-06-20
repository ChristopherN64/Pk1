package Praktikum_10.Aufgabe_2;

public class BottlingPlant implements Runnable {
    private Converyor converyor;
    private int iGeschwindigkeit;
    public BottlingPlant(Converyor c, int iGeschwindigkeit)
    {
        this.iGeschwindigkeit=iGeschwindigkeit;
        this.converyor=c;
    }

    public void run() {
        //Befüllen
        while (true)
        {
            synchronized(converyor)
            {
                if(!converyor.isOverloaded())
                {
                    converyor.load(new Bottle(new Lable("Bier ",2021)));
                    converyor.notifyAll();
                    System.out.println("Neue Flasche Abgefüllt");
                }
                else
                {
                    try {
                        System.out.println("Förderband voll - Warte auf freien Platz");
                        converyor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            try {
                Thread.currentThread().sleep(iGeschwindigkeit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
