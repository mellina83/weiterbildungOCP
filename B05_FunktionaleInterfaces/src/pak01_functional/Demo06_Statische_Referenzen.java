package pak01_functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

interface MyPersonConsumer{
	void consume(Person p);
}

public class Demo06_Statische_Referenzen {
	public static void main(String[] args) {
		Person[] persons = {
				new Person("Christian", 44),
				new Person("Susanne", 33),
				new Person("Janine", 33),
				new Person("Heinz", 34),
				new Person("Franz", 34),
				new Person("Fabian", 22) };
		
		Person[][] twoDim = {
				new Person[] {
						new Person("Christian", 44),
						new Person("Susanne", 33),
						new Person("Janine", 33),
						new Person("Heinz", 34),
						new Person("Franz", 34),
						new Person("Fabian", 22)
				},
				new Person[] {
						new Person("Andy", 44),
						new Person("Hans", 33),
						new Person("Loveline", 33),
						new Person("Osman", 34),
						new Person("Philipp", 34),
						new Person("Ulrich", 22)
				}
		};
		
		for(Person p : persons) {
			System.out.println(p);
		}
		
		Comparator<Person> persComp = (p1,p2) -> {return 0;};
		//Person[] a, Comparator<Person> c
		//int compare(Person o1, Person o2);
		
		Comparator<Person> pc2 = Demo06_Statische_Referenzen::vergleichePersonNachAlter;
		
		Arrays.sort(persons, pc2);
		System.out.println("-------------------------------------");
		for(Person p : persons) {
			System.out.println(p);
		}
		System.out.println("-------------------------------------");
		
		MyPersonConsumer mpcLambda = p -> System.out.println(p);
		mpcLambda.consume(persons[0]);
		
		MyPersonConsumer mpcMethodRef = Demo06_Statische_Referenzen::printPersonDSGVOConform;
		mpcMethodRef.consume(persons[0]);
		
		//Externe Iteration
		for(Person p : persons) {
			System.out.println(p);
		}
		System.out.println("-------------------------------------");
		//Interne Iteration
		Arrays.stream(persons).forEach(p-> System.out.println(p));
		System.out.println("-------------------------------------");
		Arrays.stream(persons).forEach(System.out::println);
		
		System.out.println("-------------------------------------");
		Arrays.stream(persons).forEach(Demo06_Statische_Referenzen::printPersonDSGVOConform);
		
		System.out.println("\n************\n");
		//Interne Iteration mit 2 Dimensionales
		
		Arrays.stream(twoDim).forEach(Demo06_Statische_Referenzen::twoDimArray);
		
		Arrays.stream(twoDim).forEach(oneDim -> Arrays.stream(oneDim).forEach(Demo06_Statische_Referenzen::printPersonDSGVOConform));
		
	}
	private static void twoDimArray(Person[] p) {
		Arrays.stream(p).forEach(Demo06_Statische_Referenzen::printPersonDSGVOConform);
	}
	
	private static int vergleichePersonNachAlter(Person p1, Person p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}
	
	private static void printPersonDSGVOConform(Person p) {
		System.out.println("Name: XXXXXX" );
		System.out.println("Alter: " + p.getAge());
	}
}
