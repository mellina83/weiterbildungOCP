package ml.Duerbeck.basics;

import ml.Duerbeck.basics.Haus.Raum;

public class MitgliedsOderElementklassen {

	//Um ausserhalb Instanz der inneren Klasse zu erstellen, bedarf es einer Instanz der aeusseren Klasse
	//(Das gleiche wie bei einer statischen Methode der aeusseren, nur dass dort Raum nicht importiert werden muss)
	
	public static void main(String[] args) {
		Haus refHaus1 = new Haus();
		Raum refRaum1 = refHaus1.new Raum(); //Raum muss aber importiert werden
		Raum refRaum2 = new Haus().new Raum();
		new Haus().new Raum().ok();
	}
}

class Haus {
	private String eigentuemer = "Ich";
	static String strasse = "ABCStrasse";
	String s = "Haus";
	
	//In allen Methoden der aeusseren duerfen Instanzen der inneren Klasse erzeugt werden
	//auch Konstruktor
	void instanzErzeugen() {
		new Raum();
	}
	
//  Geht nicht:
	static void instanzErzeugen2() {
//		new Raum();
	}
	
	class Raum {
		String s = "Raum";
		final static String a ="Bla";
		
		//Nur non-static Member erlaubt
		private String bewohner = "WiederIch";
//		static String raumnummer = "123";
		
		void ok() {
			System.out.println(eigentuemer); //Innere Klasse sieht private Member der aeusseren
		}

//		static void error() {}
		
		// Beispiel fuer Zugriffe von inneren Klasse nach Eigenschaften von aeusseren Klassen
		class Stuhl {
			String s = "Stuhl";
			
			void output() {
				System.out.println(s);				//Stuhl
				System.out.println(this.s);			//Stuhl
				System.out.println(Stuhl.this.s);	//Stuhl
				System.out.println(Raum.this.s);	//Raum
				System.out.println(Haus.this.s);	//Haus
			}
		}
		
	}
	
	//Um in einer statischen Methode der aeusseren Klasse eine Instanz der inneren erstellen zu koennen,
	//bedarf es einer Instanz der aeusseren Klasse
	//(Das gleiche wie komplett ausserhalb, nur dass dort Raum importiert werden muss)
	
	public static void main() {
		Haus refHaus1 = new Haus();
		Raum refRaum1 = refHaus1.new Raum(); //Raum muss nicht importiert werden
		Raum refRaum2 = new Haus().new Raum();

	}
	
}


