package pak03_lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Demo03SubList {
	public static void main(String[] args) {
		List<Integer> list01 = new ArrayList<>();
//		List<Integer> list01 = new LinkedList<>();
//		List<Integer> list01 = new Vector<>();

		for (int i = 0; i < 25; i++) {
			list01.add(i);
		}

		demoSubList01(list01);
	}

	/**
	 * Returns a view of the portion of this list between the specified fromIndex,
	 * inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the
	 * returned list is empty.) The returned list is backed by this list, so
	 * non-structural changes in the returned list are reflected in this list, and
	 * vice-versa.The returned list supports all of the optional list operations
	 * supportedby this list.
	 * 
	 */

	private static void demoSubList01(List<Integer> origin) {
		System.out.println("--------------SubList 01--------------");

		origin.forEach(i -> System.out.print(i + " , "));
		System.out.println("\n");

		List<Integer> sublist = origin.subList(4, 10);
		sublist.forEach(i -> System.out.print(i + " , "));
		System.out.println("\n");
		
		
		
		sublist.set(0, 999);
		sublist.add(12345);
		/*
		 * Ohne vorheriges Loesen der Subliste, ermoeglichen wir eine
		 * java.util.ConcurrentModificationException sofern wir nochmals
		 * auf die verbundene Liste zugreifen
		 */
//		sublist = null;
		origin.add(1);

		System.out.println("Origin");
		origin.forEach(i -> System.out.print(i + " , "));
		System.out.println("\nSublist");
		sublist.forEach(i -> System.out.print(i + " , "));
		
	}
}
