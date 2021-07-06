package ml.meineLoesungen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @A1 Gegeben ist der Code wie in der Methode A1:
 * 
 * @A2 Gegeben ist der Code wie in der Methode A2:
 * 
 * @A3 Gegeben ist der Code wie in der Methode A3:
 * 
 * @A4 Gegeben ist der Code wie in der Methode A4:
 * 
 * @A5 Gegeben ist der Code wie in der Methode A5:
 */

public class AufgabeStreams_01_StreamsBilden {

	public static void main(String[] args) {
//		A1();
//		A2();
//		A3();
//		A4();
		A5();
	}

	/**
	 * Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Stream
	 * Pipeline, die dieselben Ausgaben liefert.
	 */
	public static void A1() {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(55, 77);

		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for (List<Integer> e : list3) {
			System.out.println("size = " + e.size() + ". elements = " + e);
		}
		// B
		
//		Loesung
		System.out.println("Loesung A1: ");
		Stream.of(list1, list2).forEach(e -> System.out.println("size = " + e.size() + ". elements = " + e));
	}

	/**
	 * Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den
	 * Stream mit der Methode `Stream.generate`.
	 * 
	 * @Tipp: Die 'intermediate' operation `limit` kann die Anzahl der
	 *        Stream-Elemente begrenzen.
	 */
	public static void A2() {
		class MyRand {
			Integer nextInt() {
				return new Random().nextInt();
			}
		}
		MyRand myRand = new MyRand();
		for (int i = 1; i < 100; i++) {
			System.out.println(myRand.nextInt());
		}

//		Loesung
		System.out.println("\nLoesung zu A2:");
		Stream.generate(myRand::nextInt).limit(100).forEach(System.out::println);
		
		//mit Lambda
		//Supplier<Integer> randomIntFactory = ()-> myRand.nextInt();
		//Stream.generate(randomIntFactory).limit(100).forEach(System.out::println);

	}

	/**
	 * Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den
	 * Stream mit der Methode `Stream.iterate`.
	 * 
	 * @Tipp: Die 'intermediate' operation `limit` kann die Anzahl der
	 *        Stream-Elemente begrenzen.
	 */
	public static void A3() {

		for (int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
		
//		Loesung
		//Siehe Loesung von Auerbach mit decrement exact, auch gut, und mit Methodenref
		System.out.println("\nLoesung zu A3:");
		Stream.iterate(100, e -> e - 1).limit(100).forEach(System.out::println);
	}

	/**
	 * Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline,
	 * die dieselben Ausgaben liefert.
	 * 
	 * Verwenden Sie f�r die L�sung die Methode `Stream.concat`.
	 */
	public static void A4() {

		String[] a1 = { "a", "b" };
		String[] a2 = { "c", "d" };

		// A
		String[][] a3 = { a1, a2 };
		for (String[] arr : a3) {
			for (String s : arr) {
				System.out.println(s);
			}
		}
		// B
		
//		Loesung
		//Siehe Loesung mit Map bei Auerbach
		System.out.println("\nLoesung zu A4:");
		Stream.concat(Arrays.stream(a1), Arrays.stream(a2)).forEach(System.out::println);
	}

	/**
	 * Erzeugen Sie ein Stream mit `java.util.Arrays.stream(T[] array)`.
	 * 
	 * Erzeugen Sie ein Stream mit `java.util.Collection.stream()`.
	 */
	public static void A5() {
		Integer[] zahlenarray = { 2, 3, 4, 5, 6, 7, 8, 9, 7, 8, 5, 4, 54, 5, 7, 84, 54, 48, 48,
				48, 4, 564, 65 };
		List<Integer> zahlenliste = new ArrayList<>(Arrays.asList(zahlenarray));
		
		System.out.println("Loesung zu Aufgabe 5:");
		Arrays.stream(zahlenarray).forEach(element -> System.out.print(element + " "));
		System.out.println();
		zahlenliste.stream().forEach(element -> System.out.print(element + " "));
		
		

	}
}