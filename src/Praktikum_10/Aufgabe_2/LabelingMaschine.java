package Praktikum_10.Aufgabe_2;

public class LabelingMaschine implements Runnable {
    private Converyor converyor;
    private int iGeschwindigkeit;

    public LabelingMaschine(Converyor c, int iGeschwindigkeit)
    {
        this.iGeschwindigkeit=iGeschwindigkeit;
        this.converyor=c;
    }


    @Override
    public void run() {
        while (true)
        {
            synchronized(converyor)
            {
                if(!converyor.isEmpty())
                {
                    System.out.print("Etikettiere: ");
                    converyor.withdraw().printLable();
                    converyor.notifyAll();
                }
                else
                {
                    try {
                        System.out.println("Förderband leer - Warte auf Flasche");
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
