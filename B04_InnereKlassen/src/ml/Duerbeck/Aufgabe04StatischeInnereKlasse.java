package ml.Duerbeck;

//Habe ein Attribut fuer Obstname genommen. Besser waere getClass.getSimpleName in einer default Methode des Interfaces.
//Siehe Loesung von Hanif Soleiman

public class Aufgabe04StatischeInnereKlasse {

	public static void main(String[] args) {
		
		Obst obst1 = new Apfel(9);
		Obst.Obstmengenausgabe.print(obst1);
		Obst obst2 = new Birne(7);
		Obst.Obstmengenausgabe.print(obst2);
	}
}

interface Obst {
		
	String getObstname();
	int getAnzahl();
	
	static class Obstmengenausgabe {
		
		static void print (Obst obst){
			System.out.println(obst.getObstname() + ": " + obst.getAnzahl() + " Stueck");
		}
	}
	
}

class Apfel implements Obst {
	int anzahl;
	final static String obstname = "Apfel";
	
	Apfel(int anzahl){
		this.setAnzahl(anzahl);
	}
	
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public String getObstname() {
		return obstname;
	}

	@Override
	public int getAnzahl() {
		return anzahl;
	}
}

class Birne implements Obst {
	int anzahl;
	final static String obstname = "Birne";
	
	Birne(int anzahl){
		this.setAnzahl(anzahl);
	}
	
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	@Override
	public String getObstname() {
		return obstname;
	}

	@Override
	public int getAnzahl() {
		return anzahl;
	}
}
