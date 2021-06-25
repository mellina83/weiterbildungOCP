package pak03_lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Demo02List {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		List<Integer> list01 = new ArrayList<>();
		List<Integer> list02 = new LinkedList<>();
		List<Integer> list03 = new Vector<>();
		
		long timeBefore = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000; i++) {
//			list01.add(i);
//			list02.add(i);
			list03.add(i);
		}
		
		long timeAfter = System.currentTimeMillis(); 
		System.out.println("Time needed : " + (timeAfter - timeBefore));
		
	}
}
