package ml.khalil.StatischeInnereKlasse;

public interface Obst {
public String getObstname();
public int getAnzahl();
static class Obstmengenausgabe{
static	void print (Obst obst){System.out.println("Name: "+obst.getObstname()+" Zahl: "+ obst.getAnzahl());}
}
}
class Apfel implements Obst{
int zahl;
Apfel(int zahl){this.zahl=zahl;}

	@Override
	public String getObstname() {
		
		return "Apfel";
	}

	@Override
	public int getAnzahl() {
		
		return this.zahl;
	}
	
}
class Birne implements Obst{
int zahl;
Birne(int zahl){this.zahl=zahl;}

	@Override
	public String getObstname() {
		
		return "Birne";
	}

	@Override
	public int getAnzahl() {
		
		return this.zahl;
	}
	
}
