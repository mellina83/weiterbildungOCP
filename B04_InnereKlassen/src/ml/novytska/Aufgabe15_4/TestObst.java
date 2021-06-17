package ml.novytska.Aufgabe15_4;

public class TestObst {
	
	static String obstname;
	static int anzahl;

	public static void main(String[] args) {
		
		Obst obst1 = new Apfel (9);
		Obst.Obstmengenausgabe.print (obst1);
		Obst obst2 = new Birne (7);
		Obst.Obstmengenausgabe.print (obst2);
		}
		
	

}
