package pak07_Overriding;

import java.util.List;

public class DemoOverriding {

}

class A {
	List<? super B> lower() {
		return null;
	}

	List<? extends B> upper() {
		return null;
	}
}

class B extends A {
	// Bei LowerBound darf der Rueckgabetyp allgemeiner
	// werden
	@Override
	List<? super A> lower() {
		return null;
	}

	// Bei Upperbound darf der Rueckgabetyp spezieller
	// werden
	@Override
	List<? extends C> upper() {
		return null;
	}
}

class C extends B {

}

class A1<T> {

	void go(T t) {

	}
}

class B1<T> extends A1<T> {
//	@Override
	void go(Integer t) {
		System.out.println("Overload");
	}
}
