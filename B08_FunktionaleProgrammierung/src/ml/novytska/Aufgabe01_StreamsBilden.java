package ml.novytska;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		System.out.println("-----------A1()-----------");

		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for (List<Integer> e : list3) {
			System.out.println("size = " + e.size() + ". elements = " + e);
		}
		Stream<List<Integer>> stream1 = Stream.of(list1);
		Stream<List<Integer>> stream2 = Stream.of(list2);
		Stream.concat(stream1, stream2).forEach(n -> System.out.println(n));
//		Stream.of(stream1, stream2)
//		.flatMap(i->i)
//			.forEach(n -> System.out.println(n));
		// B
	}

	/**
	 * Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den
	 * Stream mit der Methode `Stream.generate`.
	 * 
	 * @Tipp: Die 'intermediate' operation `limit` kann die Anzahl der
	 *        Stream-Elemente begrenzen.
	 */
	public static void A2() {
		System.out.println("-----------A2()-----------");
		class MyRand {
			Integer nextInt() {
				return new Random().nextInt();
			}
		}
		MyRand myRand = new MyRand();
		for (int i = 1; i < 100; i++) {
			System.out.println(myRand.nextInt());
		}
		System.out.println("-----------Stream-----------");
		Stream.generate(() -> myRand.nextInt()).limit(25).forEach(System.out::println);

	}

	/**
	 * Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den
	 * Stream mit der Methode `Stream.iterate`.
	 * 
	 * @Tipp: Die 'intermediate' operation `limit` kann die Anzahl der
	 *        Stream-Elemente begrenzen.
	 */
	public static void A3() {
		System.out.println("-----------A3()-----------");

		for (int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
		System.out.println("-----------Stream-----------");
		Stream.iterate(100, x -> x - 1).limit(25).forEach(System.out::println);

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
		System.out.println("-----------A4()-----------");

		// A
		String[][] a3 = { a1, a2 };
		for (String[] arr : a3) {
			for (String s : arr) {
				System.out.println(s);
			}
		}
		System.out.println("-----------Stream-----------");

		Stream<String> str1 = Arrays.stream(a1);
		Stream<String> str2 = Arrays.stream(a2);
		Stream.concat(str1, str2).forEach(n -> System.out.println(n));

		// B
	}

	/**
	 * Erzeugen Sie ein Stream mit `java.util.Arrays.stream(T[] array)`.
	 * 
	 * 
	 * Erzeugen Sie ein Stream mit `java.util.Collection.stream()`.
	 */
	public static void A5() {
		
		System.out.println("-----------Stream mit `java.util.Arrays.stream(T[] array)-----------");

		Stream<String> stream5 = Arrays.stream(new String[]{"Paris", "London", "Madrid"}) ;
		stream5.forEach(s->System.out.println(s));
		
		 List<String> phones = new ArrayList<String>();
	        Collections.addAll(phones, "iPhone 8", "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2");
          
        List<String> stream6 = phones.stream().collect(Collectors.toList());
        System.out.println("-----------Stream mit java.util.Collection.stream()-----------");
                 
        for(String s : stream6){
            System.out.println(s);
        }

	}

}
