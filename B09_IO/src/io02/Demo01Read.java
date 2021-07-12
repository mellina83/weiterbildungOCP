package io02;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo01Read {

	public static void main(String[] args) throws IOException{
		File myFile = new File("./testfiles/kurz.txt");
//		System.out.println(myFile.exists());

		Reader in = new FileReader(myFile);
		
		/**
		 * Reads a single character. This method will block until a character
		 * is available, an I/O error occurs, or the end of the stream is reached.
		 * 
		 * @return The character read, as an integer in the range 0 to
		 *         65535(0x00-0xffff), or -1 if the end of the stream has been reached
		 */
		
		int ch = 0;
		
		while((ch = in.read())!=-1) {
			System.out.print((char)ch);
		}

		in.close();
	}

}
