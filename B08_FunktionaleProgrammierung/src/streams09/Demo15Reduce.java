package streams09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Demo15Reduce {

	public static void main(String[] args) {
//		reduce01_Integer();
		
//		reduce01_String();
		
//		reduce02_Integer();
		
		reduce02_Kreis();

	}

	private static void reduce02_Kreis() {
		List<Kreis> list = Arrays.asList(new Kreis(11), new Kreis(12), new Kreis(13));
		
		BinaryOperator<Kreis> accumulator = (k1,k2) -> new Kreis(k1.getRadius()+k2.getRadius());
		
		Kreis identity = new Kreis(0);
		Kreis result = list.stream().reduce(identity, accumulator);
		System.out.println("reduce Kreis mit Accumulator und Identity: " + result);
	}

	private static void reduce02_Integer() {
		/**
		 * @param identity    the identity value for the accumulating function
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * @return the result of the reduction - T
		 */
		
		List<Integer> list = Arrays.asList(5, 6, 7, 8);
		
		/**
		 * Accumulator
		 */
		BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2;
		
		/**
		 * Identity
		 */
		Integer identity = 0;
		
		
		/**
		 * Daten 5,6,7,8 + identity = 0
		 * 
		 * Schritt 01: Identity(0) = apply(Identity(0),5) -> Identity(5)
		 * 
		 * Schritt 02: Identity(5) = apply(Identity(5),6) -> Identity(11)
		 * 
		 * Schritt 03: Identity(11) = apply(Identity(11),7) -> Identity(18)
		 * 
		 * Schritt 04: Identity(18) = apply(Identity(18),8) -> Identity(26)
		 * 
		 * return Identity(26)
		 */
		Integer result = list.stream().reduce(identity, accumulator);
		System.out.println("reduce mit Accumulator und Identity: " + result);
	}

	private static void reduce01_String() {
		/**
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * 
		 * @return an Optional<T> reduce(BinaryOperator<T> accumulator);
		 */
		
		List<String> list = Arrays.asList("Hallo", "Welt", "hier", "ist", "Java");
		
		/**
		 * Accumulator
		 */
		BinaryOperator<String> accumulator = (str1,str2) -> str1 + " | " +  str2;
		
		Optional<String> mayBeString = list.stream().reduce(accumulator);
		String result = mayBeString.get();
		System.out.println("reduce mit Accumulator: " + result);
	}

	/**
	 * 
	 * @reduce Performs a reduction on the elements of this stream, using an
	 *         associative accumulation function, and returns an Optional describing
	 *         the reduced value,if any.
	 * 
	 * 
	 *         Optional<T> reduce(BinaryOperator<T> accumulator);
	 */
	private static void reduce01_Integer() {
		/**
		 * @param accumulator an associative non-interfering stateless function for
		 *                    combining two values
		 * 
		 * @return an Optional describing the result of the reduction
		 */
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

		for (int i = 0; i < 500; i++) {
			list.add(new Random().nextInt(100));
		}
		
		/**
		 * Accumulator
		 */
		BinaryOperator<Integer> accumulator = (i1, i2) -> i1 + i2;
		BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;
		/**
		 * List 1,2,3,4
		 * 
		 * Optional.epmty();
		 * 
		 * Schritt 1: apply(Optional(0),1) -> Optional(0)+1 = Optional(1)
		 * 
		 * Schritt 2: apply(Optional(1),2) -> Optional(1)+2 = Optional(3)
		 * 
		 * Schritt 3: apply(Optional(3),3) -> Optional(3)+3 = Optional(6)
		 * 
		 * Schritt 4: apply(Optional(6),4) -> Optional(6)+4 = Optional(10)
		 * 
		 * return Optional(10)
		 */
		
		Optional<Integer> mayBeInt = list.stream().reduce(accumulator);
		System.out.println("reduce mit Accumulator: " + mayBeInt.get());//10
	}

}
