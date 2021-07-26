package pak01_threads;

class Demo08_Geteilt {
	static int count;
}

class Demo08Runnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100_000; i++) {
			Demo08_Geteilt.count++;
//			Demo08_Geteilt.count = Demo08_Geteilt.count + 1;
//			try {
//				Thread.sleep(150);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println("Count im Run = " + Demo08_Geteilt.count);
	}

}

public class Demo08_Join {
	public static void main(String[] args) {
		Runnable target = new Demo08Runnable();
//		target.run();
		Thread t1 = new Thread(target);
		t1.start();

		/*
		 * Waits for this thread to die.
		 * 
		 * An invocation of this method behaves in exactly the sameway as the invocation
		 * 
		 * Instanz Methode join der Klasse Thread
		 * 
		 * join();
		 * 
		 * join(long millis)
		 * 
		 * join(long millis, int nanos)
		 * 
		 * - join haelt den Thread an, in dem sie aufgerufen wurde(hier: main)
		 * 	bis der aufrufende Thread(hier: t1) fertig ist.
		 * 
		 * - join wird beendet, wenn der Thread, zu dem sie aufgerufen wurde fertig ist
		 *	(hier: t1)
		 *
		 *	- join wird den aufrufenden Thread (hier: main )nicht anhalten, wenn der Thread,
		 *	zu dem sie aufgerufen ist NEW ist.
		 */		
		try {
			//Main wartet jetzt auf T1
			t1.join();
//			t1.join(1500);
//			t1.join(1500, 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		/*
		 * Moeglich auftretende "Race Condition"
		 * 
		 * Zwei Threads lesen und schreiben auf das selbe Attribut:
		 * - Thread 1 liest 100, wird dann in Pause versetzt.
		 * - Thread 2 arbeitet, schreibt bis 10000, macht dann Pause
		 * - Thread 1 schreibt 101, obwohl Thread 2 schon bei 10001 waere
		 */
		Thread t2 = new Thread(target);
		t2.start();
				
		/*
		 * Ich moechte sichergestellt haben, dass die Berechnung des Attributs komplett
		 * ist
		 */
		System.out.println("Count im Main = " + Demo08_Geteilt.count);
	}
}
