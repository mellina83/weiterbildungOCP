package aufgabeAdapter_Loesung;

import java.util.ArrayList;

//Die Engine darf nicht veraendert werden
public class WorkflowEngine {

	ArrayList<WorkflowObjekt> workflowObjekte;
	
	public WorkflowEngine() {
		workflowObjekte = new ArrayList<>();		
	}

	public void addWorkflowObjekt(WorkflowObjekt workflowObjekt) {
		workflowObjekte.add(workflowObjekt);
	}
	
	public WorkflowErgebnis alleWorkflowsAusfuehren() {
		for(WorkflowObjekt workflowObjekt: workflowObjekte) {
			System.out.println("Objekttyp: " + workflowObjekt.getClass().getSimpleName());
			WorkflowErgebnis ergebnis = workflowObjekt.ausfuehren();
			if(!ergebnis.isWarErfolgreich()) {
				return ergebnis;
			}
		}
		WorkflowErgebnis gesamtErgebnis = new WorkflowErgebnis("engine");
		gesamtErgebnis.setWarErfolgreich(true);
		return gesamtErgebnis;
	}
	
	
}
