package function05.alltogether;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import data.Dog;

/**
 * @predicate wird genutzt um boolsche Tests durchzuführen. Z.B. Für Filter
 * 
 * 
 * @function wird genutzt wenn wir die Parameter und die Rückgabe bestimmen
 *           wollen. z.B. Um Kopien einer Instanz zu erstellen
 * 
 * @supplier wird genutzt, wenn etwas von einem Bestimmten Rückgabetyp geliefert
 *           werden soll. z.B. Aufruf eines Standard Konstruktors
 * 
 * @consumer wird genutzt, wenn wir von der Operation keine Rückgabe erwarten.
 *           z.B. Bei der Ausgabe auf der Console
 *
 */
public class Demo01AllTogether {

	static Supplier<Dog> dogSupplier = () -> {
		return new Dog("Bello", -1, -1);
	};

	public static void main(String[] args) {
		List<Dog> dogs = new ArrayList<>();
		fillDogs(dogs);

//		demo_Predicate(dogs);
//		demo_Predicate_Function(dogs);
//		demo_Predicate_Function_Supplier(dogs);
		demo_Predicate_Function_Supplier_Consumer(dogs);
	}

	private static void demo_Predicate_Function_Supplier_Consumer(List<Dog> dogs) {
		/**
		 * Zum filtern der Instanzen nach bestimmten kriterien
		 */
		Predicate<Dog> ageOverTen = d -> d.getAge() > 10;

		/**
		 * Wir wollen beim übertragen der Instanzen in eine andere Liste, neue Instanzen
		 * erzeugen lassen statt nur eine Referenzkopie zu erhalten
		 */
		Function<Dog, Dog> dogClone = (d) -> {
			return new Dog(d.getName(), d.getWeight(), d.getAge());
		};

		/**
		 * Die Metoden Referenz auf System.out::println nutzt die toString() Methode der
		 * Klasse
		 * 
		 * Über die Lambda Variante haben wir Zentrale möglichkeit die Ausgabe zu
		 * steuern, unabhängig von der toString() methode der Klasse
		 */
		Consumer<Dog> cOutput01 = System.out::println;
		Consumer<Dog> cOutput02 = (d) -> System.out
				.print(d.getName() + " : " + d.getAge() + " : " + d.getWeight() + " | ");

		Consumer<Dog> writeToCSV = (d) -> System.out.print(d.getName() + ";" + d.getAge() + ";" + d.getWeight() + "\n");

		File file = new File("dogs.txt");
		PrintWriter pw;
		Consumer<Dog> writeToFile = null;
		try {
			pw = new PrintWriter(new FileWriter(file),true);
			writeToFile = (d) -> {
				pw.println(d);
			};
		} catch (Exception e) {
			
		}

		List<Dog> oldDogs = new ArrayList<>();

		dogs.forEach(dog -> {
			if (ageOverTen.test(dog)) {
				oldDogs.add(dogClone.apply(dog));
			}
		});

//		System.out.println("dogs = " + dogs);
		dogs.forEach(cOutput02);
		System.out.println();
//		System.out.println("oldDogs = " + oldDogs);
		oldDogs.forEach(cOutput02);
		System.out.println();
		for (Dog dog : oldDogs) {
			dog.setWeight(90);
		}
		for (int i = 0; i < 6; i++) {
			oldDogs.add(dogSupplier.get());
		}

		System.out.println("---------------");
//		System.out.println("dogs = " + dogs);
		dogs.forEach(writeToCSV);
		System.out.println();
//		System.out.println("oldDogs = " + oldDogs);
		oldDogs.forEach(writeToFile);

	}

	private static void demo_Predicate_Function_Supplier(List<Dog> dogs) {
		/**
		 * Zum filtern der Instanzen nach bestimmten kriterien
		 */
		Predicate<Dog> ageOverTen = d -> d.getAge() > 10;

		/**
		 * Wir wollen beim übertragen der Instanzen in eine andere Liste, neue Instanzen
		 * erzeugen lassen statt nur eine Referenzkopie zu erhalten
		 */
		Function<Dog, Dog> dogClone = (d) -> {
			return new Dog(d.getName(), d.getWeight(), d.getAge());
		};

		/**
		 * Siehe statisches Attribut
		 */
//		Supplier<Dog> dogSupplier = () -> {
//			return new Dog("Bello", -1, -1);
//		};

		List<Dog> oldDogs = new ArrayList<>();

		dogs.forEach(dog -> {
			if (ageOverTen.test(dog)) {
				oldDogs.add(dogClone.apply(dog));
			}
		});

		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);

		for (Dog dog : oldDogs) {
			dog.setWeight(90);
		}
		for (int i = 0; i < 6; i++) {
			oldDogs.add(dogSupplier.get());
		}

		System.out.println("---------------");
		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);

	}

	private static void demo_Predicate_Function(List<Dog> dogs) {
		/**
		 * Zum filtern der Instanzen nach bestimmten kriterien
		 */
		Predicate<Dog> ageOverTen = d -> d.getAge() > 10;

		/**
		 * Wir wollen beim übertragen der Instanzen in eine andere Liste, neue Instanzen
		 * erzeugen lassen statt nur eine Referenzkopie zu erhalten
		 */
		Function<Dog, Dog> dogClone = (d) -> {
			return new Dog(d.getName(), d.getWeight(), d.getAge());
		};

		List<Dog> oldDogs = new ArrayList<>();

		dogs.forEach(dog -> {
			if (ageOverTen.test(dog)) {
				oldDogs.add(dogClone.apply(dog));
			}
		});

		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);

		for (Dog dog : oldDogs) {
			dog.setWeight(90);
		}

		System.out.println("---------------");
		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);

	}

	private static void demo_Predicate(List<Dog> dogs) {
		/**
		 * Zum filtern der Instanzen nach bestimmten kriterien
		 */
		Predicate<Dog> ageOverTen = d -> d.getAge() > 10;

		List<Dog> oldDogs = new ArrayList<>();

//		for (Dog dog : dogs) {
//			if (ageOverTen.test(dog)) {
//				oldDogs.add(dog);
//			}
//		}

		dogs.forEach(dog -> {
			if (ageOverTen.test(dog)) {
				oldDogs.add(dog);
			}
		});

		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);

		for (Dog dog : oldDogs) {
			dog.setWeight(90);
		}

		System.out.println("---------------");
		System.out.println("dogs = " + dogs);
		System.out.println("oldDogs = " + oldDogs);
	}

	private static void fillDogs(List<Dog> dogs) {
		dogs.add(new Dog("boi", 30, 6));
		dogs.add(new Dog("tyri", 40, 12));
		dogs.add(new Dog("charis", 120, 7));
		dogs.add(new Dog("aiko", 50, 10));
		dogs.add(new Dog("clover", 35, 12));
		dogs.add(new Dog("mia", 15, 4));
		dogs.add(new Dog("zooey", 45, 9));
	}
}
