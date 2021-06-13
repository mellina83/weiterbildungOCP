package aufgabe_MeineLoesung;

import java.text.MessageFormat;

public enum KaffeeAutomat {
	KAFFEE(1), CAPUCCINO(1.20), ESPRESSO(1.13);

	private KaffeeAutomat(double preis) {
		this.preis = preis;
	}

	private double preis;
	private static double restbetrag;

	public double getPreis() {
		return preis;
	}

	public double getRestbetrag() {
		return restbetrag;
	}

	public static void preislisteAnzeigen() {

		for (int i = 0; i < KaffeeAutomat.values().length; i++) {
			System.out.print(MessageFormat.format("Nr. {0} - {1}: {2} Euro", (i + 1), KaffeeAutomat.values()[i],
					KaffeeAutomat.values()[i].getPreis()));
			System.out.println();
		}
		System.out.println();
	}

}
