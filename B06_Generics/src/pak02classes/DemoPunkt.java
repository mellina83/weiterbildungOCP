package pak02classes;

import java.util.List;

public class DemoPunkt {
	public static void main(String[] args) {
//		demoNonGeneric();
//		demoGen01();
//		demoGen02();
		demoGen03();
		
	
	}

	private static void demoGen03() {
		PunktGen<Integer> intPunkt = new PunktGen<Integer>(1, 2);
		PunktGen<Double> doublePunkt = new PunktGen<Double>(1.0, 2.0);
		
		Integer i1 = intPunkt.getX();
//		Double d1 = (Double)intPunkt.getX();
		Double d1 = doublePunkt.getX();
		
		System.out.println("Integer: " + intPunkt);
		System.out.println("Double: " + doublePunkt);
	}

	private static void demoGen02() {
//		PunktGen<String> pg1 = new PunktGen<>("Hallo", 100);
		PunktGen<String> pg1 = new PunktGen<>("Hallo", "Welt");
		
		String tmp = pg1.getX();
		System.out.println(tmp);
		System.out.println(pg1);
	}

	private static void demoGen01() {
		PunktGen<Integer> pg1;
		//Risiko ClassCastException
		//Raw Type
//		PunktGen is a raw type. References to generic type PunktGen<T> should be parameterized
		PunktGen pg2 = new PunktGen<>("Hallo", 100);
		//Das ist kein raw type
		PunktGen<Object> pg3;
		
	}

	private static void demoNonGeneric() {
		Punkt p1 = new Punkt(10, 20);
		Punkt p2 = new Punkt(10.5, 20.5);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("------------------------");
		Punkt p3 = new Punkt(1.5);
		System.out.println(p3.num.getClass().getSimpleName());
		System.out.println(p3);
		Punkt p4 = new Punkt(10L);
		System.out.println(p4.num.getClass().getSimpleName());
		System.out.println(p4);
		
		//ClassCastException
//		Integer i1 = (Integer)p3.num;
		
	}
}
