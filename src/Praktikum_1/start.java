package Praktikum_1;

public class start {

	public static void main(String[] args) {
		
		Audio a = new Audio("it Means Nothing",2007,"Stereophonics",229);
		Audio a2 = new Audio("it Means Nothing",2007,"Stereophonics",229);
		Bild b = new Bild("Geb�ude Fb Informatik",2019,"Dortmund");
		Bild b2 = new Bild("Geb�ude Fb Informatik",2019,"M�nster");
		
		a.druckeDaten();
		b.druckeDaten();
		System.out.println(a.alter());
		
		System.out.println(a.equals(a2));
		System.out.println(a.hashCode()+"   "+a2.hashCode());
		System.out.println(b.equals(b2));
		System.out.println(b.hashCode()+"   "+b2.hashCode());
		
		
	
	}

}
