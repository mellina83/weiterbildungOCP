package collections08.bulkoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Demo02RemoveIf {

	public static void main(String[] args) {
		Collection<Integer> myInts = Arrays.asList(55, 8, 5, 99, 45, 42, 78, 75, 42, 12, 13, 14, 15, 16, 98,
				987, 789);

		// Wie kann eine weitere Zahl beispielweise 4713 hinzugefügt werden?
		myInts = new ArrayList<Integer>(myInts);
		myInts.add(4713);
		System.out.println(myInts);
		
		// Wir wollen alle geraden zahlen aus der Liste entfernen.
//		Iterator<Integer> iter = myInts.iterator();
//		while(iter.hasNext()) {
//			if(iter.next()%2==0) {
//				iter.remove();
//			}
//		}
		myInts.removeIf(e -> e%2==0);
		System.out.println(myInts);
	}

}
