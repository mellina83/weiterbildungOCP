package aufgabe_MeineLoesung;

//Ich dachte, es haette mit enums gemacht werden muessen.
//Feedback war gut vom Dozenten, die Parameter bei den enums haette ich mir aber sparen koennen, wegen getName Methode
//Beste Loesung s. Hanif Soleiman

import java.util.Scanner;

public class Rot13VerschluesselungTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welche Buchstabenfolge soll (de-)codiert werden?");
		String eingabeStr = sc.next();
		eingabeStr = eingabeStr.toUpperCase();
		String ausgabeStr = "";
		int codierArt = auswahlCodierArt();
		
		for (int i = 0; i < eingabeStr.length(); i++) {
			String eingabeLetter = String.valueOf(eingabeStr.charAt(i));
		
			if (codierArt == 1) {
				for (int j = 0; j < Rot13A.values().length; j++) {
					if (eingabeLetter.equals(Rot13A.values()[j].getLetter())) {
						String neuerBuchstabe = Rot13B.values()[j].getLetter();
						ausgabeStr = ausgabeStr.concat(neuerBuchstabe);
					} 
				} 
			} else if (codierArt == 2) {
				for (int j = 0; j < Rot13B.values().length; j++) {
					if (eingabeLetter.equals(Rot13B.values()[j].getLetter())) {
						String neuerBuchstabe = Rot13A.values()[j].getLetter();
						ausgabeStr = ausgabeStr.concat(neuerBuchstabe);
					} 
				} 
			}

		} // Ende aeussere for
		
		System.out.println("Loesung: " + ausgabeStr);
		
		sc.close();

	} //Ende Main


	private static int auswahlCodierArt() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Waehle aus:");
		System.out.println("(1) Verschluesseln");
		System.out.println("(2) Entschluesseln");
		int eingabeCodierArt;

		doWhileSchleife:
		do {
			eingabeCodierArt = sc.nextInt();	
			switch(eingabeCodierArt) {
			case 1:
				System.out.println("Du moechtest also Code verschluesseln.");
				eingabeCodierArt = 1;
				break doWhileSchleife;
			case 2:
				System.out.println("Du moechtest also Code entschluesseln.");
				eingabeCodierArt = 2;
				break doWhileSchleife;
			default:
				System.err.println("Falsche Auswahl. Bitte waehle 1 oder 2.");
				continue doWhileSchleife;
			} 
		} while (eingabeCodierArt != 1 | eingabeCodierArt != 2);
		return eingabeCodierArt;
	}

}

enum Rot13A {
	A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G"), H("H"), I("I"), J("J"), K("K"), L("L"), M("M"), N("N"), O("O"), P("P"), Q("Q"), R("R"), S("S"), T("T"), U("U"), V("V"), W("W"), X("X"), Y("Y"), Z("Z");
	
	private String letter;
	
	public String getLetter() {
		return letter;
	}

	Rot13A(String letter) {
		this.letter = letter;
	}
}

enum Rot13B {
	N("N"), O("O"), P("P"), Q("Q"), R("R"), S("S"), T("T"), U("U"), V("V"), W("W"), X("X"), Y("Y"), Z("Z"), A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G"), H("H"), I("I"), J("J"), K("K"), L("L"), M("M");
	
	private String letter;
	
	public String getLetter() {
		return letter;
	}
	
	Rot13B(String letter) {
		this.letter = letter;
	}
}
