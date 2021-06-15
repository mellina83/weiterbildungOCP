package pak03memberclass.pak03Vererbung;

public class App {
	public static void main(String[] args) {
		System.out.println(Out.In2.In2.t);
		
		Out o1 = new Out();
		o1.o = o1;
		System.out.println(o1.o.o.text);
		
		System.out.println(o1.hashCode());
		System.out.println(o1.o.hashCode());
		System.out.println(o1.o.o.hashCode());
		
		Out.In.In.In in = new Out().new In();
		Out in2 = new Out().new In();
		
	}
}

class Out{
	Out o;
	String text = "Out";
	
	class In extends Out{
		
	}
	
	static class In2 extends Out{
		public static String t = "Hallo";
	}
}



