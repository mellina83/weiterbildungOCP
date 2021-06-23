package ml.novytska.Aufgabe_01_Generic;

public class Fahrzeuge {
	private String name;
	private int rad;
	private double gewicht;
	private boolean dreckig;
	
	public boolean isDreckig() {
		
		return dreckig;
	}

	public void setDreckig(boolean dreckig) {
		this.dreckig = dreckig;
	}

	public Fahrzeuge(String name, int rad, double gewicht, boolean dreckig) {
		this.name = name;
		this.rad = rad;
		this.gewicht = gewicht;
		this.dreckig = dreckig;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double volume) {
		this.gewicht = volume;
	}

}
