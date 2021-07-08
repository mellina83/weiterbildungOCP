package streams09;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import data.Person;

public class Demo17Collectors {

	public static void main(String[] args) {
//		onExam();
//		notOnExam();

		toMap();
	}

	private static void toMap() {
//		public static <T, K, U, M extends Map<K, U>>
//		Collector<T, ?, M>
//		toMap(
//			Function<? super T, ? extends K> keyMapper, i -> i
//        	Function<? super T, ? extends U> valueMapper, i -> i+"";
//        	BinaryOperator<U> mergeFunction,
//        	Supplier<M> mapSupplier
//		)

		/**
		 * Generischen Typen <T, K, U, M extends Map<K, U>>
		 * 
		 * <T> the type of the input elements -> Integer
		 * 
		 * <K> the output type of the key mapping function -> Integer
		 * 
		 * <U> the output type of the value mapping function -> String
		 * 
		 * <M> the type of the resulting extends Map<Integer,String> ->
		 * TreeMap<Integer,String>
		 * 
		 * @keyMapper a mapping function to produce keys
		 * 
		 * @valueMapper a mapping function to produce values
		 * 
		 * @mergeFunction a merge function, used to resolve collisions between values
		 *                associated with the same key, as supplied to
		 *                {@link Map#merge(Object, Object, BiFunction)}
		 * 
		 * @mapSupplier a function which returns a new, empty Map into which the results
		 *              will be inserted
		 * 
		 */

		/**
		 * Rückgabewert Collector<T, ?, M>
		 * 
		 * 
		 * toMap(
		 * 
		 * Function<? super Integer, ? extends Integer> keyMapper,
		 * 
		 * Function<? super Integer, ? extends String> valueMapper,
		 * 
		 * BinaryOperator<U> mergeFunction,
		 * 
		 * Supplier<M> mapSupplier
		 */

		Function<Integer, Integer> keyMapper = i -> i;

		Function<Integer, String> valueMapper = i -> {
			switch (i) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return "Arbeitstag";
			case 6:
			case 7:
				return "Wochenende";
			default:
				return "Kein Wochentag";
			}
		};

		BinaryOperator<String> mergeFunction = (oldValue, newValue) -> oldValue;

		Supplier<Map<Integer, String>> mapSupplier = TreeMap::new;

		System.out.println("Mapping");
		System.out.println(
				"Collector<x,y,z> coll = Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)");

		Integer[] array = { 99, 99, 99, 99, 7, 6, 5, 1, 2, 3, 9, 78, 98, 777, 123456 };

		Collector<Integer, ?, Map<Integer, String>> collector = Collectors.toMap(keyMapper, valueMapper,
				mergeFunction, mapSupplier);
		
		Map<Integer,String> woche = Arrays.stream(array).collect(collector);
		
		System.out.println(woche);
		woche.forEach((k, v) -> System.out.println(k + " : " + v));
	}

	/**
	 * Auch wichtig, aber nicht im Exam auftretend.
	 */
	private static void notOnExam() {
		System.out.println("Collector<x,y,z> coll = Collectors.toCollection(Supplier)");

		/**
		 * Ein Collector für ein TreeSet mit Personen.
		 */
		Collector<Person, ?, TreeSet<Person>> col01 = Collectors.toCollection(TreeSet::new);

		/**
		 * Ein Collector als Queue für Numbers in einer PriorityQueue
		 */
		Collector<Number, ?, Queue<Number>> col02 = Collectors.toCollection(PriorityQueue::new);
	}

	/**
	 * Erzeugen einfacher Collectoren - Exams Relevant
	 */
	private static void onExam() {
		Integer[] array = { 99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456 };
		String[] texte = { "Hallo", "Welt", "hier", "ist", "Java" };

		System.out.println("Collector<x,?,z> coll = Collectors.toList()");

		Collector<Integer, ?, List<Integer>> col01 = Collectors.toList();
		Collector<String, ?, List<String>> col02 = Collectors.toList();

		System.out.println("Collector<x,?,z> coll = Collectors.toSet()");
		Collector<Integer, ?, Set<Integer>> col03 = Collectors.toSet();
		Collector<String, ?, Set<String>> col04 = Collectors.toSet();
	}

}
