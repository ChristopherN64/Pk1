package Praktikum_10.Aufgabe_1;

public class Timer implements Runnable {
    private TimerListener timerListener;

    public Timer(TimerListener timerListener)
    {
        this.timerListener=timerListener;
    }

    public void run()
    {
        boolean run = true;
        while(run)
        {
            if(Thread.currentThread().isInterrupted())
            {
                System.out.println("Thread Interrupt sbevor ausgabe");
                run= false;
            }
            else {
                timerListener.signalPerformed();
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupt in Sleep");
                run = false;

            }
        }

    }
}
