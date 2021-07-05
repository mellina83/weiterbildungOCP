package collections08.bulkoperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

import data.Utility;

public class Demo08MapComputeIf {

	/**
	 * 
	 * @computeIfPresent If the value for the specified key is present and non-null,
	 *                   attempts to compute a new mapping given the key and its
	 *                   current mapped value.
	 * 
	 * 
	 * @computeIfAbsent If the specified key is not already associated with a value
	 *                  (or is mapped to null), attempts to compute its value using
	 *                  the given mapping function and enters it into this map
	 *                  unless null.
	 */
	public static void main(String[] args) {
//		demoMapComputeIfPresent01();
		demoMapComputeIfAbsent01();
	}

	/**
	 * @computeIfAbsent If the specified key is not already associated with a value
	 *                  (or is mapped to null), attempts to compute its value using
	 *                  the given mapping function and enters it into this map
	 *                  unless null.
	 */
	private static void demoMapComputeIfAbsent01() {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);

		map.put(9, null);

		String msg = " - Our default Message";

		Function<Integer,String> mapping = key -> key.toString() + msg;
		
		/**
		 * Key '2' gefunden - Value ist vorhanden : Der Eintrag bleibt unverändert
		 */
		map.computeIfAbsent(2, mapping);
		
		/**
		 * Key '9' gefunden - Value ist null : - Das Value angepasst
		 */
		map.computeIfAbsent(9, mapping);
		
		/**
		 * Key '12345' nicht gefunden - : Es wird ein Eintrag erzeugt.
		 */
		map.computeIfAbsent(12345, mapping);
		
		map.forEach(Utility::printMyMap);
	}

	/**
	 * @computeIfPresent If the value for the specified key is present and non-null,
	 *                   attempts to compute a new mapping given the key and its
	 *                   current mapped value.
	 */
	private static void demoMapComputeIfPresent01() {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);

		map.put(9, null);

		String msg = " - Our default Message";

		/**
		 * Key '2' gefunden - Value ist vorhanden : wird hinzugefügt
		 * 
		 * 'Welt - Our default Message'
		 */
		map.computeIfPresent(2, (k, v) -> v.concat(msg));
		map.forEach(Utility::printMyMap);

		/**
		 * Key '9' gefunden - Value ist null : - Das Value wird nicht verändert.
		 */
//		map.compute(9, (k,v) -> v.concat(msg));
		map.computeIfPresent(9, (k, v) -> v.concat(msg));

		/**
		 * Key '12345' nicht gefunden - : Es wird kein Eintrag erzeugt.
		 */
		map.computeIfPresent(12345, (k, v) -> v.concat(msg));
		System.out.println("---------------");
		map.forEach(Utility::printMyMap);
	}

}
