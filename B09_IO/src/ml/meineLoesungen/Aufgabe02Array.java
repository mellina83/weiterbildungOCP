package ml.meineLoesungen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Random;

/**
 * Die Datei './testfiles/RandomArray.txt' wird Automatisch mit jedem Start neu
 * erstellt
 * 
 * Ihre Aufgabe ist es die Datei './testfiles/RandomArray.txt' einzulesen und
 * die Werte in einem Array zu Speichern. Das Array soll nur so gro�
 * dimensioniert sein, wie es elemente in der Datei gibt.
 * 
 * Nutzen Sie nur den primitiven Datentyp.
 * 
 * Es sollen keine Collections oder Utility-Klassen zur erzeugung des Arrays
 * verwendet werden.
 * 
 * Die �bung zielt auf das erkennen und umsetzen der notwendigen Schritte.
 */
public class Aufgabe02Array {

	public static void main(String[] args) throws IOException {
		generateRandomArrayFile();
		readFile();
	}

	private static void readFile() throws IOException {
		File file = new File("./testfiles/RandomArray.txt");
		
		//Fuer ein Array muessen wir zuerst die Groesse, also die Zeilenanzahl der Datei wissen
		Reader reader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(reader);
		
		int count = (int) bufReader.lines().count();
		
		/*
		 int count = 0;
		 
		 Meine Loesung:
			while (bufReader.ready() ) {
			count++;
			bufReader.readLine();
		}
		
		Dozent:
		while (bufReader.readLine() != null) {
			count++;
		}
		*/
		
		System.out.println("Anzahl Zeilen in der Datei: " + count);
		bufReader.close();
		
		//Da die ReaderStreams nur einmal durchlaufen, neu erstellen:
		Reader reader2 = new FileReader(file);
		BufferedReader bufReader2 = new BufferedReader(reader2);
		int[] array = new int[count];
		
		//Schreiben der Datei in ein Array
		for (int i = 0; i < array.length; i++) {
			String str = bufReader2.readLine();
			array[i] = Integer.parseInt(str); // ergibt primitiven Datentyp
		}
	
		bufReader2.close();
		
		//Ausgeben des Arrays auf Konsole:
		for (int element : array) {
			System.out.println(element);
		}
	}

	/**
	 * Erzeugt eine Text Datei mit integer Werten. Die Laenge der Textdatei ist immer
	 * unterschiedlich.
	 */
	public static void generateRandomArrayFile() throws IOException {
		Random rand = new Random(System.currentTimeMillis());
		int loop = rand.nextInt(500) + 200;
		File file = new File("./testfiles/RandomArray.txt");
		Writer out = new FileWriter(file);
		for (int i = 0; i < loop; i++) {
			// toString da die zahl nicht die interpretation des Ints geschrieben werden
			// soll
			// out.write(Integer.toString(rand.nextInt(10000) + 1) + "\r\n");
			out.write((rand.nextInt(127) + 36) + "\r\n");
			out.flush();
		}
		out.close();
	}
}
