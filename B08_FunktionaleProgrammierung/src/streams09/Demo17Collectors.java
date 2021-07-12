package streams09;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import data.Dog;
import data.Person;

public class Demo17Collectors {

	public static void main(String[] args) {
//		onExam();
//		notOnExam();

		toMap01();
//		toMap02();
//		toMap03();

//		partitioningBy01();
//		partitioningBy02();

//		partitioningByExampleWithIO();

//		groupingBy();
//		groupingByDog();
	}

	private static void groupingByDog() {
		List<Dog> dogs = new ArrayList<>();
		fillDogs(dogs);

		Function<Dog, Integer> classifier = d -> d.getAge();
//		Collector<Dog, ?, Set<Dog>> downstream = Collectors.toCollection(TreeSet::new);
		Collector<Dog, ?, Set<Dog>> downstream = Collectors.toSet();
		Supplier<TreeMap<Integer, Set<Dog>>> mapFactory = TreeMap::new;

		Collector<Dog, ?, TreeMap<Integer, Set<Dog>>> mapCollector = Collectors.groupingBy(classifier,
				mapFactory, downstream);
		
		TreeMap<Integer, Set<Dog>> result = dogs.stream().collect(mapCollector);
		
		for (Integer gruppe : result.keySet()) {
			System.out.println("Alterklassen : " + gruppe + " [" + result.get(gruppe) + "]");
		}
		System.out.println(result.size());
	}

	private static void fillDogs(List<Dog> dogs) {
		dogs.add(new Dog("boi", 30, 6));
		dogs.add(new Dog("tyri", 40, 12));
		dogs.add(new Dog("charis", 120, 7));
		dogs.add(new Dog("aiko", 50, 10));
		dogs.add(new Dog("clover", 35, 12));
		dogs.add(new Dog("mia", 15, 4));
		dogs.add(new Dog("zooey", 45, 9));
		dogs.add(new Dog("rex", 30, 6));
		dogs.add(new Dog("hasso", 40, 12));
		dogs.add(new Dog("waldi", 120, 7));
		dogs.add(new Dog("dackel", 50, 10));
		dogs.add(new Dog("spike", 35, 12));
		dogs.add(new Dog("sam", 15, 4));
		dogs.add(new Dog("bodo", 45, 9));
	}

	private static void groupingBy() {
//	    public static <T, K> Collector<T, ?, Map<K, List<T>>>
//	    groupingBy(Function<? super T, ? extends K> classifier) {
//	        return groupingBy(classifier, toList());
//	    }

		/**
		 * @param <T>        the type of the input elements
		 * 
		 * @param <K>        the type of the keys
		 * 
		 * 
		 * @param classifier the classifier function mapping input elements to keys
		 * 
		 * @return a Collector implementing the group-by operation
		 */
		Random rand = new Random();
		Stream<Integer> data = rand.ints(-50, 50).boxed().limit(1000);
//		Stream<Integer> data = Stream.of(0,1,2,3,-4,-5,-6,-7);
		Function<Integer, String> classifier = i -> {
			if (i > 0) {
				return "Positiv";
			} else if (i < 0) {
				return "Negativ";
			} else {
				return "Zero(0)";
			}
		};

		Collector<Integer, ?, Map<String, List<Integer>>> mapCollector = Collectors.groupingBy(classifier);

		Map<String, List<Integer>> result = data.collect(mapCollector);

		for (String gruppe : result.keySet()) {
			System.out.println("Gruppe : " + gruppe + "[" + result.get(gruppe) + "]");
		}
		System.out.println(result.size());
	}

	private static void partitioningByExampleWithIO() {
		File dir = new File("C:/Windows");

		Predicate<File> isFile = file -> file.isFile();
		Collector<File, ?, List<File>> downstream = Collectors.toList();

		Collector<File, ?, Map<Boolean, List<File>>> mapCollector = Collectors.partitioningBy(isFile,
				downstream);

		File[] allPaths = dir.listFiles();

		Map<Boolean, List<File>> mapOfFiles = Arrays.stream(allPaths).collect(mapCollector);

		System.out.println("Datei : " + mapOfFiles.get(true));
		System.out.println("Ordner : " + mapOfFiles.get(false));
	}

