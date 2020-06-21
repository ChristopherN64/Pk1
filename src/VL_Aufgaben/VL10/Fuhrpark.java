package VL_Aufgaben.VL10;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Fuhrpark {
    private List<Auto> garage = new LinkedList<Auto>();
    Stream<Auto> autoStream;

    public Fuhrpark()
    {
        this.garage.add(new Auto("Audi",2012));
        this.garage.add(new Auto("Audi",2018));
        this.garage.add(new Auto("Audi",2018));

        this.garage.add(new Auto("Mercedes",2020));
        this.garage.add(new Auto("Mercedes",2018));

        this.garage.add(new Auto("Tesla",2018));
        this.autoStream = garage.stream();
    }

    public boolean istHerstellerVorhanden(String hersteller)
    {
        return  autoStream.anyMatch((Auto auto)->auto.getHersteller().equals(hersteller));
    }

    public Auto neustesBaujahr(String hersteller)
    {
        autoStream=autoStream.filter((auto)->auto.getHersteller().equals(hersteller));
        autoStream=autoStream.sorted((a,b)->-1*Integer.compare(a.getBaujahr(),b.getBaujahr()));
        Optional<Auto> a= autoStream.findFirst();
        if(a.isPresent())
        {
            return a.get();
        }
        else return null;
    }

    public void druckeAutosMitBaujahr(int baujahr,int n)
    {
        autoStream=autoStream.filter((auto) -> auto.getBaujahr()==baujahr);
        autoStream.limit(n).forEach((auto)->System.out.println(auto.getHersteller()));
    }
}
