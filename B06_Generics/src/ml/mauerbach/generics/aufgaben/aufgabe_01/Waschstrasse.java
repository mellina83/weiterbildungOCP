package ml.mauerbach.generics.aufgaben.aufgabe_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Waschstrasse<T extends Fahrzeug> {
	private Parkhaus parkhaus;
	private Queue<T> warten;
	Waschstrasse(Parkhaus parkhaus){
		warten = new ArrayDeque<T>();
		this.parkhaus = parkhaus;
	}
	
	public void waschen(T fahrzeug) {
		fahrzeug.setDreckig(false);
	}
	
	public void waschen() {
		if(!warten.isEmpty()) {
			T fahrzeug = warten.remove();
			fahrzeug.setDreckig(false);
			parkhaus.einfahren(fahrzeug);
		}
	}
	
	public void einfahren(T fahrzeug) {
		if(!fahrzeug.isDreckig()) {
			parkhaus.einfahren(fahrzeug);
		} else {
			warten.add(fahrzeug);
		}
	}
	@Override
	public String toString() {
		return warten.toString();
	}
}
