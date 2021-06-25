package pak03_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Demo01Iterator {
	public static void main(String[] args) {
		List<Person> personen = getList();
			
		/**
		 * Entfernen alle Personen die aelter als 25 sind mit einer Schleife
		 * 
		 * 6 Personen sollen entfernt werden
		 */
		personen.forEach(System.out::println);// 10 Personen
		
		//Wir veraendern die Indizes, dadurch Fehler moeglich
		//Wir muessen die Zaehlvariable waehrend der Schleife anpassen
//		for (int i = 0; i < personen.size(); i++) {
//			if(personen.get(i).getAge() > 25){
//				personen.remove(i--);
//			}
//		}
		
//		Iterator<Person> iter = personen.iterator();
//		while(iter.hasNext()) {
//			if(iter.next().getAge()> 25) {
//				iter.remove();
//			}
//		}
		
		//Lambda
		Predicate<Person> filter = (Person p) -> {return p.getAge()>25;};
		personen.removeIf(filter);
		
		
		
		System.out.println("\n****************\n");
		personen.forEach(System.out::println); //4 Personen

		
		
		
		
		
//		System.out.println("\n****************\n");
//		personenIterator();
	}
	
	
	public static List<Person> getList(){
		Person pers0 = new Person("Christian", 50);
		Person pers1 = new Person("Anna", 18);
		Person pers2 = new Person("Bertha", 50);
		Person pers3 = new Person("Bertha", 26);
		Person pers4 = new Person("Anna", 12);
		Person pers5 = new Person("Christian", 50);
		Person pers6 = new Person("Anna", 18);
		Person pers7 = new Person("Bertha", 50);
		Person pers8 = new Person("Bertha", 26);
		Person pers9 = new Person("Anna", 12);

		List<Person> personen = new ArrayList<>();

		personen.add(pers0);
		personen.add(pers1);
		personen.add(pers2);
		personen.add(pers3);
		personen.add(pers4);
		personen.add(pers5);
		personen.add(pers6);
		personen.add(pers7);
		personen.add(pers9);
		personen.add(pers8);
		
		return personen;
	}
	
	public static void personenIterator() {
		Person pers0 = new Person("Christian", 50);
		Person pers1 = new Person("Anna", 18);
		Person pers2 = new Person("Bertha", 50);
		Person pers3 = new Person("Bertha", 26);
		Person pers4 = new Person("Anna", 12);
		
		pers0.personHinterMir = pers1;
		pers1.personHinterMir = pers2;
		pers2.personHinterMir = pers3;
		pers3.personHinterMir = pers4;
		
		Person iter = pers0;
		while(iter.hasNext()) {
			System.out.println(iter);
			iter = iter.next();
		}
		
		System.out.println("---------------------");
		for(Person p: iter) {
			System.out.println(p);
		}
		
		
		
	}
}
