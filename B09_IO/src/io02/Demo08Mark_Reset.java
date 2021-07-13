package io02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 012345678
 * 
 * abcdefghi
 * 
 * Hans
 * 
 * im
 * 
 * Glueck
 *
 */

public class Demo08Mark_Reset {

	public static void main(String[] args) throws IOException {
		Reader in = new BufferedReader(new FileReader("./testfiles/mark_reset.txt"));

		/**
		 * mark(int readAHeadLimit);
		 * 
		 * Marks the present position in the stream. Subsequent calls to reset() will
		 * attempt to reposition the stream to this point.
		 * 
		 * Not all character-input streams support the mark() operation.
		 * 
		 * Parameters: readAheadLimit
		 * 
		 * Limit on the number of characters that may be read while still preserving the
		 * mark. After reading this many characters, attempting to reset the stream
		 * 'may' fail.
		 */
		int readAheadLimit = 4;
		//in.mark(readAheadLimit);
		
		// Virtuellen Cursor: zu beginn steht dieser vor dem ersten zeichen
		// -0123456789
		// -abcdefghi
		// |

		System.out.println("in.markSupported() : " + in.markSupported());
		
		in.mark(4);
		// Virtuellen Cursor: nach dem in.mark(4);
		// |   Marker 4 für 4 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// | Virtuelle Cursor
		
		// -----------------------------------------------
		char ch = '0';
		
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 1. read() Aufruf stehen wir beim 'a'
		// |   Marker 4 noch 3 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// -|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 2. read() Aufruf stehen wir beim 'b'
		// |   Marker 4 noch 2 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// --|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 3. read() Aufruf stehen wir beim 'c'
		// |   Marker 4 noch 1 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// ---|
		
		System.out.println("reset()");
		in.reset();
		//nach dem reset()
		// Virtuellen Cursor: 0 lesevorgänge durchgeführt
		// |   Marker 4 noch 4 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// |
		
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 1. read() Aufruf stehen wir beim 'a'
		// |   Marker 4 noch 3 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// -|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 2. read() Aufruf stehen wir beim 'b'
		// |   Marker 4 noch 2 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// --|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 3. read() Aufruf stehen wir beim 'c'
		// |   Marker 4 noch 1 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// ---|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 4. read() Aufruf stehen wir beim 'd'
		// |   Marker 4 noch 0 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// ----|
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 5. read() Aufruf stehen wir beim 'e'
		// |   Marker 4 noch -1 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// -----|
		
		System.out.println("reset()");
		in.reset();//LAUT API DOC könnte diese schief gehen
		//nach dem reset()
		// Virtuellen Cursor: 0 lesevorgänge durchgeführt
		// |   Marker 4 noch 4 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// |
		
		ch = (char)in.read();
		System.out.println(ch);
		// Virtuellen Cursor: nach dem 1. read() Aufruf stehen wir beim 'a'
		// |   Marker 4 noch 3 lesevorgänge reserviert
		// -0123456789
		// -abcdefghi
		// -|
		
		in.skip(5);
		// -0123456789
		// -abcdefghi
		// ------|
		ch = (char)in.read();
		System.out.println(ch);
		// -0123456789
		// -abcdefghi
		// -------|
		in.close();
	}

}






