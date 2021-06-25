package ml.novytska.Aufgabe_Person;

import java.util.Set;
import java.util.TreeSet;

public class PersonTest {
	public static void main(String[] args) {
		PersonTreeSet();
	}
	private static void PersonTreeSet(){
		
		Set<Person> persons = new TreeSet<>();
		
		
		persons.add(new Person("Lena", 35));
		persons.add(new Person("Katerina", 20));
		persons.add(new Person("Leonie", 25));
		persons.add(new Person("Michael", 40));
		persons.add(new Person("Anton", 35));
		persons.add(new Person("Alex", 31));
		persons.add(new Person("Lena", 35));
		
		persons.forEach(System.out::println);
		
		System.out.println(persons.add(new Person("Borys", 18)));
		
		persons.forEach(System.out::println);
		
	}
}
