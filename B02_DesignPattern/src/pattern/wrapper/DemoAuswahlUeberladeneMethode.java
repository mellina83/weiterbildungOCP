package pattern.wrapper;

public class DemoAuswahlUeberladeneMethode {
	public static void main(String[] args) {
		Integer a = 4;
		probe(a);		
		/*
		 * Unboxing + Widening : 	ja
		 * Widening + Boxing   :	nein
		 */
		int b = 4;		
		probe(b);
		
		probe(12.0);
				
//		int i = 12.0;
	}
//	static void probe(double x) {
//		System.out.println("In double");
//	}
	static void probe(Double x) {
		System.out.println("In DOUBLE");
	}
	static void probe(long x) {
		System.out.println("In long");
	}
	static void probe(int... x) {
		System.out.println("In ...");
	}
	static void probe(int x) {
		System.out.println("In int");
	}
	static void probe(Integer x) {
		System.out.println("In Integer");
	}
	static void probe(Long x) {					
		System.out.println("In LONG");
	}
	static void probe(Number x) {				
		System.out.println("In Number");
	}
	static void probe(Object x) {
		System.out.println("In Object");
	} 
	
	/*
	 * Prioritaeten bei der Auswahl der ueberladenen Methode
	 * Variable Wrapper
	 * 
	 * 1. Upcast zu Number bzw. Object, wenn entspechender Wrappertyp nicht vorhanden
	 * 2. Unboxing ohne Widening
	 * 3. Unboxing + Widening
	 * 4. Varargs
	 * 
	 * Variable primitiver Datentyp
	 * 1. primitiver Datentyp der exakt passt.
	 * 2. primiver Datentyp mit Widening
	 * 3. Wrapper mit Boxing
	 * 4. Wrapper mit Boxing und UpCast -> Number bzw. Object
	 * 5. Varargs
	 */
}
