package pak01_functional;

interface nonFunctional01 {
} // kein Functional Interface

interface nonFunctional02 { // kein Functional Interface
	public abstract void method01();

	void method02();
}

interface IFunctional01 { // Das ist ein Funktionales Interface
	public abstract int doStuff();
}

interface IFunctional02 {
	public abstract int doStuff01();

	default void doStuff() {
		System.out.println("Ich bin ein funktionales Interface");
	}

	public static void doStuff03() {
		System.out.println("Ich bin ein funktionales Interface");
	}
}

/**
 * Die Annotation @FunctionalInterface ist nicht noetig, um ein funktionales
 * Interface zu erstellen
 */
@FunctionalInterface
interface IFunctional03 {
	public abstract int doStuff01();

	// Invalid '@FunctionalInterface' annotation; IFunctional03 is not a functional
	// interface
//	public abstract int doStuff04();

	default void doStuff() {
		System.out.println("Ich bin ein funktionales Interface");
	}

	public static void doStuff03() {
		System.out.println("Ich bin ein funktionales Interface");
	}
}

@FunctionalInterface
interface ExamWatch extends IFunctional03 {
	@Override
	default void doStuff() {
		ExamWatch ew = () -> 5;
		ew.doStuff();
	}
}

@FunctionalInterface
interface ExamWatch02 extends IFunctional03 {
	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public String toString();

}

@FunctionalInterface
interface ExamWatch03 extends IFunctional03 {
	public abstract boolean equals(Object o);

	public abstract int hashCode();

	public String toString();
	//Invalid '@FunctionalInterface' annotation; ExamWatch03 is not a functional interface
//	void doBadStuff();

}

public class Demo01_Functional_Interface {
	public static void main(String[] args) {
		
	}
}
