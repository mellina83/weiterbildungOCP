package ml.khalil.Elementklasse;

public class TestCdListe {
	public static void main (String[] args)
	{
	CdListe liste = new CdListe ("Klassik", 3);
	liste.listeAnzeigen();
	liste.cdHinzufuegen ("Zauberfl�te", "Mozart", 2003);
	liste.cdHinzufuegen ("Nussknacker", "Tschaikowsky", 2001);
	liste.listeAnzeigen();
	liste.cdHinzufuegen ("F�r Elise", "Beethoven", 1990);
	liste.listeAnzeigen();
	}
}
