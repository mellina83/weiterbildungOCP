package aufgaben.a05;

import java.util.Map;
import java.util.TreeMap;

/***
 * @Thema 'TreeMap'
 * 
 * @Aufgabe01 Lassen Sie sich den ersten und letzten Key ausgeben.
 *
 * @Aufgabe02 Lassen Sie sich den ersten und letzten Entry ausgeben.
 * 
 * @Aufgabe03 Suchen nach folgenden Einträgen<Entry> in der Map
 * 
 *            - kleiner oder gleich 55
 * 
 *            - größer oder gleich 555
 * 
 *            - kleiner 3
 * 
 *            - größer 456
 * 
 * @Aufgabe04 Suchen nach folgenden Schlüssel<Keys> in der Map
 * 
 *            - kleiner oder gleich 55
 * 
 *            - größer oder gleich 555
 * 
 *            - kleiner 3
 * 
 *            - größer 456
 * 
 * @Aufgabe05 Geben Sie die Map Aufsteigend und Absteigend Sortiert aus.
 * 
 *            Verwenden Sie dafür:
 * 
 *            - descendingKeySet
 * 
 *            - descendingMap
 * 
 *            Welche Consumer müssen verwendet werden?
 * 
 * @Aufgabe06 Zerlegen Sie die Map.
 * 
 *            Verwenden Sie dafür, jeweils immer 'inklusive':
 * 
 *            - subMap : von 3 bis 666
 * 
 *            - headMap : bis 234
 * 
 *            - tailMap : von 55
 * 
 *            Wieviele Einträge beinhalten die Teilmaps?
 * 
 * @Bonus Wie kann eine Map mit einem Iterator verwendet werden?
 * 
 *        Direkt geht das nicht, nur über die verschiedenen Collections welche
 *        wir aus einer Map erhalten können.
 */
