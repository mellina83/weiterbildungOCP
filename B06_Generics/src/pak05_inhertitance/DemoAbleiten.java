package pak05_inhertitance;

public class DemoAbleiten {
	public static void main(String[] args) {
		//Generische Oberklasse
		GenKlasseA<Double> refA = new GenKlasseA<>();
		refA.methodA(1.5);
		
		//1. GenSubKlasseB<T> extends GenKlasseA<T>
		GenKlasseA<Number> refAb = new GenSubKlasseB<>();
		refA.methodA(1.5);
		
		((GenSubKlasseB<Number>)refAb).methodB(1.5);
		
		GenSubKlasseB<Double> refB = new GenSubKlasseB<Double>();
		refB.methodA(1.5);
		refB.methodB(1.5);
		
		System.out.println("-----------------------");
		//Die Klasse GenKlasseA wird mit Integer vorparametrisiert
		//2. GenSubKlasseC<T> extends GenKlasseA<Integer>
		GenSubKlasseC<Integer> refC_I = new GenSubKlasseC<>();
		refC_I.methodA(1);
		refC_I.methodC(1);
		
//		GenSubKlasseC<Double> extends GenKlasseA<Integer>
		GenSubKlasseC<Double> refC_II = new GenSubKlasseC<>();
		refC_II.methodC(1.5);//Double		
		refC_II.methodA(1);//Integer
		
		GenKlasseA<Integer> refC_III = new GenSubKlasseC<>();
		refC_III.methodA(1);
		((GenSubKlasseC<Double>)refC_III).methodC(1.5);
		((GenSubKlasseC<Integer>)refC_III).methodC(5);
		((GenSubKlasseC<String>)refC_III).methodC("5");
		
		//3. GenSubKlasseD<T> extends EinfacheKlasseA
		GenSubKlasseD<Double> refD_I = new GenSubKlasseD<Double>();
		refD_I.methodD(1.5);
		
		//Keine richtige Typsicherheit im Sinne der Generics
		EinfacheKlasseA refD_II = new GenSubKlasseD<Double>();
		((GenSubKlasseD<String>) refD_II).methodD("5 als String");
		
		
		//4. EinfacheKlasseB extends GenKlasseA<Integer>
		EinfacheKlasseB refBA_I = new EinfacheKlasseB();
		refBA_I.methodA(1);
		
		GenKlasseA<Integer> refBA_II = new EinfacheKlasseB();
		refBA_II.methodA(1);
		
		//5. GenSubSubKlasseB<T,Z> extends GenSubKlasseB<T>
		GenSubSubKlasseB<String, Integer> refgsskB_I = new GenSubSubKlasseB<>();
		refgsskB_I.methodA("");
		refgsskB_I.methodB("");
	}
}
