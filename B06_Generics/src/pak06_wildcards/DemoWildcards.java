package pak06_wildcards;

import java.util.ArrayList;
import java.util.List;

public class DemoWildcards {

	static void collectionProblem() {
		Animal[] animals = { new Dog(), new Dog() };
		takesArray(animals); // Ok, weil das Array vom Typ Animal ist
		/*
		 * Fuer diesen Fall haben Arrays eine java.lang.ArrayStoreException
		 */
		Dog[] dogs = { new Dog(), new Dog() };
		takesArray(dogs);

		// Bei Arrays ok
		animals = dogs;

//		List<Animal> list1 = new ArrayList<Dog>();

		List<Animal> list1 = new ArrayList<Animal>();
		List<Dog> doglist = new ArrayList<Dog>();

		takesCol(list1);
		// The method takesCol(List<Animal>) in the type DemoWildcards is not applicable
		// for the arguments (List<Dog>)
//		takesCol(doglist);

		takesColWildCard(doglist);
	}

	static void takesCol(List<Animal> list) {
		list.add(new Cat());
	}

	static void takesArray(Animal[] animals) {
		animals[0] = new Cat();
	}

	static void takesColWildCard(List<? extends Animal> list) {
		/*
		 * The method add(capture#1-of ? extends Animal) in the type List<capture#1-of ?
		 * extends Animal> is not applicable for the arguments (Cat)
		 */
//		list.add(new Cat());
//		list.add(new Object());
//		list.add(new Animal());
		list.add(null);
		Animal a = list.get(0);
		int gewicht = a.gewicht;
	}

	static void takesColWildCard2(List<? super Animal> list) {		
		list.add(new Cat());
		list.add(new Dog());
//		list.add(new Object());
		Animal a1 = new Dog();
		Animal a2 = new Cat();

		if (a1 instanceof Dog) {
			Dog d = (Dog) a1;
		}
	}

	static void takesColWildCard3(List<?> list) {
//		list.add(new Cat());
		Object o = list.get(0);
	}

	public static void main(String[] args) {
		collectionProblem();
	}
}

class Animal {
	int gewicht;
}

class Dog extends Animal {

}

class Cat extends Animal {

}