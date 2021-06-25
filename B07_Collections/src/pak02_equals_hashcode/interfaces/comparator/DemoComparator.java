package pak02_equals_hashcode.interfaces.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pak02_equals_hashcode.interfaces.Artikel;

public class DemoComparator {
	//Pre Java 8
	static Comparator<Artikel> compNameKlassenObjekt = getCompKlassenObjekt();
	static Comparator<Artikel> compNameAnoObj = getCompAnoClass();
	//Since Java 8
	static Comparator<Artikel> compNameLambda = getCompLambda();
	static Comparator<Artikel> compNameStaticMethRef = methodStaticRefComp();
	static Comparator<Artikel> compNameObjMethRef = methodObjRefComp();
	static Comparator<Artikel> compNameUnknownObj = methodObjRefComp2();
	

	public static void main(String[] args) {

	}

	private static void demo01ObjComp() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, compNameKlassenObjekt);

		lArtikel.forEach(System.out::println);

	}

	private static void demo02AnoObjComp() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, new Comparator<Artikel>() {
			@Override
			public int compare(Artikel o1, Artikel o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		lArtikel.forEach(System.out::println);

	}

	private static void demo03StaticMethodRefComp() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, methodStaticRefComp());
		Collections.sort(lArtikel, DemoComparator::sortArtikelNachNameStatic);

		lArtikel.forEach(System.out::println);

	}

	private static void demo04NonStaticMethodRefComp() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, methodObjRefComp());

		lArtikel.forEach(System.out::println);

	}

	private static void demo05NonStaticMethodRefComp2() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, methodObjRefComp2());

		lArtikel.forEach(System.out::println);

	}

	private static void demo03ObjMethodRefComp() {
		List<Artikel> lArtikel = fillList();

		lArtikel.forEach(System.out::println);

		Collections.sort(lArtikel, methodObjRefComp());

		lArtikel.forEach(System.out::println);

	}
	
	//Pre Java 8
	//Objekt einer Klasse die Comparator implementiert
	static Comparator<Artikel> getCompKlassenObjekt() {
		return new CompareArtikelNachName();
	}
	
	//Anonyme Klasse
	static Comparator<Artikel> getCompAnoClass(){
		return new Comparator<Artikel>() {
			@Override
			public int compare(Artikel o1, Artikel o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
	}
	
	// Since Java 8
	// Lambda
	static Comparator<Artikel> getCompLambda() {
		return (a1, a2) -> a1.getName().compareTo(a2.getName());
	}

	// Statische Methodenreferenz
	static Comparator<Artikel> methodStaticRefComp() {
		return DemoComparator::sortArtikelNachNameStatic;
	}

	// Methodenreferenz auf bestimmtes Objekt
	static Comparator<Artikel> methodObjRefComp() {
		DemoComparator dc = new DemoComparator();
		return dc::sortArtikelNachNameNonStatic;
	}

	// Methodenreferenz auf unbestimmtes Objekt eines bestimmten Typs
	static Comparator<Artikel> methodObjRefComp2() {
		return Artikel::compareTo;
	}

	static int sortArtikelNachNameStatic(Artikel o1, Artikel o2) {
		return o1.getName().compareTo(o2.getName());
	}

	int sortArtikelNachNameNonStatic(Artikel o1, Artikel o2) {
		return o1.getName().compareTo(o2.getName());
	}

	public static List<Artikel> fillList() {
		List<Artikel> lArtikel = new ArrayList<Artikel>();
		Artikel a = new Artikel("1000", "Mutter 8x10");
		Artikel b = new Artikel("1001", "Dichtungsring 20x100");
		Artikel c = new Artikel("1002", "Abstreifsring 25x125");
		Artikel d = new Artikel("1003", "Montierbarer Zackenring 5x25");

		lArtikel.add(c);
		lArtikel.add(d);
		lArtikel.add(a);
		lArtikel.add(b);

		return lArtikel;
	}
}
