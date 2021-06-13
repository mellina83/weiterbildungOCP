package aufgabe_MeineLoesung;

import java.util.Scanner;

public class KaffeAutomatTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Folgende Getraenke stehen zur Auswahl:");
		KaffeeAutomat.preislisteAnzeigen();

		System.out.println("Welche Nummer wuenschen Sie?");
		int eingabe = sc.nextInt();
		double preis = auswahl(eingabe);
		zahlung(preis);
		
		sc.close();

	} // Ende Main

	public static double auswahl(int eingabe) {
		
		//While(mit booleschen Variablen) vorher, damit man richtige Eingabe macht.
		//default: System.err.println("Falsche Eingabe")
		
		double preis = 0;
		switch (eingabe) {
		case 1:
			System.out.println("Bitte bezahlen Sie: " + KaffeeAutomat.KAFFEE.getPreis() + " Euro.");
			preis = KaffeeAutomat.KAFFEE.getPreis();
			break;
		case 2:
			System.out.println("Bitte bezahlen Sie: " + KaffeeAutomat.CAPUCCINO.getPreis() + " Euro.");
			preis = KaffeeAutomat.CAPUCCINO.getPreis();
			break;
		case 3:
			System.out.println("Bitte bezahlen Sie: " + KaffeeAutomat.ESPRESSO.getPreis() + " Euro.");
			preis = KaffeeAutomat.ESPRESSO.getPreis();
			break;
		}
		return preis;
	} // Ende auswahl

	public static void zahlung(double preis) {

		double restbetrag = preis;
		Scanner sc = new Scanner(System.in);
		
		tom:
		while (restbetrag > 0) {
			System.out.println("Restbetrag: " + restbetrag + " Euro.");
			System.out.println("Bitte werfen Sie eine der folgenden Muenzen ein: ");
			Muenze.alleMuenzenAnzeigen();
			String eingabe = sc.next();
			Muenze muenze = Muenze.valueOf(eingabe);
			restbetrag = restbetrag - muenze.getMuenzBetrag();
			
			if (restbetrag == 0) {
				System.out.println("Der Betrag ist voll bezahlt. Sie erhalten jetzt Ihr Getraenk.");
				break tom;
			} else if (restbetrag < 0) {
				System.out.println("Der Betrag ist bezahlt und Sie erhalten " + (muenze.getMuenzBetrag() - restbetrag) + " Euro zurueck. Sie erhalten jetzt Ihr Getraenk.");
				break tom;
			}
			
		}

	} // Ende Zahlung

	public static Muenze muenzeinwurf(Muenze muenzauswahl) {
		
		Muenze muenzeGewaehlt = null;

		switch (muenzauswahl) {
		case ZWEIEURO:
			System.out.println("Eingeworfen: " + Muenze.ZWEIEURO + " Euro.");
			return Muenze.ZWEIEURO;
		case EINEURO:
			System.out.println("Eingeworfen: " + Muenze.EINEURO + " Euro.");
			return Muenze.EINEURO;
		case FUENFZIGCENT:
			System.out.println("Eingeworfen: " + Muenze.FUENFZIGCENT + " Euro.");
			return Muenze.FUENFZIGCENT;
		case ZWANZIGCENT:
			System.out.println("Eingeworfen: " + Muenze.ZWANZIGCENT + " Euro.");
			return Muenze.ZWANZIGCENT;
		case ZEHNCENT:
			System.out.println("Eingeworfen: " + Muenze.ZEHNCENT + " Euro.");
			return Muenze.ZEHNCENT;
		case FUENFCENT:
			System.out.println("Eingeworfen: " + Muenze.FUENFCENT + " Euro.");
			return Muenze.FUENFCENT;
		}
		
		return null;
	} // Ende muenzeinwurf

}// Ende Klasse


	

		
		
