package pak06_maps.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import pak06_maps.Adress;
import pak06_maps.Person;

/**
 * Maps werden gelegentlich auch als: Assoziative Arrays oder Assoziative
 * Speicher bezeichnet.
 *
 * Assoziative Arrays: Im Map liegt Wertepaare: Schlüssel + Wert Begriff kommt
 * daher weil Verknüpfung zwischen Schlüssel und Wert hergestellt wird
 * 
 * Bei einer Map wird sowohl der Schlüssel, nach dem eine Map durchsucht wird,
 * als auch die Bedeutung des Schlüssels durch ein Objekt repräsentiert. Das
 * bedeutet, dass man mit einer Map beliebige Objekte miteinander in Beziehung
 * setzen kann (engl. to map = zuordnen). Daher werden sie auch als
 * Assoziativspeicher bezeichnet.
 * 
 * Die Klasse HashMap<K,V> verwendet den Hash-Code des Schlüssels, um die
 * Position zu ermitteln, an welcher Stelle ein Schlüssel-Wert-Paar in der
 * Collection abgelegt wird.
 * 
 * Entspricht dem Verfahren wie es beim HashSet verwendet wird.
 * 
 * Es können beliebige Objekte als Schluessel verwendet werden, allerdings
 * muessen die Klassen der Schluessel-Objekte ggf. die Methoden equals() und
 * hashCode() implementieren.
 * 
 * A Map cares about unique identifiers. You map a unique key (the ID) to a
 * specific value, where both the key and the value are, of course, objects.
 * You're probably quite familiar with Maps since many languages support data
 * structures that use a key/value or name/value pair. The Map implementations
 * let you do things like search for a value based on the key, ask for a
 * collection of just the values, or ask for a collection of just the keys. Like
 * Sets, Maps rely on the equals() method to determine whether two keys are the
 * same or different.
 * 
 * The HashMap gives you an unsorted, unordered Map. When you need a Map and you
 * don't care about the order (when you iterate through it), then HashMap is the
 * way to go; the other maps add a little more overhead. Where the keys land in
 * the Map is based on the key's hashcode, so, like HashSet, the more efficient
 * your hashCode() implementation, the better access performance you'll get.
 * 
 * HashMap allows one null key and multiple null values in a collection.
 * 
 * 
 * 
 * @get <V> get(Object key) - Returns the value to which the specified key is
 *      mapped, or {@code null} if this map contains no mapping for the key.
 * 
 *      the value to which the specified key is mapped, or null if this map
 *      contains no mapping for the key
 * 
 * @keySet() Set<K> keySet() - Returns a Set view of the keys contained in this
 *           map.
 * 
 * @remove V remove(Object key) - Removes the mapping for a key from this map if
 *         it is present (optional operation). More formally, if this map
 *         contains a mapping from key <tt>k</tt> to value <tt>v</tt> such that
 *         <code>(key==null ?  k==null : key.equals(k))</code>, that mapping is
 *         removed. (The map can contain at most one such mapping.)
 * 
 * @values Collection<V> values() - Returns a {@link Collection} view of the
 *         values contained in this map. The collection is backed by the map, so
 *         changes to the map are reflected in the collection, and vice-versa.
 * 
 * @containsKey containsKey(Object key) - Returns <tt>true</tt> if this map
 *              contains a mapping for the specified key.
 * 
 * @containsValue containsValue(Object value) - Returns <tt>true</tt> if this
 *                map maps one or more keys to the specified value.
 * 
 * @replace V replace(K key, V value) - Replaces the entry for the specified key
 *          only if it is currently mapped to some value.
 */
public class Demo01HashMap {

	static BiConsumer<String, Person> biConsumer = (key, value) -> {
		System.out.print(key + " : ");
		System.out.println(value);
	};

	static BiConsumer<Integer, String> biConsumer02 = (key, value) -> {
		System.out.print(key + " : ");
		System.out.println(value);
	};

