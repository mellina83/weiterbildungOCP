package ml.szyska;

/*
 * Bitte realisieren Sie 'StringProcessor' so, dass die Anwendung die Strings
 * (Zeile 18, 19 und 20) auf der Konsole ausgibt
 * 
 * Realisieren Sie die Aufgaben mit Lambda Ausdrücken und mit
 * Methoden Referenzen. - Probieren Sie auch hier mehrere Notationen aus.
 * 
 * Bonus: Passen Sie die Ausgaben an z.b. alles in LowerCase oder UpperCase.
 */

interface StringProcessor {
	void process(String s);
}

interface MethodenReferenzenProcessor{
	void process(Aufgabe_02_MethodenReferenz mr);
}

public class Aufgabe_02_MethodenReferenz {

	static String s1 = "Hallo Welt!";
	static String s2 = "Wir arbeiten mit Methoden Referenzen";
	static String s3 = "Java ist auch eine Insel";

	String name = "Ref 1";
	
	public static void main(String[] args) {
		
		System.out.println("-------------------------Lambda-----------------------------");
		demoLambda();
		
		System.out.println("-----------statische Methodenreferenz-----------------");
		makeOutPut(Aufgabe_02_MethodenReferenz::printStatic);
		
		System.out.println("-----------Methodenreferenz auf eine Instanzmethode-----------------");
		Aufgabe_02_MethodenReferenz obj = new Aufgabe_02_MethodenReferenz();
		makeOutPut(obj::printNonStatic);
		makeOutPut(new Aufgabe_02_MethodenReferenz()::printNonStatic);
		
		System.out.println("-----------Methodenreferenz auf System.out::println-----------------");
		makeOutPut(System.out::println);
		StringProcessor sp = System.out::println;
		
		System.out.println("-------------Referenz auf unbestimmtes Objekt eines bestimmten Typs-----------------");
		MethodenReferenzenProcessor mrp = Aufgabe_02_MethodenReferenz::printInstance;
		mrp.process(obj);
	}

	private void printInstance() {
		System.out.println(this.name + " " + s1);
		System.out.println(this.name + " " + s2);
		System.out.println(this.name + " " + s3);
	}
	
	private static void makeOutPut(StringProcessor sp) {
		sp.process(s1);
		sp.process(s2);
		sp.process(s3);
	}

	private static void printStatic(String s) {
		System.out.println(s);
	}
	private void printNonStatic(String s) {
		System.out.println(s);
	}

	private static void demoLambda() {
		StringProcessor sp = s -> System.out.println(s);
		sp.process(s1);
		sp.process(s2);
		sp.process(s3);

		StringProcessor spLC = s -> System.out.println(s.toLowerCase());
		spLC.process(s1);
		spLC.process(s2);
		spLC.process(s3);
		System.out.println("-------------------------------");

		StringProcessor sp02 = s -> {
			System.out.println(s);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
		};

		sp02.process("Hallo Welt");
	}

}
