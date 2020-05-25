package Praktikum_6;

import java.io.IOException;
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
		String sTemp = "ID = "+super.getId() +" "+super.getTitel() +" aufgenommen im Jahr "+super.getJahr()+" in " +this.ort+"\n";
		if(stream instanceof PrintStream)
		{
			((PrintStream) stream).printf("ID = %d   %s aufgenommen im Jahr %d Ort: %s\n",super.getId(),super.getTitel(),super.getJahr(),this.ort);
		}
		else
		{
			try {
				stream.write(sTemp.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
