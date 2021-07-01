package function04.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import data.Utility;

public class Demo01Consumer {

	static int sum;
	
	public static void main(String[] args) {
//		demoConsumer01();
		demoConsumer02();

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
		Function<String,Integer> stringToInteger = String::length;
		
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

		//list.forEach(outputCalc.andThen(outputAsSquare));
		
		Consumer<Integer> methodRef = Demo01Consumer::myConsumer;
		list.forEach(methodRef);
		
		/**
		 * Ich möchte die Summe alle Zahlen ermitteln
		 */
		list.forEach((i) -> sum +=i);
		System.out.println("Summe aller Zahlen = " + sum);
		
		int sum02 = list.stream().mapToInt(i->i).sum();
		System.out.println("Summe aller Zahlen = " + sum02);
	}

	public static void myConsumer(Integer t) {
		System.out.println(t + " * " + t + " = " + t * t);
	}
}
