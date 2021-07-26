package pak01_threads;

/*
 * Jede Methode, die einen Thread anhalten kann, deklariert
 * die checked Exception 'InterruptedException'
 * 
 */
public class Demo06_Sleep {
	public static void main(String[] args) {
//		Thread.sleep(5000);//Compile Error : Unhandled exception type InterruptedException
		
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(i);
					System.out.println(this.getName() + "schlaeft 5 Sekunden");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
//		t.start();
		
		try {
			/*
			 * Der Thread, in dem die Methode sleep aufgerufen wird,
			 * legt eine 5 Sekunden Pause ein.
			 */
			System.out.println("main schlaeft 5 Sekunden");
			Thread.sleep(5000);
			/*
			 * Wir legen eine 2 Sekunden und 5000 Nanosekunden Pause ein
			 */
			Thread.sleep(2000, 5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

//		try {
//			t.sleep(1000);
////			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println("end of main");
	}
}
