package pak04_sets.treeset;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Set;

/**
 * 5 Methoden aus dem Interface SortedSet
 * 
 * @subSet() Returns a view of the portion of this set whose elements range from
 *           <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>, exclusive.
 *           (If <tt>fromElement</tt> and <tt>toElement</tt> are equal, the
 *           returned set is empty.) The returned set is backed by this set, so
 *           changes in the returned set are reflected in this set, and
 *           vice-versa. The returned set supports all optional set operations
 *           that this set supports.
 * 
 * @headSet() Returns a view of the portion of this set whose elements are
 *            strictly less than <tt>toElement</tt>. The returned set is backed
 *            by this set, so changes in the returned set are reflected in this
 *            set, and vice-versa. The returned set supports all optional set
 *            operations that this set supports.
 * 
 * @tailSet() Returns a view of the portion of this set whose elements are
 *            greater than or equal to <tt>fromElement</tt>. The returned set is
 *            backed by this set, so changes in the returned set are reflected
 *            in this set, and vice-versa. The returned set supports all
 *            optional set operations that this set supports.
 * 
 * @first() Returns the first (lowest) element currently in this set.
 * 
 * @last() Returns the last (highest) element currently in this set.
 * 
 */
public class Demo02SortedSet {

	public static void main(String[] args) {
//		demoSubSetString();

//		demoTailSet();
//		demoHeadSet();
		
		demoLastElement();
		demoFirstElement();
	}
	
	/**
	 * @first() Returns the first (lowest) element currently in this set.
	 */
	private static void demoFirstElement() {
		SortedSet<String> set = erzeugeStringSet();
		// [A, B, C, D, E, F, G, H, I, J, K]

		String first = set.first();
		System.out.println(first);// A
		set.remove(first);
		first = set.first();
		System.out.println(first);// B

	}

	/**
	 *  * @last() Returns the last (highest) element currently in this set.
	 */
	private static void demoLastElement() {
		SortedSet<String> set = erzeugeStringSet();
		// [A, B, C, D, E, F, G, H, I, J, K]
		String last = set.last();
		System.out.println(last);// K
		set.remove(last);
		last = set.last();
		System.out.println(last);// J	
	}

	/**
	 * @headSet() Returns a view of the portion of this set whose elements are
	 *            strictly less than <tt>toElement</tt>. The returned set is backed
	 *            by this set, so changes in the returned set are reflected in this
	 *            set, and vice-versa. The returned set supports all optional set
	 *            operations that this set supports.
	 */
	private static void demoHeadSet() {
		SortedSet<String> origin = erzeugeStringSet();
		// [A, B, C, D, E, F, G, H, I, J, K]

		/*
		 * Bis zu <toElement> Exklusive, beginnend mit dem ersten Element des Sets
		 */
		Set<String> headSet = origin.headSet("FE");
		System.out.println(headSet);//[A, B, C, D, E, F ]
		headSet.add("FAAAAAAA");
		headSet.add("012345");
		
//		java.lang.IllegalArgumentException: key out of range
//		headSet.add("FE");

		headSet.add("Aa");
		headSet.add("Bb");
		headSet.add("Cc");
		origin.add("Dd");
		origin.add("ZZZ");
		System.out.println("headSet");
		System.out.println(headSet);
		System.out.println("\n\norigin");
		System.out.println(origin);
	}

	/**
	 * @tailSet() Returns a view of the portion of this set whose elements are
	 *            greater than or equal to <tt>fromElement</tt>. The returned set is
	 *            backed by this set, so changes in the returned set are reflected
	 *            in this set, and vice-versa. The returned set supports all
	 *            optional set operations that this set supports.
	 */
	private static void demoTailSet() {
		SortedSet<String> origin = erzeugeStringSet();
		System.out.println(origin);
		// [A, B, C, D, E, F, G, H, I, J, K]

		/*
		 * Von <fromElement> Inklusive, endet mit dem letzten Element aus dem Set
		 */
		Set<String> tailSet = origin.tailSet("G");
		System.out.println(tailSet);// [G, H, I, J, K]

//		Exception in thread "main" java.lang.IllegalArgumentException: 
//		key out of range
//		Beim hinzufügen müssen wir die "range" beachten
//		tailSet.add("F");

		origin.add("Zoey Zoolander");
		tailSet.add("ohje - ausserhalb der range");
		System.out.println(tailSet);// [G, H, I, J, K,Zoey Zoolander]

		System.out.println("\n\n ------ tailSet");
		System.out.println(tailSet);
		System.out.println("\n\n ------ origin");
		System.out.println(origin);
	}

	/**
	 * @subSet() Returns a view of the portion of this set whose elements range from
	 *           <tt>fromElement</tt>, inclusive, to <tt>toElement</tt>, exclusive.
	 *           (If <tt>fromElement</tt> and <tt>toElement</tt> are equal, the
	 *           returned set is empty.) The returned set is backed by this set, so
	 *           changes in the returned set are reflected in this set, and
	 *           vice-versa. The returned set supports all optional set operations
	 *           that this set supports.
	 */
	private static void demoSubSetString() {
		SortedSet<String> origin = erzeugeStringSet();
		System.out.println(origin);

		System.out.println("subSet01");
		Set<String> subSet01 = origin.subSet("C", "H");
		System.out.println(subSet01);// [C, D, E, F, G]
		System.out.println("----------");

		System.out.println("subSet02");
		Set<String> subSet02 = origin.subSet("A", "F");
		System.out.println(subSet02);// [A, B, C, D, E]
		System.out.println("----------");

		origin.add("Duesentrieb");
		subSet01.add("Donnerlidchen");// C - H
		// subSet01.add("Mittwoch");//C - H
		subSet01.add("GGGG");
		subSet02.add("Donnerstag");
		subSet02.add("Aschermittwoch");

		System.out.println("\n\nNach dem Hinzufügen ...\n\n");
		System.out.println("subSet01");
		subSet01.forEach(System.out::println);
		System.out.println("\n\nsubSet02");
		subSet02.forEach(System.out::println);
		System.out.println("\n\norigin");
		origin.forEach(System.out::println);

	}

	public static SortedSet<String> erzeugeStringSet() {
		SortedSet<String> origin = new TreeSet<>();
		origin.add("A");
		origin.add("B");
		origin.add("C");
		origin.add("D");
		origin.add("E");
		origin.add("F");
		origin.add("G");
		origin.add("H");
		origin.add("I");
		origin.add("J");
		origin.add("K");
		return origin;
	}

	public static void fuellePersonCollection(Collection<? super Person> coll) {
		coll.add(new Person("Anja", "Musterfrau"));
		coll.add(new Person("Christina", "Schmidt"));
		coll.add(new Person("Elena", "Heldenreich"));
		coll.add(new Person("Michael", "Musterfrau"));
		coll.add(new Person("Felix", "Amazing"));
		coll.add(new Person("Siri", "Apfel"));
		coll.add(new Person("Cortana", "Winzigweich"));
		coll.add(new Person("Assistent", "Mycroft"));

	}
}
