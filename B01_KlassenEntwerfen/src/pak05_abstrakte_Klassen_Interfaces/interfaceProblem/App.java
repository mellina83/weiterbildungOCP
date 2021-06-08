package pak05_abstrakte_Klassen_Interfaces.interfaceProblem;

public class App {
	public static void main(String[] args) {
		I a = new A();
		a.go();
	}
}

interface I {
	default void go() {
		System.out.println("go I");
	}
}

interface I2{
	default void go() {
		System.out.println("go I2");
	}
}
class A implements I, I2{
	public void go() {
		System.out.println("go A");
		I.super.go();
	}
}