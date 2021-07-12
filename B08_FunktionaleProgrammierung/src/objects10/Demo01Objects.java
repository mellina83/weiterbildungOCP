package objects10;

import java.util.Objects;

import data.Dog;

class MyClass {
	String urgent;
	int length;
	public MyClass(String urgent) {
		Objects.requireNonNull(urgent,"Param urgent must not null.");
		this.urgent = urgent;
//		if(urgent == null) {
//			throw new NullPointerException("Param urgent must not null.");
//		}
		this.length = urgent.length();
	}
}

public class Demo01Objects {

	
	public static void main(String[] args) {
		MyClass m01 =new MyClass(null);
	}
}
