package function04.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import javax.swing.JOptionPane;

import data.Dog;
import data.Person;
import data.Utility;

public class Demo01Consumer {

	static int sum;

	public static void main(String[] args) {
//		demoConsumer01();
//		demoConsumer02();
//		demoBiConsumer03();

		exkurs();
	}

	private static void exkurs() {
		// Consumer verarbeitet, liefer nichts zurück.
		Consumer<String> myOptionPane = (message) -> JOptionPane.showMessageDialog(null, message);
		
		
		myOptionPane.accept("Hallo Welt, Lambda und GUI");
		myOptionPane.accept("Welche Java Version?");
		myOptionPane.accept("Haben wir Spaß?");
		
		List<String> list = new ArrayList<>();
		list.add("Hallo Welt");
		list.add("Hier ist Java");
		list.add("Funktionale Programmierung");
		list.add("Streams sind toll");
		list.forEach(myOptionPane);
	}

	private static void demoBiConsumer03() {
//		Map<key,value>

		Comparator<Person> comparePerson = (p1, p2) -> {
			int result = p1.getName().compareTo(p2.getName());
			if (result == 0) {
				result = Integer.compare(p1.getAge(), p2.getAge());
			}
			return result;
		};
		Map<Person, List<Dog>> mapPersonDog = new TreeMap<>(comparePerson);

		Person pers1 = new Person("Christian", 50);
		Person pers2 = new Person("Anna", 18);
		Person pers3 = new Person("Bertha", 50);
		Person pers4 = new Person("Bertha", 26);
		Person pers5 = new Person("Anna", 12);

		Dog dog01 = new Dog("boi", 30, 6);
		Dog dog02 = new Dog("tyri", 40, 12);
		Dog dog03 = new Dog("charis", 120, 7);
		Dog dog04 = new Dog("aiko", 50, 10);
		Dog dog05 = new Dog("clover", 35, 12);
		Dog dog06 = new Dog("mia", 15, 4);
		Dog dog07 = new Dog("zooey", 45, 9);
		Dog dog08 = new Dog("waldi", 42, 3);

		mapPersonDog.put(pers1, Arrays.asList(dog01, dog08));
		mapPersonDog.put(pers2, Arrays.asList(dog02, dog07));

		BiConsumer<Person, List<Dog>> action = (p, ld) -> {
			System.out.println(p);
			ld.forEach((dog) -> System.out.println(dog));
			System.out.println("----------------------");
		};

		mapPersonDog.forEach(action);
	}

	private static void demoConsumer02() {
		List<String> list = new ArrayList<>();
		list.add("Hallo Welt");
		list.add("Hier ist Java");
		list.add("Funktionale Programmierung");
		list.add("Streams sind toll");

		/*
		 * Alle Texte der Liste untereinander ausgeben
		 */
//		list.forEach(text -> System.out.println(text));
		list.forEach(System.out::println);

		/*
		 * Die länge von jedem Text der Liste untereinander ausgeben
		 */
		list.forEach(text -> System.out.println(text.length()));

		/*
		 * Anzahl der Zeichen von den Texten aus der Liste.
		 */
//		Function<String,Integer> stringToInteger = (s) -> s.length();
		Function<String, Integer> stringToInteger = String::length;

		ToIntFunction<String> primInt = String::length;

		System.out.println("-------------");
		int sum02 = list.stream().mapToInt(primInt).sum();
		System.out.println("Anzahl aller Zeichen = " + sum02);
	}

	/**
	 * 
	 * @Consumer Performs this operation on the given argument.
	 * 
	 *           param t the input argument
	 * 
	 *           void accept(T t);
	 */
	private static void demoConsumer01() {
		List<Integer> list = new ArrayList<>();
		Utility.befuellen(list);// 256:1-100

		Consumer<Integer> outputAsSquare = (Integer i) -> System.out.println(i * i);
		Consumer<Integer> outputCalc = (Integer i) -> System.out.print(i + " * " + i + " = ");

		// list.forEach(outputCalc.andThen(outputAsSquare));

		Consumer<Integer> methodRef = Demo01Consumer::myConsumer;
		list.forEach(methodRef);

		/**
		 * Ich möchte die Summe alle Zahlen ermitteln
		 */
		list.forEach((i) -> sum += i);
		System.out.println("Summe aller Zahlen = " + sum);

		int sum02 = list.stream().mapToInt(i -> i).sum();
		System.out.println("Summe aller Zahlen = " + sum02);
	}

	public static void myConsumer(Integer t) {
		System.out.println(t + " * " + t + " = " + t * t);
	}
}
