package pak02classes.bauernhof;

public class Schwein extends AAnimal{

	public Schwein(String name, int alter) {
		super(name, alter);
	}
	
	@Override
	public void laufen() {
		System.out.println(this.getClass().getSimpleName() + " : " + this.getName());
	}

}
