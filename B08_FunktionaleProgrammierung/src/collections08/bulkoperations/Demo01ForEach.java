package collections08.bulkoperations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Demo01ForEach {

	public static void main(String[] args) {
//		externeIteration();

		interneIteration();
	}

	private static void interneIteration() {
		Collection<Integer> myInts = Arrays.asList(55, 8, 5, 99, 45);
		Collection<String> myStrings = Arrays.asList("Hallo", "Welt", "hier", "ist", "Java");

		myInts.forEach((element) -> System.out.print(element +","));
		System.out.println();
		myStrings.forEach((element) -> System.out.print(element+","));
	}

	private static void externeIteration() {
		List<Integer> myInts = Arrays.asList(55, 8, 5, 99, 45);
		List<String> myStrings = Arrays.asList("Hallo", "Welt", "hier", "ist", "Java");

		for(String str : myStrings) {
			System.out.print(str);
		}
		System.out.println();
		Iterator<Integer> iter = myInts.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
	}

}
