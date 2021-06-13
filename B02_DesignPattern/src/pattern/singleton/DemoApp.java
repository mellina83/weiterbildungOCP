package pattern.singleton;

public class DemoApp {
	public static void main(String[] args) {
		System.out.println(SimpleSingleton.text);
		
		SimpleSingleton02 s01 = SimpleSingleton02.getInstance();
		SimpleSingleton02 s02 = SimpleSingleton02.getInstance();
		
		System.out.println(s01.hashCode());
		System.out.println(s02.hashCode());
	}
}
