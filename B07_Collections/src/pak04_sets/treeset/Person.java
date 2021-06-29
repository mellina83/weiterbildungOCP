package pak04_sets.treeset;

public class Person implements Comparable<Person>{

	private String vorname;
	private String nachname;

	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime + result * this.getVorname().hashCode();
		result = prime + result * this.getNachname().hashCode();	
		return result;
	}

	@Override
	public String toString() {
		return "Person [vorname=" + vorname + ", nachname=" + nachname + "]";
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
