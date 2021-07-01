package function01.predicate.oca;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import data.Dog;

public class Demo01Dogs {

	public static void main(String[] args) {
		List<Dog> dogs = new ArrayList<>();

		dogs.add(new Dog("boi", 30, 6));
		dogs.add(new Dog("tyri", 40, 12));
		dogs.add(new Dog("charis", 120, 7));
		dogs.add(new Dog("aiko", 50, 10));
		dogs.add(new Dog("clover", 35, 12));
		dogs.add(new Dog("mia", 15, 4));
		dogs.add(new Dog("zooey", 45, 9));

		// run a few OLD "queries"
		System.out.println("all dogs " + dogs);
		/*
		 * Alle Hunde mit einen mindest Alter von xxx
		 */
		System.out.println("min age 7 " + minAge(dogs, 7));
		/*
		 * Alle Hunde mit einen maximal Gewicht von xxx
		 */
		System.out.println("max weight 40 " + maxWeight(dogs, 40));
		/*
		 * Alle Hunde mit einen minimal Gewicht von xxx
		 */
		System.out.println("min weight 40 " + minWeight(dogs, 40));

		// Some new queries with Lambda
		System.out.println("Mit Lambda");
		System.out.println("max age 7 " + dogQuery(dogs, (d) -> d.getAge() <= 7));
		System.out.println("min age 9 " + dogQuery(dogs, (d) -> d.getAge() >= 9));
		System.out.println("Name contains i " + dogQuery(dogs, (d) -> d.getName().contains("i")));
		System.out.println("Name endsWith a " + dogQuery(dogs, (d) -> d.getName().endsWith("a")));
	}

	private static List<Dog> minAge(List<Dog> dogs, int testFor) {
		ArrayList<Dog> result = new ArrayList<>();
		for (Dog d : dogs) {
			if (d.getAge() >= testFor) {// the key moment!
				result.add(d);
			}
		}
		return result;
	}

	private static List<Dog> maxWeight(List<Dog> dogs, int testFor) {
		ArrayList<Dog> result = new ArrayList<>();
		for (Dog d : dogs) {
			if (d.getWeight() <= testFor) {// the key moment!
				result.add(d);
			}
		}
		return result;
	}

	private static List<Dog> minWeight(List<Dog> dogs, int testFor) {
		ArrayList<Dog> result = new ArrayList<>();
		for (Dog d : dogs) {
			if (d.getWeight() >= testFor) {// the key moment!
				result.add(d);
			}
		}
		return result;
	}

	private static List<Dog> dogQuery(List<Dog> dogs, Predicate<Dog> lambdaExpression) {
		ArrayList<Dog> result = new ArrayList<>();
		for (Dog d : dogs) {
			if (lambdaExpression.test(d)) {// the key moment!
				result.add(d);
			}
		}
		return result;
	}
}