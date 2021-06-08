package pak05_abstrakte_Klassen_Interfaces;

public class App {
	public static void main(String[] args) {
//		Tier t = new Tier();
		Tier t = new Hund();
		Tier t1 = new Katze();
		System.out.println(t.machLaut());
		System.out.println(t1.machLaut());
		
		t.essen(new Moehre());
		t.essen(new Kartoffel());
		t.essen(new Stein());
	}
}
