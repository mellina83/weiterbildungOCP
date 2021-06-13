package pattern.decorator;

public class AddonArchivierung extends VertragAddon{

	public AddonArchivierung(Vertrag vertrag) {
		super(vertrag);
	}

	public void archivieren() {
		System.out.println("Vertrag archiviert");
	}
}
