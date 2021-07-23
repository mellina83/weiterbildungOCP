package localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo05_RessourceBundle {
	
	/*
	 * Fake Leerzeichen
	 * alt + 255 auf Numpad
	 */
	
	
	public static void main(String[] args) {
		String message = "Hello World";

		/*
		 * Resource bundles contain locale-specific objects. When your program needs
		 * a locale-specific resource, a String for example, your program can load it from
		 * the resource bundle that is appropriate for the current user's locale. In this
		 * way, you can write program code that is largely independent of the user's
		 * locale isolating most, if not all, of the locale-specific information in
		 * resource bundles.
		 */
//		Locale.setDefault(Locale.US);
		
		String bundle = "localization/MyAppText";
		ResourceBundle textBundle = ResourceBundle.getBundle(bundle);
		
		message = textBundle.getString("welcome-msg");
		System.out.println(message);
		
		message = textBundle.getString("farewell-msg");
		System.out.println(message);
		
		/*
		 * Ist ein Key in der lokalisierten Datei nicht vorhanden,
		 * wird der Fallback Text genommen.
		 */
		message = textBundle.getString("msg01");
		System.out.println(message);
		/*
		 * Ist ein Key nur in der lokalisierten Datei vorhanden,
		 * nicht aber in der Fallbackdatei, wird eine 
		 * java.util.MissingResourceException geworfen
		 */
		message = textBundle.getString("msg02");
		System.out.println(message);
		
		
		System.out.println("---------------------");
		
		Locale locale = new Locale("hu", "HU");
		textBundle = ResourceBundle.getBundle(bundle, locale);
		
		message = textBundle.getString("welcome-msg");
		System.out.println(message);
		
		message = textBundle.getString("farewell-msg");
		System.out.println(message);
		
		message = textBundle.getString("msg01");
		System.out.println(message);
		
		message = textBundle.getString("msg02");
		System.out.println(message);
		
		System.out.println("Programmende");

	}
}
