package ml.novytska.Aufgabe_Person.Array;
import java.util.Arrays;

import ml.novytska.Aufgabe_Person.Person;
public class ArrayTest {

	public static void main(String[] args) {
		PersonArraySort();
		
	}
	private static void PersonArraySort() {
		Person [] arr = {new Person("Lena", 35),
		new Person("Katerina", 20),
		new Person("Leonie", 25),
		new Person("Michael", 40),
		new Person("Anton", 35),
		new Person("Alex", 31),
		new Person("Lena", 35),
		new Person("Borys", 18)};
		
		
		Arrays.stream(arr).forEach(System.out::println);
		
		Arrays.sort(arr);
		
		System.out.println("----------------------------");
		
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	

}
