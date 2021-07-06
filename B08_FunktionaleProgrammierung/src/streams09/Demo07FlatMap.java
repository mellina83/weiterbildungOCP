package streams09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @flatMap(Function) Returns a stream consisting of the results of replacing
 *                    each element of this stream with the contents of a mapped
 *                    stream produced by applying the provided mapping function
 *                    to each element. Each mapped stream is closed after its
 *                    contents have been placed into this stream. (If a mapped
 *                    stream is null an empty stream is used, instead.)
 *
 */
public class Demo07FlatMap {

	public static void main(String[] args) {
//		demoOhneFlatMap();

		demoWithFlatMap();

	}

	private static void demoWithFlatMap() {
		Collection<Integer> radien01 = Arrays.asList(11, 12, 13);
		Collection<Integer> radien02 = Arrays.asList(14, 15, 16, 17, 18);
		Collection<Integer> radien03 = Arrays.asList(19, 20);
		Collection<Integer> radien04 = Arrays.asList(55, 56, 57);

		Set<Integer> mySet = new TreeSet<>();
		mySet.add(123);
		mySet.add(113);
		mySet.add(143);
		mySet.add(183);
		mySet.add(13);

		List<Collection<Integer>> toFlatMap = new ArrayList<>(
				Arrays.asList(radien01, radien02, radien03, radien04));
		toFlatMap.add(Arrays.asList(1, 2, 4, 5, 6, 9));
		toFlatMap.add(mySet);

		System.out.println(toFlatMap);

		Stream<Collection<Integer>> myStream = toFlatMap.stream();

		/**
		 * Ganz ganz schlechtes Beispiel, bitte so nicht coden.
		 */
//		Consumer<Collection<Integer>> action = list -> list.stream().forEach(i -> System.out.print(i + " : "));
//		myStream.forEach(action);

		/**
		 * Bessere Variante
		 */
		Function<Collection<Integer>, Stream<Integer>> mapper = coll -> coll.stream();
		Consumer<Integer> action = i -> System.out.print(i + " : ");
//		myStream.flatMap(mapper)      //Stream<Collection<Integer>> -> Stream<Integer>
//				.forEach(action);

		myStream.flatMap(Collection::stream).map(Kreis::new).forEach(System.out::println);

	}

	private static void demoOhneFlatMap() {
		List<Integer> radien01 = Arrays.asList(11, 12, 13);
		List<Integer> radien02 = Arrays.asList(14, 15, 16, 17, 18);
		List<Integer> radien03 = Arrays.asList(19, 20);
		List<Integer> radien04 = Arrays.asList(55, 56, 57);

//		Object[] zahlen = radien01.toArray();
//		Integer[] zahlen = radien01.toArray(new Integer[0]);
//		System.out.println(zahlen[2]);

		Stream<Integer> stream01 = Stream.of(radien01.toArray(new Integer[0]));
		Stream<Integer> stream02 = Stream.of(14, 15, 16, 17, 18);
		Stream<Integer> stream03 = radien03.stream();
		Stream<Integer> stream04 = Arrays.asList(55, 56, 57).stream();

		Stream<Integer> together = Stream.concat(stream01, stream02);
		together = Stream.concat(together, stream03);
		together = Stream.concat(together, stream04);

		together.forEach(i -> System.out.print(i + ", "));
	}

}
