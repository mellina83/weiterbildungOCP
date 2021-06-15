package pak03memberclass;

public class Haus {
	private String eigentuemer = "Ich";
	public String text = "";
	
	public class Raum{
		private String eigentuemer = "Nicht ich";
		
		
		public static final String staticAttr = "staticAttr";
		
		void lesevonHaus() {
			System.out.println(eigentuemer);
			System.out.println(this.eigentuemer);
			System.out.println(Haus.this.eigentuemer);			
		}
		void lesevonHaus2() {
			System.out.println(Haus.this.text);
			
		}
		//The method doStuff cannot be declared static; static methods can only be declared in a static or top level type
//		static void doStuff() {
//			System.out.println("doStuff");
//		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Haus.Raum.staticAttr);
		
		/*
		 * Instanzierung von Raum in 2 Schritten
		 */
		//Eine Instanz von Haus erzeugen
		Haus refHaus = new Haus();
		
		//mit der Referenz der umgebenen Klasse und dem nachgestellten
		//new koennen Instanzen von Raum erzeugt werden.
		Raum refRaum01 = refHaus.new Raum();
		Raum refRaum02 = refHaus.new Raum();
		Raum refRaum03 = refHaus.new Raum();
		
		/*
		 * Instanzierung in einem Schritt
		 */
		Raum refRaum04 = new Haus().new Raum();
		
		refRaum04.lesevonHaus();
		
		refHaus.text = "Hallo Welt"; 
		Haus refHaus2 = new Haus();
		refHaus2.text = "Hallo Java";
		
		Raum r1 = refHaus.new Raum();
		Raum r2 = refHaus2.new Raum();
		r1.lesevonHaus2();
		r2.lesevonHaus2();
		
	}
}
