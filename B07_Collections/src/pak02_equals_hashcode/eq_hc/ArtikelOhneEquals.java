package pak02_equals_hashcode.eq_hc;

public class ArtikelOhneEquals {
	private String artNr;
	private String name;
	
	public ArtikelOhneEquals(String artNr, String name) {
		this.artNr = artNr;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ArtikelOhneEquals [artNr=" + artNr + ", name=" + name + "]";
	}
	
	
}
