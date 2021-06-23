package pak05_inhertitance;

public class GenSubKlasseB<T> extends GenKlasseA<T>{
	T t;
	
	public void methodB(T t) {
		System.out.println("methodB() aufgerufen mit: " + t);
	}
}
