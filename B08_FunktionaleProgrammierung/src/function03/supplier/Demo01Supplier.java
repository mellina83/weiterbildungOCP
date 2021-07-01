package function03.supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import data.Dog;
import data.Utility;

class Person {
	private String name;

	public Person() {
		this.name = "Hugo";
	}

	public Person(String name) {
		this.name = name;
	}
}

public class Demo01Supplier {

	public static void main(String[] args) {
		demoSupplier01();
	}

	private static void demoSupplier01() {
//		Supplier<T>
//		Type Parameters:
//		<T> the type of results supplied by this supplier
//	    T get();

		Supplier<Person> pSupplier = () -> new Person("Kurt");
		Supplier<Person> pConRef = Person::new;

		Person p01 = pConRef.get();
		Person p02 = pConRef.get();
		Person p03 = pConRef.get();

		System.out.println(p01.hashCode());
		System.out.println(p02.hashCode());
		System.out.println(p03.hashCode());

		Utility.useSupplier(pSupplier);
		Utility.useSupplier(() -> new Dog("Waldi", 42, 4));
		Utility.useSupplier(() -> LocalDate.now());
		Utility.useSupplier(LocalDateTime::now);
	}

}
