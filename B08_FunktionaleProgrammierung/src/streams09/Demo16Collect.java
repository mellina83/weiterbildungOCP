package streams09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 
 * collect() sammelt die Elemente des Streams
 * 
 * Utility Klasse f�r den Collector ist Collectors
 *
 * @collect01 Performs a mutable reduction operation on the elements of this
 *            stream using a Collector. A Collector encapsulates the functions
 *            used as arguments to collect(Supplier, BiConsumer, BiConsumer),
 *            allowing for reuse of collection strategies and composition of
 *            collect operations such as multiple-level grouping or
 *            partitioning.
 * 
 *            <R, A> R collect(Collector<? super T, A, R> collector);
 * 
 * 
 * @collect02 Performs a mutable reduction operation on the elements of this
 *            stream. A mutable reduction is one in which the reduced value is a
 *            mutable result container,such as an ArrayList, and elements are
 *            incorporated by updating the state of the result rather than by
 *            replacing the result.
 * 
 *            <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>
 *            accumulator, BiConsumer<R, R> combiner);
 */
public class Demo16Collect {

	public static void main(String[] args) {
//		collect01();
//		beispiel01();
		collect02();
	}

	/**
	 * @collect02 Performs a mutable reduction operation on the elements of this
	 *            stream. A mutable reduction is one in which the reduced value is a
	 *            mutable result container,such as an ArrayList, and elements are
	 *            incorporated by updating the state of the result rather than by
	 *            replacing the result.
	 * 
	 *            <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>
	 *            accumulator, BiConsumer<R, R> combiner);
	 */
	private static void collect02() {
		/**
		 * <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,
		 * BiConsumer<R, R> combiner);
		 * 
		 * R -> Result : List<T>
		 * 
		 * T -> Type : Integer
		 *  
		 */

		/**
		 * Supplier<List<T>> supplier ->
		 */
//		Supplier<List<Integer>> supplier = () -> new LinkedList<Integer>();
		Supplier<List<Integer>> supplier = LinkedList::new;
		
		/**
		 * BiConsumer<R, ? super T> accumulator
		 */
//		BiConsumer<List<Integer>, Integer> accumulator = (list,i) -> list.add(i);
		BiConsumer<List<Integer>, Integer> accumulator = Collection::add;
		
		/**
		 * BiConsumer<R, R> combiner
		 */
//		BiConsumer<List<Integer>, List<Integer>> combiner = (left,right) -> left.addAll(right);
		BiConsumer<List<Integer>, List<Integer>> combiner = Collection::addAll;
		
		Stream<Integer> myStream01 = Stream.of(99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456);

		List<Integer> result01 = myStream01.collect(supplier, accumulator, combiner);
		System.out.println("Result01 : " + result01);
		System.out.println(result01.getClass());
		
		myStream01 = Stream.of(99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456);
		List<Integer> result02 = myStream01.collect(Vector::new,Collection::add,Collection::addAll);
		System.out.println("Result02 : " + result02);
		System.out.println(result02.getClass());
		
		myStream01 = Stream.of(99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456);
		Collection<Integer> result03 = myStream01.collect(ArrayDeque::new, Collection::add, Collection::addAll);
		System.out.println("Result03 : " + result03);
		System.out.println(result03.getClass());
	}

	private static void beispiel01() {
		Random rand = new Random();
		rand.nextInt(); // Integer.MIN_VALUE - Integer.MAX_VALUE;
		Collection<Integer> randoms = Stream.generate(rand::nextInt).limit(6_294_967_295L)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(randoms.size());// Integer.MAX_VALUE
	}

	/**
	 * @collect01 Performs a mutable reduction operation on the elements of this
	 *            stream using a Collector. A Collector encapsulates the functions
	 *            used as arguments to collect(Supplier, BiConsumer, BiConsumer),
	 *            allowing for reuse of collection strategies and composition of
	 *            collect operations such as multiple-level grouping or
	 *            partitioning.
	 * 
	 *            <R, A> R collect(Collector<? super T, A, R> collector);
	 */
	private static void collect01() {
		/**
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * in diesem Beispiel
		 * 
		 * R -> result : List<Integer>
		 * 
		 * T -> Type : Integer
		 * 
		 * A -> the intermediate accumulation type of the Collector
		 * 
		 * A -> Accumulator : ? beziehen wir aus der Collectors Utility
		 * 
		 */
		Stream<Integer> myStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10);

		/**
		 * in einer Liste Sammeln
		 * 
		 * Collector<? super T, A, R> collector
		 */
		Collector<Integer, ?, List<Integer>> colList = Collectors.toList();

		List<Integer> list = myStream.collect(colList);
		System.out.println("list : " + list);
		System.out.println(list.getClass());

		/**
		 * in einer Set Sammeln
		 * 
		 * Collector<? super T, A, R> collector
		 */
		myStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10);

		Collector<Integer, ?, Set<Integer>> colSet = Collectors.toSet();
//		Set<Integer> set = myStream.collect(colSet);
		Set<Integer> set = myStream.collect(Collectors.toSet());
		System.out.println("set : " + set);
		System.out.println(set.getClass());

		/**
		 * in einer LinkedList gesammelt
		 * 
		 * Collector<T, ?, C> toCollection(Supplier<C> collectionFactory)
		 * 
		 * Collector<Integer, ?, LinkedList<Integer>> collector
		 */
		myStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10);

//		Supplier<LinkedList<Integer>> supplier = () -> {return new LinkedList<Integer>();};
		Supplier<LinkedList<Integer>> supplier = LinkedList::new;
		Collector<Integer, ?, LinkedList<Integer>> colLinked = Collectors.toCollection(supplier);
		LinkedList<Integer> linkedList = myStream.collect(colLinked);
		System.out.println("linkedList : " + linkedList);
		System.out.println(linkedList.getClass());

		myStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10);
		Collection<Integer> collection = myStream.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("collection : " + collection);
		System.out.println(collection.getClass());
	}
}
