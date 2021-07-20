package date_time;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Demo07_DaylightSaving {
	public static void main(String[] args) {
		dayLightSaving();
		
//		durationBetween();
	}

	private static void durationBetween() {
		int year = 2015;
		int month = 3;
		int dayOfMonth = 8;
		
		int hour = 1;
		int minute = 0;
		int second = 0;
		int nanoOfSecond = 0;
		
		ZoneId zone01 = ZoneId.of("UTC");//Barcelona
		
		ZonedDateTime dt1 = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone01);
		
		ZoneId zone02 = ZoneId.of("UTC+5");//Mumbai
		
		ZonedDateTime dt2 = ZonedDateTime.of(year, month, dayOfMonth, 9, minute, second, nanoOfSecond, zone02);
		
		Duration between = Duration.between(dt1, dt2);
		
		System.out.printf("Ihr Flug dauerte %d Stunden %n", between.toHours());
		System.out.println(dt1);
		System.out.println(dt2);
	}

	private static void dayLightSaving() {
		/**
		 * Bekannt (auch in der Pr�fung wird es bekannt gegeben) ist ein Datum f�r die
		 * Zeitumstellung in den USA (daylight saving):
		 * 
		 * 2015, am 8. M�rz, um 2:00 Uhr ( um diese Zeit wurde die Uhr auf 3:00
		 * umgestellt) Zeitzone: US/Central
		 */
		int year = 2015;
		int month = 3;
		int dayOfMonth = 8;
		
		int hour = 1;
		int minute = 0;
		int second = 0;
		int nanoOfSecond = 0;
		
		ZoneId zone = ZoneId.of("US/Central");
		
		ZonedDateTime dt1 = //1 Uhr nachts
				ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		hour += 2;
		
		ZonedDateTime dt2 = //3 Uhr nachts
				ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		System.out.println(dt1);//2015-03-08T01:00-06:00[US/Central]
		System.out.println(dt2);//2015-03-08T03:00-05:00[US/Central]
		
		Duration d = Duration.between(dt1, dt2);
		
		/**
		 * Zwischen 1:00 nachts und 3:00 nachts liegen 2 Stunden.
		 * 
		 * Wieviele Stunden liegen dazwischen, wenn zwischendurch eine Zeitumstellung
		 * stattfindet. 2 oder 1 Stunde
		 */
		System.out.printf("Zwischen den beiden Zeitpunkten liegen %d Stunden", d.toHours());
		
	}
}
