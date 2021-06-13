package aufgabeAdapter;

import aufgabeAdapter.adaptierter_Workflow.WorkflowObjektAusgabeGross;

public class App {
	
	public static void main(String[] args) {
		WorkflowEngine engine = new WorkflowEngine();
		WorkflowObjektAusgabe a1 = new WorkflowObjektAusgabe("1", "Ausgabe 1");
		WorkflowObjektAusgabe a2 = new WorkflowObjektAusgabe("2", "Ausgabe 2");
		
		engine.addWorkflowObjekt(a1);
		engine.addWorkflowObjekt(a2);
		
		WorkflowErgebnis erg1 = engine.alleWorkflowsAusfuehren();
		
		WorkflowObjektAusgabeGross g1 = new WorkflowObjektAusgabeGross("grosse ausgabe 1");
		//Das soll funktionieren
//		engine.addWorkflowObjekt(g1);
		
		
	}
}
