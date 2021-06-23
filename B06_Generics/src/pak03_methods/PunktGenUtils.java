package pak03_methods;

public class PunktGenUtils<T> {
	
	/*
	 * Im Instanzkontext ist T bekannt von der Klassendeklaration
	 */
	public PunktGen<T> erzeugePunkt(){
		return new PunktGen<>();		
	}
	/*
	 * Im statischen Kontext ist der Typ nicht bekannt, muss also
	 * bei der Methode neu deklariert werden.
	 */
	public static <E> PunktGen<E> createPunktGen(){
		return new PunktGen<>();
	}
	
	public static <T, E> void tausche(PunktGen<E> p1, PunktGen<E> p2) {
		E tmpX = p2.getX();
		E tmpY = p2.getY();
		
		p2.setX(p1.getX());
		p2.setY(p1.getY());
		
		p1.setX(tmpX);
		p1.setY(tmpY);
	}
	
	public static <T,S> void ausgeben(PunktGen<T> p1, PunktGen<S> p2) {
		System.out.println(p1.getX() + " " +p1.getY() + " : " + p1.getClass().getSimpleName());
		System.out.println(p2.getX() + " " +p2.getY() + " : " + p2.getClass().getSimpleName());
	}
	
	/*
	 * Wir koennen bei VarArgs nicht mehrere unterschiedliche generische Typen bestimmen
	 * Durch die Wildcard kann zwar alles uebergeben werden, ist dann in der Methode
	 * aber auf Object typisiert.
	 */
	public static void alleAusgeben(PunktGen<?>...p1) {
		for(PunktGen<?> punktGen : p1) {
			Object o = punktGen.getX();
			System.out.println(o.getClass().getSimpleName());
			System.out.println(punktGen);
		}
	}
	

	
	
}
