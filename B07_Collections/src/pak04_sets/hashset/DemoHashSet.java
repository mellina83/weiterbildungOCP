package pak04_sets.hashset;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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
		/*
		 * @HashSet Reihenfolge nicht vorhersagbar
		 * 
		 * @LinkedHashSet Einfüge Reihenfolge
		 * 
		 * @TreeSet Sortiert nach natürlicher Reihenfolge
		 */
		Set<Person> anmeldungen = new HashSet<>();
//		Set<Person> anmeldungen = new LinkedHashSet<>();
		
//		Comparator<Person> compVorUndNachname = (p1,p2) ->{
//			System.out.println("Compare : \n\t" + p1 + "\n\t" + p2);
//			int result = p1.getNachname().compareTo(p2.getNachname());
//			if(result==0) {
//				result = p1.getVorname().compareTo(p2.getVorname());
//			}	
//			return result;
//		};
//		Set<Person> anmeldungen = new TreeSet<>();
//		Set<Person> anmeldungen = new TreeSet<>(compVorUndNachname);
		
		anmeldungen.add(new Person("Anja", "Musterfrau"));
		anmeldungen.add(new Person("Christina", "Schmidt"));
		anmeldungen.add(new Person("Elena", "Heldenreich"));
		anmeldungen.add(new Person("Nico", "Musterfrau"));
		anmeldungen.add(new Person("Michael", "Musterfrau"));
		anmeldungen.add(new Person("Hans", "Musterfrau"));
		anmeldungen.add(new Person("Franziska", "Musterfrau"));
		anmeldungen.add(new Person("Alexa", "Amazing"));
		anmeldungen.add(new Person("Siri", "Apfel"));
		anmeldungen.add(new Person("Cortana", "Winzigweich"));
		anmeldungen.add(new Person("Assistent", "Mycroft"));
		anmeldungen.add(new Person("Assistent", "Mycroft"));
		
		System.out.println("Anzahl Anmeldungen: " + anmeldungen.size());//8
		
		/*
		 * Interne Iteration
		 */
		anmeldungen.forEach(System.out::println);
		
		System.out.println("----------");
		/*
		 * erweiterte For-Schleife
		 */
//		for(Person p : anmeldungen) {
//			System.out.println(p.getVorname());
//		}
		
		/*
		 * Iterator
		 */
		Iterator<Person> iter = anmeldungen.iterator();
		
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
