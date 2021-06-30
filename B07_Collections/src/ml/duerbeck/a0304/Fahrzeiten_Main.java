package ml.duerbeck.a0304;

import java.util.Collections;
import java.util.TreeSet;

public class Fahrzeiten_Main {
	
	public static TreeSet<String> abfahrtzeiten = new TreeSet<>();

	public static void main(String[] args) {
		
		abfahrtzeitenHinzufuegen(abfahrtzeiten);
		
		ersteAbfahrtNach(abfahrtzeiten, "12:12", false);
		ersteAbfahrtNach(abfahrtzeiten, "12:12", true);
		ersteAbfahrtVor(abfahrtzeiten, "12:12", true);
		ersteAbfahrtVor(abfahrtzeiten, "12:12", false);
		ersteAbfahrtNach(abfahrtzeiten, "17:12", true);
		ersteAbfahrtNach(abfahrtzeiten, "17:12", false);
		ersteAbfahrtZwischen(abfahrtzeiten, "12:00", "13:00", true, true);
		ersteAbfahrtZwischen(abfahrtzeiten, "12:00", "13:00", false, false);
		ersteAbfahrtZwischen(abfahrtzeiten, "11:52", "13:12", false, true);
		ersteAbfahrtZwischen(abfahrtzeiten, "11:52", "13:12", true, false);
		ersteAbfahrt(abfahrtzeiten);
		letzteAbfahrt(abfahrtzeiten);

	}
	
	private static void ersteAbfahrtNach(TreeSet<String> abfahrten, String string, boolean b) {
		if (b) {
			System.out.println("Erste Abfahrt nach " + string + ", Inklusive: " + b + ": " + abfahrten.ceiling(string));
		} else {
			System.out.println("Erste Abfahrt nach " + string + ", Inklusive: " + b + ": " + abfahrten.higher(string));
		}
	}

	private static void ersteAbfahrtVor(TreeSet<String> abfahrten, String string, boolean b) {
		if (b) {
			System.out.println("Erste Abfahrt vor " + string + ", Inklusive: " + b + ": " + abfahrten.floor(string));
		} else {
			System.out.println("Erste Abfahrt vor " + string + ", Inklusive: " + b + ": " + abfahrten.lower(string));
		}
	}

	private static void ersteAbfahrtZwischen(TreeSet<String> abfahrten, String string, String string2, boolean b, boolean c) {
		System.out.println("Erste Abfahrt zwischen " + string + " und " + string2 + ", Inklusive: " + b + " " + c + ": " + abfahrten.subSet(string, b, string2, c).first());
	}

	private static void ersteAbfahrt(TreeSet<String> abfahrten) {
		System.out.println("Erste Abfahrt: " + abfahrten.first());
		//System.out.println("Erste Abfahrt: " + Collections.min(abfahrten));
	}

	private static void letzteAbfahrt(TreeSet<String> abfahrten) {
		System.out.println("Letzte Abfahrt: " + abfahrten.last());
		//System.out.println("Letzte Abfahrt: " + Collections.max(abfahrten));
	}

	public static void abfahrtzeitenHinzufuegen(TreeSet<String> abfahrtszeiten) {
		for (int hour = 6; hour < 24; hour++) {
			for (int min = 12; min < 60; min+=20) {
				String zeit = String.format("%02d:%02d", hour, min);
				abfahrtszeiten.add(zeit);
			}
		}
		
		
		/*
		 * abfahrtzeiten.add("06:12"); abfahrtzeiten.add("06:32");
		 * abfahrtzeiten.add("06:52"); abfahrtzeiten.add("07:12");
		 * abfahrtzeiten.add("07:32"); abfahrtzeiten.add("07:52");
		 * abfahrtzeiten.add("08:12"); abfahrtzeiten.add("08:32");
		 * abfahrtzeiten.add("08:52"); abfahrtzeiten.add("09:12");
		 * abfahrtzeiten.add("09:32"); abfahrtzeiten.add("09:52");
		 * abfahrtzeiten.add("10:12"); abfahrtzeiten.add("10:32");
		 * abfahrtzeiten.add("10:52"); abfahrtzeiten.add("11:12");
		 * abfahrtzeiten.add("11:32"); abfahrtzeiten.add("11:52");
		 * abfahrtzeiten.add("12:12"); abfahrtzeiten.add("12:32");
		 * abfahrtzeiten.add("12:52"); abfahrtzeiten.add("13:12");
		 * abfahrtzeiten.add("13:32"); abfahrtzeiten.add("13:52");
		 * abfahrtzeiten.add("14:12"); abfahrtzeiten.add("14:32");
		 * abfahrtzeiten.add("14:52"); abfahrtzeiten.add("15:12");
		 * abfahrtzeiten.add("15:32"); abfahrtzeiten.add("15:52");
		 * abfahrtzeiten.add("16:12"); abfahrtzeiten.add("16:32");
		 * abfahrtzeiten.add("16:52"); abfahrtzeiten.add("17:12");
		 * abfahrtzeiten.add("17:32"); abfahrtzeiten.add("17:52");
		 * abfahrtzeiten.add("18:12"); abfahrtzeiten.add("18:32");
		 * abfahrtzeiten.add("18:52"); abfahrtzeiten.add("19:12");
		 * abfahrtzeiten.add("19:32"); abfahrtzeiten.add("19:52");
		 * abfahrtzeiten.add("20:12"); abfahrtzeiten.add("20:32");
		 * abfahrtzeiten.add("20:52"); abfahrtzeiten.add("21:12");
		 * abfahrtzeiten.add("21:32"); abfahrtzeiten.add("21:52");
		 * abfahrtzeiten.add("22:12"); abfahrtzeiten.add("22:32");
		 * abfahrtzeiten.add("22:52"); abfahrtzeiten.add("23:12");
		 * abfahrtzeiten.add("23:32"); abfahrtzeiten.add("23:52");
		 */
	}
	
	

}
