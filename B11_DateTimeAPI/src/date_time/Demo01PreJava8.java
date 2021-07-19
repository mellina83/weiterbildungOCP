package date_time;

import java.util.Date;
/**
 * Vor Einfuehrung der neuen DATE and Time API mit Java 8, war das Arbeiten mit
 * dem Date´s nicht sehr intuitiv gestaltet
 * 
 */
public class Demo01PreJava8 {
	public static void main(String[] args) {
		Date date = new Date(); //now
		System.out.println(date);
		
		date = new Date(25217364663827L);
		System.out.println(date);
		
		date = new Date (2021, 7, 19, 10,0, 0);
		System.out.println(date);
	}
}
