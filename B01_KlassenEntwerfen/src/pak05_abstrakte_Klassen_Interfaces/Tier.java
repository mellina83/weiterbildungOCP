package pak05_abstrakte_Klassen_Interfaces;

public abstract class Tier extends Object {
		
	abstract String machLaut();
	
	public void essen(IFressbar g) {
		g.wirdgegessen();
	}
}
class Hund extends Tier{
	@Override
	String machLaut() {		
		return "Wuff";
	}
	
}
class Katze extends Tier{
	@Override
	String machLaut() {
		return "miau";
	}
	
}
class Schwein extends Tier{

	@Override
	String machLaut() {
		return "oink";
	}
	
}

class Stein implements IFressbar{

	@Override
	public void wirdgegessen() {
		System.out.println(this.getClass().getSimpleName() + " wird gegessen");
		
	}
	
}

class Gemuese implements IFressbar{

	@Override
	public void wirdgegessen() {
		System.out.println(this.getClass().getSimpleName() + " wird gegessen");
		
	}
	
}

class Moehre extends Gemuese{
	
}
class Kartoffel extends Gemuese{
	
}
interface IFressbar{
	void wirdgegessen();
}