	public static void main(String[] args) {
//		demoMap01();
//		demoMap02();
//		demoMap03();
//		demoMap04();
//		demoMap05();

//		demoMapPerson();

//		demoGet();

//		demoGetWithKeySet();

//		demoPut_PutIfAbsent();

//		demoRemove();

//		demoEntrySet();

//		demoValues01();
//		demoValues02();

//		demoContainsKey();
//		demoContainsValue();

		demoReplace();
	}

	/**
	 * @replace V replace(K key, V value) - Replaces the entry for the specified
	 *          key only if it is currently mapped to some value.
	 */
	private static void demoReplace() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);
		
		map.forEach(biConsumer02);
		
		System.out.println("map.replace(3, \"Phaser 3\");");
		map.replace(3, "Phaser 3");
		
		System.out.println("map.replace(7777, \"Phaser 3\");");
		map.replace(7777, "Phaser 3");
		
		/*
		 * Replaces the entry for the specified key only if currently mapped to
		 * the specified value.
		 */
		System.out.println("map.replace(789, \"C#\", \"PHP 9.1234\");");
		map.replace(789, "C#", "PHP 9.1234");
		
		map.forEach(biConsumer02);
	}

	/**
	 * @containsValue containsValue(Object value) - Returns <tt>true</tt> if
	 *                this map maps one or more keys to the specified value.
	 */
	private static void demoContainsValue() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);
		
		if (map.containsValue("Java")) {
			System.out.println("Value gefunden");
		} else {
			System.out.println("Value nicht gefunden");
		}
	}

	/**
	 * @containsKey containsKey(Object key) - Returns <tt>true</tt> if this map
	 *              contains a mapping for the specified key.
	 */
	private static void demoContainsKey() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		if (map.containsKey(678)) {
			System.out.println("Key gefunden");
		} else {
			System.out.println("Key nicht gefunden");
		}

	}

	private static void demoValues02() {
		Map<Integer, Person> map = new HashMap<>();
		map.put(1, new Person("Christian", "Schirmer"));
		map.put(2, new Person("Christina", "Schirmer"));
		map.put(3, new Person("Christiane", "Schirmer"));
		map.put(4, new Person("Christine", "Schirmer"));

		List<Person> listOfValues = new ArrayList<>(map.values());

		listOfValues.forEach((person) -> System.out.println(person));

		map.put(345, new Person("Dozent", "Trainer"));

		System.out.println("---\nNach dem Hinzufügen\n---");
		listOfValues.forEach((person) -> System.out.println(person));

		for (int i = 0; i < listOfValues.size(); i++) {
//			listOfValues.set(i, new Person("a", "b"));
			listOfValues.get(i).setVorname("A");
		}
		System.out.println("---\nNach dem ändern.\n---");
		listOfValues.forEach((person) -> System.out.println(person));
		System.out.println("Inhalt der Map");
		map.forEach((key, value) -> {
			System.out.print(key + " : ");
			System.out.println(value);
		});
	}

	private static void demoValues01() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		System.out.println(map.values().getClass());

		List<String> listOfValues = new ArrayList<>(map.values());

		listOfValues.forEach((text) -> System.out.println(text));
		for (int i = 0; i < listOfValues.size(); i++) {
			listOfValues.set(i, "Changed");
		}
		listOfValues.forEach((text) -> System.out.println(text));

		map.forEach(biConsumer02);// Alte Werte oder Changed?
	}

	private static void demoEntrySet() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		Set<Entry<Integer, String>> entrySet = map.entrySet();

		Consumer<Entry<Integer, String>> action = (e) -> {
			System.out.println(e);
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			e.setValue("xxxxx");
		};

		entrySet.forEach(action);
		System.out.println("--------");
		entrySet.forEach(System.out::println);
		System.out.println("--------");
		map.forEach(biConsumer02);
	}

	/**
	 * @remove V remove(Object key) - Removes the mapping for a key from this map if
	 *         it is present (optional operation). More formally, if this map
	 *         contains a mapping from key <tt>k</tt> to value <tt>v</tt> such that
	 *         <code>(key==null ?  k==null : key.equals(k))</code>, that mapping is
	 *         removed. (The map can contain at most one such mapping.)
	 */
	private static void demoRemove() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		/**
		 * Foreach für Listen und Sets nutzen das Consumer Interface
		 */
		Set<Integer> keys = map.keySet();
		keys.forEach((x) -> System.out.println(x));

		System.out.println("----- Remove 678");

		String value = map.remove(678);
		System.out.println("Value : " + value);

		/**
		 * Beim überladenen Remove müssen beide Kriterien zutreffen, damit der eintrag
		 * entfernt wird.
		 * 
		 * @param key   key with which the specified value is associated
		 * 
		 * @param value value expected to be associated with the specified key
		 */
		System.out.println("map.remove(55, \"J2EE\") : " + map.remove(55, "J2EE"));
		System.out.println("map.remove(55, \"Ruby on Rails\") : " + map.remove(55, "Ruby on Rails"));
		map.forEach(biConsumer02);
	}

	/**
	 * @put Associates the specified value with the specified key in this
	 *      map(optional operation). If the map previously contained a mapping for
	 *      the key, the old value is replaced by the specified value. (A map m is
	 *      said to contain a mapping for a key k if and only if m.containsKey(k)
	 *      would return true.)
	 * 
	 * @putIfAbsent If the specified key is not already associated with a value (or
	 *              is mapped to null) associates it with the given value and
	 *              returns null, else returns the current value.
	 */
	private static void demoPut_PutIfAbsent() {
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "Hallo");
		map.put(1, "Java");

		System.out.println(map.get(1));// Java

		map.putIfAbsent(1, "Wir lernen C#");

		System.out.println(map.get(1));// Java
	}

	/**
	 * @get V get(Object key) - Returns the value to which the specified key is
	 *      mapped, or {@code null} if this map contains no mapping for the key.
	 * 
	 * @keySet() Set<K> keySet() - Returns a Set view of the keys contained in this
	 *           map.
	 */
	private static void demoGetWithKeySet() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		Set<Integer> keys = map.keySet();
