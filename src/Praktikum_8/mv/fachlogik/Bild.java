package Praktikum_8.mv.fachlogik;

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

	public Bild()
	{
		super("",0);
		this.ort="";
	}


	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
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

	@Override
	public String toString()
	{
		return super.toString()+" Ort: "+this.getOrt();
	}

}
