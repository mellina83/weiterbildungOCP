package ml.soleiman;

import java.util.ArrayList;
import java.util.List;

public class Waschstrasse<T extends Fahrzeug> {

	public List<Fahrzeug> fahrzeugeWS;

	Waschstrasse() {
		fahrzeugeWS = new ArrayList<>();
	}

	public void einfahren(T fahrzeug) {
		if (fahrzeug.isDreckig()) 
			waschen(fahrzeug);
		fahrzeugeWS.add(0, fahrzeug);
	}
	
	void waschen(T fahrzeug) {
		fahrzeug.setDreckig(false);
	}
	
	public void einfahrenInWarteschlange(T fahrzeug) {
		fahrzeugeWS.add(fahrzeug);
	}
	
	public void alleWaschen() {
		for (int i = 0; i < fahrzeugeWS.size(); i++) {
			if (fahrzeugeWS.get(i).isDreckig()) {
//				if(fahrzeugeWS.get(i) instanceof LKW)
//				waschen((T)fahrzeugeWS.get(i));				
			}
		}
	}
}
