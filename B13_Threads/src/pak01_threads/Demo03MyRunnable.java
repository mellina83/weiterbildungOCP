package pak01_threads;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("MyRunnable");
		Thread t = Thread.currentThread();
		System.out.printf("%d ID %8s Name %n", t.getId(), t.getName());	
	}

}

public class Demo03MyRunnable {
	public static void main(String[] args) {
		Runnable target = new MyRunnable();
		
		Thread t1 = new Thread(target, "Fred");
		t1.start();
		Thread t2 = new Thread(target, "Barney");
		t2.start();
	}
}
