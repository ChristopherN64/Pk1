package Praktikum_8.mv.fachlogik;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Medium implements Comparable<Medium>, Serializable {
	private static final long serialVersionUID = -729034045372955790L;
	private static int mediumCount =0;



	private int id=0;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr)
	{
		this.id=mediumCount;
		mediumCount++;
		
		this.titel=titel;
		this.jahr=jahr;
	}
	
	public int alter()
	{
		LocalDate now = LocalDate.now();
		now.getYear();
		return now.getYear()-this.jahr;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getJahr()
	{
		return this.jahr;
	}
	
	public String getTitel()
	{
		return titel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.titel,this.jahr);
	}
	
	public boolean equals(Object obj)
	{
		//Vergleich der Refferenz
		if(this == obj)
		{
			return true;
		}
		//Pr�fen auf Nullrefferenz
		else if(obj == null)
		{
			return false;
		}
		
		else
		{
			//Typenconvetierung
			Medium mTemp;
			if(this.getClass()==obj.getClass())
			{
				mTemp = (Medium)obj;
			}
			else
			{
				return false;
			}
			
			//Vergleich der Variablenwerte
			if(this.hashCode()==mTemp.hashCode())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public abstract void druckeDaten(OutputStream stream);

	@Override
	public int compareTo(Medium o) {
		return Integer.compare(this.jahr,o.getJahr());
	}

	@Override
	public String toString()
	{
		return "ID = "+this.id+" Titel: "+this.titel+" Aus dem Jahre: "+this.jahr;
	}
}
