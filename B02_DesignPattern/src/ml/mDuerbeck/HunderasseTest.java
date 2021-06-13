package ml.mDuerbeck;

public class HunderasseTest {
	
	public static void main(String[] args) {
		
		Hunderasse.zeigeKonstanten();
		
	}
	
} // Ende HunderasseTest


enum Hunderasse {
	DACKEL(0.5), COLLIE(1.0), DOGGE(1.5);
	
	private final double maxGroesse;
	
	private Hunderasse(double maxGroesse){
		this.maxGroesse = maxGroesse;
	}
	
	public double getMaxGroesse() {
		return maxGroesse;
	}
	
	public static void zeigeKonstanten() {
		
		System.out.println("Es gibt folgende Hunderassen, bis zu einer Maximalgroesse von:");
		
		for (int i = 0; i < Hunderasse.values().length; i ++) {
			System.out.println(Hunderasse.values()[i] + ", max. Groesse: " + Hunderasse.values()[i].maxGroesse);
		}
		
	}
} // Ende ENUM Hunderasse
