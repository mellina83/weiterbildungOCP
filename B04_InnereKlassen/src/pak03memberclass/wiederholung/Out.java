package pak03memberclass.wiederholung;

public class Out {
	static class StaticIn{
		
	}
	
	class In{
		
	}
	
	static void staticGo() {
//		In in1 = new In();
		In in1 = new Out().new In();
		StaticIn in2 = new StaticIn();		
	}
	
	void go() {
		In in1 = new In();
		StaticIn in2 = new StaticIn();
	}
}

class Ausserhalb{
	static void staticGo() {
		Out.StaticIn in1 = new Out.StaticIn();
		Out.In in2 = new Out().new In();
	}
}