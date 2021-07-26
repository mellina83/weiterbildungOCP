package pak01_threads.aufgaben;

import java.util.ArrayList;
import java.util.List;

/**
 * @Aufgabe01 Realisierung durch Ableitung von der Klasse 'Thread'.
 * 
 *            Bitte starten Sie einen 10_000Loop extra-Thread, der ca. jede
 *            Sekunde seine ID und seinen Namen auf der Konsole ausgibt..
 *
 *
 * @Aufgabe02 Realisierung mit implementierung 'Interface Runnable'.
 * 
 *            Bitte starten Sie einen 10_000Loop extra-Thread, der ca. jede
 *            Sekunde seine ID und seinen Namen auf der Konsole ausgibt.
 *
 * 
 * @Aufgabe03 Bitte 16 Threads im Zustand 'NEW' in einer Schleife erzeugen.
 *            Danach alle 16 Threads in einer weiteren Schleife starten lassen.
 *            Jeder Thread soll einfach seine ID und seinen Namen auf der
 *            Konsole ausgeben.
 *
 */
class My_Thread_ML extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			System.out.println(Thread.currentThread().getName());
//			System.out.println(Thread.currentThread().getId());
			System.out.printf("%d ID %8s Name %n", this.getId(), this.getName());
		}
	}
}

class MyRunnable_ML implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Thread t = Thread.currentThread();
			System.out.printf("%d ID %8s Name %n", t.getId(), t.getName());
		}

	}

}

public class Aufgabe01_Simple_Thread_Api_ML {

	public static void main(String[] args) {
		// Aufgabe 1
//		new My_Thread_ML().start();
		// Aufgabe 2
//		new Thread(new MyRunnable_ML()).start();
		// Aufgabe 3
		/**
		 * @Aufgabe03 Bitte 16 Threads im Zustand 'NEW' in einer Schleife erzeugen.
		 *            Danach alle 16 Threads in einer weiteren Schleife starten lassen.
		 *            Jeder Thread soll einfach seine ID und seinen Namen auf der
		 *            Konsole ausgeben.
		 */
		Thread[] threads = new Thread[16];
		List<Thread> listOfThreads = new ArrayList<>();
		
		//Variante 1 als Kindklasse
//		for (int i = 0; i < 16; i++) {
//			listOfThreads.add(new Thread() {
//				public void run() {
//					Thread t = Thread.currentThread();
//					System.out.printf("%d ID %8s Name %n", t.getId(), t.getName());
//				}
//			});
//		}
		//Variante 2 Interface Runnable
		//Lambda Variante
		Runnable targetLambda = ()->{
			Thread t = Thread.currentThread();
			System.out.printf("%d ID %8s Name %n", t.getId(), t.getName());
		};
		//Anonyme Klasse Variante
		Runnable targetAnoClass = new Runnable(){
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.printf("%d ID %8s Name %n", t.getId(), t.getName());				
			}			
		};
		
		for (int i = 0; i < 16; i++) {
			listOfThreads.add(new Thread(targetAnoClass));
		}
				
//		for(Thread t : listOfThreads) {
//			t.start();
//		}
		
		listOfThreads.forEach(t->t.start());
		
		
	}

}
