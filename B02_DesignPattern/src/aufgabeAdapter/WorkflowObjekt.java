package aufgabeAdapter;

public abstract class WorkflowObjekt {

	private String objektId;
	
	public WorkflowObjekt(String objektId) {
		this.setObjektId(objektId);
	}

	public String getObjektId() {
		return objektId;
	}
	public void setObjektId(String objektId) {
		this.objektId = objektId;
	}

	public WorkflowErgebnis ausfuehren() {
		WorkflowErgebnis ergebnis = new WorkflowErgebnis(this.getObjektId());
		ergebnis.setWarErfolgreich(true);
		return ergebnis;
	}
	
}
