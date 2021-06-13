package aufgabeAdapter.adaptierter_Workflow_Loesung;

import aufgabeAdapter.WorkflowErgebnis;
import aufgabeAdapter.WorkflowObjekt;

public class WorkFlowAdapter extends WorkflowObjekt {
	/*
	 * Die Adapterklasse erhaelt eine Referenz auf ein Objekt
	 * der zu Adaptierenden Klasse.
	 */
	private WorkflowObjektAusgabeGross instanz;
	
	
	public WorkFlowAdapter(String objektId, String ausgabeText) {
		super(objektId);
		this.instanz = new WorkflowObjektAusgabeGross(ausgabeText);
	}

	/*
	 * Der Adapter erweitert die Systemklasse und ist kompatibel zum System.
	 * Wenn das System die ausfuehren() Methode aufruft, ruft die ueberschriebene
	 * Adaptermethode das entsprechende Gegenstueck in der inkompatiblen,
	 * zu adaptierenden Klasse auf. Und das ebenfalls inkompatible Ergebnis wird
	 * auf Erfolg gepr�ft und ein entsprechend kompatibles Ergebnis zurueckgegeben.
	 */
	public WorkflowErgebnis ausfuehren() {
		WorkflowErgebnis ergebnis = new WorkflowErgebnis(this.getObjektId());
		WorkflowErgebnisB ergebnisB = this.instanz.starten();
			if(ergebnisB.getErgebnis() >0) {
				ergebnis.setWarErfolgreich(true);
			}else {
				ergebnis.setWarErfolgreich(false);
				ergebnis.setFehlermeldung("n/a");
			}
			if(ergebnis.isWarErfolgreich()) {
				return super.ausfuehren();
			}
		return ergebnis;
	}
	
	
}
