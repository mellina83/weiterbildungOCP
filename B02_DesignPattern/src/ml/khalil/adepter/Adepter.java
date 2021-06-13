package ml.khalil.adepter;

public class Adepter extends WorkflowObjekt {
	WorkflowObjektAusgabeGross g;

	public Adepter(String objektId) {
		super(objektId);

	}

	public WorkflowErgebnis ausfuehren() {
		WorkflowErgebnis ergebnis = new WorkflowErgebnis(this.getObjektId());
		g.starten();
		super.ausfuehren();
		return ergebnis;
	}

}
