package pak01_threads;

public class Demo04_Static_Api {
	public static void main(String[] args) {
		Thread current = Thread.currentThread();

		System.out.println(current.getId());
		System.out.println(current.getName());
		System.out.println(current.getPriority());

		/*
		 * A hint to the scheduler that the current thread is willing to yield its
		 * current use of a processor. The scheduler is free to ignore this hint.
		 */
		Thread.yield();

		try {
			Thread.sleep(5000);
			Thread.sleep(1000, 500);
		} catch (InterruptedException e) {
			System.out.println("In diesem Beispiel wird es keine Exception geben");
		}
		/*
		 * Returns an estimate of the number of active threads in the current thread's
		 * thread group and its subgroups. Recursively iterates over all subgroups in the
		 * current thread's thread group.
		 */
		System.out.println(Thread.activeCount());

		System.out.println("End of Main");

	}
}
