package pak03memberclass.pak02_accessModifier;

interface I{
	
}
public class Out {
	/*
	 * Erlaubte Modifizierer:
	 * Sichtbarkeit: public, protected, default, private
	 * private: Instanzieren der In von ausserhalb nicht moeglich
	 * 
	 * final: erlaubt
	 * abstract: erlaubt
	 */
	private class In implements I{

	}
	
	public static In instanciateIn() {
		return new Out().new In();
	}
	
	class SubIn extends In{
		
	}
}

class App{
	static void testIn() {
//		In in;
		I inner = Out.instanciateIn();
	}
}
