package ml.soleiman;

enum Hunderasse {

	DACKEL(0.5), COLLIE(1.0), DOGGE(1.5);

	private double maxGroesse;

	Hunderasse(double maxGroesse) {
		this.maxGroesse = maxGroesse;
	}

	public double getMaxGroesse() {
		return this.maxGroesse;
	}

	public String toString() {
		return this.name() + ", max. Größe: " + this.getMaxGroesse() ; //Dackel, max. Größe: 0.5
	}
	
	public static void main(String[] args) {

		for (Hunderasse h1 : Hunderasse.values()) {
			System.out.println(h1.toString());
		}
	}
}
