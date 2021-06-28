package aufgaben.a02.loesung;

import java.util.Scanner;

public class Bestellung {
	static int counter;
	static int eing1;
	static int eing2;
	static int eing3;
	static double summe;

	public static void main(String[] args) {

		summe = 0;
		counter = 0;

		MyLiFo<String> pizza = new MyLiFo<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("bitte ein Topping ausw�hlen :");
		System.out.println();

		Topping[] belag = Topping.values();
		for (Topping e : belag) {
			System.out.println(
					e.ordinal() + 1 + " = " + e.name() + "(" + e.getPrice() + " Euro)");
			counter++;
		}
		System.out.println();
		System.out.println("0 = Ende");
		System.out.println();

		do {
			do {
				eing1 = sc.nextInt();
			} while (eing1 < 0 || eing1 > counter);
			if (eing1 != 0) {
				pizza.add(belag[eing1 - 1].name());
				summe += belag[eing1 - 1].getPrice();
			}
		} while (eing1 != 0);

		System.out.println("Die Pizza kostet : " + summe);

		pizza.reverse();
		System.out.println();
		System.out.println("Belagreihenfolge : ");
		pizza.forEach(System.out::println);

	}

}
