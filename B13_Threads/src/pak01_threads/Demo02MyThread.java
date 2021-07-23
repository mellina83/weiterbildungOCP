package pak01_threads;

class MyThread extends Thread{
	public void run() {
		int i = 0;
		while(i<10) {
			System.out.println("MyThread");
			i++;
		}
	}
}
class MyThread2 implements Runnable{
	
	int count = 0;
	
	public void run() {
		int i = 0;
		while(count<10) {
			System.out.println("MyThread 2");
			count++;
		}
	}
}

public class Demo02MyThread {
	public static void main(String[] args) {
		Thread t01 = new MyThread();
		
		t01.start();
		
		Thread t02 = new Thread(new MyThread2());
		
		t02.start();
		System.out.println("Main");
	}
}
