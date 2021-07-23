package localization;

import java.util.ResourceBundle;

public class Demo07_ResourceBundle_Suchreihenfolge {
	public static void main(String[] args) {
		String basename = "localization.locals.Labels";
		
		ResourceBundle bundle = ResourceBundle.getBundle(basename);
		
		/**
		 * default Locale = de_DE
		 * 
		 * Suchreihenfolge von ResourceBundle -> de_DE -> de -> default(Fallback)
		 * 
		 * Es wird immer zuerst nach Klasse dann nach Properties gesucht.
		 * 
		 * - Nach einer Klasse localization.locals.Labels_de_De suchen
		 * - Nach einer Datei localization.locals.Labels_de_De suchen
		 * 
		 * - Nach einer Klasse localization.locals.Labels_de suchen
		 * - Nach einer Datei localization.locals.Labels_de suchen
		 * 
		 * - Nach einer Klasse localization.locals.Labels suchen
		 * - Nach einer Datei localization.locals.Labels suchen
		 */		
		String labeltext = bundle.getString("center-label");
		System.out.println(labeltext + " : [44,55]");
	}
}
