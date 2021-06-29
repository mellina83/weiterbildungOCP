package ml.novytska.SetAufgabe;
import java.util.TreeSet;

public class AbfahrtZeiten {

	public static void main(String[] args) {
		
		TreeSet<String> zeiten = new TreeSet<String>();
		System.out.println("Die Abfahrtzeiten für eine Buslinie von einer Haltestelle");
		String s = "";
		for(int i=6; i<24; i++ ) {
			if(i<10) {
			 s ="0"+i;
			} else {
				s = String.valueOf(i);
			}
			for(int j=12; j<=52; j+=20) {
				String s1 = s + ":" + j;
				System.out.print(s1+" ");
				
				zeiten.add(s1);	
			}
			System.out.println();
			
			
		}
		
		
		System.out.printf("  TreeSet contains %d elements \n", zeiten.size());
		
		System.out.println("  die erste Abfahrtzeit nach 12:03 ist um " + zeiten.higher("12:03"));
		System.out.println("  der ersten Abfahrtzeit vor 12:03 ist um " + zeiten.floor("12:03"));
		System.out.println("  der ersten Abfahrtzeit nach 17:12 inklusive ist um " + zeiten.ceiling("17:12"));
		System.out.println("  der ersten Abfahrtzeit nach 17:12 exklusive ist um " + zeiten.higher("17:12"));
		System.out.println("  die alle Abfahrtzeiten zwischen 12:00 bis 13:00 sind " + zeiten.subSet("12:00", "13:00"));
		System.out.println("  die alle Abfahrtzeiten zwischen 11:52 exklusive bis 13:12 inklusive sind  " + zeiten.subSet("11:52", false, "13:12", true));
		System.out.println("  die erstmögliche Abfahrtzeit ist um " + zeiten.ceiling("00:00"));
		System.out.println("  die letztmöglichen Abfahrtzeitt ist um " + zeiten.floor("23:59"));
		
		
		



	}

}
