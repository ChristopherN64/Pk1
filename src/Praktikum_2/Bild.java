package Praktikum_2;

import java.util.Objects;

public class Bild extends Medium {
	private String ort;
	
	public Bild(String titel, int jahr, String ort)
	{
		super(titel,jahr);
		this.ort=ort;
	}

	@Override
	public void druckeDaten() {
		// TODO Auto-generated method stub
		System.out.println("ID = "+super.getId() +" "+super.getTitel() +" aufgenommen im Jahr "+super.getJahr()+" in " +this.ort);
		
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
