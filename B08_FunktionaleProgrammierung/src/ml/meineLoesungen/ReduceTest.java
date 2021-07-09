package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import streams09.Kreis;

public class ReduceTest {
	
	//reduce(): Reduziert Elemente seines Streams, mittels einer Accumulator-Funktion,
	//			und gibt als Optional Object einen reduzierten Wert zurueck, sofern vorhanden.
	//accumulator: Funktion, die zwei Werte zu einem Wert zusammensetzt
	//identity: Wert, der zu Beginn im Akkumulator hinzugefuegt wird.
	//Sollte der Wert des Streams 0 sein, so ist er nun so hoch wie der Identity.
	
	//reduce
	
	public static void main(String[] args) {
				
		List<Kreis> listkreis = Arrays.asList(new Kreis(11), new Kreis(12), new Kreis(13));
		Kreis identity = new Kreis(40);
		Kreis result1 = listkreis.stream().reduce(identity, (k1, k2) -> new Kreis(k1.getRadius() + k2.getRadius()));
		System.out.println(result1);
	}
	
	private static void reduce03() {
		/**
		 * @param <U>         The type of the result
		 * @param identity    the identity value for the combiner function
		 * @param accumulator an associative non-interfering stateless function for
		 *                    incorporating an additional element into a result
		 * @param combiner    an associative non-interfering stateless function for
		 *                    combining two values, which must be compatible with the
		 *                    accumulator function
		 * @return the result of the reduction
		 */
		/*
		 * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator,
		 * BinaryOperator<U> combiner);
		 * 
		 * <U> - Integer
		 * 
		 * @return U-> Integer
		 * 
		 * @param1 : U identity -> Integer identity
		 * 
		 * @param2 : BiFunction<U, ? super T, U> accumulator BiFunction<Integer, String,
		 * Integer> accumulator
		 * 
		 * @param3 : BinaryOperator<U> combiner BinaryOperator<Integer> combiner
		 */
		Integer identity = 0;

		BiFunction<Integer, String, Integer> accumulator = (i, s) -> i + s.length();

		BinaryOperator<Integer> combiner = (left, right) -> {
			System.out.println("left : " + left + " | right : " + right);
			return left + right;
		};

		/**
		 * Aufgabe ist die L�nge des Strings z�hlen.
		 */
		List<String> list = new ArrayList<String>(Arrays.asList("aa", "bbb", "cc", "dddd"));

		/**
		 * Sequenziell
		 * 
		 * Daten: "aa", "bbb" , "cc", "dddd"
		 * 
		 * Identity = 0
		 * 
		 * Thread left
		 * 
		 * Schritt 1 : accumulator.apply(0,"aa") -> 2
		 * 
		 * Schritt 2 : accumulator.apply(2,"bbb") -> 5
		 * 
		 * Schritt 3 : accumulator.apply(5,"cc") -> 7
		 * 
		 * Schritt 4 : accumulator.apply(7,"dddd") -> 11
		 * 
		 * left = 11
		 * 
		 * right = 0
		 * 
		 * return left;
		 */

	
		Integer resultSeq = list.stream().reduce(identity, accumulator, combiner);
		System.out.println("resultSeq : " + resultSeq);

	}

}
