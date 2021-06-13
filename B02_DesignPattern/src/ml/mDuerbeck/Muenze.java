package ml.mDuerbeck;

public enum Muenze {

	EINEURO(1.00), ZWEIEURO(2.00), FUENFZIGCENT(0.50), ZWANZIGCENT(0.20), ZEHNCENT(0.10), FUENFCENT(0.05);

	private double muenzBetrag;

	public double getMuenzBetrag() {
		return muenzBetrag;
	}

	private Muenze(double muenzBetrag) {
		this.muenzBetrag = muenzBetrag;
	}
	
	public static void alleMuenzenAnzeigen() {
		for (int i = 0; i < Muenze.values().length; i++) {
			System.out.println(Muenze.values()[i]);
		}
		System.out.println();
	}

}
