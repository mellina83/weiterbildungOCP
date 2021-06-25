package ml.khalil.treeSet_Teil2;

import java.util.Comparator;

public class ComparePersonNachAlles implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		int i = Integer.compare(o1.getAge(), o2.getAge());
		if(i == 0) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}else {
			return i;
		}
	}
	}


