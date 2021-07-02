package optional07;

import java.util.Optional;
import java.util.Random;

import data.OptionalEmptyException;
import data.Utility;

class Person {
	private String name;

	public Person() {
	}

	public String getName() {
		return this.name;
	}
}

public class DemoOptional {

	public static void main(String[] args) {
//		demoOptional01("Hallo Welt");
//		demoOptional01("Hier ist Java");
//		demoOptional01(null);
		
		String s = getString();
		
		/**
		 * NullPointerException werden oft übersehen und nicht geprüft.
		 */
		try {
			System.out.println(s.toUpperCase());
		} catch (NullPointerException e) {
			System.out.println("Sorry es ist eine NullPointerException aufgetreten");
		}
		
		Optional<String> optString = getStringMitOptional();
		
		optString.ifPresent((str) -> System.out.println("Op sagt : " + str.toUpperCase()));
		
		if(optString.isPresent()) {
			String s02 = optString.get();
			System.out.println("if/else " + s02.toUpperCase());
		} else {
			System.out.println("if/else optString war leer");
		}
		
		String s03 = optString.orElse("ERSATZ Default");
		System.out.println(s03.toUpperCase());
		
		String s04 = optString.orElseGet(Utility.errorMessage);
		System.out.println(s04);
		
		String s05 = optString.orElseThrow(OptionalEmptyException::new);
		System.out.println(s05);
		
		Optional<Person> optPerson = getPersonMitOptional();
		
		Person p01 = optPerson.orElseGet(Person::new);
		Person p02 = optPerson.orElseThrow(OptionalEmptyException::new);
		
		System.out.println("Beendet");
	}
	
	private static Optional<Person> getPersonMitOptional() {
		// eine komplexe Methode wird hier simuliert,
		// die unter Umständen eine null liefern könnte:
		if (new Random().nextBoolean()) {
			return Optional.empty();
		}
		return Optional.of(new Person());
	}
	
	private static Optional<String> getStringMitOptional(){
		if(new Random().nextBoolean()) {
			return Optional.empty();
		}
		return Optional.of("Opt : Java ist eine Insel");
	}
	
	public static String getString() {
		// eine komplexe Methode wird hier simuliert,
		// die unter Umständen eine null liefern könnte:
		if (new Random().nextBoolean()) {
			return null;
		}
		return "String : Java ist eine Insel";
	}
	
	public static void demoOptional01(String text) {
		System.out.println("Flüstern : " + text.toLowerCase());
		System.out.println("Rufen : " + text.toUpperCase());
	}

}
