package ml.Duerbeck.basics;

interface DoStuff {
	void doStuff();
}

class Schwein {
	String name;
	
	Schwein(String name){
		this.name = name;
	}
	
	void laufen() {
		System.out.println(this.name + " laeuft");
	}
}

public class F03_Methodenref_bestimmtesObjekt {

	public static void main(String[] args) {
		
		Schwein pig1 = new Schwein("Piggy");
		
		DoStuff ds = pig1::laufen;
		ds.doStuff();

	}

}
