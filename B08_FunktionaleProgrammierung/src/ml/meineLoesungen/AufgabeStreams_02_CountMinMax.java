package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @A01 Gegeben ist ein `java.util.Locale` Array:
 * 
 *      Locale[] locales = Locale.getAvailableLocales();
 * 
 *      Bilden Sie eine Stream-Pipeline, die das `Locale` mit dem
 *      lexicographisch gr��ten Wert findet, den man mit der Methode
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
public class AufgabeStreams_02_CountMinMax {

	public static void main(String[] args) {
		
		//Aufgabe01
		Locale[] locales = Locale.getAvailableLocales();
//		Stream.of(locales).forEach(loc -> System.out.println(loc.getDisplayCountry()));
		
		//Loesung
		System.out.println("Aufgabe 1, letztes Land in Locale[] :");
		Function<Locale,String> mapper = Locale::getDisplayCountry;
		
		Stream.of(locales)		//Stream<Locale>
				.map(mapper)	//Stream<Locale> -> Stream<String>
				.filter(str -> !str.isEmpty())
				.max(String::compareTo)
				.ifPresent(System.out::println);;
		
		/* Das gleiche, nur mit expliziter Uebergabe an Optional:
		Optional<Locale> optLoc = Stream.of(locales).max(compareMaxLocale);
		optLoc.ifPresent(l->System.out.println(l.getDisplayCountry()));
		*/		
				
		/*Eine andere Moeglichkeit:
		Comparator<String> compareString = String::compareTo;
		Stream.of(locales)		//Stream<Locale>
				.map(mapper)	//Stream<Locale> -> Stream<String>
				.sorted(compareString.reversed())	//127 Eintraege -> 127 Sortierte Eintraege
				.limit(1)
				.forEach(System.out::println);
		*/	
		
		/*Meine Loesung
		Consumer<Locale> displayCountry = loc -> System.out.println(loc.getDisplayCountry());
		Comparator<Locale> maxLocale = (l2, l1) -> l1.getDisplayCountry().compareTo(l2.getDisplayCountry());
		Stream.of(locales).sorted(maxLocale).limit(1).forEach(displayCountry);
		*/
		
		//Aufgabe02
//		Stream.of(locales).forEach(loc -> System.out.println(loc.getLanguage()));
		
		//Loesung
		System.out.println("\nAufgabe 2, alle Laender, die deutschsprachig sind :");
		
		long count = Stream.of(locales)
							.map(loc-> loc.getLanguage())
							.filter(str -> str.equalsIgnoreCase("de"))
							.count();
		System.out.println("Anzahl der Elemente mit 'de' : " + count);
		
		
		//Meine Loesung ist falsch, weil nicht gezaehlt:
		//Stream.of(locales).filter(germanLanguageCountries).filter(displayCountryWithEntry).forEach(displayCountry);
		
		aufgabe03();
	}
	


	/**
	 * Aufgabe 03
	 * Bilden Sie eine Stream-Pipeline, die die Zeilen zwischen A und B ersetzt,
	 * also
	 * 
	 * - nur die Elemente ber�cksichtigt, die in dem Display-Country ein 't' haben
	 * (in dem Wert aus der Methode `getDisplayCountry`)
	 * 
	 * - diese Elemente absteigend nach dem Display-Language sortiert
	 * (lexikographisch nach dem Wert aus `getDisplayLanguage`)
	 * 
	 * - Display-Country und Display-Language f�r das kleinste Element (falls
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
		
		//Loesung
		System.out.println("\nAufgabe 3 :");
		Predicate<Locale> countriesWithLetterT = p1 -> p1.getDisplayCountry().contains("t");
		Comparator<Locale> minLanguage = (l1, l2) -> l1.getDisplayLanguage().compareTo(l2.getDisplayLanguage());
		Consumer<Locale> displayCountryAndLanguage = loc -> System.out.println(loc.getDisplayCountry() + ": " + loc.getDisplayLanguage());
		
		Stream.of(locales)
				.filter(countriesWithLetterT)
				.min(minLanguage)
				.ifPresent(displayCountryAndLanguage);
		
		/* Das gleiche, nur mit vorheriger Uebergabe an Optional:
		 * Optional<Locale> optLoc = Stream.of(locales)
		 *								.filter(filter)
		 *								.min(cmp);		//Stream closed -> Optional<Locale>	
		 * optLoc.ifPresent(action);
		 */
		
		//Meine Loesung:
		//Stream.of(locales).filter(countriesWithLetterT).sorted(minLanguage).limit(1).forEach(displayCountryAndLanguage);
	}
}
