package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class AufgabeStreams_Intermediate {
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
		
		//Loesung
		System.out.println("Loesung Aufgabe 4:");
		Random random;
		List<Kreis> kreisliste = new ArrayList<>();
		for (int i = 0; i < 10_000; i++) {
			random = new Random();
			int radiusRandom = random.nextInt(500_000);
			kreisliste.add(new Kreis(radiusRandom));
		}
				
		Predicate <Kreis> ungeraderRadius = k -> k.getRadius() % 2 == 0;
		Predicate <Kreis> rangeRadius = k -> k.getRadius() > 120_000 && k.getRadius() < 375_000;
		
		kreisliste.stream().distinct().filter(ungeraderRadius).filter(rangeRadius).limit(10).forEach(System.out::println);
		
		//Eleganter:
		//Random rand = new Random();
		//Stream.generate(new Kreis(rand.nextInt(500_000) + 1));
		
	

	}

	private static void aufgabe03() {
		/**
		 * Mit Stream und Pipeline 30 Zufallswerte im Bereich [-20 ... 20] generieren und den durchschnitt
		 * ermitteln lassen.
		 * 
		 * Tipp: average() PrimitivenStreams
		 */
		
		//Loesung
		System.out.println("Loesung Aufgabe 3:");
		Random rd = new Random();
		rd.ints(-20, 21).limit(30).peek(s -> System.out.print(+ s + " ")).average().ifPresent(s -> System.out.println("\nDurchschnitt: " + s));
		
		//oder Stream.generate und darin rand.nextint (41)-20
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
		
		//Loesung
		System.out.println("Loesung Aufgabe 2:");
		Function <Integer, String> equalOrUnequal = s -> {return s % 2 == 0 ? "gerade" : "ungerade";};
		Arrays.stream(array).map(equalOrUnequal).forEach(System.out::println);
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
		
		//Loesung
		System.out.println("\nLoesung Aufgabe 1:");
		Predicate<Integer> equalThreeOrNine = (t) -> (t == 3 || t == 9);
		list.stream().filter(equalThreeOrNine).forEach(s -> System.out.println("Found: " + s));

	}
}
