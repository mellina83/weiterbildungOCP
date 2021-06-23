package pak05_inhertitance;

public class GenSubKlasseC<T> extends GenKlasseA<Integer>{
	public void methodC(T t) {
		System.out.println("methodC() aufgerufen mit: " + t);
	}
	
//	public GenSubKlasseC(T t) {
//		
//	}
	
}
