package ml.soleiman.obst;

public class Apfel implements Obst {

	int obstmenge;

	public Apfel(int obstmenge) {
		this.obstmenge = obstmenge;
	}

	@Override
	public int getAnzahl() {
		return obstmenge;
	}
}
