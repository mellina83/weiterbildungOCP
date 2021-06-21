package pak02classes.bauernhof;

public class Kuh extends AAnimal{

	
	public Kuh(String name, int alter) {
		super(name, alter);
	}
	
	@Override
	public void laufen() {
		System.out.println(this.getClass().getSimpleName() + " : " + this.getName());
	}

}
