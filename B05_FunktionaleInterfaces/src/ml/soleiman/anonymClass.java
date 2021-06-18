package ml.soleiman;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class anonymClass {
	public static void main(String[] args) {
		
		String[] arr = { "achtzehnbuchstaben", "dry", "vier", "1", "fuenf", "neunzehn Buchstaben", };

		List<String> woerter = Arrays.asList(arr);
		
		Comparator<String> c = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() == o2.length()) {
					return 0;
				} else {
					return 1;
				}
			}
		};
		System.out.println(woerter);
		woerter.sort(c);
		System.out.println(woerter);
		
		Comparator<String> reversed = c.reversed();
		woerter.sort(reversed);
		System.out.println(woerter);
		
	}

}
