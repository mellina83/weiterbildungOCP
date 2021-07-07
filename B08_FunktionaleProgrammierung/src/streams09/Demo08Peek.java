package streams09;

import java.util.stream.Stream;

/**
 * 
 * @peek(Consumer) Returns a stream consisting of the elements of this stream,
 *                 additionally performing the provided action on each element
 *                 as elements are consumed from the resulting stream.
 *
 */
public class Demo08Peek {

	public static void main(String[] args) {
//		demoOhneTerminal();
		demoMitTerminal();
	}

	private static void demoMitTerminal() {
		Stream.of(1,1,2,2,2,2,3,4,5,6,7,8,9,10)  				//Stream<Integer> 14
		      .limit(5)											//Stream<Integer> 5 (1,1,2,2,2)
		      .peek(i -> System.out.print(" peek i : " + i))    //Stream<Integer> 5 (1,1,2,2,2)
		      .filter(i-> i%2==0)							    //Stream<Integer> 3 (2,2,2)
		      .map(i -> "(" + i + ")")							//Stream<String> 3 ("(2)","(2)","(2)")
		      .peek(s -> System.out.print(" | peek s : " + s))  //Stream<String> 3 ("(2)","(2)","(2)")
		      .distinct()										//Stream<String> 1 ("(2)")
		      .forEach(s -> System.out.println(" | forEach s : " + s));//Stream<String> 1 ("(2)")
		
		
		
		
		
		
	}

	private static void demoOhneTerminal() {
		/**
		 * peek ist eine Intermediate Operation, wird also so nicht aktiviert.
		 */
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).peek(System.out::println);
		
	}

}
