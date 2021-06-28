package aufgaben.a02.loesung;

public class Artikel {

	private double preis;
	private String name;
	
	public double getPreis() {
		return preis;
	}

	public String getName() {
		return name;
	}

	public Artikel(double preis, String name){
		this.preis = preis;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return preis + " " + name ;
	}
}

