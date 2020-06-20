package Praktikum_10.Aufgabe_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Converyor {

    private Queue<Bottle> queue;

    public Converyor()
    {
        queue=new LinkedList<Bottle>();
    }

    public void load(Bottle b)
    {
        queue.add(b);
    }

    public Bottle withdraw()
    {
        return queue.remove();
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public boolean isOverloaded()
    {
        if(queue.size()>=3)
        {
            return true;
        }
        else return false;
    }

}

