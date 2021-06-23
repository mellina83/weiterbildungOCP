package pak04_typeInference;

public class DemoTypeInference {
	/**
	 * < Generischen Typangabe > <- angle Brackets
	 *
	 * <> <- Diamond Operator
	 * 
	 * <?> <- Wildcard Operator, nur für Variablen deklaration
	 * 
	 * Typ-Inferenz bezeichnet die Arbeitsweise des Diamond Operator. Der Diamond
	 * Operator leitet den Generischen Datentyp von der Referenzseite ab
	 * 
	 * "Inferenz = in der Informatik vor allem aus einem formalen System
	 * automatisiert erstellte Folgerung " (Wiktionary)
	 */
	public static void main(String[] args) {
		demoCasting03();
	}
	public static void inferenz(){
		//Kompiliert, auf beiden Seiten der selbe Typ
		PunktGen<Number> punktNum01 = new PunktGen<Number>();
		
		//Kompiliert nicht, unterschiedliche generische Typen
//		PunktGen<Number> punktNum02 = new PunktGen<Float>();
		
		//Diamont Operator, auf der Instanzseite koennen wir den
		//generischen Typ weglassen, dieser wird von der Referenz abgeleitet
		PunktGen<Number> punktNum02 = new PunktGen<>();
		
		//Kompiliert nicht, die Inferenz muss auf der Instanzseite
//		passieren.
//		PunktGen<> punktNum03 = new PunktGen<Number>();
	}
	
	/*
	 * Wenn die Referenz mit einem Generic versehen ist, koennen wir beim Casting
	 * keinen anderen, auch keinen Subtyp als generischen Typ werwenden.
	 */
	public static void demoCasting01() {
		PunktGen<Number> punkt;
		
//		punkt = new PunktGen<>("5", "5");
//		System.out.println(punkt.getX());//String
//		System.out.println(punkt.getY());//String
		
		//Type mismatch: cannot convert from PunktGen<Integer> to PunktGen<String>
		punkt = new PunktGen<Number>(5,5);
		
		//Type mismatch: cannot convert from PunktGen<Integer> to PunktGen<String>
//		System.out.println(((PunktGen<Integer>)punkt).getX());
		
	}
	public static void demoCasting02() {
		class A{}
		class B extends A{}
		
		PunktGen<A> punkt_A;
		
		punkt_A = new PunktGen<A>();
		//Type mismatch: cannot convert from PunktGen<B> to PunktGen<A>
//		punkt_A = new PunktGen<B>();
		
//		Type mismatch: cannot convert from PunktGen<Object> to PunktGen<A>
//		punkt_A = new PunktGen<Object>();
	}
	public static void demoCasting03() {
		PunktGen<?> punkt;
		
		punkt = new PunktGen<String>("5", "5");
		String tmp = (String)punkt.getX();
		
		punkt = new PunktGen<Integer>(5,5);
		
		//ClassCastException zur Laufzeit
		System.out.println(((PunktGen<String>)punkt).getX());

	}
	/*
	 * ? unbound bzw Wildcard nur fuer die Referenzseite
	 */
	public static void demoUnbound() {
		PunktGen<?> punkt;
//		punkt = new PunktGen<?>();
		
		punkt = new PunktGen<Integer>(5,5);
		punkt = new PunktGen<Float>(5F,5F);
		punkt = new PunktGen<String>("5","5");
	}
}












