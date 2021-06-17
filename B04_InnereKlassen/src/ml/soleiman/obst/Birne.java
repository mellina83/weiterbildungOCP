package ml.soleiman.obst;

public class Birne implements Obst{

	int obstmenge;

	public Birne(int obstmenge) {
		this.obstmenge = obstmenge;
	}
	
	@Override
	public int getAnzahl() {
		return obstmenge;
	}
}
