package excurs02_reflection;

public class Person {
	public String firstName;
	private String lastName;
	public int age;
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	private void privMethod() {
		System.out.println("Hier kommt keiner ran, ich bin private");
	}
	
}
