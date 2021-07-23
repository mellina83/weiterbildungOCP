package fragen;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class App {
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2017, Month.NOVEMBER, 28);
		LocalDate d3 = d1.plusDays(3).with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println(d3 + ", ");
		LocalDate d4 = d1.minusMonths(11).with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println(d4 + ", ");
	}
}
