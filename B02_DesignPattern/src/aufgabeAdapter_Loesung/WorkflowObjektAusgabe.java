package aufgabeAdapter_Loesung;

public class WorkflowObjektAusgabe extends WorkflowObjekt {

	private String ausgabeText;
		
	public WorkflowObjektAusgabe(String objektId, String ausgabeText) {
		super(objektId);
		this.setAusgabeText(ausgabeText);
	}

	public String getAusgabeText() {
		return ausgabeText;
	}

	public void setAusgabeText(String ausgabeText) {
		this.ausgabeText = ausgabeText;
	}
	
	@Override
	public WorkflowErgebnis ausfuehren() {
		WorkflowErgebnis ergebnis = new WorkflowErgebnis(this.getObjektId());
		try {
			System.out.println(this.getAusgabeText());
			return super.ausfuehren();
		}catch(Exception e) {
			ergebnis.setWarErfolgreich(false);
			ergebnis.setFehlermeldung(e.getMessage());
			return ergebnis;
		}		
	}
	


	
	
}
