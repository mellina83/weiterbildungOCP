package aufgabe_MeineLoesung;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayListPositive liste1 = new ArrayListPositive();
		liste1.add(1);
		liste1.add(3);
		System.out.println(liste1);
		
		ArrayListPositive liste2 = new ArrayListPositive();
		liste2.add(1);
//		liste2.add(0);
		System.out.println(liste2);
		
		ArrayListPositive liste3 = new ArrayListPositive();
		liste3.add(null);
		System.out.println(liste3);

	}

}