//		Set<Integer> keys = new TreeSet<>(map.keySet());
		for (Integer key : keys) {
			System.out.println("Key : " + key + " = " + " Value :" + map.get(key));
		}
		System.out.println("-------");
		Set<Integer> sorted = new TreeSet<>(keys);
		for (Integer key : sorted) {
			System.out.println("Key : " + key + " = " + " Value :" + map.get(key));
		}
	}

	/**
	 * @get <V> get(Object key) - Returns the value to which the specified key is
	 *      mapped, or 'null' if this map contains no mapping for the key.
	 * 
	 */
	private static void demoGet() {
		Map<Integer, String> map = new HashMap<>();
		fuelleMap(map);

		String tmp = map.get(1);
		System.out.println(tmp);// C++

		tmp = map.get(234);
		System.out.println(tmp);// Dart

		tmp = map.get(-5548);
		System.out.println(tmp);// null
	}

	private static void fuelleMap(Map<Integer, String> paramMap) {
		paramMap.put(456, "Hallo Welt");
		paramMap.put(2, "Java");
		paramMap.put(3, "Python");
		paramMap.put(55, "Ruby on Rails");
		paramMap.put(678, "Scala");
		paramMap.put(789, "C#");
		paramMap.put(1, "C++");
		paramMap.put(234, "Dart");
		paramMap.put(-123, "Fortran");
	}

	private static void demoMapPerson() {
//		Map<String, Person> map = new HashMap<>();
		Map<String, Person> map = new LinkedHashMap<>();
//		Map<String, Person> map = new Hashtable<>();

		map.put("4", new Person("Felix", "Amazing"));
		map.put("456", new Person("Cordula", "Winzig"));
		map.put("3456", new Person("Ursula", "Waterworld"));

		/**
		 * Achtung!!! Wenn Hashtable verwendet wird, darf 'null' nicht als Key verwendet
		 * werden
		 */
		map.put(null, new Person("Ursula", "Waterworld"));
		map.put("3458", new Person("Ursula", "Waterworld"));
		map.put("Hallo", new Person("Ursula", "Waterworld"));

		/**
		 * Wenn wir 2 mal einen Identischen Key angeben, wird der ursprüngliche wert
		 * überschrieben.
		 * 
		 * Somit erscheint Person("Danach ", "war ich da") in der Map.
		 */
		map.put("Upsi", new Person("Ich War", "zuerst da"));
		map.put("Upsi", new Person("Danach ", "war ich da"));

//		System.out.println(map);
		map.forEach(biConsumer);

	}

	private static void demoMap05() {
		Map<Person, Set<Adress>> myMap = new HashMap<>();

		Person p01 = new Person("Anja", "Musterfrau");
		Adress a01 = new Adress("Musterstrasse", "12345");
		Adress a02 = new Adress("Niemandsland", "987654");

		myMap.put(p01, new HashSet<>());
		myMap.get(p01).add(a01);
		myMap.get(p01).add(a02);

		System.out.println(myMap);
	}

	enum Family {
		VATER, MUTTER, BRUDER, SCHWESTER
	}

	private static void demoMap04() {
		Map<Person, Map<Person, Family>> myMap = new HashMap<>();

		Person p01 = new Person("Anja", "Musterfrau");
		Person p02 = new Person("Christina", "Schmidt");
		Person p03 = new Person("Elena", "Heldenreich");
		Person p04 = new Person("Michael", "Musterfrau");
		Person p05 = new Person("Felix", "Amazing");
		Person p06 = new Person("Siri", "Apfel");
		Person p07 = new Person("Cortana", "Winzigweich");
		Person p08 = new Person("Assistent", "Mycroft");
		Person p09 = new Person("Assistent", "Mycroft");

		myMap.put(p01, new HashMap<>());
		myMap.get(p01).put(p04, Family.BRUDER);
		myMap.get(p01).put(p02, Family.SCHWESTER);
		myMap.get(p01).put(p07, Family.MUTTER);
		myMap.get(p01).put(new Person("Harald", "Schmidt"), Family.VATER);
		myMap.get(p01).put(new Person("Herbert", "Feuerstein"), Family.VATER);

		System.out.println(myMap);
	}

	private static void demoMap03() {
		Map<Person, Adress> myMap = new HashMap<>();

		Person p01 = new Person("Christian", "Schirmer");
		Person p02 = new Person("Max", "Musterfrau");
		Adress a01 = new Adress("Musterstrasse", "12345");
		Adress a02 = new Adress("Niemandsland", "987654");

		myMap.put(p01, a01);
		myMap.put(p02, a01);
		myMap.put(p01, a02);
		System.out.println(myMap);
		System.out.println(myMap.size());
	}

	private static void demoMap02() {
		System.out.println("-----------\n\nMap<Double,String> myMap = new HashMap<>()\n-----------\n");
		Map<Double, String> myMap = new HashMap<>();

		myMap.put(0.000001, "NullkommaEins");
		myMap.put(0.002, "NullkommaZwei");
		myMap.put(0.0003, "NullkommaDrei");
		myMap.put(0.4, "NullkommaVier");
		myMap.put(0.1, "'Zero'kommaEins");

		System.out.println(myMap);
		System.out.println(myMap.get(0.002));
		System.out.println(myMap.get(1.234));// null
	}

	private static void demoMap01() {
		List<String> myList = new ArrayList<>();
		Map<Integer, String> myMap = new HashMap<>();

		myList.add(0, "Hallo Welt");
//		Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1299, Size: 1
//		myList.add(1299, "Hallo Welt");

		myMap.put(0, "Hallo Welt");
		myMap.put(1, "Hallo Welt");
		myMap.put(1299, "Java ist eine Insel");

		System.out.println(myList.get(0));
		System.out.println(myMap.get(1299));

	}

}
