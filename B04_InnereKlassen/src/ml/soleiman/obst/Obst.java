package ml.soleiman.obst;

public interface Obst {
	
	default public String getObstname() {
		return this.getClass().getSimpleName();
	}
	int getAnzahl();
	
	static class Obstmengenausgabe{
		static void print (Obst obst) {
			System.out.print("Obstsorte: " + obst.getObstname() + " ");
			System.out.println(obst.getAnzahl() + " Stk. ");
		}
	}
}
