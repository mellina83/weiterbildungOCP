package localization.aufgaben.ml;

import java.util.ListResourceBundle;

public class Hexe_de extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { 
				{ "clockRow", " Klasse: Morgens fr�h um " }, 
				{ "6", "kommt die kleine Hex." },
				{ "7", "schabt sie gelbe R�ben." }, 
				{ "8", "wird Kaffe gemacht." }, 
				{ "9", "geht sie in die Scheun." },
				{ "10", "hackt sie Holz und Sp�n'." }, 
				{ "11", "Feuert an um 11,\nkocht sie bis um 12." },
				{ "12", "Fr�schebein und Krebs und Fisch.\nHurtig Kinder kommt zu Tisch" },
				{ "defaultText", "Kleene Hexe ist jefallen inne Ofen, nun m�ssen wir ne neue koofen" } };
	}

}
