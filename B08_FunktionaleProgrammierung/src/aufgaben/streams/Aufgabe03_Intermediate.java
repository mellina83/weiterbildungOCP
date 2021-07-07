package aufgaben.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Aufgabe03_Intermediate {
	public static void main(String[] args) {
		aufgabe01();
		aufgabe02();
		aufgabe03();
		aufgabe04();
	}

	private static void aufgabe04() {
		/**
		 * Mit einer Pipeline sollen:
		 * 
		 * - Ein Stream mit 10.000 Kreisen erstellt werden
		 * 
		 * - Die Kreise sollen mit einem Radius bis zu 500_000 erstellt werden
		 * 
		 * - doppelte gefiltert
		 * 
		 * - Kreis mit ungerade Radien gefiltert
		 * 
		 * - Kreise mit Radien kleiner 120_000 bzw gr��er 375_000 gefiltert
		 * 
		 * - bis zu 10 Kreise ausgegeben werden
		 */

	}

	private static void aufgabe03() {
		/**
		 * Mit Stream und Pipeline 30 Zufallswerte im Bereich [-20 ... 20] generieren und den durchschnitt
		 * ermitteln lassen.
		 * 
		 * Tipp: average() PrimitivenStreams
		 */

	}

	private static void aufgabe02() {
		Integer[] array = { 1, 4, 7, 3, -8 };

		// A
		for (Integer x : array) {
			System.out.println(x % 2 == 0 ? "gerade" : "ungerade");
		}
		// B
		/**
		 * Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer
		 * Pipeline,die dieselben Ausgaben liefert.
		 */
	}

	private static void aufgabe01() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 7, 8, 9, 10);
		// A
		for (Integer x : list) {
			if (x == 3 || x == 9) {
				System.out.println("Found: " + x);
			}
		}
		// B
		/**
		 * Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer
		 * Pipeline,die dieselben Ausgaben liefert.
		 */

	}
}
