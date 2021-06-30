package ml.duerbeck.a0304;

//Klasse Browser History
//String Array mit 5, oder ArrayList als Attribut

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class BrowserHistory {
	
	//Aufgabe01
	Deque<String> history;
	
	BrowserHistory() {
		history = new ArrayDeque<>(5);
	}

	public static void main(String[] args) {
		BrowserHistory h = new BrowserHistory();
		
	//Aufgabe02
		 h.open("u1.com");
		 h.open("u2.com");
		 h.open("u3.com");
		 h.open("u4.com");
		 h.open("u5.com");
		 System.out.println(h.getCurrent());
	//Aufgabe03	 
		 h.open("u6.com");
		 System.out.println( h.getCurrent() );
		 
	//Aufgabe04	 
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
		 System.out.println( h.getCurrent() );
	//Aufgabe05	 
	  try {
		  h.openPrevious();
	  } catch (RuntimeException e) {
		  e.getMessage();
		  }
	  System.out.println( h.getCurrent() );
	 
		System.out.println("Aufgabe06");
		h.openNext();
		h.openNext();
		h.openNext();
		h.openNext();
		System.out.println( h.getCurrent() );

	}
	
	//Aufgabe06
	private void openNext() {
	//	history.removeFirst();
	}

	//Aufgabe04 u 05
	private void openPrevious() throws RuntimeException {
		history.removeLast();
	}

	//Aufgabe02
	private String getCurrent() { 
		return history.getLast();
	}

	private void open(String string) {
		history.offer(string);
	}

}
