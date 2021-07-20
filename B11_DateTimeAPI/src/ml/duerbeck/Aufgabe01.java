package ml.duerbeck;

//Meine Aufgabe ist ML, hatte Dozent mit allen gemeinsam ergaenzt

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

/**
 * 
 * @Aufgabe01 Tage zwischen Ihren Geburtstag und Heute berechen. Geben Sie die
 *            werte in Jahre, Monate und Tage aus. Einmal berechnen Sie die Tage
 *            seit ihrer Geburt, einmal seit ihren letzten Geburtsag
 * 
 * @Aufgabe02 Tage zwischen Heute (.now()) und Kursanfang '07.06.2021 08:00'
 *            berechnen. Geben Sie die werte jeweils in Tage, Stunden & Minuten
 *            aus.
 * 
 * 
 * @Aufgabe03 DateTimeFormatter Erzeugen Sie einen DateTimeFormatter womit Sie
 *            sich ein beliebiges Datum mit beliebigen Locales Ausgeben lassen
 *            k�nnen.
 * 
 *            Erzeugen Sie den Formatter mit einem Pattern.
 * 
 *            Es soll die ERA ausgegeben werden.
 * 
 *            Gefolgt vom Datum 'Montag der 25. M�rz 2019'
 * 
 *            Als n�chstes soll die Kalenderwoche ausgegeben werden - '13. KW'
 * 
 *            Abschliessend h�ngen Sie die Uhrzeit mit an.
 * 
 * 
 */
public class Aufgabe01 {
	
	public static void main(String[] args) {
		
		//Aufgabe 1
		System.out.println("Aufgabe 1:");
		LocalDate meinGeburtstag = LocalDate.of(1983, 7, 8);
		LocalDate datumHeute = LocalDate.now();
		Period zeitraum = Period.between(meinGeburtstag, datumHeute);
		long tageSeitGeburt = ChronoUnit.DAYS.between(meinGeburtstag, datumHeute);
		
		System.out.println("Zeitraum zwischen meinem B-Day und heute:");
		System.out.println("-Jahre: " + zeitraum.getYears());
		System.out.println("-Monate: " + zeitraum.getMonths());
		System.out.println("-Tage: " + zeitraum.getDays());
		System.out.println("Tage seit meiner Geburt: " + tageSeitGeburt) ;
		
		LocalDate lastBirthDay = meinGeburtstag.plus(zeitraum.getYears(), ChronoUnit.YEARS);
		System.out.println("Tage seid letztem Geburtstag: " + ChronoUnit.DAYS.between(lastBirthDay, datumHeute));
		
		//Aufgabe 2
		System.out.println("\nAufgabe 2:");
		LocalDateTime kursbeginn = LocalDateTime.of(2021, Month.JUNE, 7, 8, 0, 0);
		LocalDateTime heute = LocalDateTime.now();
		Duration seitKursbeginn = Duration.between(kursbeginn, heute);
		
		System.out.println("Tage zwischen heute und Kursanfang: ");
		System.out.println("-Tage: " + seitKursbeginn.toDays());
		System.out.println("-Stunden: " + seitKursbeginn.toHours());
		System.out.println("-Minuten: " + seitKursbeginn.toMinutes());
		
		//Aufgabe 3
		System.out.println("\nAufgabe 3:");
		LocalDateTime datumheute2 = LocalDateTime.now();
		String pattern = "G EEEE', der 'dd'. 'MMMM' 'YYYY' - Kalenderwoche 'w' - ' H' Uhr, 'm' Minuten und 's' Sekunden.'";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		System.out.println(datumheute2.format(formatter));
		
		
	} // Ende der Main Methode

	


}
