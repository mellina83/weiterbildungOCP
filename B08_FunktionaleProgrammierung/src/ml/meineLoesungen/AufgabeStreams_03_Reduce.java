package ml.meineLoesungen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @A1 Realisieren Sie bitte die Klasse `Person`. Jede Person hat einen Vornamen
 *     und einen Nachnamen. Speichern Sie bitte in einer List folgende Personen:
 * 
 *     <Mick Berger> <Henry Valerie> <Samuel Summierer> <Dieter Etwas>
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) gr��ten Vornamen und Nachnamen aus
 *     allen Personen erh�lt (hier: Samuel Valerie).
 * 
 *     Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
 *     erzeugen, die die (lexikographisch) kleinsten Vornamen und Nachnamen aus
 *     allen Personen erh�lt (hier: Dieter Berger).
 *
 * @A2 Realisieren Sie bitte die Klasse `TextStatistics`, die den an den
 *     Konstruktor �bergebenen Text analysieren kann:
 * 
 *     Um die W�rter in dem Text zu finden, d�rfen Sie zur Vereinfachung davon
 *     ausgehen, dass die einzelnen W�rter voneinander mit Leerzeichen getrennt
 *     werden und andere Sonderzeichen beinhalten k�nnen (oder komplett aus
 *     Sonderzeichen bestehen k�nnen).
 * 
 *     Dann wird folgende Zeile ein Array aus einzelnen W�rtern erstellen:
 * 
 *     String[] words = text.split(" "); // W�rter k�nnen Sonderzeichen haben
 * 
 *     Verwenden Sie die Methode `reduce` um die TextStatistics f�r ein String
 *     zu erzeugen.
 */

class Person implements Comparable<Person> {
	private String vorname;
	private String nachname;
	
	public Person() {
		this("Max", "Mustermann");
	}
	
	public Person(String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			result = this.getVorname().equals(tmp.getVorname())
					&& this.getNachname().equals(tmp.getNachname());

		}
		return result;
	}

	@Override
	public int compareTo(Person o) {

		int i = this.getNachname().compareTo(o.getNachname());
		if (i == 0) {
			i = this.getVorname().compareTo(o.getVorname());
		}
		return i;
	}
}

class TextStatistics {
	// ...

	public TextStatistics(String text) {
		// ...
	}

	public int getCountChars() {
		return 0;
	}

	public int getCountSpecialChars() {
		return 0;
	}

	public int getCountLetters() {
		return 0;
	}

	public Optional<String> getLongestWord() {
		return null;
	}
}

public class AufgabeStreams_03_Reduce {

	public static void main(String[] args) {
		
		//Aufgabe 1:
		//In Liste speichern <Mick Berger> <Henry Valerie> <Samuel Summierer> <Dieter Etwas>
		List<Person> personenregister = new ArrayList<>();
		personenregister.add(new Person("Mick", "Berger"));
		personenregister.add(new Person("Henry", "Valerie"));
		personenregister.add(new Person("Samuel", "Summierer"));
		personenregister.add(new Person("Dieter", "Etwas"));
		
		//Verwenden Sie bitte eine Stream-Methode `reduce` um eine Person zu
		//erzeugen, die die (lexikographisch) gr��ten Vornamen und Nachnamen aus
		//allen Personen erh�lt (hier: Samuel Valerie).
		// 1: Mick Valerie
		// 2: Samuel Valerie
		// 3: Samuel Valerie
		// 4: Samuel Valerie
		
		// 1: Vrgl Vorname, nimm
		
		BinaryOperator<Person> accu1 = (p1, p2) -> {
			String neuerVorname = "";
			if (p1.getVorname().compareToIgnoreCase(p2.getVorname()) > 0) {
				neuerVorname = p1.getVorname();
			} else if (p1.getVorname().compareToIgnoreCase(p2.getVorname()) < 0) {
				neuerVorname = p2.getVorname();
			}
			
			String neuerNachname = "";
			if (p1.getNachname().compareToIgnoreCase(p2.getNachname()) > 0) {
				neuerNachname = p1.getNachname();
			} else if (p1.getNachname().compareToIgnoreCase(p2.getNachname()) < 0) {
				neuerNachname = p2.getNachname();
			}
			
			return new Person(neuerVorname, neuerNachname);
		};

		BinaryOperator<Person> accu2 = (p1, p2) -> {
			String neuerVorname = "";
			if (p1.getVorname().compareToIgnoreCase(p2.getVorname()) > 0) {
				neuerVorname = p2.getVorname();
			} else if (p1.getVorname().compareToIgnoreCase(p2.getVorname()) < 0) {
				neuerVorname = p1.getVorname();
			}
			
			String neuerNachname = "";
			if (p1.getNachname().compareToIgnoreCase(p2.getNachname()) > 0) {
				neuerNachname = p2.getNachname();
			} else if (p1.getNachname().compareToIgnoreCase(p2.getNachname()) < 0) {
				neuerNachname = p1.getNachname();
			}
			
			return new Person(neuerVorname, neuerNachname);
		};
		
		personenregister.stream().reduce(accu1).ifPresent(System.out::println);
		personenregister.stream().reduce(accu2).ifPresent(System.out::println);

	}

}
