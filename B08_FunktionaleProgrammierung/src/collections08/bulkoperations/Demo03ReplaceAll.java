package collections08.bulkoperations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Demo03ReplaceAll {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,-5,9,-11,-55,-9,8,-3,-22);

		Consumer<Integer> output = i -> System.out.print(i + " ; ");
		
		list.forEach(output);
		
		System.out.println();
		
		UnaryOperator<Integer> inversion = t -> -t;
		
		UnaryOperator<Integer> absolute = Math::abs;
		
		list.replaceAll(absolute);
		list.forEach(output);

	}

}
