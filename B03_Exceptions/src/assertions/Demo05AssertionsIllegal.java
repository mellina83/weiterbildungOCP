package assertions;

public class Demo05AssertionsIllegal {
	public static void main(String[] args) {
		doStuff();
	}

	private static void doStuff() {
		int x = 1;
		boolean b = true;
		String str = null;
		
		//Really Simple, these are illegal
//		assert(x = 1);				//Muss ein boolean sein
//		assert (x);					//ist auch kein boolean
//		assert 0;					//ist auch kein boolean
//		assert null;				//ist auch kein boolean
//		assert str;					//ist auch kein boolean
//		assert noReturnIllegal();	//kein return Value
		
		//Simple
//		assert x == 1: ;					//Darf nicht leer sein
//		assert x == 1: noReturnIllegal();	//kein return Value
//		assert x == 1: String str1 = "";	//keine Deklaration
	}
	
	public static void noReturnIllegal() {
		
	}
}
