package ml.duerbeck;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class MyLifo<E> extends ArrayList<E> {
	
	public E next() {
		E e = this.look();
		if (e == null) {
			return null;
		} else {
			this.remove(e);
			return e;
		}
	}
	
	public E look() {
		return this.get(this.size()-1);
	}
	
	public boolean reverse() {
		if (this.size() > 1) {

			ArrayDeque<E> tmp = new ArrayDeque<>(this);
			this.clear();
			Iterator<E> iter = tmp.descendingIterator();
			while (iter.hasNext()) {
				this.add(iter.next());
				return true;
			}
		}
		return false;
	}
	
	public boolean push(E e) {
		this.checkIfElementExists(e);
		this.remove(indexOf(e));
		this.add(0,e);
		return true;
	}
	
	private boolean checkIfElementExists(E e) {
		if (!this.contains(e)) {
			throw new NoSuchElementException();
		}
		return this.contains(e);
	}
	
	public boolean elevate(E e) {
		if (this.checkIfElementExists(e)) {
			int idx = this.indexOf(e);
			this.remove(idx);
			this.add(idx+1, e);
			return true;
		}
		return false;
	}
	
	public boolean toTop(E e) {
		if (this.checkIfElementExists(e)) {
			this.remove(indexOf(e));
			this.add(e);
		}
		return true;
	}
}
