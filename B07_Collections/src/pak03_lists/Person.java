package pak03_lists;

import java.util.Iterator;

public class Person implements Iterator<Person>, Iterable<Person>{
	private String name;
	private int age;
	
	public Person personHinterMir;

	public Person() {
		this("Hans",55);
	}
	
	public Person(String name) {
		this(name,55);
	}
	
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Person [getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

	@Override
	public boolean hasNext() {
		return personHinterMir != null;
	}

	@Override
	public Person next() {
		return personHinterMir;
	}

	@Override
	public Iterator<Person> iterator() {	
		System.out.println("Test");
		return personHinterMir;
	}
}
