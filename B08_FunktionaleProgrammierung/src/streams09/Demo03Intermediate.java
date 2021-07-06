package streams09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Intermediate Zwischen Operationen
 * 
 *               Alle Intermediates erzeugen einen neuen Stream
 * 
 * @Stateful_Operations Zustandsbehaftete Operationen
 * 
 * @distinct Returns a stream consisting of the distinct elements (according to
 *           Object.equals(Object)) of this stream. It Takes no Arguments
 * 
 * @sorted Returns a stream consisting of the elements of this stream, sorted
 *         according to natural order. If the elements of this stream are not
 *         Comparable, a java.lang.ClassCastException may be thrown when the
 *         terminal operation is executed.
 * 
 * @sorted(Comparator) Returns a stream consisting of the elements of this
 *                     stream, sorted according to the provided Comparator.
 * 
 * @limit(maxSize) Returns a stream consisting of the elements of this stream,
 *                 truncated to be no longer than maxSize in length.
 * 
 * 
 * @skip(long) Returns a stream consisting of the remaining elements of this
 *             stream after discarding the first n elements of the stream. If
 *             this stream contains fewer than n elements then an empty stream
 *             will be returned.
 *
 *
 *
 * @Stateless_Operations Zustandslose Operationen
 * 
 * @filter(Predicate) Returns a stream consisting of the elements of this stream
 *                    that match the given predicate.
 * 
 * @map(Function) Returns a stream consisting of the results of applying the
 *                given function to the elements of this stream.
 * 
 * @flatMap(Function) Returns a stream consisting of the results of replacing
 *                    each element of this stream with the contents of a mapped
 *                    stream produced by applying the provided mapping function
 *                    to each element. Each mapped stream is closed after its
 *                    contents have been placed into this stream. (If a mapped
 *                    stream is null an empty stream is used, instead.)
 * 
 * @peek(Consumer) Returns a stream consisting of the elements of this stream,
 *                 additionally performing the provided action on each element
 *                 as elements are consumed from the resulting stream.
 * 
 *
 */
public class Demo03Intermediate {
	static int count;
	public static void main(String[] args) {
		aufgabe01();

	}

	private static void aufgabe01() {
		List<Integer> list = new ArrayList<>();

		Random rand = new Random();
		for (int i = 0; i < 500_000; i++) {
			list.add(rand.nextInt(15));// 0-255
		}

		/**
		 * Aus der Collection einen Stream erstellen.
		 * 
		 * Bitte die Anweisungen in Sinnvoller Reihenfolge durchführen
		 * 
		 * Die ersten 5 Einträge sollen übersprungen werden.
		 * 
		 * In der Ausgabe sollen exakt 15 Elemente erscheinen.
		 * 
		 * Keine Doppelten sind in der Pipeline erlaubt.
		 * 
		 * An Ende sollen die Elemente Komma separiert auf der Konsole ausgegeben
		 * werden.
		 * 
		 * Keine Elemente größer als 50
		 */
		System.out.println("Start");
		Consumer<Integer> action = (i) -> System.out.print(i + ",");
//		list.stream()			 		// Stream<Integer> mit 1000 Elemente
//			.limit(15)					// Stream<Integer> mit 15 Elementen
//			.skip(5)					// Stream<Integer> mit 10 Elementen
//			.distinct()					// Stream<Integer> bis zu 10 ohne doppelte Elemente
//			.filter(i-> i<=50)			// Stream<Integer> bis zu 10 ohne Elemente größer 50
//			.forEach(action);			// Terminal Operation

		Predicate<Integer> filter = i-> {
			count++;
			//System.out.println("\n" + i + " wird geprüft");
			return i<=50;
		};
		list.stream()					// Stream<Integer> mit 1000 Elemente
			.skip(5)					// Stream<Integer> mit 995 Elemente
//			.filter(filter)				// Stream<Integer>           
			.distinct()					// Stream<Integer> bis zu 256(0...255) Elemente keine doppelten mehr
			.filter(filter)		        // Stream<Integer> bis zu 50(0...50) Elemente
			.limit(15)					// Stream<Integer> 20 Elemente
			.forEach(action);
		System.out.println("\nAnzahl filter aufrufe : " + count);
	}

}
