package ml.khalil.treeSet_Teil1;

import java.util.Set;
import java.util.TreeSet;

public class Person implements Comparable<Person> {
	private String name;
	private int age;

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
	public int compareTo(Person o) {
		
		return this.getName().compareTo(o.getName());
	}
	
		
		
	}

