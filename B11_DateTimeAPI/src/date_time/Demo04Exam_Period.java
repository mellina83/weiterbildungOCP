package date_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Demo04Exam_Period {
	public static void main(String[] args) {
		Period period = Period.ofDays(30).minusDays(12).plusDays(2).minusYears(4);
		
		System.out.println(period.negated());
		
		System.out.println(period);
		//Wie viele Objekte sind fuer die GC verfuegbar?
		//Antwort: 4
		
		Period pWeeks = Period.ofWeeks(2);
		LocalDate ldt = LocalDate.now();
		
		System.out.println(ldt.plus(2, ChronoUnit.WEEKS));
		System.out.println(ldt.plus(14,ChronoUnit.DAYS));
		System.out.println(ldt.plus(pWeeks));
		
		LocalDate ldt02 = LocalDate.of(2021, 8, 10);
		Period between = Period.between(ldt, ldt02);
		System.out.println(between);
		System.out.println("Jahre: " + between.getYears());
		System.out.println("Monate: " + between.getMonths());
		System.out.println("Tage: " + between.getDays());
		
		
		
		
	}
}
