package ml.khalil.generics_01;

public class Fahrzeug {
private boolean zustand;
int num;

public boolean isZustand() {
	return zustand;
}

public void setZustand(boolean zustand) {
	this.zustand = zustand;
}

public Fahrzeug(boolean zustand,int n) {
	super();
	this.zustand = zustand;
	this.num=n;
}


}
