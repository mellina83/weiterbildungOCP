package pak02classes.bauernhof;

public abstract class AAnimal {
	private String name;
	private int alter;
	
	public AAnimal() {
		this("Hugo", 42);
	}
	public AAnimal(String name, int alter) {
		this.setName(name);
		this.setAlter(alter);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "AAnimal [name=" + name + ", alter=" + alter + "]";
	}
	
	public abstract void laufen();
	
}
