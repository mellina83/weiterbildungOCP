package ml.novytska.HA0906;

public class Hunderasse {
	enum Hunderassen {
		DACKEL(0.5), COLLIE(1.0), DOGGE(1.5);

		double maxGroesse = 0;

		Hunderassen(double d) {
			maxGroesse = d;
			// TODO Auto-generated constructor stub
		}

		public double getMaxGroesse() {
			return maxGroesse;
		}

	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("+++++++++ENUM Hunderassen+++++++++++");
		for(Hunderassen h: Hunderassen.values()) {
			System.out.println(h+" "+h.getMaxGroesse());
		}
	}

}
