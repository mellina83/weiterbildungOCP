package localization.aufgaben;

import java.util.Locale;

/**
 * Aufgabe 'Localization'
 * 
 * Bitte erzeugen Sie einen Kalenderausgabe für die Sprachen de und en.
 * 
 * Die Sprachspezifischen ausgaben sollen aus einer Resourcendatei gelesen werden.
 * 
 * Falls die Sprache 'de' im default-Locale gesetzt wurde, ermittelt die
 * main-Methode das aktuelle Datum und erzeugt folgende Ausgaben:
 * 
 * Heute ist 5. September 2015. Es ist Samstag.
 * 
 * > In dem Beispiel wurde die main am 5. September 2015 ausgeführt.
 * 
 * Falls eine andere Sprache im default-Locale gesetzt wurde, liefert die main
 * in englisch verfassten Texte:
 * 
 * Today is September 5, 2015. It's Saturday.
 * 
 * Wahlweise setzen Sie die l10n in einer weiteren Ihnen geläufigen Sprache um.
 * 
 * Testen Sie die ausgaben mit unterschiedlichen Default Locales Einstellungen.
 * 
 * > Tipp: > Folgender Formatter kann den Wochentagnamen eines Datum-Objektes
 * formatieren: > DateTimeFormatter fmt = DateTimeFormatter.ofPattern("eeee");
 *
 */
public class AufgabeUserCalender {
	
	public static void main(String[] args) {
		Locale defaultLocale = Locale.getDefault();
		//defaultLocale.setDefault(Locale.GERMAN);
		//defaultLocale.setDefault(Locale.US);
	}
}
