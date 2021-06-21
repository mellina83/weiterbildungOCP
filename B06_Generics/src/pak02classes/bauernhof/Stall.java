package pak02classes.bauernhof;

import java.util.ArrayList;
import java.util.List;

public class Stall<T extends AAnimal> {
	public List<T> listOfAnimals;
	
	public Stall() {
		listOfAnimals = new ArrayList<>();
	}
	
	public void add(T animal) {
		listOfAnimals.add(animal);
	}
	
	public T get(int index) {
		return listOfAnimals.get(index);
	}

	public void rundlauf() {
		for(T element : listOfAnimals) {
			//Kann wieder eine ClassCastException geben
			/*
			 * Ohne Upperbound ist das Element vom Typ Object
			 */
//			AAnimal s = (AAnimal)element;			
			/*
			 * Ohne Upper Bound haben wir durch
			 * Type Erasure nur Zugriff auf
			 * die Methoden von Object
			 */
			element.toString();
			
			/*
			 * Mit UpperBound ist element vom Typ AAnimal
			 */
			AAnimal a1 = element;
			/*
			 * Durch den Upper Bound haben 
			 * wir wieder Zugriff auf die Methoden aus AAnimal
			 */
			element.laufen();
			
		}
	}
	
}
