package ml.soleiman;


class MyRunnable implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i < 10_000; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("ID: " + Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
			
		}
	}
}

public class Aufg2 {

	public static void main(String[] args) {
		
		Runnable target = new MyRunnable();
		
		Thread t1 = new Thread(target);
		t1.start();

	}

}

/**
 * @Aufgabe02 Realisierung mit implementierung 'Interface Runnable'.
 * 
 *            Bitte starten Sie einen 10_000Loop extra-Thread, der ca. jede
 *            Sekunde seine ID und seinen Namen auf der Konsole ausgibt.
 */
