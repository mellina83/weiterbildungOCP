package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class meinCollectTest {

	public static void main(String[] args) {
		
//collect sammelt Elemente des Streams.
//Anwendung: Ich habe eine Liste, lasse daraus Elemente suchen gemaess einer Vorgabe,
// und moechte diese Elemente dann aber nicht einzeln, sondern als neue Liste haben.
		
//collect(Collector<? super T, A, R> collector
//Rueckgabe: <R, A> R
			
		//Nimmt eine mutable Reduktion der Elemente des Streams vor,
		//mittels Gebrauch eines Collectors.
		//Der Collector ist ein Interface und kapselt die Funktionen,
		//die sonst in der anderen collect-Methode mit
		//Supplier, BiConsumer, BiConsumer als Argumente
		//einzeln aufgerufen werden.
		//Hier kann man dann besondere Funktionen nutzen wie multiple-level Gruppierung
		//oder Aufteilung, die man  in der Collectors-Klasse findet.
		
		/**
		 * <R, A> R collect(Collector<? super T, A, R> collector);
		 * 
		 * in diesem Beispiel
		 * 
		 * R -> result : List<Integer>
		 * 
		 * T -> Type(Input) : Integer
		 * 
		 * A -> the intermediate accumulation type of the Collector
		 * 
		 * A -> Accumulator : ? beziehen wir aus der Collectors Utility
		 * 		Grund: Oft bereits implizit implementiert!
		 * 
		 */
		Stream<Integer> myStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 10);
		
		//In einer Liste sammeln
		//In Collectors:
		//-die Methoden toList, toSet und toMap fuer die Interfaces
		//aber kein Einfluss auf Threads, Typ, Mutabilitaet beim ausge-
		//gegebenen Typ, dann lieber toCollection(supplier) nutzen!
		//-die Methode toCollection(Supplier), um in einer Collection-Klasse zu sammeln
		Collector<Integer, ?, List<Integer>> collList = Collectors.toList();
		Collector<Integer, ?, Set<Integer>> collSet = Collectors.toSet();
		Collector<Integer, ?, ArrayList<Integer>> collAList = Collectors.toCollection(ArrayList::new);
		//Fuer toMap gibt es drei Methoden mit Params
		
		//Weitere Bearbeitung per Stream:
		//List<Integer> a = myStream.collect(collList);
		//Set<Integer> a = myStream.collect(collSet);
		ArrayList<Integer> a = myStream.collect(collAList);
		System.out.println(a);
		
		//Weiteres Beispiel
		Random rand = new Random();
		rand.nextInt(); // Integer.MIN_VALUE - Integer.MAX_VALUE;
		Collection<Integer> randoms = Stream.generate(rand::nextInt).limit(10)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(randoms.size());// Integer.MAX_VALUE
		System.out.println(randoms);
		
//collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,
// BiConsumer<R, R> combiner)
//Rueckgabe: <R> R
		
		//Nimmt eine mutable Reduktion der Elemente des Streams vor.
		//Eine mutable Reduktion bedeutet,
		//dass der reduzierte Wert in einem mutablen
		//Ergebnis-Container gespeichert wird.
		//Das kann zB eine ArrayList sein.
		//Die Elemente sind vereinigt, indem der Zustand des Ergebnisses
		//upgedated wird anstatt das Ergebnis zu ersetzen.
		
		//Im Beispiel
		/**
		 * <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator,
		 * BiConsumer<R, R> combiner);
		 * 
		 * R -> Result : List<Integer>
		 * 
		 * T -> Type(Input) : Integer
		 *  
		 */
		
		Stream<Integer> myStream01 = Stream.of(99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456);
		
		Supplier<List<Integer>> supplier = LinkedList::new;
		//BiConsumer<List<Integer>, Integer> accumulator = (list, i) -> list.add(i);
		BiConsumer<List<Integer>, Integer> accumulator = Collection::add;
		
		//BiConsumer<List<Integer>, List<Integer>> combiner = (left, right) -> left.addAll(right);
		BiConsumer<List<Integer>, List<Integer>> combiner = Collection::addAll;
		
		myStream01 = Stream.of(99, 99, 99, 99, 77, 66, 55, 1, 2, 3, 9, 78, 98, 777, 123456);
		List<Integer> result02 = myStream01.collect(Vector::new,Collection::add,Collection::addAll);
		//List<Integer> liste1 = myStream01.collect(supplier, accumulator, combiner);
		System.out.println(result02);
	}

}
