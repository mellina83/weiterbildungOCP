package pak02.ueberladung;

public class DemoUeberladung {
	/*
	 * Ueberladung von Methoden
	 * Der Methodenname kann mehrfach verwendet werden, wenn
	 * die Argumente sich in Art, Reihenfolge und/oder Anzahl
	 * unterscheiden.
	 * 
	 * Beim Ueberladen darf der Rueckgabetyp geaendert werden.
	 * 
	 */
	public static void main(String[] args) {
		go();
		go(1);

	}

	static void go() {
		System.out.println("go noarg");
	}

	static void go(int i) {
		System.out.println("go onearg");
	}

	static void go(int zahl, String s) {

	}

	static void go(String s, int zahl) {

	}

	static int go(int i, int i1) {
		System.out.println("go onearg");
		return 5;
	}
}
