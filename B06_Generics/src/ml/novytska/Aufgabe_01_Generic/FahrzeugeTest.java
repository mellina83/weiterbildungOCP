package ml.novytska.Aufgabe_01_Generic;

public class FahrzeugeTest {
	public static void main(String[] args) {
		Fahrzeuge[] fhrs = {
				new Pkw("Audi", 4, 3000, false),
				new Pkw("BMW", 4, 2500, true),
				new Pkw("WV", 4, 2000, true),
				new Pkw("AlfaRomeo", 4, 2000, false),
				new Lkw("MAN", 8, 12000, true),
				new Lkw("Mercedes", 12, 18000, false),
				new Lkw("Volvo", 16, 24000, true),
				new Lkw("Renault", 16, 20000, true)
				};
		
		Waschstrasse<Fahrzeuge> waschstrasse = new Waschstrasse<>();
		Parkhaus<Fahrzeuge> parkhaus = new Parkhaus<>();
		for(Fahrzeuge fahrzeuge:fhrs) {
			if(fahrzeuge.isDreckig()) {
				waschstrasse.add(fahrzeuge);
			}else {
				parkhaus.parken(fahrzeuge);		
			}
		}
		for (int i = waschstrasse.getWaschList().size()-1; i >=0; i--) {
			Fahrzeuge fahrzeuge = waschstrasse.getWaschList().get(i);
			waschstrasse.waschen(fahrzeuge);
			parkhaus.parken(fahrzeuge);	
		}
		
}

}
