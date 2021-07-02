package aufgaben;

import java.util.function.BiFunction;

class Tier {
	boolean gesund;

	Zoo create(Boolean gesund) {
		return new Zoo(this, gesund);
	}
}

class Zoo {
	static Zoo create(Tier t, Boolean gesund) {
		return new Zoo(t, gesund);
	}
	
	public Zoo(Tier t, boolean gesund) {
		t.gesund = gesund;
	}
}

class ZooBuilder {
	Zoo build(Tier t, Boolean gesund) {
		return new Zoo(t, gesund);
	}
}

public class AufgabeBiFunction_Tiere {

	public static void main(String[] args) {
		
		
		BiFunction<Tier, Boolean, Zoo> f0 = new BiFunction<Tier, Boolean, Zoo>() {
			@Override
			public Zoo apply(Tier t, Boolean gesund) {
				return new Zoo(t, gesund);
			}
		};
		
		Tier t = new Tier();
		System.out.println( t.gesund );
		
		Zoo z0 = f0.apply(t, true);
		System.out.println( t.gesund );
		
		
		/**
		 * Jeweils eine BiFunction ähnlich Zeile 34-39 .... realisieren
		 */
		// Bitte mit Lambda realisieren:
		
		
		// Bitte mit einer Referenz auf einen Konstruktor realisieren:
		
		
		// Bitte die Klasse ZooBuilder realisieren/nutzen:
		
		
		// Bitte die Methode create erstellen
		
		
		// Ref. auf eine Instanz-Methode von einem unbest. Objekt von dem bestimmten Typ
	}
	
}
