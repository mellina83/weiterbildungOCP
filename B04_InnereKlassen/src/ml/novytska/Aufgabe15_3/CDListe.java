package ml.novytska.Aufgabe15_3;

import java.util.ArrayList;
import java.util.List;

public class CDListe {
	
	String archivTitel;
	int maxAnzahl;
	List<CD> liste = new ArrayList<>();
		
	public CDListe(String archivTitel, int maxAnzahl) {
		super();
		this.archivTitel = archivTitel;
		this.maxAnzahl = maxAnzahl;
	}
	public void cdHinzufuegen (String cdTitel, String kuenstler, int jahr) {
		CD cd = new CD(cdTitel, kuenstler, jahr);
		liste.add(cd);
	}
	public void listeAnzeigen() {
		for(CD cd : liste) {
			System.out.println(cd);
		}
		System.out.println("-----------------------------------------");
	}
	
	class CD {
		String cdTitel;
		String kuenstler;
		int jahr;
	
		CD(String cdTitel, String kuenstler, int jahr) {
			this.cdTitel = cdTitel;
			this.kuenstler = kuenstler;
			this.jahr = jahr;

		}

		public String toString() {
			String str = "CD: " + cdTitel + " " + kuenstler + " " + jahr;
			return str;
		}

	}

}
