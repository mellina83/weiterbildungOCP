package pak06_komposition;

import java.util.ArrayList;

public class Kurs {
	private ArrayList<Thema> themen;
	
	public Kurs() {
		themen = new ArrayList<Thema>();
	}
	/*
	 * Beim Hinzufuegen geben wir lediglich eine Information zu dem
	 * zu erzeugenen Teil der Komposition mit.
	 */
	public void addThema(int nr) {
		themen.add(new Thema(nr));
	}
	
	/*
	 * Es wird nur eine Kopie herausgegeben. Womit die Komposition ihre
	 * Aussage behaelt, wenn das Ganze geloescht wird, werden auch die Teile geloescht.
	 */	
	public Thema getThema() {
		Thema neuesThema = new Thema(2);
		neuesThema.themenNr = themen.get(themen.size() -1).themenNr;
		return neuesThema;
	}
	
	public Thema getThemaKeineKomposition() {			
		return themen.get(themen.size() -1);
	}
	
	public static void main(String[] args) {
		Kurs k = new Kurs();
		k.addThema(1);
		k.addThema(2);
		
		Thema t = k.getThemaKeineKomposition();
		System.out.println(t == k.getThemaKeineKomposition());
		
		Thema t2 = k.getThema();
		System.out.println(t2 == k.getThema());
		

	}
}
