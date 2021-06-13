package ml.khalil.adepter;


public class App {
	
	public static void main(String[] args) {
		WorkflowEngine engine = new WorkflowEngine();
		WorkflowObjektAusgabe a1 = new WorkflowObjektAusgabe("1", "Ausgabe 1");
		WorkflowObjektAusgabe a2 = new WorkflowObjektAusgabe("2", "Ausgabe 2");
		
		engine.addWorkflowObjekt(a1);
		engine.addWorkflowObjekt(a2);
		
		WorkflowErgebnis erg1 = engine.alleWorkflowsAusfuehren();
		Adepter ad =new Adepter("Ausgabe 3");
		WorkflowObjektAusgabeGross g1 = new WorkflowObjektAusgabeGross("grosse ausgabe 1");
		ad.g=g1;
		engine.addWorkflowObjekt(ad);
		WorkflowErgebnis erg2 = engine.alleWorkflowsAusfuehren();
		
		//Das soll funktionieren
//		engine.addWorkflowObjekt(g1);
		
		
	}
}
