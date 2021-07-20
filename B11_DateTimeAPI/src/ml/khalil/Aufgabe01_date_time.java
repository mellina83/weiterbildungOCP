package ml.khalil;

import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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
 *            können.
 * 
 *            Erzeugen Sie den Formatter mit einem Pattern.
 * 
 *            Es soll die ERA ausgegeben werden.
 * 
 *            Gefolgt vom Datum 'Montag der 25. März 2019'
 * 
 *            Als nächstes soll die Kalenderwoche ausgegeben werden - '13. KW'
 * 
 *            Abschliessend hängen Sie die Uhrzeit mit an.
 * 
 * 
 */
public class Aufgabe01_date_time {
public static void main(String[] args) {
	/**
	 *  @Aufgabe01 Tage zwischen Ihren Geburtstag und Heute berechen. Geben Sie die
     *            werte in Jahre, Monate und Tage aus. Einmal berechnen Sie die Tage
     *           seit ihrer Geburt, einmal seit ihren letzten Geburtsag
	 */
	LocalDate geburtstag=LocalDate.of(1989, 02, 01);
	LocalDate heute=LocalDate.now();
	LocalDate letzter_geburtstag=LocalDate.of(2021, 02, 01);

	Period p=Period.between( geburtstag,heute);
	Period p1=Period.between( letzter_geburtstag,heute);
	System.out.println("Geburtstag : "+geburtstag);
	System.out.println("Heute : "+heute);
	//System.out.println(p1);
	System.out.println("Tage zwischen Geburtstag und Heute : "+(p.toTotalMonths()*30+p.getDays()));
	System.out.println("Tage zwischen letzter Geburtstag und Heute : "+(heute.getDayOfYear()-letzter_geburtstag.getDayOfYear()));
	System.out.println("-----------------------@Aufgabe02--------------------------");
	/**
	 *  @Aufgabe02 Tage zwischen Heute (.now()) und Kursanfang '07.06.2021 08:00'
 *            berechnen. Geben Sie die werte jeweils in Tage, Stunden & Minuten
 *            aus.
	 */
	LocalDate kursanfang_date=LocalDate.of(2021, 06, 07);
	LocalTime  kursanfang_time=LocalTime.of(8, 0);
	Duration d=Duration.between(kursanfang_time, LocalTime.now());
	
	System.out.println("Tage zwischen Heute und Kursanfang '07.06.2021 08:00' : "+
	(heute.getDayOfYear()-kursanfang_date.getDayOfYear())+"  Tage " +d);
	
	
  System.out.println("--------------------------------------------------------------------------");
  /**
   *  @Aufgabe03 DateTimeFormatter Erzeugen Sie einen DateTimeFormatter womit Sie
 *            sich ein beliebiges Datum mit beliebigen Locales Ausgeben lassen
 *            können.
 * 
 *            Erzeugen Sie den Formatter mit einem Pattern.
 * 
 *            Es soll die ERA ausgegeben werden.
 * 
 *            Gefolgt vom Datum 'Montag der 25. März 2019'
 * 
 *            Als nächstes soll die Kalenderwoche ausgegeben werden - '13. KW'
 * 
 *            Abschliessend hängen Sie die Uhrzeit mit an.
 * 
   */
  String date_timePattern = "EEEE' der 'dd MMMM yyyy ";
  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(date_timePattern,Locale.GERMANY);
  //System.out.println(kursanfang.format(dateFormatter));
  
}

}
