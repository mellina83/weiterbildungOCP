package aufgaben.streams;

import java.util.Optional;

/**
 * @A1 Realisieren Sie bitte die Klasse `Person`. Jede Person hat einen Vornamen
 *     und einen Nachnamen. Speichern Sie bitte in einer List folgende Personen:
 * 
 *     <Mick Berger> <Henry Valerie> <Samuel Summierer> <Dieter Etwas>
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) gr��ten Vornamen und Nachnamen aus
 *     allen Personen erh�lt (hier: Samuel Valerie).
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) kleinsten Vornamen und Nachnamen aus
 *     allen Personen erh�lt (hier: Dieter Berger).
 *
 * @A2 Realisieren Sie bitte die Klasse `TextStatistics`, die den an den
 *     Konstruktor �bergebenen Text analysieren kann:
 * 
 *     Um die W�rter in dem Text zu finden, d�rfen Sie zur Vereinfachung davon
 *     ausgehen, dass die einzelnen W�rter voneinander mit Leerzeichen getrennt
 *     werden und andere Sonderzeichen beinhalten k�nnen (oder komplett aus
 *     Sonderzeichen bestehen k�nnen).
 * 
 *     Dann wird folgende Zeile ein Array aus einzelnen W�rtern erstellen:
 * 
 *     String[] words = text.split(" "); // W�rter k�nnen Sonderzeichen haben
 * 
 *     Verwenden Sie die Methode `reduce` um die TextStatistics f�r ein String
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
