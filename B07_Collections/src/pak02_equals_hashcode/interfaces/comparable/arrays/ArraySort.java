package pak02_equals_hashcode.interfaces.comparable.arrays;

import java.util.Arrays;

import pak02_equals_hashcode.interfaces.Artikel;

public class ArraySort {
	public static void main(String[] args) {
		demoArraySort();
		
	}

	private static void demoArraySort() {
		Artikel[] arr = new Artikel[4];
		
		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring");
		
		arr[0] = c;
		arr[1] = d;
		arr[2] = a;
		arr[3] = b;
		
		Arrays.stream(arr).forEach(System.out::println);
		/*
		 * ClassCastException, wenn der Typ des Arrays
		 * nicht Comparable ist
		 */
		Arrays.sort(arr);
		System.out.println("----------------------");
		
		Arrays.stream(arr).forEach(System.out::println);
	}
}
