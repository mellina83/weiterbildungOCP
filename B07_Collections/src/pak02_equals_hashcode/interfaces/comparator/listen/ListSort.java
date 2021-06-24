package pak02_equals_hashcode.interfaces.comparator.listen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pak02_equals_hashcode.interfaces.Artikel;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachAlles;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachArtNr;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachName;

public class ListSort {
	public static void main(String[] args) {
		CompareArtikelNachArtNr compArt = new CompareArtikelNachArtNr();
		CompareArtikelNachName compName =  new CompareArtikelNachName();
		CompareArtikelNachAlles compAlles = new CompareArtikelNachAlles();
		
		demoListSort01(compArt);
		System.out.println("\n+++\n");
		demoListSort01(compName);
		System.out.println("\n+++\n");
		demoListSort01(compAlles);
	}
	
	public static void demoListSort01(Comparator<Artikel> comparator) {
		List<Artikel> lArtikel = new ArrayList<Artikel>();
		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring 5x25");
		
		lArtikel.add(c);
		lArtikel.add(d);
		lArtikel.add(a);
		lArtikel.add(b);
		
		lArtikel.forEach(System.out::println);
		
		Collections.sort(lArtikel, comparator);
		
		lArtikel.forEach(System.out::println);
	}
}
