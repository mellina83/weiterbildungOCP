package pak04_sets.treeset;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @lower (E e) Returns the greatest element in this set strictly less than the
 *        given element, or {@code null} if there is no such element.
 * 
 * @higher (E e) Returns the least element in this set strictly greater than the
 *         given element, or {@code null} if there is no such element.
 * 
 * @floor (E e) Returns the greatest element in this set less than or equal to
 *        the given element, or {@code null} if there is no such element.
 * 
 * @ceiling (E e) Returns the least element in this set greater than or equal to
 *          the given element, or {@code null} if there is no such element.
 *
 * @pollFirst Retrieves and removes the first (lowest) element, or returns
 *            {@code null} if this set is empty.
 * 
 * @pollLast Retrieves and removes the last (highest) element, or returns
 *           {@code null} if this set is empty.
 * 
 * @descendingSet Returns a reverse order view of the elements contained in this
 *                set. The descending set is backed by this set, so changes to
 *                the set are reflected in the descending set, and vice-versa.
 *                If either set is modified while an iteration over either set
 *                is in progress (except through the iterator's own
 *                {@code remove} operation), the results of the iteration are
 *                undefined.
 */
public class Demo03NavigableSet {

	public static void main(String[] args) {
		NavigableSet<String> origin = erzeugeStringSet();
		
//		demoLower(origin);
//		demoHigher(origin);
		
//		demoFloor(origin);
//		demoCeiling(origin);
		
//		demoPollFirst(origin);
//		demoPollLast(origin);
		
//		demoDescendingSet(origin);
		
		demoIterator(origin);
	}
	
	private static void demoIterator(NavigableSet<String> origin) {
		Iterator<String> ascIter = origin.iterator();
		
		Iterator<String> descIter = origin.descendingIterator();
		
		while(descIter.hasNext()) {
			System.out.println(descIter.next());
		}
	}

	/**
	 * @descendingSet Returns a reverse order view of the elements contained in this
	 *                set. The descending set is backed by this set, so changes to
	 *                the set are reflected in the descending set, and vice-versa.
	 *                If either set is modified while an iteration over either set
	 *                is in progress (except through the iterator's own
	 *                {@code remove} operation), the results of the iteration are
	 *                undefined.
	 */
	private static void demoDescendingSet(NavigableSet<String> origin) {
		System.out.println("\n\n --- demoDescendingSet --- \n\n");
		NavigableSet<String> descendingSet = origin.descendingSet();
		
		System.out.println("\n\n --- origin");
		System.out.println(origin);
		System.out.println("\n\n --- descendingSet");
		System.out.println(descendingSet);
		
		origin.add("L");
		origin.add("M");
		origin.add("N");
		origin.add("O");
		origin.add("P");
		
		descendingSet.add("Q");
		descendingSet.add("R");
		descendingSet.add("S");
		descendingSet.add("T");
		descendingSet.add("U");
		
		System.out.println("\n\n Nach dem hinzufügen");
		
		System.out.println("\n\n --- origin");
		System.out.println(origin);
		System.out.println("\n\n --- descendingSet");
		System.out.println(descendingSet);
	}

	/**
	 * @pollLast Retrieves and removes the last (highest) element, or returns
	 *           {@code null} if this set is empty.
	 */
	private static void demoPollLast(NavigableSet<String> origin) {
		System.out.println("\n\n --- demoPollLast --- \n\n");
		System.out.println(origin.size());
		String tmp;
		do {
			tmp = origin.pollLast();
			System.out.println("Eintrag : " + tmp);// K - A
//		} while (tmp != null);
//		} while (origin.size() != 0);
		} while (!origin.isEmpty());
		
		System.out.println(origin.size());

	}
	
	/**
	 * @pollFirst Retrieves and removes the first (lowest) element, or returns
	 *            {@code null} if this set is empty.
	 */
	private static void demoPollFirst(NavigableSet<String> origin) {
		System.out.println("\n\n --- demoPollFirst --- \n\n");
		
		String tmp;
		do {
			tmp = origin.pollFirst();
			System.out.println("Eintrag : " + tmp);//A - K
//		} while(tmp != null);
		} while(!origin.isEmpty());
			
	}

	/**
	 * @ceiling (E e) Returns the least element in this set greater than or
	 *          equal to the given element, or {@code null} if there is no such
	 *          element.
	 */
	private static void demoCeiling(NavigableSet<String> origin) {
		System.out.println("demoCeilling Element : F");
		System.out.println(origin.ceiling("F"));// G
		System.out.println("demoCeilling Element : H");
		System.out.println(origin.ceiling("H"));// H
		System.out.println("demoCeilling Element : K");
		System.out.println(origin.ceiling("K"));// K
		System.out.println("demoCeilling Element : ZZZ");
		System.out.println(origin.ceiling("ZZZ"));// null
		System.out.println("demoCeilling Element : 1");
		System.out.println(origin.ceiling("1"));// A
	}

	/**
	 * @floor (E e) Returns the greatest element in this set less than or equal
	 *        to the given element, or {@code null} if there is no such element.
	 */
	private static void demoFloor(NavigableSet<String> origin) {
		System.out.println("demoFloor Element : F");
		System.out.println(origin.floor("F"));//E
		System.out.println("demoFloor Element : A");
		System.out.println(origin.floor("A"));//A
		System.out.println("demoFloor Element : ZZZ");
		System.out.println(origin.floor("ZZZ"));//K	
		System.out.println("demoFloor Element : 1");
		System.out.println(origin.floor("1"));//null
	}

	/**
	 * @higher (E e) Returns the least element in this set strictly greater than
	 *         the given element, or {@code null} if there is no such element.
	 */
	private static void demoHigher(NavigableSet<String> origin) {
		System.out.println("demoHigher Element : F");
		System.out.println(origin.higher("F"));//G
		System.out.println("demoHigher Element : A");
		System.out.println(origin.higher("A"));//B
		System.out.println("demoHigher Element : K");
		System.out.println(origin.higher("K"));//null
	}

	/**
	 * @lower (E e) Returns the greatest element in this set strictly less than
	 *        the given element, or {@code null} if there is no such element.
	 */
	private static void demoLower(NavigableSet<String> origin) {
		System.out.println("demoLower Element : E");
		System.out.println(origin.lower("E"));//D
		System.out.println("demoLower Element : F");
		System.out.println(origin.lower("F"));//E
		System.out.println("demoLower Element : A");
		System.out.println(origin.lower("A"));//null		
	}

	public static NavigableSet<String> erzeugeStringSet() {
		NavigableSet<String> origin = new TreeSet<>();
		origin.add("A");// 65
		origin.add("B");// 66
		origin.add("C");// 67
		origin.add("D");// 68
		origin.add("E");// 69
//		origin.add("F");// 70
		origin.add("G");// 71
		origin.add("H");// 72
		origin.add("I");// 73
		origin.add("J");// 74
		origin.add("K");// 75
		return origin;
	}

}
