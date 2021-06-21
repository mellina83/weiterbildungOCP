package pak02classes.bauernhof;

public class Schaf extends AAnimal {

	public Schaf(String name, int alter) {
		super(name, alter);
	}
	
	@Override
	public void laufen() {
		System.out.println(this.getClass().getSimpleName() + " : " + this.getName());
	}

}
