package ml.duerbeck;

import java.util.Comparator;

public class ComparePersonenNachAlles implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int i = o1.getName().compareToIgnoreCase(o2.getName());
		if (i == 0) {
			return o1.getAge()-o2.getAge();
		} else {
			return i;
		}
		
		
	}

}
