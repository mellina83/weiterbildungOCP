package aufgaben.streams;

import java.util.Optional;

/**
 * @A1 Realisieren Sie bitte die Klasse `Person`. Jede Person hat einen Vornamen
 *     und einen Nachnamen. Speichern Sie bitte in einer List folgende Personen:
 * 
 *     <Mick Berger> <Henry Valerie> <Samuel Summierer> <Dieter Etwas>
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) größten Vornamen und Nachnamen aus
 *     allen Personen erhält (hier: Samuel Valerie).
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) kleinsten Vornamen und Nachnamen aus
 *     allen Personen erhält (hier: Dieter Berger).
 *
 * @A2 Realisieren Sie bitte die Klasse `TextStatistics`, die den an den
 *     Konstruktor übergebenen Text analysieren kann:
 * 
 *     Um die Wörter in dem Text zu finden, dürfen Sie zur Vereinfachung davon
 *     ausgehen, dass die einzelnen Wörter voneinander mit Leerzeichen getrennt
 *     werden und andere Sonderzeichen beinhalten können (oder komplett aus
 *     Sonderzeichen bestehen können).
 * 
 *     Dann wird folgende Zeile ein Array aus einzelnen Wörtern erstellen:
 * 
 *     String[] words = text.split(" "); // Wörter können Sonderzeichen haben
 * 
 *     Verwenden Sie die Methode `reduce` um die TextStatistics für ein String
 *     zu erzeugen.
 */

class Person {

}

class TextStatistics {
	// ...

	public TextStatistics(String text) {
		// ...
	}

	public int getCountChars() {
		return 0;
	}

	public int getCountSpecialChars() {
		return 0;
	}

	public int getCountLetters() {
		return 0;
	}

	public Optional<String> getLongestWord() {
		return null;
	}
}

public class Aufgabe03_Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
