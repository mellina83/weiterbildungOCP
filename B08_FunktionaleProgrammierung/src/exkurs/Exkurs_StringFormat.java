package exkurs;

public class Exkurs_StringFormat {

	public static void main(String[] args) {
		String toFormat = "%10d %s %s als Methode verwendet %n";
		
		String waehrung = "Euro";
		
		/**
		 * den String formattieren lassen
		 */
		String tmp = String.format(toFormat, 1_000_000_000, waehrung, true);
		System.out.println(tmp);
		System.out.println(String.format(toFormat, 1_000_000, waehrung, true));
		System.out.println(String.format(toFormat, 1_000, waehrung, true));
		System.out.println(String.format(toFormat, 1_00, waehrung, true));
		System.out.println(String.format(toFormat, 1_0, waehrung, true));
		
		System.out.printf(toFormat,1, waehrung, true);
		System.out.format(toFormat,1, waehrung, true);
		
		/**
		 * mit %d Argument als ganze Zahl formatieren:
		 */
		System.out.printf("%d %n", 12);
		System.out.printf("%d %n", new Integer(22));
		System.out.printf("%d %n", 12L);
		
		/**
		 * mit %x Argument als ganze Zahl in Hexadezimal:
		 */
		System.out.printf("%5x %n", 12);
		System.out.printf("%5x %n", new Integer(22));
		System.out.printf("%5X %n", 12L);
		
		/**
		 * mit %f Argument als Gleitkomma-Zahl formatieren:");
		 */
		System.out.printf("%09.2f %n", 12.254);
		System.out.printf("%f %n", new Float(12.0));
		
		/**
		 * Mehrere Argumente ersetzen
		 */
		System.out.printf("%s %s %s %d %n","Hallo","Welt","Java",8 );
		
		/**
		 * Mehrere Argumente ersetzen mit index
		 * 
		 * EXAM WATCH
		 */
//		System.out.printf("%s %s %s %s %n","A","B","C");//MissingFormatArgumentException
		//                 0                 , 1 , 2 , 3 
		//                "   1-                
		System.out.printf("%3$s %s %s %s %n","A","B","C");//C A B C
		System.out.printf("%3$s %3$s %3$s %3$s %n","A","B","C");//C C C C
		System.out.printf("%3$s %1$s %2$s %3$s %n","A","B","C");//C A B C
		System.out.printf("%s %1$s %s %4$s %n","A","B","C",42);//A A B C
		System.out.printf("%0$s %n","A","B","C",42);
	}

}
