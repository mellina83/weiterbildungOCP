package streams09;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @map(Function) Returns a stream consisting of the results of applying the
 *                given function to the elements of this stream.
 * 
 * 
 *                Mit der Map methode bekommt man aus einen Stream<X> einen
 *                Stream<Y>
 * 
 */
public class Demo06Map {

	public static void main(String[] args) {
		demoMap();

	}

	private static void demoMap() {
		Stream<String> streamOfStrings = Stream.of("aa", "aaaa", "aaa", "aaaaa");//

//		streamOfStrings.map(s -> s.getBytes())			//Stream<String> -> Stream<byte[]>
//					   .map(b-> b[0])                   //Stream<String> -> Stream<Byte>
//					   .map(b-> Character.valueOf((char)b.byteValue()))//Stream<Byte> -> Stream<Character>
//					   .forEach(System.out::println);

//		Function<String,Integer> mapper = s->s.length();
		Function<String, Integer> mapper = String::length;
		Stream<Integer> streamOfInteger = streamOfStrings.map(mapper);
		streamOfInteger.forEach(System.out::println);

		System.out.println("----------------");

		Stream.of("Hallo", "Welt", "hier", "ist", "Java").forEach(str -> System.out.println(str));
		
//		Function<String, StringBuilder> mapToSB = str -> new StringBuilder(str);
		Function<String, StringBuilder> mapToSB = StringBuilder::new;
		Stream.of("Hallo", "Welt", "hier", "ist", "Java")
			  .map(mapToSB)
			  .map(sb -> sb.reverse())
			  .map(sb -> sb.append(" Streams sind toll"))
			  .map(sb -> sb.toString())
			  .map(str -> str.replaceAll("e", "E"))
			  .forEach(System.out::println);
	}

}
