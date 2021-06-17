package ml.khalil.Elementklasse;

import java.util.ArrayList;

public class CdListe {
	ArrayList<CdListe.Cd> list=new ArrayList<CdListe.Cd>();
	String archivTitel;
	int maxAnzahl;
	
	public CdListe (String archivTitel, int maxAnzahl) {
		this.archivTitel=archivTitel;
		this.maxAnzahl=maxAnzahl;
	}
	
	public void cdHinzufuegen (String cdTitel, String kuenstler,
	int jahr) {
		 list.add(new Cd(cdTitel,kuenstler,jahr));
	 }
	 public void listeAnzeigen() {
		 list.forEach(System.out::println);}
     
	 class Cd{
		 String cdTitel;
		 String kuenstler;
		 int jahr;
	 Cd (String cdTitel, String kuenstler, int jahr){
		 this.cdTitel=cdTitel;
		 this.kuenstler=kuenstler;
		 this.jahr=jahr;
	 }
	public String toString() {
		return "Titel: "+cdTitel+"  künstler: "+kuenstler+"  Jahr:"+jahr;}
}
}
