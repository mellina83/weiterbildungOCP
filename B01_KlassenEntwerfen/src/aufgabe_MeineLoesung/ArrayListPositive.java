package aufgabe_MeineLoesung;

import java.util.ArrayList;

public class ArrayListPositive extends ArrayList<Integer> {
	
	//Add Methoden sollten ueberschrieben werden
	@Override
	public boolean add(Integer value) throws NullArgumentException, NotPositiveArgumentException {
		this.check(value);
		return super.add(value);
	}
	
	public void add(int index, Integer value) throws NullArgumentException, NotPositiveArgumentException {
		this.check(value);
		super.add(index, value);
	}
	
	//Checken der Werte mit Auswurf von RuntimeExceptions
	public void check(Integer value) throws NullArgumentException, NotPositiveArgumentException {
		if (value == null) {
			throw new NullArgumentException("Wert darf nicht null sein!");
		}
		
		if (value <= 0) {
			throw new NotPositiveArgumentException("Wert darf nur positiv sein!");
		}
	}

}
