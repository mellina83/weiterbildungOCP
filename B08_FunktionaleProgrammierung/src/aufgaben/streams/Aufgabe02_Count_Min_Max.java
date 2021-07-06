package aufgaben.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @A01 Gegeben ist ein `java.util.Locale` Array:
 * 
 *      Locale[] locales = Locale.getAvailableLocales();
 * 
 *      Bilden Sie eine Stream-Pipeline, die das `Locale` mit dem
 *      lexicographisch größten Wert findet, den man mit der Methode
 *      `getDisplayCountry` bekommt.
 * 
 * @A02 Gegeben ist ein `java.util.Locale` Array:
 * 
 *      Locale[] locales = Locale.getAvailableLocales();
 * 
 *      Bilden Sie eine Stream-Pipeline, die die Anzal der Array-Elementen
 *      ermittelt, die als Sprache 'de' haben ("de" mit der Methode
 *      `getLanguage` liefern).
 * 
 * @A03 Siehe methode aufgabe03
 *
 */
public class Aufgabe02_Count_Min_Max {

	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		Stream.of(locales).forEach(loc -> System.out.println(loc.getDisplayCountry()));
		Stream.of(locales).forEach(loc -> System.out.println(loc.getLanguage()));
//		aufgabe03();
	}

	/**
	 * Bilden Sie eine Stream-Pipeline, die die Zeilen zwischen A und B ersetzt,
	 * also
	 * 
	 * - nur die Elemente berücksichtigt, die in dem Display-Country ein 't' haben
	 * (in dem Wert aus der Methode `getDisplayCountry`)
	 * 
	 * - diese Elemente absteigend nach dem Display-Language sortiert
	 * (lexikographisch nach dem Wert aus `getDisplayLanguage`)
	 * 
	 * - Display-Country und Display-Language für das kleinste Element (falls
	 * vorhanden) ausgibt
	 */
	public static void aufgabe03() {
		// Gegeben ist ein `java.util.Locale` Array:
		Locale[] locales = Locale.getAvailableLocales();

		// A
		List<Locale> filtered = new ArrayList<>();
		for (Locale locale : locales) {
			if (locale.getDisplayCountry().contains("t")) {
				filtered.add(locale);
			}
		}

		Comparator<Locale> cmp = (loc1, loc2) -> loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());

		filtered.sort(cmp);

		if (filtered.size() > 0) {
			Locale min = filtered.get(0);
			System.out.println(min.getDisplayCountry());
			System.out.println(min.getDisplayLanguage());
		}
		// B
	}
}
