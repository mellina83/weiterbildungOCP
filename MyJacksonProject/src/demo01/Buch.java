package demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buch {

	private List<Autor> autoren;
	private String titel;
	private String isbn;

	public List<Autor> getAutoren() {
		return autoren;
	}

	public void setAutoren(List<Autor> autoren) {
		this.autoren = autoren;
	}
	
	public void addAutor(Autor autor) {
		this.getAutoren().add(autor);
	}


	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Buch() {
		this(new ArrayList<>(),"","");
	}

	public Buch(List<Autor> autoren,String Titel,String isbn) {
		this.setAutoren(autoren);
		this.setTitel(Titel);
		this.setIsbn(isbn);
	}

	@Override
	public String toString() {
		return "Buch [autor=" + autoren + ", titel=" + titel + ", isbn=" + isbn + "]";
	}
	
	
}
