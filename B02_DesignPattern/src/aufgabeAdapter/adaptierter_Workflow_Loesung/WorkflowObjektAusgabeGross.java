package aufgabeAdapter.adaptierter_Workflow_Loesung;

//Diese Klasse darf auch nicht veraendert werden
public class WorkflowObjektAusgabeGross {

	private String ausgabeText;
	
	public WorkflowObjektAusgabeGross(String ausgabeText) {
		this.setAusgabeText(ausgabeText);
	}

	public String getAusgabeText() {
		return ausgabeText;
	}

	public void setAusgabeText(String ausgabeText) {
		this.ausgabeText = ausgabeText;
	}

	public WorkflowErgebnisB starten() {
		System.out.println(this.getAusgabeText().toUpperCase());
		WorkflowErgebnisB ergebnis = new WorkflowErgebnisB();
		ergebnis.setErgebnis(1);
		return ergebnis;
	}
	
}
