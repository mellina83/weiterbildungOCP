package ml.novytska.Aufgabe15_4;

public class Apfel implements Obst {
	int anzahl;
	String obstname = "Apfel";

	Apfel(int anzahl) {
		this.anzahl = anzahl;
	}

	public int getAnzahl() {
		return anzahl;

	}

	public String getObstname() {
		return obstname;
	}

}



