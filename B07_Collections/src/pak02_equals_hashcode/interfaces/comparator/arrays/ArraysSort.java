package pak02_equals_hashcode.interfaces.comparator.arrays;

import java.util.Arrays;
import java.util.Comparator;

import pak02_equals_hashcode.interfaces.Artikel;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachAlles;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachArtNr;
import pak02_equals_hashcode.interfaces.comparator.CompareArtikelNachName;

public class ArraysSort {
	public static void main(String[] args) {
		CompareArtikelNachName coName = new CompareArtikelNachName();
		CompareArtikelNachArtNr coArtNr = new CompareArtikelNachArtNr();
		CompareArtikelNachAlles coAlles = new CompareArtikelNachAlles();
		
		demoArraysSort(coArtNr);
		System.out.println("\n++++++++++++++++++\n");
		demoArraysSort((o1,o2)-> o1.getArtNr().compareTo(o2.getArtNr()));
		System.out.println("\n++++++++++++++++++\n");
		demoArraysSort(coName);
		System.out.println("\n++++++++++++++++++\n");
		demoArraysSort(coAlles);
		
	}

	public static void demoArraysSort(Comparator<Artikel> comp) {
		Artikel[] arr = new Artikel[5];

		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring");
		Artikel e = new Artikel("1003", "Artikel 1003");
		
		arr[0] = c;
		arr[1] = d;
		arr[2] = a;
		arr[3] = b;
		arr[4] = e;

		Arrays.stream(arr).forEach(System.out::println);
		
		Arrays.sort(arr, comp);
		System.out.println("---------------------------");
		Arrays.stream(arr).forEach(System.out::println);

	}
}
