package excurs02_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DemoReflection {
	public static void main(String[] args) throws Exception{
		Class<Person> person = Person.class;
		Field[] fields = person.getDeclaredFields();
		
		for (int i = 0; i < fields.length; i++) {
			System.out.println(i + ": " + fields[i].getName());
		}
		
		Person p = new Person("Max", "Mustermann", 30);
		System.out.println("Max Alter: " + fields[2].getInt(p));
		fields[2].setInt(p, 100);
		System.out.println("Max Alter: " + p.age);
		
		fields[0].set(p, "Max geaenderter Vorname");
		System.out.println(p.firstName);
		
		fields[1].setAccessible(true);
		fields[1].set(p, "geaenderter Nachname");
		System.out.println(p.getLastName());
		
		String s = "Hallo";
		Class<?> stringClass = "".getClass();
		Field[] stringFields = stringClass.getDeclaredFields();
		stringFields[0].setAccessible(true);
		
		for (int i = 0; i < stringFields.length; i++) {
			System.out.println(i + ": " + stringFields[i].getName());
		}
		Object chars = stringFields[0].get(s);
		((char[])chars)[0] = 'A';
		System.out.println(s);
		
		System.out.println("-----------------------------");
		Method[] methods = p.getClass().getDeclaredMethods();
		
		for(Method m : methods) {
			System.out.println(m.getName());
			if(m.getName().equals("privMethod")) {
				m.setAccessible(true);
				m.invoke(p, null);
			}
		}
		
		Parameter param;
		
		Constructor<?> constructor = p.getClass().getConstructors()[0];
		Object p1 = constructor.newInstance("eins", "zwei", 0);
		
		Person p2 = (Person)p1;
		System.out.println(p2.firstName);
		
	}
}
