package pak03_methods;

/*
 * * Generisch bedeutet, dass Klassen, Schnittstellen und Methoden
 * Parameter verwenden, welche einen Typ darstellen.
 *
 * Eine Klasse mit formalem Typ-Parameter stellt eine generische 
 * Klasse dar. 
 * 
 * Der formale Typ-Parameter ist ein symbolischer Name,
 * der wie ein normaler Bezeichner in Java aufgebaut ist und 
 * eingeschlossen in spitzen Klammern nach dem Klassennamen 
 * angegeben werden muss.
 * 
 * Die Klasse PunktGen<T> bzw. <N> stellt eine generische Klasse mit dem 
 * formalen Typ-Parameter T bzw. N dar. Die Entscheidung �ber den konkreten
 * zu verwendenden Typ � hier Integer und Double � findet erst bei
 * der Nutzung der generischen Klasse statt.
 * 
 * Der formale Typ-Parameter T in der Klassendeklaration wird auch
 * zur Definition der Datenfelder der generischen Klasse verwendet.
 * Genauso tritt er als Typ f�r formale Parameter und R�ckgabewerte
 * von Methoden auf. Damit k�nnen Klassen unabh�ngig von einem 
 * speziellen Typ generisch definiert werden. Der formale Typ-Parameter
 * wird bei der Verwendung der Klasse dann durch den gew�nschten 
 * konkreten Datentyp ersetzt.
 * 
 * Der Compiler erzeugt bei der �bersetzung einer generischen Klasse
 * nur eine einzige Bytecode-Datei, unabh�ngig davon, wie viele aktuell
 * parametrisierte Klassen der generischen Klasse verwendet werden.
 * F�r die generische Klasse PunktGen<T> erzeugt der Compiler die Datei
 * PunktGen.class.
 * 
 * Durch das Type Erasure werden beim �bersetzen einer generischen
 * Klasse alle Vorkommen des formalen Typ-Parameters T im Rumpf der
 * Klasse durch den Typ Object ersetzt. So wird f�r die Klasse
 * 
 * class GenKlasse<T>
 * {
 * 		T ref;
 * }
 * folgender Bytecode erzeugt:
 * 
 * class GenKlasse
 * {
 * 		Object ref;
 * }
 */

public class PunktGen<T> {
	private T x; 
	private T y;
	
	public PunktGen() {
		
	}
	
	public PunktGen(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	public T getX() {
		return this.x;
	}
	public void setX(T x) {
		this.x = x;
	}
	
	public T getY() {
		return this.y;
	}
	public void setY(T y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PunktGen [x " + this.x.getClass().getSimpleName() + "=" 
				+ x  + ", y " +this.y.getClass().getSimpleName() + "=" + y + "]";
	}

}

