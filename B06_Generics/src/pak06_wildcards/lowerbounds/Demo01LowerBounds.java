package pak06_wildcards.lowerbounds;

/*
 * Lowerbound wird mit super festgelegt
 * 
 * Klassen und Interfaces koennen nicht per Lowerbound generisch gebunden werden.
 */
//Kompilierfehler wegen dem super
//interface ISchnittstelle<? super Number>{}

//Kompilierfehler wegen dem super
//public class Demo01LowerBounds<T super Number> {
public class Demo01LowerBounds {
	
	//Kompilierfehler wegen dem super
//	public static <T super Number> void method01(T t) {
//		
//	}
	//Kompilierfehler wegen dem super
//	public <T super Number> void method01(T t) {
//		
//	}
	
//	public <? super Number> void method01() {}
	
	
	public static void genMethodNumberUpperBound(GenKlasse<? extends Number> punkt) {
//		Number pak06_wildcards.lowerbounds.GenKlasse.getT()
		punkt.getT();
	}
	public static void genMethodUndetermined(GenKlasse<?> punkt) {
//		Object pak06_wildcards.lowerbounds.GenKlasse.getT()
		punkt.getT();
	}
	
	public static void genMethodDouble(GenKlasse<Double> punkt) {}
	
	public static void genMethodNumber(GenKlasse<Number> punkt) {}
	
	public static void genMethodInteger(GenKlasse<Integer> punkt) {}
	
	public static void genMethodNumberLowerBound(GenKlasse<? super Number> punkt) {
//		Object pak06_wildcards.lowerbounds.GenKlasse.getT()
		punkt.getT();
	}
	
	public static void main(String[] args) {
		GenKlasse<Double> punktD = new GenKlasse<>();
		GenKlasse<Integer> punktI = new GenKlasse<>();
		GenKlasse<Number> punktN = new GenKlasse<>();
		GenKlasse<Object> punktO = new GenKlasse<>();
		
		genMethodDouble(punktD);
		//falsche Argumente
//		genMethodDouble(punktI);
//		genMethodDouble(punktN);
//		genMethodDouble(punktO);
		
		genMethodInteger(punktI);
//		genMethodInteger(punktD);
//		genMethodInteger(punktN);
//		genMethodInteger(punktO);
		
		genMethodNumber(punktN);
//		genMethodNumber(punktD);
//		genMethodNumber(punktI);
//		genMethodNumber(punktO);
		
		//Lowerbound akzeptiert alles bis zur Klasse Number
		genMethodNumberLowerBound(punktN);
		genMethodNumberLowerBound(punktO);
//		genMethodNumberLowerBound(punktI);
//		genMethodNumberLowerBound(punktD);
		
		//Upperbound akzeptiert alles was von Number abgeleitet ist
		genMethodNumberUpperBound(punktN);
		genMethodNumberUpperBound(punktI);
		genMethodNumberUpperBound(punktD);
//		genMethodNumberUpperBound(punktO);
		
		genMethodUndetermined(punktO);
		genMethodUndetermined(punktI);
		genMethodUndetermined(punktD);
		genMethodUndetermined(punktN);
	}
	
}
