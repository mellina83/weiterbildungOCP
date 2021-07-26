package ml.soleiman;

class MyThread_Aufg1 extends Thread{
	
	@Override
	public void run() {
		setName("Max");
		for (int i = 0; i < 10_000; i++) {
			try {
				sleep(1000);
				System.out.println("ID: " + getId() + " Name: " + getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Aufg1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread_Aufg1();
		t1.start();
	}
}
/**
 * @Aufgabe01 Realisierung durch Ableitung von der Klasse 'Thread'.
 * 
 *            Bitte starten Sie einen 10_000Loop extra-Thread, der ca. jede
 *            Sekunde seine ID und seinen Namen auf der Konsole ausgibt..
 *
 *
 */