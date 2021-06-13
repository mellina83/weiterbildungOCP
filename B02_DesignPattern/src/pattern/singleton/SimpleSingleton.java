package pattern.singleton;

public class SimpleSingleton {
	private static SimpleSingleton instance = new SimpleSingleton();
	
	public static String text = "";
	

	private SimpleSingleton() {
		
	}
	
	public static SimpleSingleton getInstance() {
		return instance;
	}
	
}
