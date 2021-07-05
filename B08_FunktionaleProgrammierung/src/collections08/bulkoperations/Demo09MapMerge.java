package collections08.bulkoperations;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import data.Utility;

/**
 * @merge If the specified key is not already associated with a value or is
 *        associated with null, associates it with the given non-null value.
 *        Otherwise, replaces the associated value with the results of the given
 *        remapping function, or removes if the result is null. This method may
 *        be of use when combining multiple mapped values for a key.
 * 
 *        For example, to either create or append a String msg to a value
 *        mapping: map.merge(key, msg, String::concat)
 * 
 *        If the function returns null the mapping is removed. If the function
 *        itself throws an (unchecked) exception, the exception is rethrown, and
 *        the current mapping is left unchanged.
 * 
 */
public class Demo09MapMerge {

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<>();
		Utility.fillMap(map);
		
		map.put(9, null);

		String msg = " welt, wir mergen Maps";

		//BiFunction<? super V, ? super V, ? extends V> remappingFunction
		//BiFunction<String, String, String> remappingFunction
		BiFunction<String, String, String> remappingFunction = (old, toMerge) ->{
			return old.concat(toMerge);
		};
		map.forEach(Utility::printMyMap);
		map.merge(1, msg, remappingFunction);
		

		// Methodenreferenz eines Unbestimmten Objekt eines speziellen Typs
//		'Erster Parameter'.concat('Zweiter Parameter');
		BiFunction<String, String, String> merge = String::concat;
		BinaryOperator<String> merge02 = String::concat;
		
		map.merge(2, " wir finden Lambda cool", String::concat);
		
		
		
		/**
		 * Key '9' gefunden - Value ist 'null' :
		 */
		map.merge(9, " Verbinden mit NULL", String::concat);
		
		/**
		 * Key '12345' nicht gefunden implizit bedeutet Value ist null : Ein neuer Eintrag wird
		 * erstellt
		 */
		map.merge(12345, msg, String::concat);
		
		map.forEach(Utility::printMyMap);
	}

}
