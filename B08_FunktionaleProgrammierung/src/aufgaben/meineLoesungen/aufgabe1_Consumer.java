package aufgaben.meineLoesungen;

//Meine Aufgabe ist voellig korrekt und wurde als Musterloesung auserkoren :)

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import function04.consumer.Demo01Consumer;

public class aufgabe1_Consumer {

	public static void main(String[] args) {
		/**
		 * Schreiben Sie bei den TODO�s Lambda Funktionen und Methoden Referenz die die
		 * Methode putIntegers verwenden.
		 * 
		 * Die Funktionen sollen mit StringBuilder, ArrayList und Methoden Referenz
		 * verwendet werden.
		 * 
		 * Consumer
		 * accept(T t)
		 */

		StringBuilder sb = new StringBuilder();
		putIntegers(i -> sb.append(i + " ")); //Lambda
//		putIntegers(sb::append); //Mit Methodenref, allerdings nur ohne Leerzeichen moeglich
		System.out.print("Stringbuilder: " + sb); // Zeile A: 1 2 3 4

		List<Integer> list = new ArrayList<>();
		putIntegers(i -> list.add(i));//Lambda Beispiel
//		putIntegers(list::add); //Mit Methodenref
		System.out.print("\nArrayList: " + list); // Zeile B: [1, 2, 3, 4]
		
		
		// Bitte mit der print Methode von System.out verwenden.
		System.out.print("\nMethodenreferenz mit Sysoutprint: \n");
		putIntegers(i -> System.out.print (i + " ")); //Lambda
		System.out.println();
		putIntegers(System.out::print); //Methodenref, allerdings nur ohne Leerzeichen moeglich
		
	}
	// Bei Eingabe eines Consumers mit Integer als Parameter:
	// 4x: Consumer nimmt i = 1 und soll es ausgeben, dann i = 2 nehmen und ausgeben, etc.
	static void putIntegers(Consumer<Integer> c) {
		for (int i = 1; i <= 4; i++) {
			c.accept(i);
		}
	}

}