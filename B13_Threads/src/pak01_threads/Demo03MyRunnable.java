package pak01_threads;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("MyRunnable");
	}

}

public class Demo03MyRunnable {
	public static void main(String[] args) {
		Runnable target = new MyRunnable();
		
		Thread t1 = new Thread(target);
		t1.start();
	}
}
