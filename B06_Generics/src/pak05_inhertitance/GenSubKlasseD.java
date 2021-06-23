package pak05_inhertitance;

public class GenSubKlasseD<T> extends EinfacheKlasseA {
	public void methodD(T t) {
		System.out.println("methodD() gerufen mit: " + t);
	}
}
