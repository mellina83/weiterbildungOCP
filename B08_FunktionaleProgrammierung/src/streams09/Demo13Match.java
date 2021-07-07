package streams09;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * @allMatch(Predicate) Returns whether all elements of this stream match the
 *                      provided predicate. May not evaluate the predicate on
 *                      all elements if not necessary for determining the
 *                      result. If the stream is empty then true is returned and
 *                      the predicate is not evaluated. -boolean
 *
 * @anyMatch(Predicate) Returns whether any elements of this stream match the
 *                      provided predicate. May not evaluate the predicate on
 *                      all elements if not necessary for determining the
 *                      result. If the stream is empty then false is returned
 *                      and the predicate is not evaluated. -boolean
 *
 * @noneMatch(Predicate) Returns whether no elements of this stream match the
 *                       provided predicate. May not evaluate the predicate on
 *                       all elements if not necessary for determining the
 *                       result. If the stream is empty then true is returned
 *                       and the predicate is not evaluated. -boolean
 */
public class Demo13Match {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10_000; i++) {
			list.add(new Random().nextInt(600_000 + 1));// 0-600_000
		}

		Predicate<Integer> lowerThan600K = i -> i < 600_000;

		Predicate<Integer> evenNumber = i -> {
			System.out.println("Even ? " + i);
			return i % 2 == 0;
		};

		System.out.println(" allMatch");
		boolean isLower = list.stream().allMatch(lowerThan600K);
		System.out.println("All items are Lower than 600_000 : " + isLower);
		boolean allEven = list.stream().allMatch(evenNumber);
		System.out.println("All numbers are Even ? " + allEven);
		
		System.out.println("\n anyMatch");
		boolean anyEven = list.stream().anyMatch(evenNumber);
		System.out.println("Any numbers are Even ? " + anyEven);
		
		System.out.println("\n noneMatch");
		boolean noneEven = list.stream().noneMatch(evenNumber);
		System.out.println("None numbers are Even ? " + noneEven);
	}

}
