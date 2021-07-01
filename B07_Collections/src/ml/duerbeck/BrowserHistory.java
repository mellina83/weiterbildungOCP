package ml.duerbeck;

//Loesung funktioniert nicht komplett
//Besser: Siehe Loesung von Dozent


//String Array mit 5, oder ArrayList als Attribut

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class BrowserHistory {

	// Aufgabe01
	Deque<String> history;
	Deque<String> save;

	BrowserHistory() {
		history = new ArrayDeque<>();
		save = new ArrayDeque<>();
	}

	public static void main(String[] args) {
		BrowserHistory h = new BrowserHistory();

		// Aufgabe02
		h.open("u1.com");
		h.open("u2.com");
		h.open("u3.com");
		h.open("u4.com");
		h.open("u5.com");
		System.out.println(h.getCurrent());
		// Aufgabe03
		System.out.println("Aufgabe 3:");
		h.open("u6.com");
		System.out.println(h.getCurrent());

		// Aufgabe04
		System.out.println("Aufgabe 4:");
		h.openPrevious();
		h.openPrevious();
		h.openPrevious();
		h.openPrevious();

		// Aufgabe05
		System.out.println("Aufgabe 5:");
		try {
			h.openPrevious();
		} catch (IllegalStateException e) {
			e.printStackTrace(); //getMessage funktioniert nicht
		}
		System.out.println( h.getCurrent() );

		System.out.println("Aufgabe 6:");
		h.openNext();
		h.openNext();
		h.openNext();
		h.openNext();
		
		System.out.println("Aufgabe 7:");
		try {
			h.openNext();
		} catch (IllegalStateException e) {
			e.printStackTrace(); //getMessage funktioniert nicht
		}
		System.out.println( h.getCurrent() ); // Leider wird hier u2.com, und nicht u6.com angezeigt.

	}
	

	// Aufgabe06 und 07
	private void openNext() {
		if (history.size() > 4) {
			throw new IllegalStateException("Next History is empty!");
		} else {
			this.history.addFirst(this.save.getFirst());
			this.save.remove();
			System.out.println(this.history.getFirst());
		}
	}

	// Aufgabe04 u 05
	private void openPrevious() throws IllegalStateException {
		if (history.size() < 2) {
			throw new IllegalStateException("Previous History is empty!");
		} else {
			this.save.addFirst(this.history.getLast());
			this.history.removeLast();
			System.out.println(this.history.getLast());
		}
	}

	// Aufgabe02
	private String getCurrent() {
		return this.history.getLast();
	}

	private void open(String string) {
		if (this.history.size() < 5) {
			this.history.offer(string);
		} else {
			this.history.remove(); // wieso geht poll nicht?
			this.history.offer(string);
		}

	}

}
