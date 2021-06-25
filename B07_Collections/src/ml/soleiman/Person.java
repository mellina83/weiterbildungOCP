package ml.soleiman;

public class Person implements Comparable<Person>{
	private String name;
	private int age;

	public Person() {
		this("Hans", 55);
	}

	public Person(String name) {
		this(name, 55);
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
		//return (this.getAge()+"").compareTo(o.getAge()+"");
//		return this.getAge()>o.getAge()?1:this.getAge()<o.getAge()?-1:0;
		return Integer.compare(this.getAge(), o.getAge());
//		return (this.getName()).compareTo(o.getName());
		
	}
}

//Teil 1
//Stellen Sie die Person Klasse so um, das diese in einem TreeSet verwendet werden kann.
//Erzeugen Sie einige Personen und fügen Sie diese einem TreeSet hinzu.
//
//Probieren Sie ihre Personen Klasse auch mit Listen und Arrays.
//Sortieren Sie die Listen und Arrays.
//
//
//Teil 2
//Erzeugen Sie unterschiedliche Comparatoren für die Person Klasse.
//
//Probieren Sie ihre Personen Klasse  mit den Comparatoren in Listen und Arrays.
//Sortieren Sie die Listen und Arrays mit diesen Comparatoren.
//
//
//Nutzen Sie die Methoden Referenzen und Stream ForEach möglichkeit
//für ihre Konsolen ausgaben, wenn möglich.
