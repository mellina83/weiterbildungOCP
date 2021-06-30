package ml.duerbeck.a03bis05;

//Klasse Browser History
//String Array mit 5, oder ArrayList als Attribut

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BrowserHistory {
	
	//Aufgabe01
	String[] history;
	
	BrowserHistory() {
		history = new String[5];
	}

	public static void main(String[] args) {
		BrowserHistory h = new BrowserHistory();
		
	//Aufgabe02
		 h.open("u1.com");
		 h.open("u2.com");
		 h.open("u3.com");
		 h.open("u4.com");
		 h.open("u5.com");
//		 System.out.println(h.getCurrent());
	//Aufgabe03	 
		 h.open("u6.com");
//		 System.out.println( h.getCurrent() );
		 
	//Aufgabe04	 
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
		 h.openPrevious();
//		 System.out.println( h.getCurrent() );
	//Aufgabe05	 
	  try {
		  h.openPrevious();
	  } catch (RuntimeException e) {
		  e.getMessage();
		  }
	//  System.out.println( h.getCurrent() );
	 
		System.out.println("Aufgabe06");
		h.openNext();
		h.openNext();
		h.openNext();
		h.openNext();
	//	System.out.println( h.getCurrent() );

	}
	
	//Aufgabe06
	private void openNext() {
	//	history.removeFirst();
	}

	//Aufgabe04 u 05
	private void openPrevious() throws RuntimeException {
		List<String> list = Arrays.asList(history);
		Deque<String> deque = new ArrayDeque<>(list);
		deque.removeLast();
	}

	//Aufgabe02
//	private String getCurrent() { 
//		return history.getLast();
//	}

	private void open(String string) {

		//history.offer(string);
	}
}

