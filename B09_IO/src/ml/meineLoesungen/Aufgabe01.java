package ml.meineLoesungen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
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
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//Fuer voruebergehende Speicherung der Texte Erstellung einer String-List
		List<String> texte = new ArrayList<>();
		
		//Konsoleneingaben
		System.out.println("Bitte einen Text eingeben");
		String read =sc.nextLine();
		texte.add(read);
		
		while(!read.equalsIgnoreCase("ende")) {
			System.out.println("Bitte einen weiteren Text eingeben");
			read = sc.nextLine();
			
			if (!read.toLowerCase().contains("ende")) {
				texte.add(read);
				
			}
		}

		sc.close();
		
		//Writer und File erstellen sowie Strings in Datei speichern
		String ls = System.getProperty("line.separator");
		File file = new File("filesAufgaben\\output.txt");
		Writer writer = new FileWriter(file);
		
		for (int i = 0; i < texte.size(); i++) {
			writer.write(texte.get(i) + ls);
			writer.flush();
		}
		//Alternative: Mit Consumer und forEach s. ML

		System.out.println("Speichern erfolgreich.");
		writer.close();
		
		//Reader erstellen und Ausgabe des Texts aus der Datei auf der Konsole
		Reader reader = new FileReader(file);
		System.out.println("\nIn der Datei output.txt steht:");
		
		List<Integer> input = new ArrayList<>();
		while(reader.ready()) {
			input.add(reader.read()); //Liest alles, auch cr und lf
		}
		input.stream().map(i -> (char) i.intValue()).forEach(System.out::print); //Stream<Integer> -> Stream<Character>
		
		/*
		while (bufReader.ready()) {
			System.out.println(bufReader.readLine()); // readLine ist ohne Zeilenumbrueche
		}
		*/
		
		reader.close();
	}
}
