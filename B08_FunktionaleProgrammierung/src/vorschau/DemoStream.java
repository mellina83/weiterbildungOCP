package vorschau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class DemoStream {

	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10, 11, 12, 13, 14);

		Stream<Integer> myStream = myList.stream();

		// myStream.forEach(i -> System.out.print(i + ","));
		/**
		 * java.lang.IllegalStateException:
		 * 
		 * stream has already been operated upon or closed
		 */
		// myStream.forEach(i -> System.out.print(i + ","));

		/**
		 * Vorgabe : Keine Doppelten Einträge
		 */
//		myStream.distinct().forEach(i -> System.out.print(i + ","));

		/**
		 * Vorgabe : Keine Doppelten Einträge und nur gerade Zahlen
		 */
//		myStream.distinct().filter((i)-> i%2==0).forEach(i -> System.out.print(i + ","));

		/**
		 * Vorgabe : Keine Doppelten Einträge und nur gerade Zahlen
		 * 
		 * Wenn die Zahl >= 10 dann bitte einen String erzeugen mit Alarm Meldung in
		 * eine Collection
		 */
		Set<Integer> zahlen = new HashSet<>(myList);
		zahlen.removeIf((i) -> i % 2 == 0);
		List<String> zahlenAlsString = new ArrayList<>();
		zahlen.forEach((zahl) -> {
			if (zahl >= 10)
				zahlenAlsString.add(zahl + " Alarm");
		});

		myStream.distinct()
				.filter((i) -> i % 2 == 0)
				.filter(i -> i >= 10)
				.map(i -> i + " Alarm")
				.forEach(message -> JOptionPane.showMessageDialog(null, message));
	}

}
