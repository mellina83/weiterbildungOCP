package z_lokalisierung_Zusammenfassung;

import java.time.Duration;
import java.time.LocalDate;

/*
 * Locales, Properties Files, and Resource Bundles
		(OCP 12.1, 12.2, and 12.3)
		
	- The java.util.Properties class gives you a convenient way to create
	and maintain text files that are external to your applications and can hold
	configuration values.
	
	- A file that is java.util.Properties�compliant and has a name
		that ends with a locale and a suffix of .properties can be used by
		ResourceBundle.getBundle().
		
	- A ListResourceBundle comes from Java classes, and a
		PropertyResourceBundle comes from .properties files.
		
	- ResourceBundle.getBundle(name)uses the default Locale.
	
	- Locale.getDefault()returns the JVM's default Locale. Locale.setDefault(locale) can change the JVM's locale.
	
	- Java searches for resource bundles in this order: requested language/country,
		requested language, default locale language/country, default locale language,
		default bundle. Within each item, Java ListResourceBundle is favored
		over PropertyResourceBundle.
		
	- Once a ResourceBundle is found, only parents of that bundle can be used
		to look up keys.	
 */
public class Lokalisierung {
public static void main(String[] args) {

}
}
