package aufgaben.loesungen;

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
public class Aufgabe02_Count_Min_MaxML {

	public static void main(String[] args) {

		Locale[] locales = Locale.getAvailableLocales();
		Stream.of(locales).forEach(loc -> System.out.println(loc.getDisplayCountry()));
		Stream.of(locales).forEach(loc -> System.out.println(loc.getLanguage()));

		System.out.println("---A1----------");
		/**
		 * Bilden Sie eine Stream-Pipeline, die das `Locale` mit dem lexicographisch
		 * gr��ten Wert findet, den man mit der Methode `getDisplayCountry` bekommt.
		 */
		Comparator<Locale> compareMaxLocale = (loc1, loc2) -> {
			return loc1.getDisplayCountry().compareTo(loc2.getDisplayCountry());
		};
		Comparator<String> compareString = String::compareTo;

//		Optional<Locale> optLoc = Stream.of(locales).max(compareMaxLocale);
//		optLoc.ifPresent(l-> System.out.println(l.getDisplayCountry()));

		Function<Locale, String> mapper = Locale::getDisplayCountry;
//		Function<Locale,String> mapper = (loc) -> loc.getDisplayCountry();

//		Stream.of(locales) 						//Stream<Locale>
//			  .map(mapper) 		    			//Stream<Locale> -> Stream<String>
//			  .sorted(compareString.reversed()) //127 Eintr�ge -> 127 Descending Sortiert Eintr�ge
//			  .limit(1)
//			  .forEach(System.out::println);

		Stream.of(locales).map(mapper).filter(str -> !str.isEmpty()).max(String::compareTo)
				.ifPresent(System.out::println);

		System.out.println("---A2----------");
		/**
		 * Bilden Sie eine Stream-Pipeline, die die Anzal der Array-Elementen ermittelt,
		 * die als Sprache 'de' haben ("de" mit der Methode `getLanguage` liefern).
		 */
		long count = Stream.of(locales).map(loc -> loc.getLanguage()).filter(str -> str.equals("de")).count();

		System.out.println("Anzahl der Elemente mit 'de' : " + count);

		System.out.println("---A3----------");
		aufgabe03();
	}

	/**
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
//		List<Locale> filtered = new ArrayList<>();
//		for (Locale locale : locales) {
//			if (locale.getDisplayCountry().contains("t")) {
//				filtered.add(locale);
//			}
//		}
//
//		Comparator<Locale> cmp = (loc1, loc2) -> loc1.getDisplayLanguage()
//				.compareTo(loc2.getDisplayLanguage());
//
//		filtered.sort(cmp);
//
//		if (filtered.size() > 0) {
//			Locale min = filtered.get(0);
//			System.out.println(min.getDisplayCountry());
//			System.out.println(min.getDisplayLanguage());
//		}
		// B

		/**
		 * diese Elemente absteigend nach dem Display-Language sortiert (lexikographisch
		 * nach dem Wert aus `getDisplayLanguage`)
		 */
		Comparator<Locale> cmp = (loc1, loc2) -> loc1.getDisplayLanguage()
				.compareTo(loc2.getDisplayLanguage());
		/**
		 * nur die Elemente ber�cksichtigt, die in dem Display-Country ein 't' haben (in
		 * dem Wert aus der Methode `getDisplayCountry`)
		 */
		Predicate<Locale> filter = (loc) -> loc.getDisplayCountry().contains("t");

		/**
		 * Display-Country und Display-Language f�r das kleinste Element (falls
		 * vorhanden) ausgibt
		 */
		Consumer<Locale> action = loc -> System.out
				.println(loc.getDisplayCountry() + " : " + loc.getDisplayLanguage());

		Optional<Locale> optLoc = Stream.of(locales)
										.filter(filter)
										.min(cmp);		//Stream closed -> Optional<Locale>
			
		optLoc.ifPresent(action);
	}
}
