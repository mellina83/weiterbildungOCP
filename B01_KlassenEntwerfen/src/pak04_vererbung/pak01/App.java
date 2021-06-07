package pak04_vererbung.pak01;

public class App {
	public static void main(String[] args) {
		Perser peter = new Perser();
		Cat carlo = new Perser();
		Animal jerry = new Perser();
		Object tom = new Perser();
		
		peter.eat();
		peter.meow();
		peter.sleep();
		
		carlo.eat();
		carlo.meow();
//		carlo.sleep();
		
		jerry.eat();
//		jerry.meow();
//		jerry.sleep();
		
		System.out.println(peter.getClass().getSimpleName());
		System.out.println(carlo.getClass().getSimpleName());
		System.out.println(jerry.getClass().getSimpleName());
		System.out.println(tom.getClass().getSimpleName());
		
		Animal a1 = new Cat();
		System.out.println(a1.getClass().getSimpleName());
		System.out.println("----------------");
		Animal a2 = new Animal();
		Animal a3 = new Perser();
		a2.eat();
		a3.eat();
	}
}
