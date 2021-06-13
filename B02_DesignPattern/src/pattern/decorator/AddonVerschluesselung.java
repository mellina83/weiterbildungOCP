package pattern.decorator;

public class AddonVerschluesselung extends VertragAddon{

	public AddonVerschluesselung(Vertrag vertrag) {
		super(vertrag);
	}
	
	public void verschluesseln() {
		System.out.println("Vertrag verschluesselt");
	}

}
