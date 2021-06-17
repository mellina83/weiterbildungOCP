package ml.Duerbeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Realisieren Sie bitte einen String-Comparator, der die Strings
 * aus dem Array nach ihren L�ngen vergleicht und sortiert:
 * 
 * 1. mit einer anonymen Klasse
 * 2. mit Lambda-Funktionen (bitte alle Notationen ausprobieren, die kompilieren)
 * 
 * 
 * Hinweis: Verwenden Sie bitte das Interface Comparator
 */

public class StringComparatorTest {

	public static void main(String[] args) {
		String[] arr = { "achtzehnbuchstaben", "dry", "vier", "1", "fuenf", "neunzehn Buchstaben", };

		// Zuerst in ArrayListe "umwandeln"
		List<String> stringliste = new ArrayList<>(Arrays.asList(arr));
		List<String> stringliste2 = new ArrayList<>(Arrays.asList(arr));

		// Mit Lambda
		System.out.println("Mit Lambda:");
		Comparator<String> stringcomparator = (String s01, String s02) -> {
			if (s01.length() < s02.length()) {
				return -1;
			} else if (s01.length() == s02.length()) {
				return 0;
			} else {
				return 1;
			}
		};

		stringliste.sort(stringcomparator);

		for (String string : stringliste) {
			System.out.println(string);
		}
		
		System.out.println();
		
		// Mit anonymer innerer Klasse
		System.out.println("Mit anonymer innerer Klasse:");
		sortierenMitAnonymerKlasse(stringliste2);
		
		for (String string : stringliste2) {
			System.out.println(string);		}

	}

	private static void sortierenMitAnonymerKlasse(List<String> sliste) {
		Comparator comparatorMitAnonym = new Comparator() {
			
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String)o1;
				String s2 = (String)o2;
			
				if (s1.length() < s2.length()) {
					return -1;
				} else if (s1.length() == s2.length()) {
					return 0;
				} else {
					return 1;
			}
		};
	};
}
}


