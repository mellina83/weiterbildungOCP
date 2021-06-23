package pak03_methods.demo02;

public class MyClass {
	public static void main(String[] args) {
		A<B> a1 = new A<>();
		A<B> a2 = new A<>();
		
		go(a1, a2);
		
		A<Object> a3 = new A<>();
//		go(a1, a3);
		
	}
	
	public static <E, T extends E> void go(A<E> a1 , A<T> a2) {
		
	}
}

class A<T> {

}


class B {

}

class C extends B {

}
