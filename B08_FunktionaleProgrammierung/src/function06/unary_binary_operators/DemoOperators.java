package function06.unary_binary_operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import data.Utility;

/**
 * @UnaryOperator Represents an operation on a single operand that produces a
 *                result of the same type as its operand.
 *
 * @BinaryOperator Represents an operation upon two operands of the same type,
 *                 producing a result of the same type as the operands
 */
public class DemoOperators {

	public static void main(String[] args) {
//		demoUnary01();
//		demoUnary02();
//		demoUnary03();

//		demoBinaryOperator01();
//		demoBinaryOperator02();

//		demoReduce01();
		demoReduce02();
	}

	private static void demoReduce02() {
		List<Integer> list = Arrays.asList(1, 2, 39, 5);
		
		BinaryOperator<Integer> addierer = (t, u) -> t + u;
		
		/**
		 * Alle werte Summiert bekommen.
		 */
		// 1 , 2 ,39 ,5
		Integer sum = list.stream().reduce(0,addierer);
		System.out.println(sum);
	}

	private static void demoReduce01() {
//		List<Integer> list = Arrays.asList(2, -12, -45, 24, -79, -99, 123, -771, 2, -12, -45, 24, -79, -99,
//				123, -771);
		// (2, -12, -45, 24, -79, -99, 123, -771, 2, -12, -45, 24, -79, -99, 123, -771)
		// Alle doppelten entfernen
		// (2, -12, -45, 24, -79, -99, 123, -771)
		// alle einträge zählen
		// result 8
		// Anzahl der geraden Einträge
		List<Integer> list = new ArrayList<>();
		Utility.befuellen(list);
		
		Predicate<Integer> even = i -> i % 2 == 0;
		
		Set<Integer> uniques = new HashSet<>(list);
		int sum=0;

		
		for (Integer integer : uniques) {
			if(even.test(integer)) {
				sum++;
			}
		}
		System.out.println("Set result = " + uniques.size());
		System.out.println("Set Anzahl der geraden Einträge = " + sum);
	
		Stream<Integer> myStream = list.stream();
		
		long result = list.stream().distinct().count();
		long evenresult = list.parallelStream().distinct().filter(even).count();
		System.out.println("Stream result " + result);
		System.out.println("Stream Anzahl der geraden Einträge = " + evenresult);
	}

	private static void demoBinaryOperator02() {
		BinaryOperator<Kreis> kreisAccumulator = (k1, k2) -> new Kreis(k1.getRadius() + k2.getRadius());

		/**
		 * Hier sollen die beiden Kreise k01 und k02 zusammengeführt werden. K03 soll
		 * den gesamt Radius der beiden Instanzen erhalten. Die Radien der instanzen k01
		 * und k02 sollen addiert werden
		 */
		Kreis k01 = new Kreis(9);
		Kreis k02 = new Kreis(6);

		Kreis k03 = kreisAccumulator.apply(k01, k02);
		System.out.println(k01);
		System.out.println(k02);
		System.out.println(k03);

		/**
		 * Es werden die beiden Operanden verglichen und der 'Größere' wird als
		 * Referenzkopie zurückgegeben
		 */
		BinaryOperator<Kreis> maxKreis = BinaryOperator.maxBy(Kreis::compareTo);
		BinaryOperator<Kreis> minKreis = BinaryOperator.minBy(Kreis::compareTo);

		Kreis k04 = maxKreis.apply(k01, k03);
		Kreis k05 = minKreis.apply(k01, k03);
		System.out.println(k04);// 15
		System.out.println(k05);// 9
	}

	private static void demoBinaryOperator01() {
		BinaryOperator<Number> ganzZahlAddierer = (x, y) -> x.longValue() + y.longValue();

		BinaryOperator<Number> maxValue = (x, y) -> {
//			if(x.longValue()>y.longValue()) {
//				return x;
//			} else {
//				return y;
//			}

//			return (x.longValue()>y.longValue()) ? x : y;

			return Math.max(x.longValue(), y.longValue());
		};
		BinaryOperator<Long> maxValue02 = Math::max;

		float f01 = 4500000.0F;
		float f02 = 78.9F;

		long l01 = 12345678;
		long l02 = 78;

		Number addiert = ganzZahlAddierer.apply(f01, f02);
		System.out.println(addiert);// 4500078

		Number max = maxValue.apply(l01, f01);
		System.out.println(max);
	}

	private static void demoUnary03() {
		UnaryOperator<Integer> inversion = (i) -> -i;
		List<Integer> list = new ArrayList<>(
				Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE, -12, -45, 24, -79, -99, 123, -771));

		System.out.println(list);
		list.replaceAll(inversion);
		System.out.println(list);
		list.replaceAll((i) -> new Random().nextInt(12345));
		System.out.println(list);

	}

	private static void demoUnary02() {
		Function<Integer, Integer> inversionFunc = i -> -i;
		UnaryOperator<Integer> inversion = i -> -i;

		System.out.println(inversion instanceof Function);
		System.out.println(inversion instanceof UnaryOperator);

		Integer origin = 12345;
		Integer negativ = inversion.apply(origin);
		System.out.println(origin);
		System.out.println(negativ);
		System.out.println(inversion.apply(negativ));
	}

	private static void demoUnary01() {
		/**
		 * Ich möchte einen String umdrehen.
		 */
		String origin = "Hallo Welt";

		Function<String, String> toReverseFunc;
		UnaryOperator<String> reverseOperator = (s) -> new StringBuilder(s).reverse().toString();

		String reversed = reverseOperator.apply(origin);
		System.out.println(reversed);
		System.out.println(reverseOperator.apply("Hier ist Java"));

	}

}
