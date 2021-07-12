package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lesen Sie einen Text mit dem Scanner ein.
 * 
 * Solange der Benutzer nicht Ende schreibt, sammeln Sie die eingegebenen Texte.
 * 
 * Nachdem der Benutzer Ende eingegeben hat, schreiben Sie die Texte in eine
 * Datei namens output.txt.
 * 
 * Nach dem erfolgreichen Schreiben der Datei, lesen Sie diese ein und geben Sie
 * sie in der Konsole aus
 *
 */
public class Aufgabe01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> texte = new ArrayList<>();
		System.out.println("Bitte einen Text eingeben");
		String read =sc.nextLine();
		texte.add(read);
		while(!read.equalsIgnoreCase("ende")) {
			System.out.println("Bitte einen weiteren Text eingeben");
			read =sc.nextLine();
			texte.add(read);
		}
		
	}
}
