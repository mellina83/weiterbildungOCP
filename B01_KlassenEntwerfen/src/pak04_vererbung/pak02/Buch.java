package pak04_vererbung.pak02;

public class Buch extends Artikel{
	public String titel = "Buch";
	
	public void doStuff() {
		System.out.println("Buch");
	}
	public String getTitel() {
		return this.titel;
	}
}
