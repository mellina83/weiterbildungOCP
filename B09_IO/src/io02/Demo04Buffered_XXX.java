package io02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Demo04Buffered_XXX {

	public static void main(String[] args) throws Exception {
		/**
		 * Lesen der Datei mit dem BufferedReader
		 */
		File file = new File("./testfiles/lorem.txt");
		Reader in = new FileReader(file);
		BufferedReader br = new BufferedReader(in);

		
		/**
		 * Buffered Reader wird gleich beim Writer verwendet und ein Reader welcher
		 * abgearbeitet ist, kann nicht wiederverwendet werden.
		 */
		
//		while (br.ready()) {
//			/**
//			 * Reads a line of text. A line is considered to be terminated by any one of a
//			 * line feed ('\n'), a carriage return ('\r'), or a carriage return followed
//			 * immediately by a linefeed.
//			 * 
//			 * Returns: A String containing the contents of the line, not including any
//			 * line-termination characters, or null if the end of the stream has been reached
//			 */
//			System.out.println(br.readLine());
//		}
//		br.close();

		
		/**
		 * Schreiben einer Datei mit Hilfe des 'BufferedReader'
		 * 
		 * Wir nutzen die Klasse BufferedWriter für die Schreibmethoden
		 */
		File fileOut = new File("./testfiles/lorem_copy.txt");
		Writer out = new FileWriter(fileOut);
//		BufferedWriter bw = new BufferedWriter(out);
		PrintWriter pw = new PrintWriter(out);
		
		String zeile = "";
//		while((zeile = br.readLine())!=null) {
		while(br.ready()) {
			zeile = br.readLine();
//			bw.write(zeile);
//			bw.newLine();
			pw.println(zeile);
		}
		br.close();
//		bw.close();
		pw.close();
	}

}
