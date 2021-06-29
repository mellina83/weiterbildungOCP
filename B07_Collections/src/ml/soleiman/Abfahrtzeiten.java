package ml.soleiman;

import java.time.LocalTime;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Abfahrtzeiten {

	public static void main(String[] args) {
		NavigableSet<String> abfahrt = new TreeSet<String>();

		int startzeit_h = 6, startzeit_min = 12;
		int endzeit_h = 23, endzeit_min = 52;
		int takt_in_minuten = 20;

		LocalTime endzeit = LocalTime.of(endzeit_h, endzeit_min);

		LocalTime ld1 = LocalTime.of(startzeit_h, startzeit_min);
		for (int i = 0; i < 100; i++) {
			abfahrt.add(ld1.toString());
			if (ld1.equals(endzeit)) {
				break;
			}
			ld1 = ld1.plusMinutes(takt_in_minuten);
		}

//			for (String string : abfahrt) {
//				System.out.println(string);
//			}
 
		System.out.println("erste Abfahrtzeit nach 12:03 -> " + abfahrt.higher("12:03"));
		System.out.println("erste Abfahrtzeit vor 12:03 -> " + abfahrt.lower("12:03"));
		System.out.println("ersten Abfahrtzeit nach 17:12 inklusive -> " + abfahrt.ceiling("17:12"));
		System.out.println("ersten Abfahrtzeit nach 17:12 exklusive -> " + abfahrt.higher("17:12"));
//		    - suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00
//		    - suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive
		System.out.println(abfahrt.subSet("12:00", "13:00"));
		System.out.println(abfahrt.subSet("11:52",false , "13:12", true));
		System.out.println("erstmögliche Abfahrtzeit -> " + abfahrt.pollFirst());
		System.out.println("letztmöglich Abfahrtzeit -> " + abfahrt.pollLast());



	}
}

//# Aufgabe 'Set - Abfahrtzeiten'
//
//- Generieren Sie bitte die Abfahrtzeiten für eine Buslinie von einer Haltestelle:
//    - Der erste Bus fährt um 06:12 ab.
//    - Der letzte Bus fährt um 23:52 ab.
//    - Die Busse fahren in 20-Minuten-Takt
//
//
//- Die Abfahrtzeiten sollen als Strings in einem TreeSet gespeichert werden.
// Die Strings sollen folgende Form haben:
//
//    	"06:12", "06:32", "06:52" ... "23:52"
//    	
//
//
//- Untersuchen Sie die Abfahrtzeiten:
//    - suchen Sie die erste Abfahrtzeit nach 12:03
//    - suchen Sie nach der ersten Abfahrtzeit vor 12:03
//    - suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive
//    - suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive
//    - suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00
//    - suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive
//    - suchen Sie nach der erstmöglichen Abfahrtzeit
//    - suchen Sie nach der letztmöglichen Abfahrtzeit
//
//
//- Optional. Gibt es andere (bessere) Möglichkeiten die Abfahrtzeiten in einem TreeSet
//  zu speichern als die in dieser Aufgabe verwendeten Strings?
