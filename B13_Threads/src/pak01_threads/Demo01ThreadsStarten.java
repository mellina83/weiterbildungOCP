package pak01_threads;

public class Demo01ThreadsStarten {
	public static void main(String[] args) {
//		thread01();
//		thread02();
//		thread03();
	
		
//		exam01();
		exam02();
//		exam03();
		
	
		System.out.println("Programmende");

	}
	
	private static void exam03() {
		Thread t1 = new Thread(() -> System.out.println("Hello Lambda"));
		
		t1.run();
		
		t1.start();
		
		t1.run();
		
		//Wie viele Threads wurden gestartet?
		//1 
		
	}

	private static void exam02() {
		Thread t1 = new Thread() {
			public void run() {				
				System.out.println(Thread.currentThread().getName() + " Motorad");
			}
		};
		t1.start();
		t1.run();
		t1.run();
		//java.lang.IllegalThreadStateException
//		t1.start(); 
		
		//What will be the Output
		//A: Motorrad Motorrad Motorrad
		//B: Motorrad Motorrad Motorrad Exception |
		//C: CompileError
		//D: Motorrad
	}

	private static void exam01() {
		Runnable target = new Runnable() {			
			@Override
			public void run() {
				System.out.println("Auto");				
			}
		};
		Thread t1 = new Thread(target) {
			@Override
			public void run() {
				System.out.println("Motorrad");
			}
		};
		t1.start();	
		t1.run();
		//A: Auto		
		//B: Motorrad	||
		//C: Auto Motorrad
		//D: Exception
	}

	/**
	 * Klasse Thread 2x
	 * 
	 * Interface Runnable 1x
	 */
	private static void thread03() {
		Runnable target = new Runnable() {			
			@Override
			public void run() {
				int i = 0;
				while(i < 100) {
					try {
						Thread.sleep(125);
						System.out.println(Thread.currentThread().getId() + " : " + i++);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
		};
		Thread t01 = new Thread(target);
		Thread t02 = new Thread(target);
		t01.start();
		t02.start();	
	}
	
	/**
	 * Klasse Thread
	 * 
	 * Interface Runnable
	 */
	private static void thread02() {
		Runnable target = new Runnable() {			
			@Override
			public void run() {
				int i = 0;
				while(i < 150) {
					try {
						Thread.sleep(125);
						System.out.println("Unser erster Thread mit einem Runnable");
						i++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}				
			}
		};		
		Thread thread = new Thread(target);
		thread.start();
		int i = 0;
		while(i < 10) {
			try {
				Thread.sleep(125);
				System.out.println("Dies ist aus Main Thread heraus");
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	/*
	 * Klasse Thread
	 */
	private static void thread01() {
		/**
		 * Wir reservieren einen Thread
		 * 
		 * State: NEW
		 */
		Thread thread = new Thread();
		
		/**
		 * Wir registrieren unseren Thread beim Scheduler, damit geht der Thread vom
		 * Zustand NEW -> Living -> Runnable ueber.
		 * 
		 * Unser Thread wird dem Threadpool hinzugefuegt.
		 */
		thread.start();
		//Ab jetzt ist ein zweiter Thread im Pool mit den gleichen Rechten wie der Main Thread
	}
}
