package io02;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Demo06StandardStreams {

	public static void main(String[] args) throws IOException {
		System.setOut(new PrintStream("console.txt"));
		System.setErr(new PrintStream("error.txt"));
	
		System.in.close();
		
		String tmp = null;
		
		System.out.println(tmp.toUpperCase());

	}

}