	private static void partitioningBy02() {
		/**
		 * Datenquelle
		 */
		Random rand = new Random();
		Supplier<Integer> dataSupplier = rand::nextInt;// Integer.MIN_VAULE bis INTEGER.MAX_VALUE
		// IntStream intStream = rand.ints();
		// Stream<Integer> date = Stream.generate(dataSupplier).limit(1000);
		Stream<Integer> data = rand.ints().boxed().limit(1000);

		/**
		 * Partionieren in gerade und ungerade
		 */
//	    public static <T, D, A>
//	    Collector<T, ?, Map<Boolean, D>> partitioningBy
//		(
//			Predicate<? super T> predicate,
//	        Collector<? super T, A, D> downstream
//		)

		Predicate<Integer> predicate = i -> i % 2 == 0;

		Collector<Integer, ?, Set<Integer>> downstream = Collectors.toCollection(TreeSet::new);

		Collector<Integer, ?, Map<Boolean, Set<Integer>>> partitioningBy = Collectors
				.partitioningBy(predicate, downstream);

		Map<Boolean, Set<Integer>> mapResult = data.collect(partitioningBy);

		System.out.println("Die Gruppierung ausgeben");
		System.out.println(mapResult.size());
		System.out.println("false : " + mapResult.get(false));
		System.out.println("true : " + mapResult.get(true));

	}

	private static void partitioningBy01() {
		/**
		 * Datenquelle
		 */
		Random rand = new Random();
		Supplier<Integer> dataSupplier = rand::nextInt;// Integer.MIN_VAULE bis INTEGER.MAX_VALUE
		// IntStream intStream = rand.ints();
		// Stream<Integer> date = Stream.generate(dataSupplier).limit(1000);
		Stream<Integer> data = rand.ints().boxed().limit(1000);

		/**
		 * Partionieren in gerade und ungerade
		 */
//		public static <T>
//		Collector<T, ?, Map<Boolean, List<T>>> partitioningBy
//		(
//		Predicate<? super T> predicate
//		)

		Predicate<Integer> predicate = i -> i % 2 == 0;

		Collector<Integer, ?, Map<Boolean, List<Integer>>> partitioningBy = Collectors
				.partitioningBy(predicate);

		Map<Boolean, List<Integer>> mapResult = data.collect(partitioningBy);

		System.out.println("Die Gruppierung ausgeben");
		System.out.println(mapResult.size());
		System.out.println("false : " + mapResult.get(false));
		System.out.println("true : " + mapResult.get(true));
	}

	private static void toMap03() {
		Integer[] array = { 99, 99, 99, 99, 7, 6, 5, 1, 2, 3, 9, 78, 98, 777, 123456 };

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

		Collector<Integer, ?, Map<Integer, String>> collector = Collectors.toMap(keyMapper, valueMapper);
//      Exception in thread "main" java.lang.IllegalStateException: Duplicate key Kein Wochentag
//		Map<Integer, String> woche = Arrays.stream(array).collect(collector);

		Map<Integer, String> woche = Arrays.stream(array).distinct().filter(i -> i <= 7).collect(collector);

		System.out.println(woche.getClass());
		woche.forEach((k, v) -> System.out.println(k + " : " + v));
	}

	private static void toMap02() {
		Integer[] array = { 99, 99, 99, 99, 7, 6, 5, 1, 2, 3, 9, 78, 98, 777, 123456 };

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

		Collector<Integer, ?, Map<Integer, String>> collector = Collectors.toMap(keyMapper, valueMapper,
				mergeFunction);

		Map<Integer, String> woche = Arrays.stream(array).collect(collector);

		System.out.println(woche.getClass());
		woche.forEach((k, v) -> System.out.println(k + " : " + v));
	}

	private static void toMap01() {
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
		 * R�ckgabewert Collector<T, ?, M>
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

		Map<Integer, String> woche = Arrays.stream(array).collect(collector);

		System.out.println(woche);
		woche.forEach((k, v) -> System.out.println(k + " : " + v));
	}

	/**
	 * Auch wichtig, aber nicht im Exam auftretend.
	 */
	private static void notOnExam() {
		System.out.println("Collector<x,y,z> coll = Collectors.toCollection(Supplier)");

		/**
		 * Ein Collector f�r ein TreeSet mit Personen.
		 */
		Collector<Person, ?, TreeSet<Person>> col01 = Collectors.toCollection(TreeSet::new);

		/**
		 * Ein Collector als Queue f�r Numbers in einer PriorityQueue
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
