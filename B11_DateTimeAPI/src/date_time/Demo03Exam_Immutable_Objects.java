package date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Demo03Exam_Immutable_Objects {
	public static void main(String[] args) {
		localXXX();
	}

	private static void localXXX() {
		int year = 2021;
		int month = 7;
		int dayOfMonth = 19;

		LocalDate ld01 = LocalDate.of(year, month, dayOfMonth);
		LocalDate ld02 = LocalDate.of(year, Month.JULY, dayOfMonth);

		System.out.println("ld01: " + ld01); // 2021-07-19
		System.out.println("ld02: " + ld02); // 2021-07-19

		ld02.plusYears(17);// immutable, neues Objekt geht verloren

		System.out.println("ld02: " + ld02); // 2021-07-19
		System.out.println("ld02: " + ld02.plusYears(17));// 2038-07-19

		/*
		 * In der Klasse LocalDate koennen wir nicht mit Minuten, Stunden, Sekunden oder
		 * Nanos arbeiten. Die entprechenden Methoden sind nicht vorhanden.
		 */

		LocalDate ld03 = ld02.plus(17, ChronoUnit.YEARS);
//		ld03 = ld02.plusMinutes(10); //LocalDate hat kein plusMinutes() etc.
		System.out.println("ld03: " + ld03);

		System.out.println("ld02: " + ld02);
		LocalDate ld04 = ld02.plusDays(20);
		System.out.println("ld04: " + ld04);
		
		LocalDate ld05 = ld04.withYear(2000).withMonth(10).withDayOfMonth(20); //3 neue Objekte
		System.out.println("ld05: " + ld05);
		
		int hour = 9;
		int minute = 30;
		int second = 1;
		int nanoOfSecond = 12345;

		LocalTime lt01 = LocalTime.of(hour, minute, second, nanoOfSecond);

		System.out.println("lt01: " + lt01); // 09:30:01.000012345
		/*
		 * In der Klasse LocalTime koennen wir nicht mit Tagen, Monaten oder Jahren arbeiten.
		 * Die entprechenden Methoden sind nicht vorhanden.
		 */
		LocalTime lt02 = lt01.plusMinutes(240);
//		lt02 = lt01.plusYears(1);
		
		System.out.println("lt02: " + lt02); //13:30:01.000012345
		lt02 = lt01.plus(240, ChronoUnit.HALF_DAYS);
		System.out.println("lt02: " + lt02);
		
		year = 2021;
		month = 7;
		dayOfMonth = 17;
		hour = 10;
		minute = 15;
		second = 10;
		nanoOfSecond = 10;
		
		LocalDateTime ldt01 = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);
		
		ldt01.plusDays(20);
		ldt01.plusMinutes(20);
		
		System.out.println("ldt01: " + ldt01);//2021-07-17T10:15:10.000000010
		
		LocalDateTime ldt02 = ldt01.plusMonths(10);
		System.out.println("ldt02: " + ldt02);//2022-05-17T10:15:10.000000010
		
		LocalDateTime ldt03 = ldt01.plusMinutes(44000);
		System.out.println("ldt03: " + ldt03);
	}
}
