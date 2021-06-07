package pak03_inits;

public class DemoInit {
	public static void main(String[] args) {

		
		/* Wann werden Klassen geladen:
		 * Klassen werden bei "Benutzung" geladen.
		 * Die Deklaration einer Variablen ist kein "Benutzen" der Klasse.
		 */
		ClassA a2;
		/*
		 * Das Ansprechen eines Attributes fuehrt zum Laden der Klasse.
		 */
//		System.out.println(ClassA.text);
		/*
		 * Der Zugriff auf das Attribut ueber den Namen der Kindklasse,
		 * fuehrt nicht dazu, dass die Kindklasse geladen wird.
		 */
//		System.out.println(ClassB.text);
		
		ClassB b1 = new ClassB();
		System.out.println("--------------------------");
		ClassB b2 = new ClassB();
		
		System.out.println("Programmende");
	}
}
