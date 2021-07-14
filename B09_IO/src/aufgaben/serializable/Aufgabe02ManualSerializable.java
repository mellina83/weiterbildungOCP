package aufgaben.serializable;

import java.io.Serializable;

/**
 * Erweitern Sie die Klasse Getriebe:
 * 
 * Erstellen Sie alle n�tigen Methoden, ohne die Klasse Zahnrad anzupassen, um
 * die Klasse Getriebe zu serialisieren.
 * 
 *
 * Bitte einmal Manuell Serialisieren und dann von der Klasse wieder
 * Deserialisieren lassen
 * 
 * @Bonus Die Objekte mit JSON Serialisieren und Deserialisieren.
 *
 */
public class Aufgabe02ManualSerializable {

	/**
	 * Die Klasse Zahnrad darf nicht mit implements java.io.Serializable versehen
	 * werden und soll auch sonst unver�ndert bleiben.
	 *
	 */
	static class Zahnrad {
		int zaehne;

		@Override
		public String toString() {
			return "Zahnrad [zaehne=" + zaehne + "]";
		}

	}

	/**
	 * Diese Klasse d�rfen Sie anpassen, so wie es ben�tigt wird.
	 * 
	 * Jedoch nicht die Attribute entfernen.....:)
	 */
	static class Getriebe implements Serializable {
		public Zahnrad klein;
		public Zahnrad mittel;
		public Zahnrad gross;

	}

	public static void main(String[] args) {

	}

}
