package collections08.bulkoperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

import data.Utility;

public class Demo07MapCompute {

	/**
	 * @compute Attempts to compute a mapping for the specified key and its current
	 *          mapped value (or null if there is no current mapping).
	 * 
	 * 
	 *          For example, to either create or append a String msg to a value
	 *          mapping:
	 * 
	 *          map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
	 * 
	 *          (Method merge() is often simpler to use for such purposes.)
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);
		
		map.put(9, null);
		
		map.forEach(Utility::printMyMap);
		
		String msg = " - Our default Message";

		BiFunction<Integer, String, String> remappingFunction = (k, v) -> (v == null) ? msg : v.concat(msg);
		
		/**
		 * Key '2' gefunden - Value wird hinzugefügt : 'Welt - Our default Message'
		 */
		map.compute(2, remappingFunction);
		map.forEach(Utility::printMyMap);
		System.out.println("---------------");
		
//		Mögliche Exception in thread "main" java.lang.NullPointerException
//		map.compute(9, (k,v)-> v.concat(msg));
//		map.forEach(Utility::printMyMap);
		/**
		 * Key '9' gefunden - Value ist null : wird zu ' - Our default Message'
		 */
		map.compute(9, remappingFunction);
		map.forEach(Utility::printMyMap);
		System.out.println("---------------");
		
		/**
		 * Key '12345' nicht gefunden - Key Value Mapping wird erzeugt : ' - Our default Message'
		 */
		map.compute(12345,remappingFunction);
		map.forEach(Utility::printMyMap);
		System.out.println("---------------");
		
		/**
		 * mögliche Anwendung um alle einträge zu verändern.
		 */
		map.forEach((k,v)-> map.compute(k, remappingFunction));
		map.forEach(Utility::printMyMap);
		System.out.println("---------------");
	}

}
