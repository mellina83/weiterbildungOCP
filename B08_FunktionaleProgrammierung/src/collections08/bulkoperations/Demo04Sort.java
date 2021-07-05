package collections08.bulkoperations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo04Sort {

	public static void main(String[] args) {
//		demoSort01Int();
		demoSort02Strings();

	}

	private static void demoSort02Strings() {
		List<String> listStrings = Arrays.asList("ab", "ba", "fd", "Gt", "iu", "BA");

		System.out.println(listStrings);//[ab, ba, fd, Gt, iu, BA]
		
		Comparator<String> aufsteigend = String::compareTo;
		
		listStrings.sort(aufsteigend);
		
		System.out.println(listStrings);//[BA, Gt, ab, ba, fd, iu]

	}

	private static void demoSort01Int() {
		List<Integer> listInts = Arrays.asList(2, -5, 9, -11, -55, -9, 8, -3, -22);

//		Comparator<Integer> aufsteigend = (x,y) -> Integer.compare(x, y);
		Comparator<Integer> aufsteigend = Integer::compare;

		System.out.println(listInts);

		listInts.sort(aufsteigend);

		System.out.println(listInts);
	}
}
