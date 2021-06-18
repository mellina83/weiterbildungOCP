package pak01_functional;

/*
 * Fuer ein funktionales Interface mit einer Methode, die eine Referenz
 * von Typ X zurueckliefert(String create()) und wenn die Realisierung aus
 * return new X() bestehen wuerde ist es moeglich eine Referenz auf einen Konstruktor
 * zu erstellen.
 * 
 * - Der Konstruktor initialisiert das Objekt vom passenden Typ(hier String)
 * - Der Konstruktor hat die selbe Parameterliste wie die abstrakte Methode im Interface
 */


interface StringCreator {
	String create();
}

interface StringCreatorWithParameter {
	String create(String string);
}

interface StringCreatorWithStringBuilder {
	String create(StringBuilder sb);
}

public class Demo05_a_KonstruktorenReferenz {
	public static void main(String[] args) {
//		demo01();
		demo02();
	}

	private static void demo02() {
		StringCreatorWithParameter sc01 = string -> new String(string);
		StringCreatorWithParameter sc02 = String::new;

		String s1 = sc02.create("Hallo Welt");
		System.out.println(s1);

		StringCreatorWithStringBuilder sc03 = sb -> new String(sb);
		StringCreatorWithStringBuilder sc04 = String::new;

		// The method create(StringBuilder) in the type StringCreatorWithStringBuilder
		// is not applicable for the arguments (String)
		System.out.println(sc04.create(new StringBuilder("Hallo StringBuilder")));

	}

	private static void demo01() {
		// Anonyme Klasse
		StringCreator sc01 = new StringCreator() {
			@Override
			public String create() {
				return new String();
			}
		};
		String s1 = sc01.create();

		// Lambda
		StringCreator sc02 = () -> new String();
		String s2 = sc02.create();

		// Referenz auf den Konstruktor
		StringCreator sc03 = String::new;

		String s3 = sc03.create();
		System.out.println(s3.getClass());

		System.out.println(sc03.create() == sc03.create());
		System.out.println(sc03.create().hashCode());

	}
}
