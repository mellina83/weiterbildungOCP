package pak02staticClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo01ArraysInnerArrayList {
	public static void main(String[] args) {
		Integer[] zahlen = {1,2,3,4};
		
		List<Integer> list = Arrays.asList(zahlen);
		List<Integer> list2 = new ArrayList<Integer>();
		list.forEach(System.out::println);
		
//		list.add(5); //java.lang.UnsupportedOperationException
//		list.remove(1);//java.lang.UnsupportedOperationException
		
		System.out.println(list.getClass());
		System.out.println(list2.getClass());
		
		
		List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(zahlen));
		list3.add(5);
		list3.remove(1);
			
	}
}
