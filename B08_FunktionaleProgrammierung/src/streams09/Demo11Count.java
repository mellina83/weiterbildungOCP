package streams09;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @count() Returns the count of elements in this stream.
 *
 */
public class Demo11Count {

	public static void main(String[] args) {
//		demoCount01();
		demoCount02();

	}

	private static void demoCount02() {
		Integer[] intArray = { 1, 5, 9, 12, 16, 32, 23 };
		int[] primitiveIntArray = { 1, 5, 9, 12, 16, 32, 23 };

		/**
		 * Mit Stream die Summe alle Zahlen erhalten
		 */
		Stream<Integer> myStream01 = Stream.of(intArray);
		Optional<Integer> optInt = myStream01.reduce((i1,i2)-> i1+i2);
		optInt.ifPresent(System.out::println);
		
		IntStream  myStream02 = Arrays.stream(primitiveIntArray);
		OptionalDouble optAve = myStream02.average();
		System.out.println(optAve.getAsDouble());
	}

	private static void demoCount01() {
		Integer[] intArray = { 1, 5, 9, 12, 16, 32, 23 };
		long count = Arrays.stream(intArray).count();

		System.out.println("Anzahl der Elemente : " + count);

		count = Stream.of("aa", "aaa", "aa", "aaaa", "aa").map(String::length).filter(i -> i % 2 == 0)
				.distinct().count();
		System.out.println("Anzahl der Elemente : " + count);

		int[] primitiveIntArray = { 1, 5, 9, 12, 16, 32, 23 };
		IntStream myStream = Arrays.stream(primitiveIntArray);
	}

}
