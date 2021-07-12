package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @A01 Bitte gruppieren Sie die Personen nach ihren Berufen.
 * 
 *      Jedem Beruf sollten die Personen zugeordnet werden, die diesen Beruf
 *      aus�ben.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/groupingBy
 * 
 * @A02 Bitte Sammeln Sie alle Berufe, die im Array der Personen vorkommen in
 *      einem Set.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/mapping
 * 
 * @A03 Bitte sammeln Sie die Personen in zwei Partitionen.
 * 
 *      In der ersten befinden sich dann die Personen, die den Beruf
 *      'Lehrer(in)'aus�ben. In der anderen Partition landen alle andere
 *      Personen.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/partitioningBy
 */
public class AufgabeStreams_05_Collectors {

	public static class Person {
		private String name;
		private String beruf;

		public Person(String name, String beruf) {
			this.name = name;
			this.beruf = beruf;
		}

		public String getBeruf() {
			return beruf;
		}
		
		public String getName() {
			return name;
		}

		public String toString() {
			return "Person: " + name;
		}
	}

	
	public static void main(String[] args) {
		Person[] personen = {
				new Person("Mark", "Bauarbeiter(in)"),
				new Person("Bill", "Lehrer(in)"),
				new Person("Hugo", "Metzger(in)"),
				new Person("Egon", "Bauarbeiter(in)"),
				new Person("Franzi", "Lehrer(in)"),
				new Person("Herbert", "Lehrer(in)"),
				new Person("Walter", "Metzger(in)"),
				new Person("Simone", "Bauarbeiter(in)"),
				new Person("Melchior", "Lehrer(in)"),
				new Person("Sven", "Lehrer(in)"),
				new Person("Michaela", "Metzger(in)"),
				new Person("Anna", "Bauarbeiter(in)"),
				new Person("Katrin", "Lehrer(in)")
				};
		
		//Aufgabe 1
		System.out.println("Aufgabe 1");
		List<Person> personenliste = new ArrayList(Arrays.asList(personen));
		
		Function<Person, String> classifier = p -> p.getBeruf();
		Supplier<TreeMap<String, Set<Person>>> mapfactory = TreeMap::new;
		Collector<Person, ?, Set<Person>> downstream = Collectors.toSet();
		
		Collector<Person, ?, TreeMap<String, Set<Person>>> mapCollector = Collectors.groupingBy(classifier, mapfactory, downstream);
		personenliste.stream().collect(mapCollector).forEach((s, t) -> System.out.println(s + t));
		
		//Aufgabe 2
		System.out.println("Aufgabe 2");


		
	}

}
