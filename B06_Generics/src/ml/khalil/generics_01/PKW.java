package ml.khalil.generics_01;

public class PKW extends Fahrzeug {
	private boolean zustand;
	private int num;

	public PKW(boolean zustand,int n) {
		super(zustand,n);
		this.zustand = zustand;
		this.num=n;
	}

	@Override
	public String toString() {
		return "PKW [zustand=" + zustand + ", num=" + num + "]";
	}

	public boolean isZustand() {
		return zustand;
	}

	public void setZustand(boolean zustand) {
		this.zustand = zustand;
	}

}
