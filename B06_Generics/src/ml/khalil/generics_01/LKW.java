package ml.khalil.generics_01;

public class LKW extends Fahrzeug {
	private boolean zustand;
	private int num;

	public boolean isZustand() {
		return zustand;
	}

	public void setZustand(boolean zustand) {
		this.zustand = zustand;
	}

	public LKW(boolean zustand,int n) {
		super(zustand,n);
		this.zustand = zustand;
		this.num=n;
	}

	@Override
	public String toString() {
		return "LKW [zustand=" + zustand + ", num=" + num + "]";
	}

	
}
