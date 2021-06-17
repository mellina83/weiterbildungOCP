package pak01_functional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo03LambdaRules {
	private String memberString = "MemberString";
	private static String staticMember = "Static Member";
	/**
	 * Runde Klammer sind noetig fuer leere Parameterliste
	 */
	interface IFunc01{
		void method01();
	}
	IFunc01 member01 = ()->{};
	/**
	 * Runde Klammer sind noetig fuer die Parameterliste mit mehreren Parametern
	 */
	interface IFunc02{
		void method01(int x, int y);
	}
	IFunc02 member02 = (int x, int y)->{x = 10;};
	IFunc02 member03 = (zahl1, zahl2)->{zahl1 = 10;};
	
//	IFunc02 member02a = int x, int y ->{x = 10;};
//	IFunc02 member02b = x, y ->{x = 10;};
	
	/**
	 * Wenn kein Datentyp angegeben ist, ist die runde Klammer
	 * bei einem Parameter optional
	 */
	interface IFunc03{
		void method01(int x);
	}
	IFunc03 member03a = (int x)-> {};
	IFunc03 member03b = (x)-> {};
	IFunc03 member03c = x -> {};
	
//	IFunc03 member03d = int x-> {};
	
	/**
	 * Der Rumpf der Methode darf beliebig viele Zeilen haben
	 */
	interface IFunc04{
		void method01();
	}	
	IFunc04 member04a = () -> {};
	IFunc04 member04b = () -> {
		int count = 1;
		LocalDate ld = LocalDate.now();
		System.out.println(memberString);
		System.out.println("Dies ist Zeile : " + count++);
		System.out.println("Dies ist Zeile : " + count++);
		System.out.println("Dies ist Zeile : " + count++);
		System.out.println("date : " + ld);
	};
	
	/*
	 * Wenn die realisierte Methode aus einer return Anweisung besteht,
	 * sind die geschweiften Klammern und "return" optional
	 */
	interface IFunc05{
		int method01();
	}	
	IFunc05 member05a = () -> {return 0;};
	IFunc05 member05b = () ->  0;
	IFunc05 member05b1 =() ->  0 + 10;
	IFunc05 member05c = () ->  {System.out.println("Hallo"); return 0;};
//	IFunc05 member05d = () ->  System.out.println("Hallo"); 0;
	
	static class Person {
		public String name = "Herbert";
	}
	
	public static void main(String[] args) {
		Demo03LambdaRules d = new Demo03LambdaRules();
		d.member04b.method01();
		
		String localString = "Java ist auch eine Insel";
		Person person01 = new Person();
		person01.name = "Markus";
		
		int[] arr = new int[3];
		IFunc01 localLambda = ()->{
			System.out.println(localString);
			System.out.println(person01.name);
			person01.name = "Markus";
			arr[1] = 10;
			//Local variable localString defined in an enclosing scope must be final or effectively final
//			localString = "Hawai ist ebenfalls eine Insel";
			System.out.println(staticMember);
			staticMember = "Hawai ist ebenfalls eine Insel";
		};
		
//		localString = "Hawai ist ebenfalls eine Insel";
		
		
	}
}
class A extends Demo03LambdaRules{
	
}
