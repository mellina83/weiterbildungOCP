package streams09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

class LittleDevil {
	int alter;

	public LittleDevil(int alter) {
		this.alter = alter;
	}

	public int getAlter() {
		return alter;
	}

	@Override
	public String toString() {
		return "LittleDevil getAlter = " + getAlter();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LittleDevil)) {
			return false;
		}
		LittleDevil tmpDevil = (LittleDevil) obj;
		return alter == tmpDevil.alter;
	}

	@Override
	public int hashCode() {
		return alter;
	}
}

public class Demo04Filter {

	public static void main(String[] args) {
//		demoFilter01();

		aufgabe01();

	}

	/**
	 * Bilden Sie bitte eine Pipeline, die nur die LittleDevils durchlässt, die
	 * EINZIGARTIG und dabei auch jünger als 2500 Jahre aber älter als 1111 Jahre
	 * sind
	 */
	private static void aufgabe01() {
		List<LittleDevil> bunchOfLittleDevils = createBunchOfDevils();

		Predicate<LittleDevil> youngerThan2500 = ld->ld.alter<2500;
		Predicate<LittleDevil> olderThan1111 = ld->ld.alter>1111;	
		
		long befor = System.currentTimeMillis();
		bunchOfLittleDevils
			.stream()
//			.distinct()
//			.filter(youngerThan2500.and(olderThan1111))
//			.filter(ld->ld.alter<2500 && ld.alter>1111)
			.filter(ld -> ld.alter > 1111)
			.filter(ld -> ld.alter < 2500)
			.count();
		long after = System.currentTimeMillis();
		System.out.println("Time elapsed : " +(after-befor));
	}

	/**
	 * @filter(Predicate) Returns a stream consisting of the elements of this stream
	 *                    that match the given predicate.
	 *
	 */
	private static void demoFilter01() {
		List<LittleDevil> bunchOfLittleDevils = createBunchOfDevils();

		/**
		 * Stream erzeugen
		 */
		bunchOfLittleDevils.stream();

		/**
		 * Alle LittleDevils die noch keine 100 Jahre alt sind, sollen ausgegeben
		 * werden.
		 */
		Predicate<LittleDevil> ageUnder100 = ld -> ld.alter < 100;
//		bunchOfLittleDevils.stream().filter(ageUnder100).forEach(System.out::println);

		/**
		 * Alle LittleDevils die noch keine 100 Jahre alt sind und ohne Doppelte
		 * Einträge
		 */
		bunchOfLittleDevils.stream().distinct().filter(ageUnder100).forEach(System.out::println);

		/**
		 * Alle LittleDevils die älter als 100 Jahre aber jünger als 5000 jahre sind.
		 */
		Predicate<LittleDevil> ageUnder5000 = ld -> ld.alter < 5000;
		Predicate<LittleDevil> ageOver100 = ageUnder100.negate();
		Predicate<LittleDevil> bothFilter = ageUnder5000.and(ageOver100);
//		bunchOfLittleDevils.stream().filter(bothFilter).forEach(System.out::println);
//		bunchOfLittleDevils.stream().filter(ageUnder5000).filter(ageOver100).forEach(System.out::println);
//		bunchOfLittleDevils.stream().filter(ageUnder5000.and(ageOver100)).forEach(System.out::println);

		/**
		 * Nun mit mehreren parallelen Threads.
		 */
		bunchOfLittleDevils.parallelStream().filter(ageUnder5000.and(ageOver100))
				.forEach(System.out::println);
	}

	private static List<LittleDevil> createBunchOfDevils() {
		List<LittleDevil> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(new LittleDevil(new Random().nextInt(10_000) + 1));
		}
		return list;
	}

}
