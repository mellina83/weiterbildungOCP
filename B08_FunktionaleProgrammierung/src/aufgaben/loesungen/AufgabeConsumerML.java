package aufgaben.loesungen;

import java.util.*;
import java.util.function.Consumer;

public class AufgabeConsumerML {

	public static void main(String[] args) {

		/**
		 * Schreiben Sie bei den TODO�s Lambda Funktionen und Methoden Referenz
		 * die die Methode putIntegers verwenden.
		 * 
		 * Die Funktionen sollen mit StringBuilder, ArrayList und Methoden Referenz
		 * verwendet werden.
		 */

		StringBuilder sb = new StringBuilder();
//		putIntegers(i -> sb.append(i));//Lambda
//		putIntegers(sb::append);//Methoden Referenz
		System.out.println(sb); // Zeile A: 1 2 3 4

		List<Integer> list = new ArrayList<>();
		putIntegers(i -> list.add(i));//Lambda Beispiel
//		putIntegers(list::add);//Methoden Referenz
		System.out.println(list); // Zeile B: [1, 2, 3, 4]

		// Bitte mit der print Methode von System.out verwenden.
		//putIntegers(i -> System.out.println(i));
		//putIntegers(System.out::println);
	}

	static void putIntegers(Consumer<Integer> c) {
		for (int i = 1; i <= 4; i++) {
			c.accept(i);
		}
	}

}
