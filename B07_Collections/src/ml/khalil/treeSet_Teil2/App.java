package ml.khalil.treeSet_Teil2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class App {
	public static void main(String[] args) {
		Person p1=new Person();
		Person p2=new Person("lukas");
		Person p3=new Person("laura",30);
		List<Person> list =new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		ComparePersonNachAlles com1=new ComparePersonNachAlles();
		ComparePersonNachAlter com2=new ComparePersonNachAlter();
		ComparePersonNachName com3=new ComparePersonNachName();
         System.out.println("-------------------ComparePersonNachAlles-------------------------");
		Collections.sort(list,com1);
		list.stream().forEach(System.out::println);
		System.out.println("----------------ComparePersonNachAlter--------------------");
		Collections.sort(list,com2);
		list.stream().forEach(System.out::println);
		System.out.println("---------------------ComparePersonNachName-----------------------");
		Collections.sort(list,com3);
		list.stream().forEach(System.out::println);
		System.out.println("-------------------static_refMethod--------------------------");
		Comparator<Person> com4=App::static_refMethod;
		Collections.sort(list,com4);
		list.stream().forEach(System.out::println);
		System.out.println("-------------------instance_refMethod--------------------------");
		App app= new App();
		Comparator<Person> com5=app::instance_refMethod;
		Collections.sort(list,com4);
		list.stream().forEach(System.out::println);
	
		
	}
static public int static_refMethod(Person o1, Person o2) {
	 return Integer.compare(o1.getAge(), o2.getAge());
}
public int instance_refMethod(Person o1, Person o2) {
	 return Integer.compare(o1.getAge(), o2.getAge());}


	
}
