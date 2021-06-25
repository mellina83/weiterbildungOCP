package ml.duerbeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import pak02_equals_hashcode.interfaces.Artikel;

public class Personen_Main {

	public static void main(String[] args) {
		Person person1 = new Person("Speedy Gonzales", 21);
		Person person2 = new Person("Naruto Uzumaki", 16);
		Person person3 = new Person("Bruce Wayne", 42);
		Person person4 = new Person("Minnie Maus", 34);
		Person person5 = new Person("Minnie Maus", 25);
		Person person6 = new Person("Bruce Wayne", 42);
		
		//Comparatoren
		ComparePersonenNachName coName = new ComparePersonenNachName();
		ComparePersonenNachAlter coAlter = new ComparePersonenNachAlter();
		ComparePersonenNachAlles coAlles = new ComparePersonenNachAlles();
		
		//Tree Set
		System.out.println("Tree Set:");
		Set<Person> personen = new TreeSet<>();
		personen.add(person1);
		personen.add(person2);
		personen.add(person3);
		personen.add(person4);
		personen.add(person5);
		personen.forEach(System.out::println);
		System.out.println(personen.add(person6));
		
		//Arraylist
		System.out.println("\nArrayList");
		List<Person> personenliste = new ArrayList<>();
		personenliste.add(person4);
		personenliste.add(person5);
		personenliste.add(person3);
		personenliste.add(person2);
		personenliste.add(person1);
		System.out.println(personenliste.add(person6));
		personenliste.forEach(System.out::println);
		
		System.out.println("Arraylist mit Comparator nach Name");
		Collections.sort(personenliste, coName);
		personenliste.forEach(System.out::println);
		System.out.println("Arraylist mit Comparator nach Alter");
		Collections.sort(personenliste, coAlter);
		personenliste.forEach(System.out::println);
		System.out.println("Arraylist mit Comparator nach Name, dann Alter");
		Collections.sort(personenliste, coAlles);
		personenliste.forEach(System.out::println);
		
		//Array
		System.out.println("\nArray:");
		Person[] personenarray = new Person[6];
		personenarray[0] = person1;
		personenarray[1] = person2;
		personenarray[2] = person3;
		personenarray[3] = person4;
		personenarray[4] = person5;
		personenarray[5] = person6;
		
		Arrays.stream(personenarray).forEach(System.out::println);
		
		System.out.println("Array mit Comparator nach Name");
		Arrays.sort(personenarray, coName);
		Arrays.stream(personenarray).forEach(System.out::println);
		System.out.println("Array mit Comparator nach Alter");
		Arrays.sort(personenarray,coAlter);
		Arrays.stream(personenarray).forEach(System.out::println);
		System.out.println("Array mit Comparator nach Name, dann Alter");
		Arrays.sort(personenarray, coAlles);
		Arrays.stream(personenarray).forEach(System.out::println);
	}

}
