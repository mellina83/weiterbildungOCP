package ml.novytska.HA1406.checked;



public class TestKonto {

	static Konto k1;
	static Konto k2;

	public static void main(String[] args) {
		k1 = new Konto(500);
		k2 = new Konto(100);

		System.out.println("k1 = " + k1);
		System.out.println("k2 = " + k2);
		System.out.println("Kunde 1 holt Geld ab");

		try {
			k1.geldAbheben(480);
			System.out.println("k1 = " + k1.getSaldo());
		} catch (NegativeSaldoExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Kunde 1 holt Geld ab");
		try {
			k1.geldAbheben(500);
			System.out.println("k1 = " + k1.getSaldo());
		} catch (NegativeSaldoExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		System.out.println("----------------------");
		
		System.out.println("Kunde 2 holt Geld ab");

		try {
			k2.geldAbheben(500);
			System.out.println("Kunde 2 hat Geld abgeholt");
			System.out.println("k2 = " + k2.getSaldo());
		} catch (NegativeSaldoExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
