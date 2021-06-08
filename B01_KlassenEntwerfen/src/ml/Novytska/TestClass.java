package ml.Novytska;

import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) {
		ArrayList alist = new ArrayListPositive();
		try {
			alist.add(null);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		try {
			alist.add(0);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		try {
			alist.add(-2);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		try {
			alist.add("123");
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		try {
			alist.add(10);
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("alist : "+alist);
	}

}
