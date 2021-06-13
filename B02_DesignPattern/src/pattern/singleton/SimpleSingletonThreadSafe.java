package pattern.singleton;

public class SimpleSingletonThreadSafe {
	private static SimpleSingletonThreadSafe instance = null;

	public static String text = "";

	private SimpleSingletonThreadSafe() {

	}

	public static SimpleSingletonThreadSafe getInstance() {
//		Thread 1 t1
//		Thread 2 t2	
		synchronized (SimpleSingletonThreadSafe.class) {
			if (instance == null) {
				// t1 stopped by Thread Scheduler
				instance = new SimpleSingletonThreadSafe();
			}
		}

		return instance; // t2 stopped by Thread Scheduler
	}
}
