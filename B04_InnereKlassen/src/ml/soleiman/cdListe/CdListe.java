package ml.soleiman.cdListe;

import java.util.ArrayList;
import java.util.List;

public class CdListe {
	private int maxAnzahl;
	private String archivTitel;
	private List<Cd> l1;

	public CdListe(String archivTitel, int maxAnzahl) {
		this.archivTitel = archivTitel;
		this.maxAnzahl = maxAnzahl;
		l1 = new ArrayList<>();
	}

	public void cdHinzufuegen(String cdTitel, String kuenstler, int jahr) {
		if (this.getMaxAnzahl() == l1.size()) {
			System.out.println("Archiv ist voll, bitte neue Liste anlegen!");
		} else {
			Cd neu = new Cd(cdTitel, kuenstler, jahr);
			for (Cd cd : l1) {
				if (cd.equals(neu)) return;
				
//				if(cd.cdTitel == cdTitel) return;
			}
			l1.add(neu);
		}
	}

	private int getMaxAnzahl() {
		return maxAnzahl;
	}

	private void setMaxAnzahl(int maxAnzahl) {
		this.maxAnzahl = maxAnzahl;
	}

	public void listeAnzeigen() {
		System.out.println("Archivtitel: " + this.archivTitel);
		System.out.println("Archivgröße: " + this.maxAnzahl);
		System.out.println("-------------------------------");
		for (Cd cd : l1) {
			System.out.println(cd);
		}
	}

	private class Cd {
		private String cdTitel;
		private String kuenstler;
		private int jahr;

		Cd(String cdTitel, String kuenstler, int jahr) {
			this.cdTitel = cdTitel;
			this.kuenstler = kuenstler;
			this.jahr = jahr;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cd tmp = (Cd)obj;
			return this.cdTitel.equals(tmp.cdTitel) && this.kuenstler.equals(tmp.kuenstler) && this.jahr == tmp.jahr;		
		}
		
		@Override
		public String toString() {
			return "Titel: " + cdTitel + ",	Künstler: " + kuenstler + ",	Jahr: " + jahr;
		}
	}
}
