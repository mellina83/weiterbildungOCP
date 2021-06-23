package ml.soleiman;

public abstract class Fahrzeug {

	private int id;
	private static int zaehler=1;
	private boolean dreckig;

	Fahrzeug(boolean dreckig) {
		this.setId(zaehler++);
		this.setDreckig(dreckig);
	}

	public boolean isDreckig() {
		return dreckig;
	}

	public void setDreckig(boolean dreckig) {
		this.dreckig = dreckig;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		String str="";
		str += this.getClass().getSimpleName();
		str += getId();
		str += " Zustand: " + (dreckig?"Dreckig":"Sauber");
		return str;
	}
}



