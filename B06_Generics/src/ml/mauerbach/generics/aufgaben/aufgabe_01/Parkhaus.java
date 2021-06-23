package ml.mauerbach.generics.aufgaben.aufgabe_01;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus {
	private List<Fahrzeug> list;
	Parkhaus(){
		list = new ArrayList<>();
	}
	public void einfahren(Fahrzeug fahrzeug) {
		list.add(fahrzeug);
	}
	@Override
	public String toString() {
		return list.toString();
	}
}