public class AufgabeML {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		fuelleMap(map);

//		aufgabe01(map);

//		aufgabe02(map);

//		aufgabe03(map);

//		aufgabe04(map);

//		aufgabe05(map);

//		aufgabe06(map);
	}

	/**
	 * Zerlegen Sie die Map.
	 * 
	 * Verwenden Sie dafür, jeweils immer 'inklusive':
	 * 
	 * - subMap : von 3 bis 666
	 * 
	 * - headMap : bis 234
	 * 
	 * - tailMap : von 55
	 * 
	 * Wieviele Einträge beinhalten die Teilmaps?
	 */
	private static void aufgabe06(TreeMap<Integer, String> map) {
		System.out.println("subMap : von 3 bis 666 = " + map.subMap(3, true, 666, true).size());

		System.out.println("headMap : bis 234 = " + map.headMap(234, true).size());

		System.out.println("tailMap : von 55 = " + map.tailMap(55).size());
	}

	/**
	 * Geben Sie die Map Aufsteigend und Absteigend Sortiert aus.
	 * 
	 * Verwenden Sie dafür:
	 * 
	 * - descendingKeySet
	 * 
	 * - descendingMap
	 * 
	 * Welche Consumer müssen verwendet werden?
	 * 
	 * Consumer und BiConsumer
	 */
	private static void aufgabe05(TreeMap<Integer, String> map) {
		/*
		 * Map Aufsteigend BiConsumer
		 */
		map.forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("---------------");
		/*
		 * Map Absteigend BiConsumer
		 */
		map.descendingMap().forEach((k, v) -> System.out.println(k + " : " + v));
		System.out.println("---------------");
		/*
		 * Set Aufsteigend Consumer
		 */
		map.keySet().forEach((k) -> System.out.println(k + " : " + map.get(k)));
		System.out.println("---------------");
		/*
		 * Set Absteigend Consumer
		 */
		map.descendingKeySet().forEach((k) -> System.out.println(k + " : " + map.get(k)));
		System.out.println("---------------");
	}

	/**
	 * Suchen nach folgenden Schlüssel<Keys> in der Map
	 * 
	 * - kleiner oder gleich 55
	 * 
	 * - größer oder gleich 555
	 * 
	 * - kleiner 3
	 * 
	 * - größer 456
	 */
	private static void aufgabe04(TreeMap<Integer, String> map) {
		map.forEach((k, v) -> System.out.println(k + " : " + v));

		// kleiner oder gleich
		Integer floorKey = map.floorKey(55);
		// größer oder gleich
		Integer ceilingKey = map.ceilingKey(555);
		// strikt kleiner
		Integer lowerKey = map.lowerKey(3);
		// strikt größer
		Integer higherKey = map.higherKey(456);

		System.out.println("floorKey");
		System.out.println("Key = " + floorKey);
		System.out.println("Value = " + map.get(floorKey));

		System.out.println("ceilingKey");
		System.out.println("Key = " + ceilingKey);
		System.out.println("Value = " + map.get(ceilingKey));

		System.out.println("lowerKey");
		System.out.println("Key = " + lowerKey);
		System.out.println("Value = " + map.get(lowerKey));

		System.out.println("higherKey");
		System.out.println("Key = " + higherKey);
		System.out.println("Value = " + map.get(higherKey));

	}

	/**
	 * Suchen nach folgenden Einträgen<Entry> in der Map
	 * 
	 * - kleiner oder gleich 55
	 * 
	 * - größer oder gleich 555
	 * 
	 * - kleiner 3
	 * 
	 * - größer 456
	 * 
	 */
	private static void aufgabe03(TreeMap<Integer, String> map) {
		map.forEach((k, v) -> System.out.println(k + " : " + v));

		// kleiner oder gleich
		Map.Entry<Integer, String> floorEntry = map.floorEntry(55);// 55 : Ruby on Rails
		// größer oder gleich
		Map.Entry<Integer, String> ceilingEntry = map.ceilingEntry(555);// 666 : Scala
		// strikt kleiner
		Map.Entry<Integer, String> lowerEntry = map.lowerEntry(3);// 2 : Java
		// strikt größer
		Map.Entry<Integer, String> higherEntry = map.higherEntry(456);// 666 : Scala

		System.out.println("floorEntry");
		System.out.println("Key = " + floorEntry.getKey());
		System.out.println("Value = " + floorEntry.getValue());

		System.out.println("ceilingEntry");
		System.out.println("Key = " + ceilingEntry.getKey());
		System.out.println("Value = " + ceilingEntry.getValue());

		System.out.println("lowerEntry");
		System.out.println("Key = " + lowerEntry.getKey());
		System.out.println("Value = " + lowerEntry.getValue());

		System.out.println("higherEntry");
		System.out.println("Key = " + higherEntry.getKey());
		System.out.println("Value = " + higherEntry.getValue());

	}

	/**
	 * Lassen Sie sich den ersten und letzten Entry ausgeben.
	 */
	private static void aufgabe02(TreeMap<Integer, String> map) {
		/*
		 * Liefert SimpleImmutableEntry<K,V> aus der Klasse AbstractMap<K,V>
		 * 
		 * ACHTUNG DIE ENTRY´s von TreeMap und HashMap unterscheiden sich dahingehend,
		 * dass die Entry´s aus dem TreeMap Immutable sind.
		 * 
		 * Die Zeilen firstEntry.setValue("COBOL"); und lastEntry.setValue("Scala");
		 * erzeugen eine java.lang.UnsupportedOperationException.
		 * 
		 * 
		 * Nur Entry´s einer HashMap lassen das setValue zu.
		 */
		Map.Entry<Integer, String> firstEntry = map.firstEntry();
		Map.Entry<Integer, String> lastEntry = map.lastEntry();

		System.out.println(firstEntry);
		System.out.println(lastEntry);

//		firstEntry.setValue("COBOL");
//		lastEntry.setValue("Scala");

		System.out.println(firstEntry);
		System.out.println(lastEntry);

	}

	/**
	 * Lassen Sie sich den ersten und letzten Key ausgeben.
	 */
	private static void aufgabe01(TreeMap<Integer, String> map) {
		map.forEach((k, v) -> System.out.println(k + " : " + v));

		Integer firstKey = map.firstKey();
		Integer lastKey = map.lastKey();
		System.out.println("-----------------------");
		System.out.println(firstKey + " : " + map.get(map.firstKey()));
		System.out.println(lastKey + " : " + map.get(map.lastKey()));

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
