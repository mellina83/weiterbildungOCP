package pak04localInnerClass;

public class DemoReturn {
	
	
	public static Object returnInner() {
		class Inner implements I{
			public void goInner() {
				
			}

			@Override
			public void goI() {
				System.out.println("goI in Inner");			
			}
		}	
		return new Inner();
	}
	
	public static void main(String[] args) {
		Object o = returnInner();
		System.out.println(o.getClass());
//		((Inner)o).goInner();
		I i1 = (I)returnInner();
		i1.goI();
	}
}

interface I{
	void goI();
}