package ml.novytska.Aufgabe15_3;

public class TestCDListe {

	public static void main(String[] args) {
		CDListe liste = new CDListe ("Klassik", 3);
		liste.listeAnzeigen();
		liste.cdHinzufuegen ("Zauberflöte", "Mozart", 2003);
		liste.cdHinzufuegen ("Nussknacker", "Tschaikowsky", 2001);
		liste.listeAnzeigen();
		liste.cdHinzufuegen ("Für Elise", "Beethoven", 1990);
		liste.listeAnzeigen();
	}

}
