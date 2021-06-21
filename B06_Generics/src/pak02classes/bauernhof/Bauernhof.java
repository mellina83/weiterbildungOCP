package pak02classes.bauernhof;

public class Bauernhof {
	public static void main(String[] args) {
		Schwein s1 = new Schwein("Piggeldy", 12);
		Schwein s2 = new Schwein("Frederick", 8);
		Schwein s3 = new Schwein("Babe", 4);

		Kuh k1 = new Kuh("Sonja", 6);
		Kuh k2 = new Kuh("Helga", 6);
		Kuh k3 = new Kuh("Doris", 6);

		Schaf sch01 = new Schaf("Dolly", 5);
		Schaf sch02 = new Schaf("Julia", 5);
		Schaf sch03 = new Schaf("Fergie", 5);

		Stall stall = new Stall();
		stall.listOfAnimals.add(s1);
		stall.listOfAnimals.add(k1);
		stall.listOfAnimals.add(sch01);
		Object o1 = stall.get(0); // Object

		// ClassCastException
//		Kuh k4 = (Kuh)stall.listOfAnimals.get(0);

		Stall<AAnimal> animalStall = new Stall<>();

		animalStall.add(s1);
		animalStall.add(k1);
		animalStall.add(sch01);
		AAnimal a1 = animalStall.get(0); // AAnimal
		// Kuh k4 = (Kuh)animalStall.get(0);//ClassCastException

		/*
		 * Hier koennen nur Kuehe oder Kinder von Kuehen rein Und es kommen Kuehe raus
		 */
		Stall<Kuh> kuhStall = new Stall<>();
		kuhStall.add(k1);
		kuhStall.add(k2);
		kuhStall.add(k3);
		/*
		 * Hier koennen nur Schweine oder Kinder von Schweine rein Und es kommen Schwein
		 * raus
		 */
		Stall<Schwein> schweineStall = new Stall<>();
		schweineStall.add(s1);
		schweineStall.add(s2);
		schweineStall.add(s3);
		/*
		 * Hier koennen nur Schafe oder Kinder von Schafen rein Und es kommen Schafe
		 * raus
		 */
		Stall<Schaf> schafStall = new Stall<>();
		schafStall.add(sch01);
		schafStall.add(sch02);
		schafStall.add(sch03);

		// Hier ist jetzt ganz sicher eine Kuh drin
		Kuh k5 = kuhStall.get(0);
		// Hier ist jetzt ganz sicher ein Schwein drin
		Schwein s5 = schweineStall.get(0);
		// Hier ist jetzt ganz sicher ein Schaf drin
		Schaf sch5 = schafStall.get(0);

		/*
		 * Bound mismatch: The type Integer is not a valid substitute for the bounded
		 * parameter <T extends AAnimal> of the type Stall<T>
		 */
//		Stall<Integer> integerStall;
		/*
		 * Bound mismatch: The type Object is not a valid substitute for the bounded
		 * parameter <T extends AAnimal> of the type Stall<T>
		 */
//		Stall<Object> objStall;
		
		System.out.println("----------------AAnimal rundlauf()--------------------");
		animalStall.rundlauf();
		
		System.out.println("----------------Schwein rundlauf()--------------------");
		schweineStall.rundlauf();
		
		
	}
}
