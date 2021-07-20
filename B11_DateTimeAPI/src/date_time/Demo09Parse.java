package date_time;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Demo09Parse {
	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		
		ZonedDateTime zdt02 = ZonedDateTime.parse("2021-07-20T10:20:55.871+02:00[Europe/Berlin]");
		System.out.println(zdt02);
		
		LocalDate ld = LocalDate.of(2021, 7, 20);
		System.out.println(ld);
		
		LocalDate ld2 = LocalDate.parse("2021-07-20");
		System.out.println(ld2);
		
		//Parse mit Pattern
		//Der String wird so interpretiert wie im Pattern festgelegt
		DateTimeFormatter date_tf = DateTimeFormatter.ofPattern("QQQQ dd.MMMM.yyyy");
		System.out.println(ld2.format(date_tf));
		
		LocalDate ld3 = LocalDate.parse("3. Quartal 20.Juli.2021", date_tf);
		System.out.println(ld3);
		
		//Exception, da der String die falsche Formatierung hat.
		LocalDate ld4 = LocalDate.parse("2021-07-20", date_tf);
		System.out.println(ld4);
		
	}
}
