package assertions;

import java.util.Random;

public class Demo01AssertionsReallySimple {
	public static void main(String[] args) {
		doStuff();
		System.out.println("Beendet");
	}
	
	/*
	 * Unangemessenes Nutzen von Assertions
	 */
	public static void doStuff2(String text) {
		assert(text.equals("Hallo"));
	}
	
	private static void doStuff() {
		int x = 10;
		int y = 12;
		/*
		 * Wenn die Bedingung der Assert Anweisung zu false ausgewertet wird,
		 * dann wird ein AssertionError an die JVM geleitet.
		 */
		assert (x>y);
		
//		if(y>x) {
//			throw new AssertionError();
//		}
		
		System.out.println("x: " + x);
	}
	
	public static int doComplicatedStuff() {
		return new Random().nextInt(20);
	}
}
