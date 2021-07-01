package function02.functions;

import java.util.function.Function;

import data.Dog;

import java.util.function.BiFunction;

/**
 * @function wird genutzt wenn wir die Parameter und die Rückgabe bestimmen
 *           wollen. z.B. Um Kopien einer Instanz zu erstellen
 * 
 * 
 *           E - Element
 * 
 *           T,U,S - Type
 * 
 *           K - Key
 * 
 *           V - Value
 * 
 *           R - Return
 */
public class Demo01Function {

	public static void main(String[] args) {
//		demoFunction01();
		demoBiFunction01();
	}

	private static void demoBiFunction01() {
//		BiFunction<T, U, R>
//		Type Parameters:
//		<T> the type of the first argument to the function
//		<U> the type of the second argument to the function
//		<R> the type of the result of the function
		BiFunction<Integer, Double, String> mengePreisRechner = (i, d) -> {
			Double tmp = i * d;
			return String.valueOf(tmp).concat(" €");
		};
		System.out.println(mengePreisRechner.apply(7, 0.42));

		BiFunction<Integer, Integer, Dog> dogFactory = (weight, age) -> new Dog("-----", weight, age);
		System.out.println(dogFactory.apply(55, 3));
		/*
		 * Wie können wir alle 3 Parameter für den Hund mit Lambda Realisieren?
		 */
		/*
		 * Not in the JDK, own Interface
		 */
		TriFunction<Integer, Integer, String, Dog> dogFullFactory = (weight, age, name) -> new Dog(name, weight, age);
		System.out.println(dogFullFactory.apply(42, 42, "Rex"));
		
		TriFunction<String,Integer,Integer, Dog> conRef = Dog::new;
	}

	private static void demoFunction01() {
//		Function<T, R>
//		Type Parameters:
//		<T> the type of the input to the function
//		<R> the type of the result of the function
//		R apply(T t);

		Function<Integer, Integer> imQuadrat = i -> i * i;

		int quadrat = imQuadrat.apply(123);
		System.out.println(quadrat);
		System.out.println(imQuadrat.apply(12));

		Function<Integer, String> digitToCurrency = i -> i + " €";
		System.out.println(digitToCurrency.apply(42));
		System.out.println(digitToCurrency.apply(42).getClass());

		Function<String, Dog> dogByName = name -> new Dog(name, -1, -1);
		Function<Integer, Dog> dogByAge = age -> new Dog("", -1, age);

		Dog d01 = dogByName.apply("Waldi");
		Dog d02 = dogByName.apply("Rex");
		Dog d03 = dogByAge.apply(4);
		System.out.println(d01);
		System.out.println(d02);
		System.out.println(d03);
	}

}
