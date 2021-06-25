package ml.novytska.Aufgabe_Person.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ml.novytska.Aufgabe_Person.Person;

public class ListTest {

	public static void main(String[] args) {
		PersonListSort();
		
	}

	private static void PersonListSort() {
		List<Person> lperson = new ArrayList<>();
		lperson.add(new Person("Lena", 35));
		lperson.add(new Person("Katerina", 20));
		lperson.add(new Person("Leonie", 25));
		lperson.add(new Person("Michael", 40));
		lperson.add(new Person("Anton", 35));
		lperson.add(new Person("Alex", 31));
		lperson.add(new Person("Lena", 35));
		
		lperson.stream().forEach(System.out::println);
		System.out.println("----------------------------");
		
		Collections.sort(lperson);
		lperson.stream().forEach(System.out::println);
		
	}

}
