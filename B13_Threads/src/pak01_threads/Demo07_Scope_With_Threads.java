package pak01_threads;

public class Demo07_Scope_With_Threads {
	public static void main(String[] args) {
		int i = 1000; // auf dem Stack-Memory vom Main-Thread
		
		new Thread("Thread 01") {
			public void run() {
				int i = 2000;// auf dem Stack-Memory von Thread 01
				System.out.println("i in Thread 1 : " + i);				
				/*
				 * Was passiert, wenn in diesem Thread eine Exception auftritt?
				 * 
				 * Die Runtime Exception beendet lediglich den Thread, in dem sie auftritt.
				 */
				throw new RuntimeException("Exception in Thread 01");
			}
		}.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("i in Main : " + i);
		System.out.println("End of Main");
	}
}

