package data;

public class Dog {
	private String name;
	private int weight;
	private int age;

	// constructor assigns a name, weight and age
	public Dog(String name, int weight, int age) {
		this.name = name;
		this.weight = weight;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Dog [name=" + name + ", weight=" + weight + ", age=" + age + "]";
		//return name;
	}
}
