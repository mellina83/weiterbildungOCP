package ml.Duerbeck.basics;

public class StatischeInnereKlassenUndInterfaces {

	public static void main(String[] args) {
		
		//Objekterstellung in einer anderen Main
		Lampe.Gluehbirne birne1 = new Lampe.Gluehbirne();
		
	}
}

class Lampe {
	static String sVonLampe = "Attribut von Lampe: Statischer String";
	String nVonLampe = "Attribut von Lampe: non-static String";
	
	static void print() {
	}
	
	void print2() {
	}
	
	//Methode der aeusseren Klasse darf nur statische Member der inneren aufrufen
	//Mittels Klassennamen der inneren
	void print3() {
		Gluehbirne.ausgabe2();
		System.out.println(Gluehbirne.sVonGluehlampe);
//		System.out.println(Gluebirne.nVonGluehlampe); non-static
	}
	
	static class Gluehbirne {
		
		String name;
		static String name2;
		void ausgabe() {
			//Die innere Klasse kann von der aeusseren Klasse nur statische Member abrufen
			System.out.println(sVonLampe);
//			System.out.println(nVonLampe); non-static
			print();
//			print2(); non-static
		}
		
		static void ausgabe2() {
		}
		
		static String sVonGluehlampe = "Attribut von Gluehlampe: Statischer String";
		String nVonGluehlampe = "Attribut von Lampe: non-static String";
	}
	
	public static void main (String[] args) {
		
		//Objekterstellung innerhalb der aeusseren Klasse
		//In beliebiger Kombi untereinander moeglich
		Lampe.Gluehbirne birne2 = new Lampe.Gluehbirne();
		Gluehbirne birne3 = new Gluehbirne();
		
		//Oder natuerlich an Instanz der aeusseren Klasse geheftet (nur wenn Aeussere Klasse nicht abstract):
		Lampe lampe1 = new Lampe();
		Gluehbirne birne4 = new Gluehbirne();
	}
	
	
}
