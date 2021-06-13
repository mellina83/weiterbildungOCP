package pattern.wrapper;

public class DemoWrapper {
	public static void main(String[] args) {
//		demo01();
//		demoBoxingUnboxing();
		demoVergleiche();
	}

	private static void demoVergleiche() {
//		In order to save memory, two instances of the
//		following wrapper objects (created through boxing), will always be == when their
//		primitive values are the same:
//		–  Boolean
//		–  Byte
//		–  Character from \u0000 to \u007f (7f is 127 in decimal)
//		–  Short and Integer from -128 to 127
//		Note: When == is used to compare a primitive to a wrapper, the wrapper will be
//		unwrapped and the comparison will be primitive to primitive.
		Integer i5 = 127;
		Integer i6 = 127;
		Integer i7 = new Integer(127);
				
		System.out.println(i5 == i6);//true
		System.out.println(i6 == i7);//false
		
		short s1 = 1200;
		Short s2 = new Short((short)1200);
		
		System.out.println(s1 == s2); //true
		
		Integer i1 = 1200;
		Integer i2 = 1200;
		System.out.println(i1 == i2); //false
		System.out.println(i1.equals(i2)); //true
		System.out.println(i1.intValue() == i2.intValue()); //true
	}

	private static void demoBoxingUnboxing() {
		byte b1 = 1;
//		Integer i1 = b1;  //1. Widening 2. Boxing   		
		
		Byte b2 = 12;
		int i2 = b2;		//1. Unboxing 2. Widening
		
		Integer i3 = 10;
		Integer i4 = i3;
		System.out.println(i4 == i3);
		
		i3++; // 1. Unboxing, 2. Inkrement, 3. Boxing
		System.out.println(i3 + " " + i4);
		System.out.println(i4 == i3);
		i4++;
		System.out.println(i4 == i3);
		
	}

	private static void demo01() {
		boolean b01 = true;
		Boolean b02 = false;
		Boolean b03 = new Boolean(true);
		Boolean b04 = Boolean.TRUE;
		
		byte by01 = 12;
		Byte by02 = by01; //Boxing
		Byte by03 = new Byte((byte)12);
		Byte by04 = new Byte(by02); //by02 wird ausgepackt/unboxing
		
	}
}
