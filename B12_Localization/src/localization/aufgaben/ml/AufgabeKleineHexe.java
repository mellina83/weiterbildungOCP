package localization.aufgaben.ml;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * Führen Sie internationalization und localization in diesem Programm durch.
 *
 * Bitte pflegen Sie eine localization in de und einer Sprache ihrer wahl ein.
 */
public class AufgabeKleineHexe {

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
//		littleWitchSays();
		littleWitchSaysWithLocale(Locale.GERMAN);
		System.out.println("----------------------------");
		littleWitchSaysWithLocale(Locale.ENGLISH);
		
	}

	private static void littleWitchSaysWithLocale(Locale locale) {

		ResourceBundle textbundle = ResourceBundle.getBundle("localization.aufgaben.ml.Hexe", locale);

		final String MORGEN = textbundle.getString("clockRow");
		String output = "";

//		for (int i = 6; i < 13; i++) {
//			System.out.println(textbundle.getString(i +""));
//		}
//		Enumeration<String> alleKeys = textbundle.getKeys();

//		while (alleKeys.hasMoreElements()) {
//			String key = (String) alleKeys.nextElement();
//			System.out.println(key);
////			System.out.println("" + key + " : " + textbundle.getString(key));
//		}

		for (int clock = 6; clock <= 12; clock++) {
			output = MORGEN + clock;
			switch (clock) {
			case 6: {
				output += textbundle.getString("6");
				break;
			}
			case 7: {
				output += textbundle.getString("7");
				break;
			}
			case 8: {
				output += textbundle.getString("8");
				;
				break;
			}
			case 9: {
				output += textbundle.getString("9");
				;
				break;
			}
			case 10: {
				output += textbundle.getString("10");
				break;
			}
			case 11: {
				output = textbundle.getString("11");
				break;
			}
			case 12: {
				output = textbundle.getString("12");
				break;
			}
			default: {
				output = textbundle.getString("defaultText");
				break;
			}
			}
			System.out.println(output);
		}
	}

	public static void littleWitchSays() {
		final String MORGEN = "Morgens früh um ";
		String output = "";

		for (int clock = 6; clock <= 12; clock++) {
			
			output = MORGEN + clock;
			
			switch (clock) {
			case 6: {
				output += "\nkommt die kleine Hex.";
				break;
			}
			case 7: {
				output += "\nschabt sie gelbe Rüben.";
				break;
			}
			case 8: {
				output += "\nwird Kaffe gemacht.";
				break;
			}
			case 9: {
				output += "\ngeht sie in die Scheun.";
				break;
			}
			case 10: {
				output += "\nhackt sie Holz und Spän'.";
				break;
			}
			case 11: {
				output = "Feuert an um 11,\nkocht sie bis um 12.";
				break;
			}
			case 12: {
				output = "Fröschebein und Krebs und Fisch.\nHurtig Kinder kommt zu Tisch";
				break;
			}
			default: {
				output = "Kleene Hexe ist jefallen inne Ofen, nun müssen wir ne neue koofen";
				break;
			}
			}
			System.out.println(output);
		}
	}
}