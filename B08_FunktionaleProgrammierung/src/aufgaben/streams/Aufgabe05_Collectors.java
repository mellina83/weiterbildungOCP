package aufgaben.streams;

/**
 * @A01 Bitte gruppieren Sie die Personen nach ihren Berufen.
 * 
 *      Jedem Beruf sollten die Personen zugeordnet werden, die diesen Beruf
 *      ausüben.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/groupingBy
 * 
 * @A02 Bitte Sammeln Sie alle Berufe, die im Array der Personen vorkommen in
 *      einem Set.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/mapping
 * 
 * @A03 Bitte sammeln Sie die Personen in zwei Partitionen.
 * 
 *      In der ersten befinden sich dann die Personen, die den Beruf
 *      'Lehrer(in)'ausüben. In der anderen Partition landen alle andere
 *      Personen.
 * 
 *      Verwenden Sie bitte Stream/collect und Collectors/partitioningBy
 */
public class Aufgabe05_Collectors {

	public static class Person {
		private String name;
		private String beruf;

		public Person(String name, String beruf) {
			this.name = name;
			this.beruf = beruf;
		}

		public String getBeruf() {
			return beruf;
		}

		public String toString() {
			return "Person: " + name;
		}
	}

	
	public static void main(String[] args) {
		Person[] personen = {
				new Person("Mark", "Bauarbeiter(in)"),
				new Person("Bill", "Lehrer(in)"),
				new Person("Hugo", "Metzger(in)"),
				new Person("Egon", "Bauarbeiter(in)"),
				new Person("Franzi", "Lehrer(in)"),
				new Person("Herbert", "Lehrer(in)"),
				new Person("Walter", "Metzger(in)"),
				new Person("Simone", "Bauarbeiter(in)"),
				new Person("Melchior", "Lehrer(in)"),
				new Person("Sven", "Lehrer(in)"),
				new Person("Michaela", "Metzger(in)"),
				new Person("Anna", "Bauarbeiter(in)"),
				new Person("Katrin", "Lehrer(in)")
				};

		
	}

}
