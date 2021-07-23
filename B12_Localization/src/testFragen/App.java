package testFragen;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class App {

	public static void main(String[] args) {
		/*
		 * Given: Daylight Savings Time ends on Nov 1 at 2 AM in US/Eastern time zone.
		 * As a result, 2 AM becomes 1 AM. What will the following code print ?
		 */
		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);
		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Duration.ofDays(1));
		System.out.println(date);
		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Period.ofDays(1));
		System.out.println(date);

		/*
		 * Durations and periods differ in their treatment of daylight savings time when
		 * added to ZonedDateTime. A Duration will add an exact number of seconds, thus a
		 * duration of one day is always exactly 24 hours.By contrast, a Period will add
		 * a conceptual day, trying to maintainthe local time.
		 */
	}

	static void go(int zahl) throws Exception {
		oops(zahl);
	}

	static int oops(int i) throws Exception {
		throw new Exception("oops");
	}
}
