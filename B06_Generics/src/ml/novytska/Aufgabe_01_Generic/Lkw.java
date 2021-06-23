package ml.novytska.Aufgabe_01_Generic;

public class Lkw extends Fahrzeuge{

	
	public Lkw(String name, int rad, double gewicht, boolean dreckig) {
		super(name, rad, gewicht, dreckig);
		
	}

	@Override
	public String toString() {
		return "Lkw [name=" + getName()  + "]";
	}

	

}
