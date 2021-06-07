package pak04_vererbung;

public class DemoOverloading_Overriding {
	public static void main(String[] args) {

	}
}

class A {

	public void go() {

	}
	//Beim Ueberladen darf der Rueckgabetyp geaendert werden
	//und die Sichtbarkeit darf reduziert werden.
	int go(int i) {
		return 1;
	}
	
	public A go2() {
		return null;
	}
}

class B extends A {
	//Beim Ueberschreiben darf der Rueckgabetyp nicht geaendert werden.
//	public int go() {
//		return 1;
//	}
	//Covarianter Rueckgabetyp
	public B go2() {
		return null;
	}
	
	//Beim Ueberschreiben darf die Sichtbarkeit nicht reduziert werden.
//	void go() {
//		
//	}
	
	
}
