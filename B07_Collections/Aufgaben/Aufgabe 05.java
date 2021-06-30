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
 */
public class Aufgabe {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		fuelleMap(map);

		
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
