package ml.soleiman.cdListe;

public class TestCdListe {
	public static void main(String[] args) {
		CdListe liste = new CdListe("Klassik", 3);

		liste.cdHinzufuegen("Zauberfl�te", "Mozart", 2003);
		liste.cdHinzufuegen("Zauberfl�te", "Mozart", 2003);
		liste.cdHinzufuegen("Zauberfl�te", "Mozart", 2003);
		liste.cdHinzufuegen("Nussknacker", "Tschaikowsky", 2001);
		liste.cdHinzufuegen("Nussknacker", "Tschaikowsky", 2001);
		liste.cdHinzufuegen("Nussknacker", "Tschaikowsky", 2001);
		liste.cdHinzufuegen(new String("Nussknacker"), "Tschaikowsky", 2001);
		
		liste.cdHinzufuegen("F�r Elise", "Beethoven", 1990);
//		liste.cdHinzufuegen("F�r Elise", "Beethoven", 1990);

		liste.listeAnzeigen();


		
	}
}