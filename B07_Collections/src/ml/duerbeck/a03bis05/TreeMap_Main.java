package ml.duerbeck.a03bis05;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMap_Main {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		fuelleMap(map);
		
		//Aufgabe 1 und 2
		System.out.println("Aufgabe 1: Erster und letzter Key");
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println("\nAufgabe 2: Erster und letzter Entry");
		System.out.println(map.firstEntry());
		System.out.println(map.lastEntry());
		
		//Aufgabe 3
		System.out.println("\nAufgabe 3: Suche nach diversen Eintraegen");
		System.out.println("Kleiner oder gleich 55: " + map.floorEntry(55));
		System.out.println("Groesser oder gleich 555: " + map.ceilingEntry(555));
		System.out.println("Kleiner 3: " + map.lowerEntry(3));
		System.out.println("Groesser 456: " + map.higherEntry(456));
		
		//Aufgabe 4
		System.out.println("\nAufgabe 4: Suche nach diversen Keys");
		System.out.println("Kleiner oder gleich 55: " + map.floorKey(55));
		System.out.println("Groesser oder gleich 555: " + map.ceilingKey(555));
		System.out.println("Kleiner 3: " + map.lowerKey(3));
		System.out.println("Groesser 456: " + map.higherKey(456));
		
		//Aufgabe 5
		System.out.println("\nAufgabe 5: Sortierung aufsteigend und absteigend");
		
		System.out.println("Sortierung mit descendingKeySet: " + map.descendingKeySet());
		System.out.println("Sortierung mit descendingKeyMap: " + map.descendingMap());
		
		System.out.println("\nSortierung mit BiConsumer aufsteigend");
		BiConsumer<Integer, String> biConsumer = (key, value) -> {
			System.out.print(key + " : ");
			System.out.println(value);
		};
		map.forEach(biConsumer);
		
		//Aufgabe06
		System.out.println("\nAufgabe 6: Zerlegen der Map, alle Werte inklusive + Groesse anzeigen");
		Map<Integer, String> submap = new TreeMap<>(map.subMap(3, true, 666, true));
		System.out.println("3 bis 666: " + submap + " Groesse: " + submap.size());
		Map<Integer, String> headmap = new TreeMap<>(map.headMap(234, true));
		System.out.println("bis 234: " + headmap + " Groesse: " + headmap.size());
		Map<Integer, String> tailmap = new TreeMap<>(map.tailMap(55, true));
		System.out.println("von 55: " + tailmap + " Groesse: " + tailmap.size());
		
	}
	
	private static void fuelleMap(Map<Integer, String> paramMap) {
		paramMap.put(456, "Hallo Welt");
		paramMap.put(2, "Java");
		paramMap.put(3, "Python");
		paramMap.put(55, "Ruby on Rails");
		paramMap.put(666, "Scala");
		paramMap.put(789, "C#");
		paramMap.put(1, "C++");
		paramMap.put(234, "Dart");
		paramMap.put(-123, "Fortran");
	}

}
