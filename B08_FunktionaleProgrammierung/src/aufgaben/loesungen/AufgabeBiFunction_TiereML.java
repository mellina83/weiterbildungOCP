package aufgaben.loesungen;

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

public class AufgabeBiFunction_TiereML {

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
		 * Jeweils eine BiFunction �hnlich Zeile 34-39 .... realisieren
		 */
		// Bitte mit Lambda realisieren:
		System.out.println("---f01----");
		BiFunction<Tier, Boolean, Zoo> f01 = (Tier pt, Boolean gesund) -> {
				return new Zoo(pt, gesund);
		};
		
		Tier t01 = new Tier();
		System.out.println( t01.gesund );
		
		Zoo z01 = f01.apply(t01, true);
		System.out.println( t01.gesund );
		
		
		// Bitte mit einer Referenz auf einen Konstruktor realisieren:
		System.out.println("---f02----");
		BiFunction<Tier, Boolean, Zoo> f02 = Zoo::new;
		Tier t02 = new Tier();
		System.out.println( t02.gesund );
		
		Zoo z02 = f02.apply(t02, true);
		System.out.println( t02.gesund );
		
		// Bitte die Klasse ZooBuilder realisieren/nutzen:
		System.out.println("---f03----");
		ZooBuilder zb03 = new ZooBuilder();
		BiFunction<Tier, Boolean, Zoo> f03 = zb03::build;
//		BiFunction<Tier, Boolean, Zoo> f03 = new ZooBuilder()::build;
		Tier t03 = new Tier();
		System.out.println( t03.gesund );
		
		Zoo z03 = f03.apply(t03, true);
		System.out.println( t03.gesund );
		
		// Bitte die Methode create erstellen
		System.out.println("---f04----");
		BiFunction<Tier, Boolean, Zoo> f04 = Zoo::create;
		Tier t04 = new Tier();
		System.out.println( t04.gesund );
		
		Zoo z04 = f04.apply(t04, true);
		System.out.println( t04.gesund );
		
		// Ref. auf eine Instanz-Methode von einem unbest. Objekt von dem bestimmten Typ
		System.out.println("---f05----");
//		BiFunction<Tier, Boolean, Zoo> f05 =  Zoo (Tier pt,Boolean gesund);
		// 							  create  Zoo (Boolean gesund)
		//                               		  t05.create(gesund);
		//                                    Tier::create;
		BiFunction<Tier, Boolean, Zoo> f05 = Tier::create;	
		Tier t05 = new Tier();
		System.out.println( t05.gesund );
		
		Zoo z05 = f05.apply(t05, true);
		System.out.println( t05.gesund );
	}
	
}
