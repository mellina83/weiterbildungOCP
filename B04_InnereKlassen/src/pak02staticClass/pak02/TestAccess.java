package pak02staticClass.pak02;

public class TestAccess {
	public static void main(String[] args) {
//		Outter.Inner in;
		I i = Outter.returnInner();
		i.go();
		System.out.println(i.getClass());
		
		A a = Outter.returnInner();
		a.goA();
	}
}
