package ml.soleiman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("-----------TreeSet-----------");
		
		TreeSet<Person> personen = new TreeSet<>();
		personen.add(new Person("A", 31));
		personen.add(new Person("B", 30));
		personen.add(new Person("C", 29));
		personen.add(new Person("D", 28));
		personen.add(new Person("E", 20));
		personen.add(new Person("F", 50));
		personen.add(new Person("F", 50));

		for (Person person : personen) {
			System.out.println(person);
		}

		System.out.println("-----------ArrayList-----------");

		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person("A", 31));
		pList.add(new Person("B", 30));
		pList.add(new Person("C", 29));
		pList.add(new Person("D", 28));
		pList.add(new Person("E", 20));
		pList.add(new Person("F", 50));

		pList.sort(personen.comparator());
		Collections.sort(pList); //Collection muss Comparable sein
		Collections.sort(pList, personen.comparator());
		pList.forEach(System.out::println);
		
		System.out.println("-----------Einfaches Array-----------");

		Person[] pArray = { new Person("A", 31), new Person("B", 30), new Person("C", 29), new Person("D", 28),
							new Person("E", 20),new Person("F", 50)};
		Arrays.sort(pArray);
		Arrays.sort(pArray, personen.comparator());
		Collections.sort(Arrays.asList(pArray));
		
		Arrays.stream(pArray).forEach(System.out::println);
		
	System.out.println("-----------HashSet-----------");
		
		HashSet<Person> personen1 = new HashSet<Person>();
		personen1.add(new Person("A", 31));
		personen1.add(new Person("B", 30));
		personen1.add(new Person("C", 29));
		personen1.add(new Person("D", 28));
		personen1.add(new Person("E", 20));
		personen1.add(new Person("F", 50));
		personen1.add(new Person("F", 50));
		personen1.add(new Person("A", 31));

		for (Person person : personen1) {
			System.out.println(person);
		}
	}
}
