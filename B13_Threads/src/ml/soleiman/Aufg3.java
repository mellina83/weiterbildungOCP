package ml.soleiman;

import java.util.ArrayList;

public class Aufg3 {

	public static void main(String[] args) {

		ArrayList<Thread> threadList = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
			threadList.add(new Thread(new MyThread("Thread " + i)));
//			threadList.add(new Thread(new MyRunnable2())); 	//wie kann man den Namen setzen ???
//			Thread.currentThread().setName(i+"");
		}
		for (int i = 0; i < 16; i++) {
			threadList.get(i).start();
		}
	}
}

class MyThread extends Thread {

	public MyThread(String s) {
		super(s);
	}
	
	@Override
	public void run() {
		System.out.println("ID:" + getId() + "	Name:" + getName());
	}
}

class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		System.out.println("ID: " + Thread.currentThread().getId() + " Name: " + Thread.currentThread().getName());
	}
}

/**
 * 
 * @Aufgabe03 Bitte 16 Threads im Zustand 'NEW' in einer Schleife erzeugen.
 *            Danach alle 16 Threads in einer weiteren Schleife starten lassen.
 *            Jeder Thread soll einfach seine ID und seinen Namen auf der
 *            Konsole ausgeben.
 *
 */