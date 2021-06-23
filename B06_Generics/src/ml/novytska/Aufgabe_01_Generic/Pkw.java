package ml.novytska.Aufgabe_01_Generic;

public class Pkw extends Fahrzeuge{
	
	public Pkw(String name, int rad, double gewicht, boolean dreckig) {
		super(name, rad, gewicht, dreckig);
		
	}
	@Override
	public String toString() {
		return "Pkw [name=" + getName() + "]";
	}
	

}
