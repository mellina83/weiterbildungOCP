package pattern.singleton;

public class SimpleSingleton02 {
	private static SimpleSingleton02 instance = null;
	
	public static String text = "";
	

	private SimpleSingleton02() {
		
	}
	
	public static SimpleSingleton02 getInstance() {
//		Thread 1 t1
//		Thread 2 t2		
		if(instance == null) {
			// t1 stopped by Thread Scheduler
			instance = new SimpleSingleton02();
		}
		return instance; //t2 stopped by Thread Scheduler
	}
}
