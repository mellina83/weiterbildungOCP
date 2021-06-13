package assertions;

import java.util.function.Predicate;

enum Tag{MO,DI}

public class Demo04AssertionsLegal {
	public static void main(String[] args) {
//		doStuff();
		doStuff02();
	}
	//Simple & Methods
	private static void doStuff02() {
		String str = "";
		int x = 1;
		boolean b = true;
		Object o = new Object();
		AssertionError ae = new AssertionError(x);
		
		assert(x== 1) : x;
		assert(x== 1) : new Object();
		assert(methodBool()) : methodBool();
		assert(x == 2) : null;
		
		assert(x == 2) : methodWithReturn();//Methode muss Rueckgabewert haben
//		assert(x == 2) : voidMethod();
		assert b = false;
		assert x == 2 : Tag.MO;
		assert(b): new StringBuilder();
		
	}
	static void voidMethod() {
		
	}
	static int methodWithReturn() {
		return 5;
	}
	
	static boolean methodBool() {
		return true;
	}
	
	
	//Really Simple
	private static void doStuff() {

		String str = "";
		int x = 1;
		boolean b = true;
		
		assert(x == 1);
		assert(b);
		assert false;
		
		assert true;//Legal aber sinnlos
		
		assert b = x == 1;
		
		assert str instanceof String;
		
	}
	
	private static void PredicateAssert() {
		Predicate<Integer> pred = i->true;		
//		assert(pred);
		assert pred.test(1);
	}
	
}
