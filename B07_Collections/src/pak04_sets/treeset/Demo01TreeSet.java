package pak04_sets.treeset;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Ohne Comparable
 */
class A {

}

/**
 * Mit Comparable
 */
//class A implements Comparable<A>{
//	@Override
//	public int compareTo(A o) {
//		return -1;
//	}
//}

/**
 * TreeSet is ordered and sorted.
 * 
 * The TreeSet is one of two sorted collections (the other being TreeMap). It
 * uses a Red-Black tree structure (but you knew that), and guarantees that the
 * elements will be in ascending order, according to natural order.
 * 
 * Optionally, you can construct a TreeSet with a constructor that lets you give
 * the collection your own rules for what the order should be (rather than
 * relying on the ordering defined by the elements' class) by using a Comparable
 * or Comparator.
 */
public class Demo01TreeSet {

	public static void main(String[] args) {
		Comparator<A> compA = (o1,o2)-> {
			return Integer.compare(o1.hashCode(), o2.hashCode());
		};
		Set<A> setA = new TreeSet<>(compA);
		SortedSet<A> sortA = new TreeSet<>(compA);
		NavigableSet<A> naviA = new TreeSet<>(compA);
		TreeSet<A> treeA = new TreeSet<>(compA);
		
		setA.add(new A());
		setA.add(new A());
		setA.add(new A());
		setA.add(new A());
		
		System.out.println(setA.size());//4

		System.out.println("Beendet");
	}

}
