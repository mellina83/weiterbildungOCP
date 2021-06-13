package pattern.decorator;

import java.time.LocalDate;

public abstract class VertragAddon extends Vertrag{
	
	/*
	 * Wichtig sind hier drei Dinge:
	 * 
	 * 1.Die Klasse ist abstrakt, da Addon ein abstrakter Begriff ist.
	 * Wir wollen von einem Addon keine Instanz erzeugen, sondern nur
	 * von spezifischen Addons. Z.B fuer Verschluesselung.
	 * 
	 * 2. Unser Dekorierer nimmt ein Objekt entgegen, das zu dekoriende Objekt,
	 * also das Objekt, dessen Funktionen um das Addon erweitert werden soll.
	 * 
	 * 3. An dieses Objekt werden die Methoden freigeben und kuendigen
	 * weiterdelegiert.
	 * 
	 */	
	private Vertrag vertrag;

	public Vertrag getVertrag() {
		return vertrag;
	}

	public void setVertrag(Vertrag vertrag) {
		this.vertrag = vertrag;
	}
	
	public VertragAddon(Vertrag vertrag) {
		this.setVertrag(vertrag);
	}
	
	@Override
	public void freigeben() {
		this.getVertrag().freigeben();
	}
	
	public void kuendigen(LocalDate kuendigungsdatum) {
		this.getVertrag().kuendigen(kuendigungsdatum);
	}
	
}
