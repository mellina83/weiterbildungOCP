package ml.Duerbeck.basics;

// beides zusammen (unbestimmtes und bestimmtes Objekt)

//interface fuer unbestimmtes Objekt
interface Apfelentkerner {
	void entkernen(Apfel apfel, int kerne);
}

//interface fuer bestimmtes Objekt
interface Apfelentkerner2 {
	void entkernen2(int kerne);
}

class Apfel {
	int kerne;
	
	Apfel(int kerne){
		this.kerne = kerne;
	}
	
	void entferneKerne(int kerne) {
		this.kerne -= kerne;
		System.out.println("Kerne uebrig: " + this.kerne);
	}
}

public class F04_Methodenref_unbestimmtesObj {

	public static void main(String[] args) {
		Apfel a1 = new Apfel(200);
		
		//Ref auf bestimmtes Objekt
		Apfelentkerner2 ak2 = a1::entferneKerne;
		ak2.entkernen2(100);
		
		//Ref auf unbestimmtes Objekt
		Apfelentkerner ak = Apfel::entferneKerne;
		ak.entkernen(a1, 100);
	}
}
