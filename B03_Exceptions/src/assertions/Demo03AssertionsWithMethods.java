package assertions;

public class Demo03AssertionsWithMethods {
	
	private static Demo03AssertionsWithMethods ds01 = new Demo03AssertionsWithMethods();
	private static Demo03AssertionsWithMethods ds02 = new Demo03AssertionsWithMethods();
	
	public static void main(String[] args) {
		doStuff();
		System.out.println("Beendet");
	}

	private static void doStuff() {
		
		//assert(true/false) : String
		assert(ds01.equals(ds02)): printError(ds01, ds02);
		
	}
	
	private static String printError(Object o1, Object o2) {
		return "\no1.hashcode(): " + o1.hashCode() + "\no2.hashcode(): " + o2.hashCode();
	}
	
	private static String printError() {
		return "Fehlermeldung";
	}
}
