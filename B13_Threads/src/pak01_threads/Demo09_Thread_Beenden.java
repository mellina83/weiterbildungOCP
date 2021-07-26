package pak01_threads;

class Demo09_Endloser_Thread extends Thread {

	private boolean running = true;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (isRunning()) {
			System.out.println("Thread.getId() : " + this.getId());
			ThreadUtility.pause(1000);		
		}
		System.out.println("Thread ist fertig");
	}
}

public class Demo09_Thread_Beenden {
	public static void main(String[] args) {
		Demo09_Endloser_Thread endless = new Demo09_Endloser_Thread();
		endless.start();
		
		ThreadUtility.pause(7250);
		System.out.println("Jetzt wird endless von main beendet");
		endless.setRunning(false);
		
		System.out.println("End of main");

	}
}
