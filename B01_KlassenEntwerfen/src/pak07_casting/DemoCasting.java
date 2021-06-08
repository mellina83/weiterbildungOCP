package pak07_casting;

public class DemoCasting {
	public static void main(String[] args) {
		//Upcast - Implizit
		A a = new B();
		go(new B());
			
		//Downcast - Explizit
		B b = (B)a;
		
//		A a1 = new A();
//		B b1 = (B)a1; //ClassCastException
		
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		
		
	}
	
	static void go(A a) {
		
	}
}
class A{
	
}
class B extends A{
	
}