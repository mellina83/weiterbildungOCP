package io02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo02Writer {

	public static void main(String[] args) throws IOException {
		File outputFile = new File("./testfiles/firstOutput.txt");

		Writer out = new FileWriter(outputFile);

		String ls = System.getProperty("line.separator");

		out.write("lorem" + ls);
		out.write("ipsum" + ls);

		out.flush();

		out.write("dolor sit amet - " + ls);
		out.write("Julius irgendwas" + ls);

		out.close();// flush wird dann ebenfalls ausgeführt.

		System.out.println("Beendet");

	}

}
