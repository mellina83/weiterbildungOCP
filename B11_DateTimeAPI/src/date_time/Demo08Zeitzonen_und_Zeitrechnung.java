package date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Demo08Zeitzonen_und_Zeitrechnung {
	public static void main(String[] args) {
//		demo01();
		
		demo02();
	}
	private static void demo02() {
		ZonedDateTime utcZoned = ZonedDateTime.of(LocalDate.now().atTime(11, 30), ZoneOffset.UTC);
		ZoneId swissZone = ZoneId.of("Europe/Zurich");
		//Es findet eine Umrechnung auf die neue Zeitzone statt
		ZonedDateTime swissZoned = utcZoned.withZoneSameInstant(swissZone);
		//Die Information ueber die Zeitzone verschwindet
		//ohne Umrechnung
		LocalDateTime swissLocal = swissZoned.toLocalDateTime();
				
		System.out.println(utcZoned);
		System.out.println(swissZoned);
		System.out.println(swissLocal);
				
		LocalDateTime localDateTime = LocalDateTime.of(2021, 10, 25, 12, 0);
		ZonedDateTime zonedDateTimeInUTC = localDateTime.atZone(ZoneId.of("UTC-9"));
		System.out.println("localDateTime:                 " + localDateTime);
		System.out.println("zonedDateTimeInUTC:            " + zonedDateTimeInUTC);
		
		//Umrechnung auf die neue Zeitzone
		ZonedDateTime zonedEuropeBerlinInstant = zonedDateTimeInUTC.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
		//Nur neue Zone
		ZonedDateTime zonedEuropeBerlinLocal = zonedDateTimeInUTC.withZoneSameLocal(ZoneId.of("Europe/Berlin"));
		
		System.out.println("zonedEuropeBerlinInstant:      " + zonedEuropeBerlinInstant);
		System.out.println("zonedEuropeBerlinLocal:        " + zonedEuropeBerlinLocal);
		
	}
	public static void demo01() {
		ZoneId zone1 = ZoneId.of("UTC-7");
		ZoneId zone2 = ZoneId.of("UTC-5");
		
		int hour = 3;
		int minute = 0;
		int second = 0;
		
		ZonedDateTime abflug = //03:00 Uhr, UTC-7
				ZonedDateTime.of(2020, 1, 8, hour, minute, second, 0, zone1);
		System.out.println("Abflug: " + abflug);
		
		hour = 9;
		
		ZonedDateTime ankunft = //09:00 Uhr, UTC-5
				ZonedDateTime.of(2020, 1, 8, hour, minute, second, 0, zone2);
		System.out.println("Ankunft: " + ankunft);
		
		long flugdauer = ChronoUnit.HOURS.between(abflug, ankunft);

		System.out.println("Flugdauer: " + flugdauer);
		
		//GMT zone1 = 03:00 + 7:00 = 10:00
		//GMT zone2 = 09:00 + 5:00 = 14:00
	}
}
