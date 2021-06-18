package ml.Duerbeck.basics;

//Voraussetzungen:
//es muss der entsprechende Typ zurueckgegeben werden
//Konstruktor des Typs muss vorhanden sein

//Welcher Konstruktor genommen wird, entscheidet die Argumentenliste

interface StringCreator {
	String create();
}

interface StringCreatorWithParam {
	String create(String string);

}

public class F01_MethodenreferenzKonstruktor {

	public static void main(String[] args) {
		
		//Realisierung mit Methodenreferenz
		StringCreatorWithParam scwp2 = String::new;
		//								Ref auf Konstruktor von new
		String s3 = scwp2.create("HalloMethodenreferenz");
		
		//Realisierung mit Anonymer Klasse
		StringCreatorWithParam scwp1 = new StringCreatorWithParam() {

			@Override
			public String create(String string) {
				return new String(string);
			}
			
		};
		String s2 = scwp1.create("HalloAnonym");
		
		//Realisierung mit Lambda:
		StringCreatorWithParam scwp = string -> new String();
		String s1 = scwp.create("HalloLambda");

	}

}
