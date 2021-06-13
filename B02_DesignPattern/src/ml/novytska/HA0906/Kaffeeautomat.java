package ml.novytska.HA0906;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kaffeeautomat {
	enum Kaffeesorten {
		KAFFEE("1 Euro", 100, 1), CAPPUCCINO("1,20 Euro", 120, 2), ESPRESSO("1,13 Euro", 113, 3);
        String name;
        int preis;
		int num;
		
		Kaffeesorten(String s, int d, int n) {
			name = s;
			preis = d;
			num = n;
		}
		public String getName() {
			return name;
		}
		public int getNum() {
			return num;
		}
		public int getPreis() {
			return preis;
		}

	}

	enum Muenze {
		
		ZWEIEURO(200),
		EINEURO(100),
		FUENFZIGCENT(50),
		ZWANZIGCENT(20), 
		ZEHNCENT(10), 
		FUENFCENT(5), 
		ZWEICENT(2), 
		EINCENT(1)
		;

		int wert;
		Muenze(int i) {
			wert = i;
		}

		public int getWert() {
			return wert;
		}

	}

	public static void main(String[] args) {
		int taste = 1;
		int wert = 0;
		int geld = 0;
		int rest = 0;
		int fehlt = 0;
		int z = 0;
		
		ArrayList restausgabe = new ArrayList();
		
		System.out.println("************************************");
		
		for (Kaffeesorten ks : Kaffeesorten.values()) {
			System.out.println("*   " + ks + "     "  + "   Taste "+ ++z +"       *");
		}
		System.out.println("************************************");
		z = 0;
		System.out.println("Waelen Sie bitte einen Kaffee");
		System.out.println("Taste: ");
		Scanner sc = new Scanner(System.in);
		taste = sc.nextInt();
		for(Kaffeesorten k: Kaffeesorten.values()) {
		if(taste == k.getNum())
		{wert = k.getPreis();
		System.out.println("Bezahlen Sie bitte  " + k.getName());}
		}
		
		geld = sc.nextInt();

		if( geld == wert) {
			kaffeeausgabe();
			}else if(geld > wert) {
			rest = geld - wert;
			System.out.println("Rest ist : " + rest);
			kaffeeausgabe();
			rest1(rest);
			System.out.println("Rest Ausgabe  "+ausgabelist);

//			restausgabe(rest, restausgabe);
		} else {
			
			fehlt = wert - geld;
			
			System.out.println("Es fehlt noch " + fehlt + " Cent");
			
			geld = sc.nextInt();
			
			if(geld<fehlt) 
				System.out.println("Zurueckgehen " + geld + "Cent");
			rest1(rest);
			System.out.println("Rest Ausgabe "+ausgabelist);
//			kaffeeausgabe();
				 
		}
    	
		sc.close();	
	}

	private static void kaffeeausgabe() {
		System.out.println("Kaffee ist fertig!!! Genissen Sie langsam!!!");
	}
	private static List ausgabelist = new ArrayList();
	private static void rest1(int r) {
		int nrest = 0;
		for (Muenze muenze: Muenze.values()) {
			int gteil = (int)(r/muenze.getWert());
			if (gteil == 0 ) continue;
			ausgabelist.add(muenze);
			nrest = r - muenze.getWert();
			break;
		}
		if (nrest > 0) {
			rest1(nrest);
		}
	}
}