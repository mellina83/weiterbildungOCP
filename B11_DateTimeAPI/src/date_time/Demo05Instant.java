package date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Demo05Instant {

	/**
	 * @throws InterruptedException 
	 * @Instant Bezeichnet Fortlaufende Maschinenzeit
	 * 
	 *          Einheit : Nanosekunden
	 * 
	 * 
	 * @Menschzeit Für uns Menschen bedeutet Zeit meist ein Datum im Sinne von Tagen
	 *             Monaten und Jahren, sowie Uhrzeit nach Stunde Minute und
	 *             Sekunden.
	 * 
	 * 
	 * @Maschinenzeit Die Maschinenzeit stellt eine fortlaufende Zeitspanne
	 *                abgelaufener Einheiten seit einem Fixen Zeitpunkt dar. Häufig
	 *                wird der Fixe Zeitpunkt als eine sogenannte Epoche bezeichnet.
	 *                Populäres beispiel wäre die Unix-Epoche bzw. der daraus
	 *                bekannte Unix-TimeStamp. -- 01.01.1970 - 00:00:00:000_000_000
	 *
	 */
	public static void main(String[] args) throws InterruptedException {
		long millisecond = 100000L;
		long epochSecond = 100000L;
		/**
		 * Obtains an instance of Instant using milliseconds from the epoch of
		 * 1970-01-01T00:00:00Z.
		 */
		Instant instant01 = Instant.ofEpochMilli(millisecond);
		/**
		 * Obtains an instance of Instant using seconds from the epoch of
		 * 1970-01-01T00:00:00Z.
		 */
		Instant instant02 = Instant.ofEpochSecond(epochSecond);
		/**
		 * Obtains an instance of Instant using seconds from the epoch of
		 * 1970-01-01T00:00:00Z and nanosecond fraction of second.
		 */
		Instant instant03 = Instant.ofEpochSecond(epochSecond, 1);
		
		System.out.println("ofEpochMilli: " + instant01);
		System.out.println("ofEpochSecond: " + instant02);
		System.out.println("ofEpochSecond und Nanos: " + instant03);
		
		Instant before = Instant.now();
		for (int i = 0; i < 40; i++) {
			System.out.println("Hallo Welt");
			Thread.sleep(25);
		}
		Instant after = Instant.now();
		Duration between = Duration.between(before, after);
		System.out.println(between);
		System.out.println(between.getSeconds());
		System.out.println(between.getNano());
		System.out.println(between.toMinutes());
		
		System.out.println(before.plus(between));
		
		ZonedDateTime zdt = before.atZone(ZoneId.of("UTC+6"));
		System.out.println(zdt);

	}
}
