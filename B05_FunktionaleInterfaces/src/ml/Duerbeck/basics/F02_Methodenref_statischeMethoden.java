package ml.Duerbeck.basics;

//Voraussetzungen
//Methode muss statisch sein
//Rueckgabetyp und Argumentenliste muessen identisch sein

interface MyConsumer01 {
	void consume(Person p);
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class F02_Methodenref_statischeMethoden {

	private static void schwaerzeNamen(Person p) {
		System.out.println("Name: XXXX");
		System.out.println("Alter: " + p.age);
	}

	public static void main(String[] args) {
		Person[] persons = { new Person("Al", 12), new Person("Tim", 5), new Person("Sam", 8) };
		MyConsumer01 mc = F02_Methodenref_statischeMethoden::schwaerzeNamen;
		mc.consume(persons[0]);
	}
}


