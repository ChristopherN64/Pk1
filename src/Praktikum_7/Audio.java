package Praktikum_7;

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

	@Override
	public void druckeDaten(OutputStream stream)
    {
        PrintStream ps = new PrintStream(stream);
        ps.printf("ID = %d   %s von %s aus Spieldauer: %d sec \n",super.getId(),super.getTitel(),this.interpert,this.dauer);
	}

	
	

	@Override
	public int hashCode()
	{
		return Objects.hash(super.getTitel(),super.getJahr(),this.interpert,this.dauer);
	}
	
	/*
	@Override
	public boolean equals(Object obj)
	{
		if(super.equals(obj))
		{
			//Typenconvetierung
			Praktikum_1.Audio aTemp;
			aTemp = (Praktikum_1.Audio)obj;
			
			//Vergleich der Variablenwerte
			if(this.hashCode()==aTemp.hashCode())
				return true;
			else
				return false;
		}
		else
		{
			return false;
		}
					
	}
	*/
		
}
