package pak02_equals_hashcode.interfaces.comparable.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pak02_equals_hashcode.interfaces.Artikel;

public class ListSort {
	public static void main(String[] args) {
		demoListSort();
	}

	private static void demoListSort() {
		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring");
		
		List<Artikel> lArtikel = new ArrayList<>();
		
		lArtikel.add(d);
		lArtikel.add(b);
		lArtikel.add(a);
		lArtikel.add(c);
		
		lArtikel.stream().forEach(System.out::println);
		System.out.println("--------------------");
		/*
		 * Kompilerfehler, wenn der generische Typ der Liste nicht vom
		 * Typ Comparable ist
		 */
//		Collections.sort(lArtikel);
		lArtikel.stream().forEach(System.out::println);
		
	}
}
