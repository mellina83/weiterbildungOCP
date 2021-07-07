package streams09;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @findAny() Returns an Optional describing some element of the stream, or an
 *            empty Optional if the stream is empty.
 * 
 *            The behavior of this operation is explicitly nondeterministic; it
 *            is free to select any element in the stream. This is to allow for
 *            maximal performance in parallel operations; the cost is that
 *            multiple invocations on the same source may not return the same
 *            result. (If a stable result is desired, use findFirst() instead.)
 * 
 * @findFirst() Returns an Optional describing the first element of this stream,
 *              or an empty Optional if the stream is empty. If the stream has
 *              no encounter order, then any element may be returned.
 * 
 * 
 *
 */
public class Demo14Find {

	public static void main(String[] args) {
		/**
		 * findFirst
		 */
		Optional<Integer> mayBe = Stream.of(42,-1,2,-3,4,-5).findFirst();
		System.out.println("first: " + mayBe.get());//42
		
		/**
		 * findAny
		 */
		Optional<String> mayBeString = Stream.of("believe", "asdf", "aa", "bb", "cc").findAny();
//		Optional<Object> mayBeString = Stream.empty().findAny();
		System.out.println("findAny : " + mayBeString.get());//
	}

}
