package VL_Aufgaben.VL10;

public class Auto {
    private String hersteller;
    private int baujahr;

    public Auto(String hersteller,int baujahr)
    {
        this.hersteller=hersteller;
        this.baujahr=baujahr;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public int alter()
    {
        return 2020-this.baujahr;
    }
}
