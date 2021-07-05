package collections08.bulkoperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

import data.Utility;

public class Demo06MapReplaceAll {

	/**
	 * @replaceAll(BiFunction) Replaces each entry's value with the result of
	 *                         invoking the given function on that entry until all
	 *                         entries have been processed or the function throws an
	 *                         exception. Exceptions thrown by the function are
	 *                         relayed to the caller.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		demoMapReplace01();

	}

	private static void demoMapReplace01() {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);
		
		/**
		 * Alle Value toUppercase
		 */
		BiFunction<Integer, String, String> toUpperCase = (key,value) ->{
			return value.toUpperCase();
		};
		
		map.replaceAll(toUpperCase);
		
		map.forEach(Utility::printMyMap);
		
		/**
		 * Anonymsieren letzten 3 Stellen sollen XXX werden.
		 * 
		 * Achten Sie bitte darauf, das eventuell Strings kürzer als 3 sein könnten.
		 * Wenn der String kürzer als 3 Zeichen ist, dann bitte auf XXX ersetzen.
		 */
//		BiFunction<Integer, String, String> toAnonym = (key,value) ->{
//			if(value.length()<3) {
//				return "XXX";
//			} else {
//				String tmp = value.substring(0, value.length()-3).concat("XXX");
//				return tmp;
//			}
//		};
		BiFunction<Integer, String, String> toAnonym = (key, value) ->{
			return String.format("%3s", value);//.replaceAll("(...$)", "XXX");
		};
		
		
		map.replaceAll(toAnonym);
		map.forEach(Utility::printMyMap);
		
	}

}
