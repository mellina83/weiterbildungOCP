package pak01_functional;

interface MyConsumer01 {
	Integer berechne(Integer i, Integer i1);
}

public class Demo06_b_Statische_Referenzen {
	
	static Integer myCalculatingMethod(Integer i1, Integer i2) {
		System.out.println("myCalculatingMethod");
		return i1 * i2;
	}
	
	static void doStuffWithMyConsumer01(MyConsumer01 mc, Integer i1, Integer i2) {
		Integer ergebnis = mc.berechne(i1, i2);
//		Integer ergebnis = mc.myCalculatingMethod(i1, i2);
		System.out.println("Das Ergebnis der Berechnung ist: " + ergebnis);		
	}
	
	public static void main(String[] args) {
	
		Integer zahl1 = 10;
		Integer zahl2 = 20;
		
		MyConsumer01 mc1 = new MyConsumer01() {			
			@Override
			public Integer berechne(Integer i, Integer i1) {
				return i + i1;
			}
		};
		doStuffWithMyConsumer01(mc1, zahl1, zahl2);
				
		MyConsumer01 mc2 = (i, i1) -> i * i1;
//		mc2.berechne(zahl1, zahl2);
		doStuffWithMyConsumer01(mc2, zahl1, zahl2);
		
		doStuffWithMyConsumer01((i, i1) -> i * i1, 10, 20);
		//statische Methodenreferenz als MyConsumer
		doStuffWithMyConsumer01(Demo06_b_Statische_Referenzen::myCalculatingMethod, 10, 20);
		doStuffWithMyConsumer01(Demo06_b_Statische_Referenzen::myCalculatingMethod, 10, 20);
	}
	
	
}
