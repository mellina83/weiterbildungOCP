package ml.soleiman;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("LKW's erzeugen:");
		
		LKW lkw1 = new LKW(true);	System.out.println(lkw1);
		LKW lkw2 = new LKW(true);	System.out.println(lkw2);
		LKW lkw3 = new LKW(true);	System.out.println(lkw3);
		LKW lkw4 = new LKW(true);	System.out.println(lkw4);
		
		System.out.println("\nPKW's erzeugen:");

		PKW pkw5 = new PKW(true);	System.out.println(pkw5);
		PKW pkw6 = new PKW(true);	System.out.println(pkw6);
		PKW pkw7 = new PKW(true);	System.out.println(pkw7);
		PKW pkw8 = new PKW(true);	System.out.println(pkw8);
		
		Waschstrasse<LKW> lkw_waschstrasse = new Waschstrasse<>();
		Waschstrasse<PKW> pkw_waschstrasse = new Waschstrasse<>();
		Parkhaus<Fahrzeug> parkhaus = new Parkhaus<>();
		
		System.out.println("\nPKW's und LKW's in die Waschstrasse fahren:\n");
		
		lkw_waschstrasse.einfahren(lkw1); lkw_waschstrasse.einfahren(lkw2);
		lkw_waschstrasse.einfahren(lkw3); lkw_waschstrasse.einfahren(lkw4);
		
		pkw_waschstrasse.einfahren(pkw5); pkw_waschstrasse.einfahren(pkw6);
		pkw_waschstrasse.einfahren(pkw7); pkw_waschstrasse.einfahren(pkw8);
		
		//Parken
		parkhaus.parken(lkw_waschstrasse.fahrzeugeWS, pkw_waschstrasse.fahrzeugeWS);
		
		for (Fahrzeug f : parkhaus.fahrzeugePH) {
			System.out.println(f);
		}
		
		//Prüfen ob lkw und pkw waschstraße leer ist
		System.out.println(); 
		for (Fahrzeug f : lkw_waschstrasse.fahrzeugeWS) {
			System.out.println(f);
		}
		for (Fahrzeug f : pkw_waschstrasse.fahrzeugeWS) {
			System.out.println(f);
		}
		

	}
}
