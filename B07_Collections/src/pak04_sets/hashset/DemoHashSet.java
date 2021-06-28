package pak04_sets.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * A Set cares about uniqueness — it doesn't allow duplicates.
 * 
 * Your good friend the equals() method determines whether two objects are
 * identical (in which case only one can be in the set).
 * 
 * A HashSet is an unsorted, unordered Set. - EXAM Wichtig
 * 
 * It uses the hashcode of the object being inserted, so the more efficient your
 * hashCode() implementation the better access performance you'll get. Use this
 * class when you want a collection with no duplicates and you don't care about
 * order when you iterate through it.
 * 
 * 
 * A LinkedHashSet is an unsorted, ordered Set(Insertion Order). - EXAM Wichtig
 * 
 * It uses the hashcode of the object being inserted, so the more efficient your
 * hashCode() implementation the better access performance you'll get. Use this
 * class when you want a collection with no duplicates and you care about order
 * when you iterate through it.
 * 
 * 
 * 
 * TreeSet is ordered and sorted. - EXAM Wichtig
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

public class DemoHashSet {

	
	
	public static void main(String[] args) {
//		demoHashSet01();
		demoHashSet02();
	}

	private static void demoHashSet02() {
		Set<Person> anmeldungen = new HashSet<>();
		
		anmeldungen.add(new Person("Anja", "Musterfrau"));
		anmeldungen.add(new Person("Christina", "Schmidt"));
		anmeldungen.add(new Person("Elena", "Heldenreich"));
		anmeldungen.add(new Person("Michael", "Musterfrau"));
		anmeldungen.add(new Person("Alexa", "Amazing"));
		anmeldungen.add(new Person("Siri", "Apfel"));
		anmeldungen.add(new Person("Cortana", "Winzigweich"));
		anmeldungen.add(new Person("Assistent", "Mycroft"));
		anmeldungen.add(new Person("Assistent", "Mycroft"));
		
		System.out.println("Anzahl Anmeldungen: " + anmeldungen.size());//9
		
	}

	private static void demoHashSet01() {
		Set<String> anmeldungen = new HashSet<>();
		
		anmeldungen.add("Christian");
		anmeldungen.add("Elena");
		anmeldungen.add("Anja");
		anmeldungen.add("Michael");
		
		System.out.println("Anzahl Anmeldungen: " + anmeldungen.size());//4
		
		anmeldungen.add("Christina");
		anmeldungen.add("Michael");//
		
		System.out.println("Anzahl Anmeldungen: " + anmeldungen.size());//5
	}

}
