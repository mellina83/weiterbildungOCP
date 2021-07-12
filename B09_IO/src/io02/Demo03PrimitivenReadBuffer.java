package io02;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;

public class Demo03PrimitivenReadBuffer {

	public static void main(String[] args) throws IOException {
		File myFile = new File("./testfiles/kurz.txt");

		Reader in = new FileReader(myFile);

		/**
		 * Reads characters into an array. This method will block until some input is
		 * available, an I/O error occurs, or the end of the stream is reached.
		 * 
		 * Parameters: char cbuf[] : Destination buffer
		 * 
		 * Returns: The number of characters read, or -1 if the end of the stream has
		 * been reached
		 */

		char[] cbuf = new char[16];//
		int count = 0;
		while ((count = in.read(cbuf)) != -1) {
			//			 String.valueOf(char[],int offset, int count);
			/*
			 * 0 1 2 3 4 5 6 7 8
			 * a b c d e f g h i
			 * 
			 * valueOf(char[],2, 3);
			 * 
			 * cde
			 * 
			 */
			String str = String.valueOf(cbuf,0,count);
//			String str = String.valueOf(cbuf);
			System.out.print(count);
			System.out.println(str);

		}

		in.close();
	}

}
