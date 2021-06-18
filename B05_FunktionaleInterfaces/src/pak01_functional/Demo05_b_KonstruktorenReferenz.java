package pak01_functional;

interface PersonSupplier{
	Person get(String name);
}
interface PersonFullSupplier {
	Person get(String name, int age);
}

public class Demo05_b_KonstruktorenReferenz {
	public static void main(String[] args) {
		
		PersonSupplier ps = Person::new;
		PersonSupplier ps02 = name -> {
			System.out.println("Lambda wird ausgefuehrt");
			return new Person(name);
		};
		
		Person p1 = ps.get("Markus");
		System.out.println(p1);
		
		System.out.println("------------------------------");
		Person p2 = ps02.get("Christian");
		System.out.println("------------------------------");
		
		PersonFullSupplier pfs = Person::new;
		Person p3 = pfs.get("Markus", 40);
		
	}
}
