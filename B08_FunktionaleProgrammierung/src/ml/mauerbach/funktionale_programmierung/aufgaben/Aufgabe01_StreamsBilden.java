package ml.mauerbach.funktionale_programmierung.aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

public class Aufgabe01_StreamsBilden {

	public static void main(String[] args) {
//		A1();
//		A2();
//		A3();
		A4();
//		A5();
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
		Stream.of(list1,list2).forEach(e -> System.out.println("size = " + e.size() + ". elements = " + e));
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
		/*
		for (int i = 1; i < 100; i++) {
			System.out.println(myRand.nextInt());
		}
		*/
		Stream.generate(myRand::nextInt).limit(99).forEach(System.out::println);
	}

	/**
	 * Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den
	 * Stream mit der Methode `Stream.iterate`.
	 * 
	 * @Tipp: Die 'intermediate' operation `limit` kann die Anzahl der
	 *        Stream-Elemente begrenzen.
	 */
	public static void A3() {
	    /*
		for (int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
	    */
		Stream.iterate(100, Math::decrementExact).limit(100).forEach(System.out::println);
	}

	/**
	 * Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline,
	 * die dieselben Ausgaben liefert.
	 * 
	 * Verwenden Sie für die Lösung die Methode `Stream.concat`.
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
		System.out.println("concat");
		Stream.concat(Arrays.stream(a1),Arrays.stream(a2)).forEach(System.out::println);
		System.out.println("map");
		Stream.of(a1,a2).map(Arrays::stream).reduce(Stream.empty(),Stream::concat).forEach(System.out::println);
		System.out.println("flatMap");
		Stream.of(a1,a2).flatMap(Arrays::stream).forEach(System.out::println);
	}

	/**
	 * Erzeugen Sie ein Stream mit `java.util.Arrays.stream(T[] array)`.
	 * 
	 * Erzeugen Sie ein Stream mit `java.util.Collection.stream()`.
	 */
	public static void A5() {
	  Stream<Integer> is1 = Arrays.stream(new Integer[] {1,2,3});
	  System.out.println(is1.collect(Collectors.toList()));
	  Stream<Integer> is2 = Arrays.asList(1,2,3).stream();
	  System.out.println(is2.collect(Collectors.toList()));
	  
	  Integer limit = 100000;
	  Integer i = Stream.iterate(1,Math::incrementExact).limit(limit).reduce(0,(a,b)->a+b);
	  System.out.println(i);
	  i = Stream.iterate(1,Math::incrementExact).limit(limit).reduce(1,(a,b)->a+b);
      System.out.println(i);
      i = Stream.iterate(1,Math::incrementExact).limit(limit).parallel().reduce(1,(a,b)->a+b);
      System.out.println(i);
	}
}