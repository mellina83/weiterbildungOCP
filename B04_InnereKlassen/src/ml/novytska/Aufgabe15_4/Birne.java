package ml.novytska.Aufgabe15_4;

public class Birne implements Obst{
	
	String obstname = "Birne";
	int anzahl;

	Birne(int anzahl) {
		this.anzahl = anzahl;
	}
	public String getObstname(){
		return obstname;
		
	}
	public int getAnzahl(){
		return anzahl;
		
	}	

}
