package ml.Duerbeck;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe03Elementklasse {

	public static void main(String[] args) {
		CDListe liste = new CDListe ("Klassik", 3);
		liste.listeAnzeigen();
		
		liste.cdHinzufuegen("Zauberfloete", "Mozart", 2003);
		liste.cdHinzufuegen ("Nussknacker", "Tschaikowsky", 2001);
		liste.listeAnzeigen();
		liste.cdHinzufuegen ("Für Elise", "Beethoven", 1990);
		liste.listeAnzeigen();
	}
}

class CDListe {
	String archivTitel;
	int maxAnzahl;
	List<CD> cdliste;
	
	public String getArchivTitel() {
		return archivTitel;
	}
	public void setArchivTitel(String archivTitel) {
		this.archivTitel = archivTitel;
	}
	public int getMaxAnzahl() {
		return maxAnzahl;
	}
	public void setMaxAnzahl(int maxAnzahl) {
		this.maxAnzahl = maxAnzahl;
	}
	public CDListe(String archivTitel, int maxAnzahl) {
		this.setArchivTitel(archivTitel);
		this.setMaxAnzahl(maxAnzahl);
		cdliste = new ArrayList<>();
	}
	
	public void cdHinzufuegen(String cdTitel, String kuenstler, int jahr) {
		cdliste.add(new CD(cdTitel, kuenstler, jahr));
	}
	
	public void listeAnzeigen() {
		for(CD cd : cdliste){
			System.out.println(cd);
		}
	}
	
	class CD {
		
		String cdTitel;
		String kuenstler;
		int jahr;
		
		public String getCdTitel() {
			return cdTitel;
		}
		public void setCdTitel(String cdTitel) {
			this.cdTitel = cdTitel;
		}
		public String getKuenstler() {
			return kuenstler;
		}
		public void setKuenstler(String kuenstler) {
			this.kuenstler = kuenstler;
		}
		public int getJahr() {
			return jahr;
		}
		public void setJahr(int jahr) {
			this.jahr = jahr;
		}
		
		public CD(String cdTitel, String kuenstler, int jahr) {
			this.setCdTitel(cdTitel);
			this.setKuenstler(kuenstler);
			this.setJahr(jahr);
		}
		
		@Override
		public String toString() {
			return getCdTitel() + " " + getKuenstler() + " " + getJahr();
		}

	}
	
}
