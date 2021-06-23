package pak03_methods;

public class Demo01PunktGenUtils {
	public static void main(String[] args) {
		PunktGenUtils<Integer> pgu01 = new PunktGenUtils<>();
		PunktGen<Integer> punktInteger01 = pgu01.erzeugePunkt();
		
		PunktGen<Integer> punktInteger02 = PunktGenUtils.createPunktGen();
		PunktGen<String> punktString = PunktGenUtils.createPunktGen();
		
		PunktGen<Integer> integerPunkt1 = new PunktGen<Integer>(5,5);
		PunktGen<Integer> integerPunkt2 = new PunktGen<Integer>(10,10);
		
		System.out.println("p1: " + integerPunkt1);
		System.out.println("p2: " + integerPunkt2);
		PunktGenUtils.tausche(integerPunkt1, integerPunkt2);
		System.out.println("p1: " + integerPunkt1);
		System.out.println("p2: " + integerPunkt2);
		
//		PunktGenUtils.tausche(p1, punktString);
		
		System.out.println("\nStringpunkte");
		PunktGen<String> stringPunkt1 = new PunktGen<String>("Hallo", "Welt");
		PunktGen<String> stringPunkt2 = new PunktGen<String>("Java", "Insel");
		System.out.println(stringPunkt1);
		System.out.println(stringPunkt2);
		PunktGenUtils.tausche(stringPunkt1, stringPunkt2);
		System.out.println(stringPunkt1);
		System.out.println(stringPunkt2);
		
		PunktGenUtils.ausgeben(integerPunkt1, integerPunkt2);
		PunktGenUtils.ausgeben(integerPunkt1, stringPunkt2);
		System.out.println("\n------------------------------");
		PunktGenUtils.alleAusgeben(integerPunkt1, stringPunkt2);
		
	}
}
