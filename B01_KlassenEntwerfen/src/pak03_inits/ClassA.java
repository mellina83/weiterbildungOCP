package pak03_inits;

/*
 * 2 Arten: static und non static
 */
public class ClassA {	
	
	static String text = "Hallo Welt";
	
	{
		System.out.println("ClassA nonstatic");
	}
	String nonstatictext = init();
	static {
		System.out.println("ClassA static");
	}
	public ClassA() {
		System.out.println("ClassA Konstruktor");
	}

	String init() {
		System.out.println("init()");
		return "";
	}
}

class ClassB extends ClassA{
	{
		System.out.println("ClassB nonstatic");
	}
	static {
		System.out.println("ClassB static");
	}
	public ClassB() {
		System.out.println("ClassB Konstruktor");
	}
}