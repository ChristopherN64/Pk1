package Praktikum_7;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Objects;

public class Bild extends Medium implements Serializable {
	private static final long serialVersionUID = -729034045372955690L;
	private String ort;
	
	public Bild(String titel, int jahr, String ort)
	{
		super(titel,jahr);
		this.ort=ort;
	}

	@Override
	public void druckeDaten(OutputStream stream) {
		PrintStream ps = new PrintStream(stream);
		ps.printf("ID = %d   %s aufgenommen im Jahr %d Ort: %s\n",super.getId(),super.getTitel(),super.getJahr(),this.ort);
	}
	
	

	@Override
	public int hashCode()
	{
		return Objects.hash(super.getTitel(),super.getJahr(),this.ort);
	}
	/*
	
	@Override
	
	
	public boolean equals(Object obj)
	{
		if(super.equals(obj))
		{
			
			Praktikum_1.Bild bTemp;
			bTemp = (Praktikum_1.Bild)obj;
			//Vergleich der Variablenwerte
			if(this.hashCode()==bTemp.hashCode())
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
