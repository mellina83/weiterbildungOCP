package ml.novytska.Aufgabe15_4;

public interface Obst {

	String getObstname();

	int getAnzahl();	
	

	static public class Obstmengenausgabe {
		static void print(Obst obst) {
			System.out.println("Menge " + obst.getObstname() + ": " + obst.getAnzahl());
		}

	}
}
