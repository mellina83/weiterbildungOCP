package ml.novytska.Aufgabe_01_Generic;

import java.util.ArrayList;
import java.util.List;

public class Waschstrasse<T extends Fahrzeuge>{
	
	public List<T> waschlist;

	public Waschstrasse() {
		waschlist = new ArrayList<>();
//		System.out.println("----------Waschstrasse----------");
	}

	public void waschen(T fahrzeug) {
		System.out.println(fahrzeug + "  waescht");
		fahrzeug.setDreckig(false);
		waschlist.remove(fahrzeug);
		System.out.println(fahrzeug + "  riechtet in Parkhaus");
	}
	public void add(T fahrzeug) {
		if (fahrzeug.isDreckig()) {
			waschlist.add(fahrzeug);
		}
	}
	public List<T> getWaschList(){
		System.out.println("-------Reihenfolge bei Waschanlage-------");
		System.out.println(waschlist);
		return waschlist;
	}
}
