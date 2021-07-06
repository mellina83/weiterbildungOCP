package streams09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @sorted Returns a stream consisting of the elements of this stream, sorted
 *         according to natural order. If the elements of this stream are not
 *         Comparable, a java.lang.ClassCastException may be thrown when the
 *         terminal operation is executed.
 * 
 * @sorted(Comparator) Returns a stream consisting of the elements of this
 *                     stream, sorted according to the provided Comparator.
 */
public class Demo05Sorted {

	public static void main(String[] args) {
		demoSorted();

	}

	private static void demoSorted() {
		List<Integer> list = Arrays.asList(1,-55,951,-44,-75,236,-14);
		
		System.out.println("List ausgabe per Stream Sortiert");
		list.stream().sorted().forEach(i-> System.out.print(i +","));
		System.out.println();
		System.out.println(list);
//		list.sort(Integer::compareTo);
//		list.forEach(i-> System.out.print(i +","));
//		System.out.println();
//		System.out.println(list);
		
		System.out.println("List ausgabe per Stream Sortiert, mit einen Comparator");
		Comparator<Integer> cmp = (i1,i2) -> Integer.compare(i2,i1);
		list.stream().sorted(cmp).forEach(i-> System.out.print(i +","));

		
		List<String> listOfStrings = Arrays.asList("a","A","aa","abBB","AbA","F","g");
		System.out.println("\nlistOfStrings ausgabe per Stream Sortiert, mit dem Comparator");
		listOfStrings.stream()
														 //  s2,s1        s1.compare(s2)
					 .sorted((s2,s1) -> s1.compareTo(s2))//("a","A")   -> A.compare(a);
					 									 //               65.compare(97);
					 .forEach(s -> System.out.print(s + " ,"));
		
		System.out.println("\nlistOfStrings ausgabe per Stream Sortiert");
		listOfStrings.stream()
					 .sorted()
					 .forEach(s-> System.out.print(s +","));
		
	}

}
