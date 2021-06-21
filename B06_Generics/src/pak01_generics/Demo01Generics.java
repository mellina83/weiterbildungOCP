package pak01_generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SuppressWarnings("all")
public class Demo01Generics {
	public static void main(String[] args) {
		demoPreJava1_5();
		demoSinceJava1_5();
		demoSinceJava1_7();
		demoSinceJava1_9();
		
	}
	/*
	 * Neu der <> Diamont Operator auf der Instanz Seite fuer anonyme Innere Klassen
	 */
	private static void demoSinceJava1_9() {
//		Predicate<String> pred = new Predicate<>() {
//			@Override
//			public boolean test(String t) {
//				return false;
//			}
//		};		
	}

	/*
	 * Neu der <> Diamont Operator auf der Instanz Seite
	 */
	private static void demoSinceJava1_7() {
		List<String> listofStrings = new ArrayList<>();
		
	}
	/*
	 * Mit der Generizitaet von Klassen, Interfaces und Methoden werden die folgenden
	 * Ziele verfolgt:
	 * 
	 * 1. Hoehere Typsicherheit: Erkennen von Typ-Umwandlungsfehlern zur Kompilierzeit statt zur Laufzeit
	 * 
	 * 2. Wiederverwendbarkeit von Quellcode
	 * 
	 * 3. Vermeiden eines expliziten Casts beim Auslesen aus einer Collection aus Elementen vom Typ Object
	 * 
	 * Generisch bedeutet, dass Klassen, Schnittstellen und Methoden Parameter verwenden,
	 * welche einen Typ darstellen
	 */
	private static void demoSinceJava1_5() {
		List<String> listOfStrings = new ArrayList<String>();
		//The method add(String) in the type List<String> is not applicable for the arguments (Integer)
//		listOfStrings.add(new Integer(1));
		listOfStrings.add("Hallo");
		String s = listOfStrings.get(0);
		
		String tmp;
		for (int i = 0; i < listOfStrings.size(); i++) {
			//Durch den generischen Typ ist kein Casting mehr erforderlich
			tmp = listOfStrings.get(i);
		}	
		//Generics schuetzen nicht vor NullPointerException
		listOfStrings.add(null);
		
	}

	private static void demoPreJava1_5() {
		List list = getList();

		for (int i = 0; i < list.size(); i++) {
			Object tmp2;
			if (list.get(i) instanceof Integer) {
				tmp2 = list.get(i);
				Integer tmp = (Integer) list.get(i);
				System.out.println(tmp);
			} else if (list.get(i) instanceof String) {
				String tmp = (String) list.get(i);
				System.out.println(tmp);
			}
			System.out.println(list.get(i).getClass().getSimpleName());
		}

	}

	private static List getList() {
		List list = new ArrayList();

		list.add(5);
		list.add("Fuenf");
		list.add(new Object());
		list.add(new StringBuilder("Hallo Welt"));
		return list;
	}
}



