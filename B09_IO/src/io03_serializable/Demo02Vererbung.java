package io03_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal { // Basisklasse - Superclass - Oberklasse - Elternklasse
	public String name;

	public Animal() {
		System.out.println("Animal Default-Konstruktor");
		name = "Wurde nicht gesetzt";
	}

	public Animal(String name) {
		System.out.println("Animal 1-Arg-Konstruktor");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}
}

class Dog extends Animal implements Serializable {

	public int age;

	public Dog() {
		super("Rex");
		System.out.println("Dog Constructor");
	}

	public Dog(String name) {
		super(name);
		System.out.println("Dog Constructor");
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
}

public class Demo02Vererbung {

	public static void main(String[] args) throws Exception {
		String file = "./serializable/dog";

		Dog dog01 = new Dog("Hasso");
		dog01.age = 12;
		
		System.out.println("vor dem serialisieren :" + dog01);
		
		/**
		 * serialisieren
		 */
		object2File(file, dog01);
		
		/**
		 * Deserialisieren
		 */
		System.out.println("Deserialisieren");
		Dog dog02 =(Dog) file2Object(file);
		System.out.println(dog02);
	}

	private static Object file2Object(String file) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

	private static void object2File(String file, Dog dog01) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
		oos.writeObject(dog01);
		oos.close();
		System.out.println("Objekt wurde Serialisiert");
	}

}
