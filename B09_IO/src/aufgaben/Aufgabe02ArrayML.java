package aufgaben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * Die Datei './testfiles/RandomArray.txt' wird Automatisch mit jedem Start neu
 * erstellt
 * 
 * Ihre Aufgabe ist es die Datei './testfiles/RandomArray.txt' einzulesen und
 * die Werte in einem Array zu Speichern. Das Array soll nur so groﬂ
 * dimensioniert sein, wie es elemente in der Datei gibt.
 * 
 * Nutzen Sie nur den primitiven Datentyp.
 * 
 * Es sollen keine Collections oder Utility-Klassen zur erzeugung des Arrays
 * verwendet werden.
 * 
 * Die ‹bung zielt auf das erkennen und umsetzen der notwendigen Schritte.
 */
public class Aufgabe02ArrayML {

	public static void main(String[] args) throws IOException {
		generateRandomArrayFile();
		
		/**
		 * Ermitteln wie groﬂ das Array sein muss.
		 */
		File file = new File("./testfiles/RandomArray.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
//		int arraySize =0;
//		while(br.ready()) {
//			arraySize++;
//			br.readLine();
//		}
		
		/**
		 * Bonus:
		 */
		int arraySize = (int)br.lines().count();
		br.close();
		
		/**
		 * Array Anlegen
		 */
		int[] zahlen = new int[arraySize];
		System.out.println(zahlen.length);
		
		/**
		 * BufferedReader erneuern
		 */
		br = new BufferedReader(new FileReader(file));
		for(int i=0;i<zahlen.length;i++) {
			zahlen[i] = Integer.parseInt(br.readLine());
		}

		br.close();
		
		for (int zahl : zahlen) {
			System.out.print(zahl + " , ");
		}
		
		System.out.println("\n------------");
		System.out.println("Es sind " + zahlen.length + " Zahlen enthalten");
	}

	/**
	 * Erzeugt eine Text Datei mit integer Werten. Die l‰nge der Textdatei ist immer
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
