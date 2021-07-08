package streams09;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Demo15Reduce {

	public static void main(String[] args) throws Exception {
//		reduce01_Integer();

//		reduce01_String();

//		reduce02_Integer();

//		reduce02_Kreis();

//		reduce03();

		reduce03_possibleSideEffects();
	}

	private static void reduce03_possibleSideEffects() throws Exception {
		List<String> list = Arrays.asList("aa", "bbb", "cc", "dddd", "eer", "our", "oop", "oca", "ocp",
				"lol");

		StringBuilder identity = new StringBuilder();

		BiFunction<StringBuilder, String, StringBuilder> accumulator = (sb, s) -> {
//			return sb.append(s);
			return new StringBuilder(sb.toString() + s);
		};

		BinaryOperator<StringBuilder> combiner = (left, right) -> {
//			return left.append(right);
			return new StringBuilder(left.toString() + right.toString());
		};

		// Left -> identity
		// Right -> identity

//		StringBuilder resultSeq = list.stream().reduce(identity, accumulator, combiner);
//		System.out.println("Sequenziell : " + resultSeq);

		StringBuilder resultPar = list.parallelStream().reduce(identity, accumulator, combiner);
		System.out.println("Parallel : " + resultPar);
		// aa bbb cc dddd eer our oop oca ocp lol
//		PrintWriter pw = new PrintWriter("test.txt");
//		pw.println(resultPar.toString());
//		pw.close();

		/**
		 * Ohne Accumulator oder Combiner zu verändern könnten Thread kritische Stellen
		 * im Stream umgestellt werden auf sequentiell
		 */
		list.parallelStream()
			.distinct()
			.filter(t-> true)
			.sequential() //parallelStream -> sequentialStream
			.sequential()
			.sequential()
			.sequential()
			.sequential()
			.peek(s-> System.out.println(s))
			.parallel()  //sequentialStream -> parallelStream
			.map(s -> new StringBuilder(s))
			.forEach(System.out::println);
			
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
		 * Aufgabe ist die Länge des Strings zählen.
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

		/**
		 * <code>
		 * Parallel:
		 * 
		 * Daten: "aa", "bbb" , "cc", "dddd"
		 * 
		 * Identity = 0
		 * 
		 * Daten Links: ----------------------------------- Daten Rechts:
		 * "aa","cc"   ----------------------------------- "dddd","bbb"
		 * 
		 * 				Links							 ////			Rechts
		 * Schritt 1 : accumulator.apply(1, "aa") -> 2   ////	accumulator.apply(1, "dddd") -> 4
		 * 
		 * Schritt 2 : combiner.apply(2,4) -> 6
		 * 
		 * Schritt 3 : accumulator.apply(0, "cc") -> 2   ////	accumulator.apply(0, "bbb") -> 3 
		 * 
		 * Schritt 4 : combiner.apply(2,3) -> 5
		 * 
		 * Schritt 5 : combiner.apply(Left,Right) -> 6 + 5 -> 11
		 * 
		 * </code>
		 */
		long before = System.currentTimeMillis();
		Integer resultSeq = list.stream().reduce(identity, accumulator, combiner);
		long after = System.currentTimeMillis();
		System.out.println("resultSeq : " + resultSeq + " | Time : " + (after - before));

		before = System.currentTimeMillis();
		Integer resultPar = list.parallelStream().reduce(identity, accumulator, combiner);
		after = System.currentTimeMillis();
		System.out.println("resultPar : " + resultPar + " | Time : " + (after - before));
	}

	private static void reduce02_Kreis() {
		List<Kreis> list = Arrays.asList(new Kreis(11), new Kreis(12), new Kreis(13));
//		List<Kreis> list = Arrays.asList();
		BinaryOperator<Kreis> accumulator = (k1, k2) -> new Kreis(k1.getRadius() + k2.getRadius());

		Kreis identity = new Kreis(0);

		Kreis result = list.stream().reduce(identity, accumulator);

		System.out.println("reduce Kreis mit Accumulator und Identity: " + result);
	}

	private static void reduce02_Integer() {
		/**
		 * @param identity    the identity value for the accumulating function
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * @return the result of the reduction - T
		 */

		List<Integer> list = Arrays.asList(5, 6, 7, 8);

		/**
		 * Accumulator
		 */
		BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2;

		/**
		 * Identity
		 */
		Integer identity = 0;

		/**
		 * Daten 5,6,7,8 + identity = 0
		 * 
		 * Schritt 01: Identity(0) = apply(Identity(0),5) -> Identity(5)
		 * 
		 * Schritt 02: Identity(5) = apply(Identity(5),6) -> Identity(11)
		 * 
		 * Schritt 03: Identity(11) = apply(Identity(11),7) -> Identity(18)
		 * 
		 * Schritt 04: Identity(18) = apply(Identity(18),8) -> Identity(26)
		 * 
		 * return Identity(26)
		 */
		Integer result = list.stream().reduce(identity, accumulator);
		System.out.println("reduce mit Accumulator und Identity: " + result);
	}

	private static void reduce01_String() {
		/**
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * 
		 * @return an Optional<T> reduce(BinaryOperator<T> accumulator);
		 */

		List<String> list = Arrays.asList("Hallo", "Welt", "hier", "ist", "Java");

		/**
		 * Accumulator
		 */
		BinaryOperator<String> accumulator = (str1, str2) -> str1 + " | " + str2;

		Optional<String> mayBeString = list.stream().reduce(accumulator);
		String result = mayBeString.get();
		System.out.println("reduce mit Accumulator: " + result);
	}

	/**
	 * 
	 * @reduce Performs a reduction on the elements of this stream, using an
	 *         associative accumulation function, and returns an Optional describing
	 *         the reduced value,if any.
	 * 
	 * 
	 *         Optional<T> reduce(BinaryOperator<T> accumulator);
	 */
	private static void reduce01_Integer() {
		/**
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * 
		 * @return an Optional describing the result of the reduction
		 */
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		for (int i = 0; i < 500; i++) {
			list.add(new Random().nextInt(100));
		}

		/**
		 * Accumulator
		 */
		BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;
		/**
		 * List 1,2,3,4
		 * 
		 * Optional.epmty();
		 * 
		 * Schritt 1: apply(Optional(0),1) -> Optional(0)+1 = Optional(1)
		 * 
		 * Schritt 2: apply(Optional(1),2) -> Optional(1)+2 = Optional(3)
		 * 
		 * Schritt 3: apply(Optional(3),3) -> Optional(3)+3 = Optional(6)
		 * 
		 * Schritt 4: apply(Optional(6),4) -> Optional(6)+4 = Optional(10)
		 * 
		 * return Optional(10)
		 */

		Optional<Integer> mayBeInt = list.stream().reduce(accumulator);
		System.out.println("reduce mit Accumulator: " + mayBeInt.get());// 10
	}

}
