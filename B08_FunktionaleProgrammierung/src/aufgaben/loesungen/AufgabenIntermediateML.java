package aufgaben.loesungen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AufgabenIntermediateML {
	public static void main(String[] args) {
//		aufgabe01();
//		aufgabe02();
//		aufgabe03();
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
		Random rand = new Random();
		Supplier<Kreis> supplier = () -> new Kreis(rand.nextInt(500_000)+1);
		Stream.generate(supplier)
			  .limit(10_000)
			  .distinct()
			  .filter(k -> k.getRadius()%2==0)
			  .filter(k -> k.getRadius()>120_000)
			  .filter(k -> k.getRadius()<375_000)
			  .limit(10)
			  .forEach(System.out::println);

	}

	private static void aufgabe03() {
		/**
		 * Mit Stream und Pipeline 30 Zufallswerte im Bereich [-20 ... 20] generieren
		 * und den durchschnitt ermitteln lassen.
		 * 
		 * Tipp: average() PrimitivenStreams
		 */
		Random rand = new Random();
		OptionalDouble optArg = rand.ints(-20,21).limit(30).average();
//		optArg = Stream.generate(() -> rand.nextInt(41) - 20).limit(30).mapToInt(i -> i).average();
		System.out.println("average = " + optArg.getAsDouble());
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
		System.out.println("Pipeline");
		Arrays.stream(array).map(x -> x % 2 == 0 ? "gerade" : "ungerade").forEach(System.out::println);
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
		System.out.println("Pipeline");
		list.stream().filter(x -> x == 3 || x == 9).forEach(x -> System.out.println("Found: " + x));

	}
}
