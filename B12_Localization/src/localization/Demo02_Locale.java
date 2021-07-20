package localization;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * https://de.wikipedia.org/wiki/Liste_der_ISO-639-2-Codes
 * 
 * https://www.oracle.com/java/technologies/javase/jdk8-jre8-suported-locales.html
 */

public class Demo02_Locale {
	public static void main(String[] args) {
		// Gets the current value of the default locale for this instanceof the Java
		// Virtual Machine.
		Locale defaultLocale = Locale.getDefault();

		System.out.println(defaultLocale);
		System.out.println("default country: " + defaultLocale.getCountry());
		System.out.println("default language: " + defaultLocale.getLanguage());
		
		Locale.setDefault(new Locale("en", "GB"));
		defaultLocale = Locale.getDefault();

		System.out.println(defaultLocale);
		System.out.println("default country: " + defaultLocale.getCountry());
		System.out.println("default language: " + defaultLocale.getLanguage());

		/**
		 * Wie erzeugen wir Locale Instanzen
		 * 
		 * @Konstanten verwenden.
		 * 
		 *             Locale.US;
		 * 
		 *             Locale.CANADA;
		 * 
		 *             Locale.CANADA_FRENCH;
		 *             
		 * @Konstruktor verwenden
		 * 
		 *              new Locale(String language)
		 * 
		 *              new Locale(String language, String country)
		 * 
		 * @Local.Builder verwenden
		 * 
		 *                Locale.Builder builder = new Locale.Builder();
		 * 
		 *                builder.setLanguage("ru").setRegion("RU").build();
		 * 
		 */

		Locale german = Locale.GERMAN;
		System.out.println(german);
		Locale germany = Locale.GERMANY;
		System.out.println(germany);

		Locale locUS = Locale.US;
		Locale locCa = Locale.CANADA;
		Locale locFrCa = Locale.CANADA_FRENCH;

		Locale newLoc_01 = new Locale("ger");
		Locale newLoc_02 = new Locale("de", "DE");
		Locale newLoc_03 = new Locale("hu", "HU");

		System.out.println("----");
		System.out.println("newLoc_01 country: " + newLoc_01.getCountry());
		System.out.println("newLoc_01 language: " + newLoc_01.getLanguage());
		System.out.println("newLoc_01 Display country: " + newLoc_01.getDisplayCountry());
		System.out.println("newLoc_01 Display language: " + newLoc_01.getDisplayLanguage());
		System.out.println("----");
		System.out.println("newLoc_02 country: " + newLoc_02.getCountry());
		System.out.println("newLoc_02 language: " + newLoc_02.getLanguage());
		System.out.println("newLoc_02 Display country: " + newLoc_02.getDisplayCountry());
		System.out.println("newLoc_02 Display language: " + newLoc_02.getDisplayLanguage());
		System.out.println("----");
		System.out.println("newLoc_03 country: " + newLoc_03.getCountry());
		System.out.println("newLoc_03 language: " + newLoc_03.getLanguage());
		System.out.println("newLoc_03 Display country: " + newLoc_03.getDisplayCountry());
		System.out.println("newLoc_03 Display language: " + newLoc_03.getDisplayLanguage());

		System.out.println("------------ alle Locales: ");
		int index = 1;
		for (Locale loc : Locale.getAvailableLocales()) {
			System.out.printf("%03d. | %30s | %30s | %6s %n", index++, loc.getDisplayCountry(),
					loc.getDisplayLanguage(), loc);
		}

		// Konstanten nutzen
		System.out.println("------------");
		System.out.println(
				DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.GERMAN).format(LocalDate.now()));

		// Konstruktor nutzen
		Locale loc1 = new Locale("ru", "RU");
		System.out.println("------------");
		System.out
				.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(loc1).format(LocalDate.now()));

		// Mit dem Builder erzeugen
		Locale.Builder builder = new Locale.Builder();
		Locale loc2 = builder.setLanguage("en").setRegion("GB").build();

		System.out.println("------------");
		System.out
				.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(loc2).format(LocalDate.now()));
	}
}
