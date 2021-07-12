package ml.meineLoesungen;


/**
 * @A01 Folgende Liste existiert:
 * 
 *      List<Produkt> warenkorb = new ArrayList<>();
 *      warenkorb.add(new Produkt("Brot", 129));
 *      warenkorb.add(new Produkt("Wurst", 230));
 *      warenkorb.add(new Produkt("Milch", 99));
 *      warenkorb.add(new Produkt("Milch", 99));
 * 
 *      Definieren Sie eine Pipeline, die den Gesamtpreis aller Produkte im
 *      Warenkorb ermittelt. Geben Sie das Ergebnis aus.
 * 
 * @A02 Folgende Liste existiert:
 * 
 *      List<Bestellung> bestellungen = new ArrayList<>();
 * 
 *      bestellungen.add(new Bestellung("Brot", 3));
 *      bestellungen.add(new Bestellung("Wurst", 1));
 *      bestellungen.add(new Bestellung("Milch", 2));
 * 
 *      Definieren Sie eine Methode `buildWarenkorb`, die eine Liste der
 *      Bestellungen erh�lt und damit mithilfe einer Pipeline die Liste mit den
 *      bestellten Produkten erstellt:
 * 
 *      Die Preise f�r die zu erzeugende Produkte darf die Methode
 *      `buildWarenkorb` selbst (frei) bestimmen.
 * 
 * @Optional Die Preise f�r die zu erzeugende Produkte sucht die Methode
 *           `buildWarenkorb` in einer vordefinierten Map, wo jedem Produktnamen
 *           der Produktpreis zugeordnet wurde.
 */

/**
 * Gegeben sind folgende Klassen: Bitte je nach Bedarf erweitern.
 *
 */

class Produkt {
	private String name;
	private int preis;

	// Konstruktoren und Methoden hier, wenn n�tig...
}

class Bestellung {
	private String produktName;
	private int anzahl; // gew�nschte Anzahl der Produkt-Objekte

	// Konstruktoren und Methoden hier, wenn n�tig...
}

public class AufgabeStreams_06_Collect_Map_Warenkorb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
