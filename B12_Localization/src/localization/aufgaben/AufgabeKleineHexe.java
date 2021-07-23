package localization.aufgaben;

/**
 * 
 * Führen Sie internationalization und localization in diesem Programm durch.
 *
 * Bitte pflegen Sie eine localization in de und einer Sprache ihrer wahl ein.
 */
public class AufgabeKleineHexe {

	public static void main(String[] args) {
		littleWitchSays();
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