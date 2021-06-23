package ml.mauerbach.generics.aufgaben.aufgabe_01;

public abstract class Fahrzeug {
	private boolean dreckig;
	public boolean isDreckig() {return dreckig;}
	public void setDreckig(boolean dreckig){this.dreckig = dreckig;}
	@Override public String toString() {
		return super.toString() + ", dreckig="+dreckig;
	}
}
