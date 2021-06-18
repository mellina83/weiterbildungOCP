package pak01_functional;

class Schwein {
	public String name;

	public Schwein(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Schwein [name=" + name + "]";
	}
	
	public void laufen() {
		System.out.println(this.name + " laeuft");
	}

	public void fressen() {
		System.out.println(this.name + " frisst");
	}
}

interface DoStuff {
	void doStuff();
}

public class Demo07_MethodenReferenzBestimmtesObjekt {
	public static void main(String[] args) {
		Schwein piggeldy = new Schwein("Piggeldy");
		Schwein frederick = new Schwein("Frederick");
		
		DoStuff do01 = piggeldy::fressen;
		do01.doStuff();
		DoStuff do02 = frederick::fressen;
		do02.doStuff();
		DoStuff do03 = () -> System.out.println("Lambda geht auch");
		do03.doStuff();
		
		demo01(piggeldy::laufen);
		demo01(frederick::laufen);
		/*
		 * Unschoen, wurde aber klappen
		 */
		DoStuff do04 = new DoStuff() {			
			@Override
			public void doStuff() {
				piggeldy.fressen();			
			}
		};
	}
	
	private static void demo01(DoStuff param) {
		param.doStuff();
	}
}
