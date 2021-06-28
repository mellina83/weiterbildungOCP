package aufgaben.a02.loesung;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class MyLiFo<E> extends ArrayList<E> {

	/**
	 * next() � Soll das n�chste nachfolgende Element aus der Liste holen und von
	 * der Liste entfernen. Wenn kein Element mehr vorhanden ist soll null
	 * zur�ckgegeben werden.
	 */
	public E next() {
		E e = this.look();
		this.remove(e);
		return e;
	}

	/**
	 * look() � mit Look soll das n�chste Nachfolgende Element aus der Liste geholt
	 * werden, ohne es aus der Liste zu entfernen.
	 */
	public E look() {
		return this.get(this.size() - 1);
	}

	/**
	 * reverse() � Damit soll die gesamte Liste umgedreht werden. Bei Erfolg soll
	 * die Methode true sonst false ausgeben.
	 */
	public boolean reverse() {
		if (this.size() > 1) {
			ArrayDeque<E> tmp = new ArrayDeque<E>(this);
			this.clear();
			Iterator<E> iter = tmp.descendingIterator();
			while (iter.hasNext()) {
				this.add(iter.next());
				
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * push(E e) � mit Push soll es m�glich sein, ein Element am hintersten Ende der
	 * Warteschlange zu setzen. Bei Erfolg soll die Methode true sonst false
	 * ausgeben.
	 * 
	 * @param e
	 * @return
	 */
	public boolean push(E e) {
		if (this.checkIfElementExits(e)) {
			this.remove(this.indexOf(e));
			this.add(0, e);
			return true;
		}
		return false;
	}

	private boolean checkIfElementExits(E e) {
//		if (!this.contains(e)) {
//			throw new NoSuchElementException();
//		}
		return this.contains(e);
	}

	/**
	 * elevate(E e) � Mit Elevate soll es m�glich sein das �bergebene Element um
	 * einen Listenplatz nach vorne zu schieben. Bei Erfolg soll die Methode true
	 * sonst false ausgeben.
	 * 
	 * @param e
	 * @return
	 */
	public boolean elevate(E e) {
		if (this.checkIfElementExits(e)) {
			int idx = this.indexOf(e);//1a 2b 3c '4d' 5e 6f
			this.remove(idx);//1a 2b 3c 4e 5f
			this.add(idx+1, e);//1a 2b 3c 4d 5e 6f
			return true;
		}
		return false;
	}

	/**
	 * toTop(E e) � Mit toTop soll ein Element an die Spitze der Liste gesetzt
	 * werden. Bei Erfolg soll die Methode true sonst false ausgeben.
	 * 
	 * @param e
	 * @return
	 */
	public boolean toTop(E e) {
		if(this.checkIfElementExits(e)) {
			this.remove(this.indexOf(e));
			this.add(e);
			return true;
		}
		return true;
	}
}
