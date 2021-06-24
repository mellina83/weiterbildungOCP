package ml.duerbeck;
//Laeuft nicht richtig.
//Beispiel von Auerbach nehmen

import java.util.ArrayList;
import java.util.List;

public class FahrzeugeWaschenMain {

	public static void main(String[] args) {
		
		Parkhaus<Fahrzeug> parkhausWuppertal = new Parkhaus<>();
		Waschstrasse<Pkw> waschstrassePkw = new Waschstrasse<>(parkhausWuppertal);
		Waschstrasse<Lkw> waschstrasseLkw = new Waschstrasse<>(parkhausWuppertal);

		
		Pkw pkw1 = new Pkw("W-UP-1983", true);
		Lkw lkw1 = new Lkw("W-AL-0815", false);
		Pkw pkw2 = new Pkw("K-FO-808", false);
		Lkw lkw2 = new Lkw("B-EA-0104", true);
		
		System.out.println("Sauberkeitscheck:");
		waschstrassePkw.checkObDreckig(pkw1);
		waschstrassePkw.checkObDreckig(pkw2);
		waschstrasseLkw.checkObDreckig(lkw1);
		waschstrasseLkw.checkObDreckig(lkw2);
		
		System.out.println("Fahrzeuge aktuell im Parkhaus");
		parkhausWuppertal.anzeigenGeparkteFahrzeuge();
		
		System.out.println("\nWaschgang:");
		waschstrassePkw.waschen(parkhausWuppertal);
		waschstrasseLkw.waschen(parkhausWuppertal);

	}

}

class Waschstrasse<T extends Fahrzeug> {
	public List<T> dreckigeFahrzeuge;
	public Fahrzeug fahrzeug;
	public Parkhaus<T> parkhaus;
	
	public Waschstrasse(Parkhaus parkhaus) {
		dreckigeFahrzeuge = new ArrayList<>();
		this.parkhaus = parkhaus;
	}
	
	void checkObDreckig(T fahrzeug) {
		if (fahrzeug.isDreckig()) {
			System.out.println(fahrzeug + " ist dreckig, muss also gewaschen werden.");
			einfahren(fahrzeug);
		} else if (!fahrzeug.isDreckig()) {
			System.out.println(fahrzeug + " ist sauber. Daher kann es schon ins Parkhaus gefahren werden.");
			parkhaus.einfahren(fahrzeug);
		}
	}
	
	void einfahren (T fahrzeug) {
		dreckigeFahrzeuge.add(fahrzeug);
		System.out.println(fahrzeug + " ist in die Waschstrasse reingefahren.");
	}
	
	void waschen(Parkhaus<Fahrzeug> parkhausWuppertal) {
		for (int i = 0; dreckigeFahrzeuge.size() < i; i++) {
			this.dreckigeFahrzeuge.get(i).setDreckig(false);
			System.out.println(dreckigeFahrzeuge.get(i) + " ist jetzt sauber");
			parkhausWuppertal.einfahren(dreckigeFahrzeuge.get(i));
			this.ausfahren(dreckigeFahrzeuge.get(i), i);
		}
	}
	
	void ausfahren (T fahrzeug, int index) {
		dreckigeFahrzeuge.remove(index);
		System.out.println(fahrzeug + " ist aus der Waschstrasse rausgefahren.");
	}
	
	void anzeigenFahrzeugeInWaschstrasse() {
		System.out.println("Fahrzeuge in der Waschstrasse:");
		for (T fahrzeug: dreckigeFahrzeuge) {
			fahrzeug.toString();
		}
	}
}

class Parkhaus <T extends Fahrzeug> {
	public List<T> geparkteFahrzeuge;
	public Fahrzeug fahrzeug;
	
	public Parkhaus() {
		geparkteFahrzeuge = new ArrayList<>();
	}
	
	public void einfahren(T fahrzeug) {
		geparkteFahrzeuge.add(fahrzeug);
		System.out.println(fahrzeug + " wurde im Parkhaus geparkt");
	}
	
	void anzeigenGeparkteFahrzeuge() {
		System.out.println("Liste geparkter Fahrzeuge:");
		for (int i = 0; geparkteFahrzeuge.size() < i; i++) {
			System.out.println(geparkteFahrzeuge.get(i));
		}
	}
}

abstract class Fahrzeug {
//abstract Class, weil Zustand 'dreckig' waere bei einem
//Interface konstant
	private String kennzeichen;
	private boolean dreckig;
		
	public Fahrzeug(String kennzeichen, boolean dreckig) {
		setKennzeichen(kennzeichen);
		setDreckig(dreckig);
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public boolean isDreckig() {
		return dreckig;
	}

	public void setDreckig(boolean dreckig) {
		this.dreckig = dreckig;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "- Fahrzeug, Kennzeichen " + getKennzeichen();
	}
	
	
}

class Pkw extends Fahrzeug {

	public Pkw(String kennzeichen, boolean dreckig) {
		super(kennzeichen, dreckig);
	}
}

class Lkw extends Fahrzeug {

	public Lkw(String kennzeichen, boolean dreckig) {
		super(kennzeichen, dreckig);
	}
	
}
