package date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Demo06DateTimeFormater {
	public static void main(String[] args) {
//		demoFormater();
//		demoBasicFormatter();
		
		demoDateTimeFormatterPattern();
	}
	
	private static void demoDateTimeFormatterPattern() {
		LocalDateTime ldt = LocalDateTime.now();
		
		/**
		 * Achtung: Die textuellen Teile sind in Hochkomma einzuschlieﬂen
		 */
		String datePattern = "'Es ist 'EEEE' der 'dd'. Tag im 'MMMM' im Jahr 'yyyy'.'";
		String timePattern = "'Es ist 'H' Uhr 'm' und 's' sekunden.'";
		String date_timePattern = "'Der 'dd'. Tag im 'MMMM' im Jahr 'yyyy'."
				+ "\nEs ist 'H' Uhr 'm' und 's' sekunden.'";
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern, Locale.ENGLISH);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern(date_timePattern, Locale.FRENCH);
		
		System.out.println(ldt.format(dateFormatter));
		System.out.println(ldt.format(timeFormatter));
		System.out.println();
		System.out.println(ldt.format(dtFormatter));
		
	}

	private static void demoBasicFormatter() {
		LocalDate lDate = LocalDate.now();
		LocalTime lTime = LocalTime.now();
		LocalDateTime lDateTime = LocalDateTime.now();
		
		System.out.println(lDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(lDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(lDateTime.format(DateTimeFormatter.ISO_TIME));
	}

	public static void demoFormater() {
		LocalDate lDate = LocalDate.now();
		LocalTime lTime = LocalTime.now();
		LocalDateTime lDateTime = LocalDateTime.now();
		
		//public static DateTimeFormatter ofPattern(String pattern)
		//public static DateTimeFormatter ofPattern(String pattern, Locale locale)

		//https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		
		DateTimeFormatter date_tf = DateTimeFormatter.ofPattern("QQQQ dd.MMMM.yyyy");
		System.out.println(lDate);
		System.out.println(lDate.format(date_tf));
		
		DateTimeFormatter time_tf = DateTimeFormatter.ofPattern("a HH:mm:ss");
		System.out.println(lTime);
		System.out.println(lTime.format(time_tf));
		
		DateTimeFormatter dateTime_f = DateTimeFormatter.ofPattern("QQQQ dd.MMMM.yyyy : a HH:mm:ss");
		System.out.println(lDateTime);
		System.out.println(lDateTime.format(date_tf));
		System.out.println(lDateTime.format(time_tf));
		System.out.println(lDateTime.format(dateTime_f));
		
		//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: AmPmOfDay
//		System.out.println(lDate.format(time_tf));
		
		//java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: QuarterOfYear
//		System.out.println(lTime.format(date_tf));
		
	}
}
