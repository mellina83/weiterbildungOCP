package z_date_time_Zusammenfassung;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Date_Time {
	/*
	 * Dates and Times (OCP Objectives 7.1, 7.2, and 7.3)
	 * 
	 * - The classes you need to understand are those in java.time,
	 * java.time.temporal, and java.time.format, as well as java.util.Locale. 
	 * 
	 * - Date and Calendar are no longer used, and most of the Date class's methods have
	 * been deprecated.
	 * 
	 * - A LocalDate is a date, and a LocalTime is a time. Combine the two to
		make a LocalDateTime. None of these types have a time zone associated
		with them.
	 * 
	 * - A ZonedDateTime is a datetime object with a time zone. 
		All zoned datetimes are relative to Greenwich Mean Time (GMT). 
		You may sometimes see GMT written as UTC.
		
		- A ZoneId can be created from a string representing a time zone (e.g. "US/Pacific").
		
		- When you adjust ZonedDateTimes, daylight savings time will be
		automatically handled using the ZoneRules.
		
		- If you want a datetime object with a time zone that is independent of zone
		rules, use an OffsetDateTime.
		
		- A Period is a period of time that is a day or longer.
		- A Duration is a period of time that is shorter than a day.
		
		- An Instant is an instant in time and represents the number of seconds and
		nanoseconds since January 1, 1970. You can get the number of seconds as
		a long value from an Instant and convert any ZonedDateTime object
		into an Instant.
		
		- There are several format "styles" available in the java.format class. 
		You can use format styles such as FormatStyle.SHORT with DateTimeFormatter
		to format datetime objects.
		
		- The DateTimeFormatter class is used to parse and create strings containing properly formatted dates.
		
		- The Locale class is used in conjunction with DateFormat and
		NumberFormat.
		
		- A DateTimeFormatter object can be constructed with a specific,
		immutable Locale.
		
		- For the exam, you should understand creating Locales using either
		language or a combination of language and country.
		
	 */
	
	
	public static void main(String[] args) {
		ZonedDateTime totalityUTC = ZonedDateTime.of(
				LocalDateTime.of(2019, 7, 2, 16, 55), ZoneId.of("Z "));
		ZonedDateTime totalitySanJuan =
				totalityUTC.withZoneSameInstant(ZoneId.of("America/Argentina/San_Juan"));
				System.out.println(totalitySanJuan);
	}
}
