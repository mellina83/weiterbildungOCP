package aufgaben;

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
import java.util.function.Consumer;

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
public class Aufgabe01ML {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		List<String> texte = new ArrayList<>();
		System.out.println("Bitte einen Text eingeben");
		String read = sc.nextLine();
		texte.add(read);
		while (!read.equalsIgnoreCase("ende")) {
			System.out.println("Bitte einen weiteren Text eingeben");
			read = sc.nextLine();
			if (!read.equalsIgnoreCase("ende")) {
				texte.add(read);
			}
		}
		/**
		 * Schreiben in Datei
		 */
		File output = new File("./testfiles/outputML.txt");
		Writer out = new FileWriter(output);
		String ls = System.getProperty("line.separator");

//		for(int i=0;i<texte.size();i++) {
//			out.write(texte.get(i) + ls);
//			out.flush();
//		}

		Consumer<String> action = str -> {
			try {
				out.write(str + ls);
				out.flush();
			} catch (IOException e) {

			}
		};
		texte.forEach(action);

		System.out.println("Speichern erfolgreich");
		out.close();
		
		/**
		 * Schreiben in Datei
		 */
		
		/**
		 * Lesen aus der Datei
		 */
		Reader in = new FileReader(output);
//		BufferedReader br = new BufferedReader(in);
//		while(br.ready()) {
//			System.out.println(br.readLine());//Ohne Zeilenumbrüche
//		}
		List<Integer> input = new ArrayList<>();
		while(in.ready()) {
			input.add(in.read());//Liest alles, auch 'cr' und 'lf'
		}
//		Stream<Integer> map -> Stream<Character>
		input.stream().map(i->(char)i.intValue()).forEach(System.out::print);
		/**
		 * Lesen aus der Datei
		 */
		in.close();
	}
}
