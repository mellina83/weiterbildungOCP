package pak01_threads;

public class Demo05_Instance_API {
	public static void main(String[] args) {
		/*
		 * Konstruktoren
		 */
		Thread t1 = new Thread(); //Default
		
		/*
		 * Mit Angabe eines Runnable
		 */
		Thread t2 = new Thread(()-> {});
		
		/*
		 * Mit Angabe eines Namens fuer den Thread
		 */
		Thread tFred = new Thread("Fred");
		
		/*
		 * Mit Angabe eines Runnable und eines Namens fuer den Thread
		 */
		Thread tBarney = new Thread(()->{}, "Barney");
		
		/*
		 * getName()
		 * 
		 * setName()
		 */
		System.out.println("tFred.getName(): " + tFred.getName());
		tFred.setName("Wilma");
		System.out.println("tFred.getName(): " + tFred.getName());
		
		
		/*
		 * getId()
		 */		
		long id = tFred.getId();
		System.out.println("tFred.getId(): " + tFred.getId());
		System.out.println("tBarney.getId(): " + tBarney.getId());
		
		/**
		 * getPriority()
		 * 
		 * setPriority()
		 */
		int priority = tFred.getPriority();
		System.out.println("tFred.getPriority() : " + priority);// NORM_PRIORITY = 5
		
		tFred.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("tFred.getPriority() : " + tFred.getPriority());
		
        tFred.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("tFred.getPriority() : " + tFred.getPriority());
		
		
		
	}
}
