package ml.Duerbeck;

interface StringProcessor {
	void process(String s);
}

public class MethodenreferenzTest {
	
	String s1 = "Hallo Welt!";
	String s2 = "Wir arbeiten mit Methoden Referenzen";
	String s3 = "Java ist auch eine Insel";
	
	public static void main(String[] args) {
		
		StringProcessor stripro = s -> System.out.println(s);
		stripro.s1;

	}

}
