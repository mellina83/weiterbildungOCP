package pak02staticClass.pak02;

interface I{
	void go();
}

class A{
	void goA() {
		
	}
}

public class Outter {
	private static class Inner extends A implements I{

		@Override
		public void go() {
			System.out.println("go()");		
		}
		@Override
		void goA() {
			System.out.println("goA()");
		}
	}
	
	static Inner returnInner() {
		return new Inner();
	}
}
