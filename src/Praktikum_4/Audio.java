package Praktikum_4;

import java.util.Objects;

public class Audio extends Medium {
	private String interpert;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer)
	{
		super(titel,jahr);
		this.interpert=interpret;
		this.dauer=dauer;
		
	}

	@Override
	public void druckeDaten() {
		System.out.println("ID = "+super.getId() +"  "+super.getTitel() +" von "+this.interpert+" aus "+super.getJahr()+" Spieldauer: "+this.dauer+" sek.");
		
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
