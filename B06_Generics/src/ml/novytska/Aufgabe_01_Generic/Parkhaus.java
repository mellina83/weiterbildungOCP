package ml.novytska.Aufgabe_01_Generic;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus<T extends Fahrzeuge> {
	public List<T> parkenlist;

	public Parkhaus() {
		parkenlist = new ArrayList<>();
		
	}
	
	

	public void parken(T fahrzeug) {
		System.out.println("----------Parkhaus----------");
		parkenlist.add(fahrzeug);
		System.out.println(parkenlist);
	}

}
