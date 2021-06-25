package pak02_equals_hashcode.eq_hc;

import java.util.HashSet;
import java.util.Set;

public class DemoEquals {
	public static void main(String[] args) {
//		demoEquals01();
//		demoEquals02();
//		demoHashSet01();
//		demoHashSet02();
		demoHashSet03();

	}

	

	/*
	 * Equals und Hashcode sind nicht ueberschrieben
	 */
	private static void demoEquals01() {
		ArtikelOhneEquals a = new ArtikelOhneEquals("1000", "Mutter 8x10");
		ArtikelOhneEquals b = new ArtikelOhneEquals("1001", "Dichtungsring 20x100");
		ArtikelOhneEquals c = new ArtikelOhneEquals("1001", "Dichtungsring 20x100");
		ArtikelOhneEquals d = a;

		System.out.println(a.equals(b));// false
		System.out.println(a.equals(c));// false
		System.out.println(b.equals(c));// false
		System.out.println(a.equals(d));// true

	}

	/*
	 * Hier wurde equals ueberschrieben
	 */
	private static void demoEquals02() {
		ArtikelMitEq_HC a = new ArtikelMitEq_HC("1000", "Mutter 8x10");
		ArtikelMitEq_HC b = new ArtikelMitEq_HC("1001", "Dichtungsring 20x100");
		ArtikelMitEq_HC c = new ArtikelMitEq_HC("1001", "Dichtungsring 20x100");
		ArtikelMitEq_HC d = a;

		System.out.println(a.equals(b));// false
		System.out.println(a.equals(c));// false
		System.out.println(b.equals(c));// true
		System.out.println(a.equals(d));// true
	}

	/*
	 * Equals und Hashcode sind nicht ueberschrieben
	 */
	private static void demoHashSet01() {
		ArtikelOhneEquals a = new ArtikelOhneEquals("1000", "Mutter 8x10");
		ArtikelOhneEquals b = new ArtikelOhneEquals("1001", "Dichtungsring 20x100");
		ArtikelOhneEquals c = new ArtikelOhneEquals("1002", "Abstreifring 25x125");
		ArtikelOhneEquals d = new ArtikelOhneEquals("1003", "Montierbarer Zackenring");

		Set<ArtikelOhneEquals> artikel = new HashSet<>();

		artikel.add(a);
		artikel.add(b);
		artikel.add(c);
		artikel.add(d);

		System.out.println("a: " + a.hashCode());
		System.out.println("b: " + b.hashCode());
		System.out.println("c: " + c.hashCode());
		System.out.println("d: " + d.hashCode());

		System.out.println(artikel);

		ArtikelOhneEquals e = new ArtikelOhneEquals("1000", "Mutter 8x10");

		artikel.add(e);

		System.out.println("e: " + e.hashCode());

		System.out.println(artikel);
	}

	/*
	 * Equals und Hashcode sind nicht ueberschrieben
	 */
	private static void demoHashSet02() {
		ArtikelMitEq_HC a = new ArtikelMitEq_HC("1000", "Mutter 8x10");
		ArtikelMitEq_HC b = new ArtikelMitEq_HC("1001", "Dichtungsring 20x100");
		ArtikelMitEq_HC c = new ArtikelMitEq_HC("1002", "Abstreifring 25x125");
		ArtikelMitEq_HC d = new ArtikelMitEq_HC("1003", "Montierbarer Zackenring");

		Set<ArtikelMitEq_HC> artikel = new HashSet<ArtikelMitEq_HC>();
		artikel.add(a);
		artikel.add(b);
		artikel.add(c);
		artikel.add(d);

		System.out.println("a: " + a.hashCode());
		System.out.println("b: " + b.hashCode());
		System.out.println("c: " + c.hashCode());
		System.out.println("d: " + d.hashCode());

		System.out.println(artikel);

		ArtikelMitEq_HC e = new ArtikelMitEq_HC("1000", "Mutter 8x10");

		artikel.add(e);

		System.out.println("e: " + e.hashCode());

		System.out.println(artikel);
	}

	private static void demoHashSet03() {
		ArtikelMitEqualsOHC a = new ArtikelMitEqualsOHC("1000", "Mutter 8x10");
		ArtikelMitEqualsOHC b = new ArtikelMitEqualsOHC("1001", "Dichtungsring 20x100");
		ArtikelMitEqualsOHC c = new ArtikelMitEqualsOHC("1002", "Abstreifsring 25x125");
		ArtikelMitEqualsOHC d = new ArtikelMitEqualsOHC("1003", "Montierbarer Zackenring");
		
		Set<ArtikelMitEqualsOHC> artikel = new HashSet<ArtikelMitEqualsOHC>();
		
		artikel.add(a);
		artikel.add(b);
		artikel.add(c);
		artikel.add(d);

		System.out.println("a: " + a.hashCode());
		System.out.println("b: " + b.hashCode());
		System.out.println("c: " + c.hashCode());
		System.out.println("d: " + d.hashCode());

		System.out.println(artikel);

		ArtikelMitEqualsOHC e = new ArtikelMitEqualsOHC("1000", "Mutter 8x10");

		artikel.add(e);

		System.out.println("e: " + e.hashCode());

		System.out.println(artikel);
		
	}
}
