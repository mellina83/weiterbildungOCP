package aufgaben.a03;

import java.util.Scanner;
import java.util.TreeSet;

public class MLAbfahrtzeiten {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>();
		/**
		 * * - Der erste Bus f�hrt um 06:12 ab.
		 * 
		 * - Der letzte Bus f�hrt um 23:52 ab.
		 * 
		 * - Die Busse fahren in 20-Minuten-Takt
		 */
		for (int hour = 6; hour < 24; hour++) {
			for (int min = 12; min < 60; min += 20) {
//				String zeit = time + ":" + min;
				String zeit = String.format("%02d:%02d", hour,min);
				set.add(zeit);
			}
		}

		set.forEach(System.out::println);
		
//      suchen Sie die erste Abfahrtzeit nach 12:03
		System.out.println(set.higher("12:03"));
//		suchen Sie nach der ersten Abfahrtzeit vor 12:03
		System.out.println(set.lower("12:03"));
//		suchen Sie nach der ersten Abfahrtzeit nach 17:12 inklusive
		System.out.println(set.ceiling("17:12"));
//		suchen Sie nach der ersten Abfahrtzeit nach 17:12 exklusive
		System.out.println(set.higher("17:12"));
//		suchen Sie nach allen Abfahrtzeiten zwischen 12:00 bis 13:00
		System.out.println(set.subSet("12:00", "13:00"));
//		suchen Sie nach allen Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive
		System.out.println(set.subSet("11:52",false, "13:12",true));
//		suchen Sie nach der erstm�glichen Abfahrtzeit
		System.out.println(set.first());
//		suchen Sie nach der letztm�glichen Abfahrtzeit
		System.out.println(set.last());
	}

}
