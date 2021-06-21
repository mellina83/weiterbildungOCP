package ml.Duerbeck;

interface StringProcessor {
	void process(String s);
}

//Interface fuer 4. Moeglichkeit (unbestimmtes Obj) erstellt
interface MethodenreferenzProcessor{
	void process(MethodenreferenzTest mr);
}

interface MethodenreferenzProcessor2 {
	void process(MethodenreferenzTest mr, String s);
}

public class MethodenreferenzTest {
	
	static String s1 = "Hallo Welt!";
	static String s2 = "Wir arbeiten mit Methoden Referenzen";
	static String s3 = "Java ist auch eine Insel";
	
	public static void main(String[] args) {
		
		//Lambdas
		StringProcessor stripro = s -> System.out.println(s);
		stripro.process(s1);
		
		StringProcessor striproLC = s -> System.out.println(s.toLowerCase());
		striproLC.process(s2);
		
		
		//Methodenref
		//1. Konstruktor nicht moeglich, da Rueckgabetyp anders als void vorhanden sein muesste
		
		//2. Statische
		StringProcessor striproMF = MethodenreferenzTest::printStatic;
		striproMF.process(s3);
		makeOutput(MethodenreferenzTest::printStatic, s1);
		
		//3. Instanzmethode bestimmtes Objekt
		MethodenreferenzTest methrefObj = new MethodenreferenzTest();
		makeOutput2(methrefObj::printNonStatic);
		makeOutput2(new MethodenreferenzTest()::printNonStatic);
		
		//4. Instanzmethode unbestimmtes Objekt
		MethodenreferenzProcessor mrp = MethodenreferenzTest::printIntance;
		mrp.process(methrefObj);
		MethodenreferenzProcessor2 mrp2 = MethodenreferenzTest::printIntance2;
		mrp2.process(methrefObj, s1);
		
		//0. Methodenref auf Sysout println
		makeOutput2(System.out::println);
	}
	
	public void printIntance() {
		System.out.println(s1);
	}
	public void printIntance2(String s) {
		System.out.println(s);
	}
	
	public void printNonStatic(String s) {
		System.out.println(s);
	}
	
	public static void printStatic(String s) {
		System.out.println(s);
	}
	
	public static void makeOutput(StringProcessor sp, String s) {
		sp.process(s);
	}
	
	public static void makeOutput2(StringProcessor s) {
		s.process(s1);
	}

}
