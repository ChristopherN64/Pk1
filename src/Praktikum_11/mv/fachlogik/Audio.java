package Praktikum_11.mv.fachlogik;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Objects;

public class Audio extends Medium implements Serializable {
	private static final long serialVersionUID = -729034045372955890L;
	private String interpert;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer)
	{
		super(titel,jahr);
		this.interpert=interpret;
		this.dauer=dauer;
	}

	public Audio()
	{
		super("",0);
		this.interpert="";
		this.dauer=0;
	}


	public String getInterpert() {
		return interpert;
	}

	public void setInterpert(String interpert) {
		this.interpert = interpert;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	@Override
	public void druckeDaten(OutputStream stream)
    {
        PrintStream ps = new PrintStream(stream);
        ps.printf("ID = %d   %s von %s aus Spieldauer: %d sec \n",super.getId(),super.getTitel(),this.interpert,this.dauer);
	}

	@Override
	public String toString()
	{
		return super.toString()+" von "+this.interpert+" Spieldauer: "+this.dauer;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(super.getTitel(),super.getJahr(),this.interpert,this.dauer);
	}

}
