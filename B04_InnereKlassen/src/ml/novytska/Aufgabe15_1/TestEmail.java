package ml.novytska.Aufgabe15_1;

public class TestEmail {

	public static void main(String[] args) {
		Email e1 = new Email ("Klaus.Gross*","Lotte.Klein@gmz.de",
				"Hallo","Hallo Welt");
				e1.senden();
				Email e2 = new Email ("Klaus.Gross*","Lotte.Kleingmz.de",
				"Hallo","Hallo Welt");
				e2.senden();
				}
				

	

}
