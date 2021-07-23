package ml.duerbeck;

//Meine HA als ML, vollkommen korrekt

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Aufgabe01 Wie lange dauert eine Reise, die um 12:00 Uhr in der Zeitzone
 *            "UTC+1" startet und um 16:00 Uhr in der Zeitzone "UTC+2" endet?
 *            Verwenden Sie f�r die Ermittlung die Konstante `HOURS` der
 *            enum-Klasse `java.time.temporal.ChronoUnit`.
 *
 * @Aufgabe02 Wann (um vieviel Uhr lokaler Zeit) kommt ein Reisender in die
 *            Zeitzone "UTC+1", wenn die Reise um 08:00 Uhr (Lokalzeit) in der
 *            Zeitzone "UTC+2" startet und 3 Stunden dauert?
 * 
 * @Aufgabe03 Wie viele Stunden lagen am 25. M�rz 2018 in Berlin zwischen 01:00
 *            Uhr nachts und 04:00 Uhr nachts? Warum nicht drei? Verwenden Sie
 *            f�r die Ermittlung die Klasse `java.time.Duration`.
 */
public class Aufgabe02 {
	
	public static void main(String[] args) {
		ZoneId zoneId1 = ZoneId.of("UTC+1");
		ZoneId zoneId2 = ZoneId.of("UTC+2");
		ZoneId zoneId3 = ZoneId.of("Europe/Berlin");
		
		//Aufgabe 1
		System.out.println("Aufgabe 1");
		
		ZonedDateTime start1 = ZonedDateTime.of(2021, 07, 20, 12, 0, 0, 0, zoneId1);
		ZonedDateTime ende1 = ZonedDateTime.of(2021, 07, 20, 16, 0, 0, 0, zoneId2);
		long reisedauer = ChronoUnit.HOURS.between(start1, ende1);
		
		System.out.println("Reisedauer zwischen 12Uhr (UTC+1) und 16Uhr (UTC+2): " + reisedauer + " Stunden.");
		
		
		//Aufgabe 2
		System.out.println("\nAufgabe 2");

		LocalDateTime start2 = LocalDateTime.of(2021,07,20,12,0,0,0);
		ZonedDateTime start2MitZone2 = start2.atZone(zoneId2);
		ZonedDateTime ende2MitZone1 = start2MitZone2.plusHours(3).withZoneSameInstant(zoneId1);
		LocalDateTime ende2 = ende2MitZone1.toLocalDateTime();	
		
		System.out.println("Ankunft nach 3 Stunden Flug bei Start um 12 Uhr:\n"
				+ ende2.format(DateTimeFormatter.ofPattern("HH:mm 'Uhr'")) + " Lokale Zeit");
		
		
		//Aufgabe 3
		System.out.println("\nAufgabe 3");

		ZonedDateTime datumZeit1 = ZonedDateTime.of(2018, 3, 25, 1, 0, 0, 0, zoneId3);
		ZonedDateTime datumZeit2 = ZonedDateTime.of(2018, 3, 25, 4, 0, 0, 0, zoneId3);
		Duration zeitraum = Duration.between(datumZeit1, datumZeit2);
		
		System.out.println("Dauer zwischen "
				+ datumZeit1.format(DateTimeFormatter.ofPattern("d.MM.YYYY, HH:mm 'Uhr'"))
				+ " und "
				+ datumZeit2.format(DateTimeFormatter.ofPattern("d.MM.YYYY, HH:mm 'Uhr'"))
				+ ": " + zeitraum.toHours() + " Stunden");
		//Haette ich UTC verwendet fuer die Zone ID, waere 3 herausgekommen
		
		
	} // Ende der Main Methode

}
