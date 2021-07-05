package collections08.bulkoperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import data.Utility;
/**
 * forEach()
 * 
 * replaceAll()
 * 
 * compute()
 * 
 * computeIf()
 * 
 * merge()
 */
public class Demo05MapForEach {

	/**
	 * 
	 * @foreach Performs the given action for each entry in this map until all
	 *          entries have been processed or the action throws an exception.
	 *          Unless otherwise specified by the implementing class, actions are
	 *          performed in the order of entry set iteration (if an iteration order
	 *          is specified.) Exceptions thrown by the action are relayed to the
	 *          caller.
	 */
	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);
		
		BiConsumer<Integer, String> output = (key, value) -> System.out
				.println(key + " : " + value);
		
		map.forEach(output);
		
	}

}
