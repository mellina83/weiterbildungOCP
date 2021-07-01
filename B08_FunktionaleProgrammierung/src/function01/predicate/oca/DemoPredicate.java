package function01.predicate.oca;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import data.Utility;

/**
 * @predicate wird genutzt um boolsche Tests durchzuführen. Z.B. Für Filter
 */
public class DemoPredicate {

	public static void main(String[] args) {
//		demoPredicate01();
		demoBiPredicate01();
	}

	private static void demoBiPredicate01() {
		List<Integer> zahlen = new ArrayList<>();
		Utility.befuellen(zahlen);

		/**
		 * Greater than
		 */
		int than = 5;
		Predicate<Integer> greaterThan = (i) -> i > than;

		BiPredicate<Integer, Integer> greaterThanBiParam = (i, j) -> i > j;
		System.out.println(greaterThanBiParam.test(42, 64));

		BiPredicate<Integer, String> isValueOf = (i, text) -> {
			int tmp;
			try {
				tmp = Integer.parseInt(text);
			} catch (NumberFormatException e) {
				return false;
			}
			return i.equals(tmp);
		};

		System.out.println("7777 isValueOf \"7894\" " + isValueOf.test(7777, "7894"));
		System.out.println("42 isValueOf \"42\" " + isValueOf.test(42,"42"));
		System.out.println("42 isValueOf \"abcd\" " + isValueOf.test(42,"abcd"));
	}

	private static void demoPredicate01() {
		List<Integer> zahlen = new ArrayList<>();
		Utility.befuellen(zahlen);// 256 : 1 - 100

		System.out.println(zahlen);

		/*
		 * Aus der Liste alle ungeraden Zahlen entfernen
		 * 
		 * Predicate<Integer> soll verwendet werden
		 */
		// Innere Anonyme Klasse
		Predicate<Integer> anoEven = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};

		// Lambda
		Predicate<Integer> lambdaEven = t -> t % 2 == 0;
		Predicate<Integer> lambdaOdd = lambdaEven.negate();

		// Statische Methoden Referenz
		Predicate<Integer> methodEven01 = DemoPredicate::testEven;

		// Instanz Methoden Referenz
		Predicate<Integer> methodEven02 = anoEven::test;

//		for (Integer zahl : zahlen) {
//			if(lambdaEven.test(zahl)) {
//				System.out.print(zahl + " ,");
//			}
//		}

//		for (int i = 0; i < zahlen.size(); i++) {
//			if (lambdaEven.test(zahlen.get(i))) {
//				zahlen.remove(i);
//				i--;
//			}
//		}

//		List<Integer> toRemove = new ArrayList<>();
//		for(Integer zahl : zahlen) {
//			if (lambdaEven.negate().test(zahl)) {
//				toRemove.add(zahl);
//			}
//		}
//		zahlen.removeAll(toRemove);
//		System.out.println(zahlen);

		// Alle zahlen die größer als 42 sollen auch entfernt werden.
		int testParam = 42;
		Predicate<Integer> lessThanTestParam = (t) -> t > testParam;

		/*
		 * Bulk Operation with Predicate from Lambda
		 */
		zahlen.removeIf(lambdaOdd.or(lessThanTestParam));
		System.out.println(zahlen);

	}

	private static boolean testEven(Integer t) {
		return t % 2 == 0;
	}

}
