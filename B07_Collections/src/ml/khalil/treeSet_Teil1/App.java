package ml.khalil.treeSet_Teil1;

import java.util.*;

public class App {

	public static void main(String[] args) {
		//person_treeSet();
		//person_array();
		person_list();

	}
	static void person_treeSet() {
		Person p1=new Person();
		Person p2=new Person("lukas");
		Person p3=new Person("laura",30);
		Set<Person> set=new  TreeSet<>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.stream().forEach(System.out::println);
	}
	static void person_array() {
		Person p1=new Person();
		Person p2=new Person("lukas");
		Person p3=new Person("laura",30);
		Person arr[]= {p1,p2,p3};
		Arrays.sort(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}
	static void person_list() {
		Person p1=new Person();
		Person p2=new Person("lukas");
		Person p3=new Person("laura",30);
		List<Person> list =new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Collections.sort(list);
		list.stream().forEach(System.out::println);
	}
}
