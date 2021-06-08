package pak04_vererbung.pak02;

public class App {
	public static void main(String[] args) {
		Artikel a1 = new Artikel();
		Artikel a2 = new Buch();
		Artikel a3 = new Sachbuch();
		
		a1.doStuff();
		a2.doStuff();
		a3.doStuff();
		
		//------------------Shadowing-------------
		
		System.out.println(a1.titel);
		System.out.println(a2.titel);
		System.out.println(a3.titel);
		
		System.out.println(a1.getTitel());
		System.out.println(a2.getTitel());
		System.out.println(a3.getTitel());
		System.out.println("--------------------------");
		Buch b1 = new Buch();
		System.out.println(b1.titel);
		System.out.println(b1.getTitel());
		
	}
}
