package ml.novytska.DateTimeAufgaben;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
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
public class Aufgabe01 {
	
	
	public static void main(String[] args) {
		LocalDate gt = LocalDate.of(2021, 01, 21);
		LocalDate ht = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ka = LocalDateTime.of(2021, 06, 07, 8, 00);
		LocalDateTime ha = LocalDateTime.now();
		
	    System.out.println("GeburtsTag : " + gt);
	    System.out.println("Heute Tag : " + ht);
	    System.out.println("Period : " + Period.between(ht, gt));
	    System.out.println("Anfang des Kurs : " + ka);
	    System.out.println("Heute TagTime : " + ha);
	    System.out.println("Instant : "+Instant.now());
	    System.out.println("Tages nach Anfang : "+ChronoUnit.DAYS.between(ka, ha));
	    System.out.println("Stunden nach Anfang : "+ChronoUnit.HOURS.between(ka, ha));
	    System.out.println("Minuten nach Anfang : "+ChronoUnit.MINUTES.between(ka, ha));
	    
	    
	    
	    LocalDate ld = LocalDate.of(2019, 03, 25);
	    
	    String datePattern = "EEEE' der 'dd'.'MMMM' 'yyyy'.'";
	    String timePattern = "'Die gegenwaertig Zeit ist: ' a HH:mm:ss";
	    System.out.println("Era : "+ld.getEra());
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
		
		System.out.println(ld.format(dateFormatter));
		System.out.println("KalenderWoche : "+ (ld.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR) + ".KW"));
		System.out.println(lt.format(timeFormatter));


	    
	}
}
