package ml.soleiman;

import java.util.Scanner;

enum Kaffeeautomat {
	KAFFEE(1.), CAPPUCCINO(1.1), ESPRESSO(1.13), TEE(0.79);

	private double preis;

	Kaffeeautomat(double preis) {
		this.preis = preis;
	}

	public static void main(String[] args) {

		/*************** Preisliste anzeigen ************/
		System.out.println(Kaffeeautomat.preisliste());

		/*************** Auswahl erfragen ************/
		Scanner sc1 = new Scanner(System.in);
		Kaffeeautomat auswahl;
		whileLoop: while (true) {
			System.out.println("Bitte eine Kaffesorte auswählen: ");
			int eingabe1 = sc1.nextInt();
			switch (eingabe1) {
			case 1:
				auswahl = KAFFEE;
				break whileLoop;
			case 2:
				auswahl = CAPPUCCINO;
				break whileLoop;
			case 3:
				auswahl = ESPRESSO;
				break whileLoop;
			case 4:
				auswahl = TEE;
				break whileLoop;
			default:
				System.err.println("Falsche Eingabe, bitte 1, 2 oder 3 eingeben!");
			}
		}
		/*************** Geld einwerfen ************/
		double rest = auswahl.preis;
		double eingabe2 = 0.0;
		System.out.println("Bitte " + auswahl.preisPrint() + " einwerfen");
		while (true) {
			System.out.println("Restbetrag: " + (rest = Math.abs(runden€(rest))) + " €");
			eingabe2 = sc1.nextDouble();

			/*************** Pruefen ob ein gültige Münze eingeworfen wurde ************/
			int i = 1;
			for (Kleingeld k1 : Kleingeld.values()) {
				if (k1.wert == eingabe2) {
					break;
				}
				if (i == Kleingeld.values().length) {
					System.err.println("Falschgeld!");
					eingabe2 = 0;
					break;
				}
				i++;
			}
			/*************** Pruefen ob genug Geld eingeworfen wurde ************/
			rest -= eingabe2;
			if (rest > 0) { // zu wenig Geld eingeworfen
				continue;
			} else if (rest == 0) { // passend eingeworfen
				System.out.println("Vielen Dank, genießen Sie Ihren " + auswahl.name());
				break;
			} else { // zu viel eingeworfen
				/*************** Wechselgeld ausgeben ************/
				System.out.println("Bitte Wechselgeld raus nehmen! " + (rest = Math.abs(runden€(rest))) + " €");
				Kleingeld[] k1 = Kleingeld.values();
				whileLoop3: while (true) {

					forLoop: for (int n = 0; n < k1.length; n++) {
						if (rest - k1[n].wert == 0) {
							System.out.println(" 1x " + (int) (k1[n].wert * 100) + " Cent");
							break whileLoop3;
						} else if (rest - k1[n].wert < 0)
							continue forLoop;
						else {
							System.out.println(" 1x " + ((int) (k1[n].wert * 100) >= 100 ? ((int) (k1[n].wert) + " €")
									: ((int) (k1[n].wert * 100) + " Cent")));
							if (rest - k1[n].wert == 0) {
								System.out.println("Vielen Dank, genießen Sie Ihren " + auswahl.name());
								break whileLoop3;
							}
							rest -= k1[n].wert;
							rest = runden€(rest);
							n--;
							continue forLoop;
						}

					}
				}
				System.out.println("\nVielen Dank und genießen Sie Ihren " + auswahl.name());
				break;
			}
		}
	}

	public String preisPrint() {
		String str = "";
		str = (this.preis + "").replace('.', ',');
		if (str.length() - str.indexOf(',') == 2) {
			str += "0";
		}
		str += " €";
		return str;
	}

	static public String preisliste() {
		String str = "";
		str += "Preisliste: \n";
		str += "(1) " + KAFFEE.name() + "	Preis " + KAFFEE.preisPrint() + "\n";
		str += "(2) " + CAPPUCCINO.name() + "	Preis " + CAPPUCCINO.preisPrint() + "\n";
		str += "(3) " + ESPRESSO.name() + "	Preis " + ESPRESSO.preisPrint() + "\n";
		str += "(4) " + TEE.name() + "		Preis " + TEE.preisPrint() + "\n";
		return str;
	}

	public static double runden€(double zahl) {
		zahl = Math.abs(zahl);
		zahl *= 100.0;
		zahl += 0.005;
		zahl = (int) zahl;
		zahl /= 100.0;
		return zahl;
	}

	enum Kleingeld {

		ZWEIEURO(2.0), EINEURO(1.0), FUENFZIGCENT(0.5), ZWANZIGCENT(0.2), ZEHNCENT(0.1), FUENFCENT(0.05),
		ZWEICENT(0.02), EINCENT(0.01),;

		double wert;

		Kleingeld(double wert) {
			this.wert = wert;
		}
	}
}