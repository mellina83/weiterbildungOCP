package pak02_equals_hashcode.interfaces.comparable;

import java.util.Set;
import java.util.TreeSet;

import pak02_equals_hashcode.interfaces.Artikel;

public class DemoComparable {
	public static void main(String[] args) {
		demoTreeSet();
	}

	private static void demoTreeSet() {
		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring");
		Artikel g = new Artikel("1003", "Auch ein Zackenring");
		
		Set<Artikel> artikel = new TreeSet<>();
		
		artikel.add(c); 
		artikel.add(d); 	
		artikel.add(a);
		artikel.add(b);
		
		artikel.forEach(System.out::println);
		
		Artikel e = new Artikel("1000", "Mutter 8x10");
		
		System.out.println(artikel.add(e));
		
		artikel.forEach(System.out::println);
	}
}
